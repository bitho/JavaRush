package com.javarush.test.level28.lesson15.big01.model;



/**
 * Created by Александр on 09.10.2015.
 */
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class HHStrategy implements Strategy {

    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    private static final String USER_AGENT = "Mozilla/5.0 (jsoup)";
    private static final String HH_UA = "hh.ua";
    private static final String VALUE = "vacancy-serp__vacancy";
    private static final String DATA_QA = "data-qa";

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, searchString, page);
        return Jsoup.connect(url).userAgent(USER_AGENT).referrer(HH_UA).get();
    }

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> result = new LinkedList<>();
        int page = 0;
        while (true)
            try {
                Document doc = getDocument(searchString, page++);
                Elements vacancyElements = doc.getElementsByAttributeValue(DATA_QA, VALUE);
                if (vacancyElements.isEmpty()) break;
                for (Element element : vacancyElements) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(
                            element
                                    .getElementsByAttributeValue(DATA_QA, VALUE + "-title")
                                    .text());

                    Elements salary = element.getElementsByAttributeValue(DATA_QA, VALUE + "-compensation");
                    vacancy.setSalary(salary.isEmpty() ? "" : salary.text());

                    vacancy.setCity(
                            element
                                    .getElementsByAttributeValue(DATA_QA, VALUE + "-address")
                                    .text());
                    vacancy.setCompanyName(
                            element
                                    .getElementsByAttributeValue(DATA_QA, VALUE + "-employer")
                                    .text());
                    vacancy.setSiteName(doc.title());
                    vacancy.setUrl(
                            element
                                    .getElementsByAttributeValue(DATA_QA, VALUE + "-title")
                                    .attr("href"));
                    result.add(vacancy);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        return result;
    }
}