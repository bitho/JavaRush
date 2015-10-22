package com.javarush.test.level27.lesson15.big01.statistic;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

/**
 * Created by ��������� on 13.10.2015.
 */
public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private static StatisticManager.StatisticStorage storage = new StatisticStorage();
    private final StatisticStorage statisticStorage = StatisticStorage.getInstance();
    private static Set<Cook> set=new HashSet<>();

    public static StatisticManager getInstance() { return ourInstance; }

    private StatisticManager() {}

    public void register(EventDataRow data) {
        storage.put(data);
    }

    public void register(Cook cook) {
        set.add(cook);
    }

    private final static class StatisticStorage {
        private static StatisticStorage instance;
        private Map<EventType, List<EventDataRow>> eventTypeListMap = new HashMap<>();

        private StatisticStorage()
        {
            eventTypeListMap = new HashMap<>();
            for (EventType eventType : EventType.values()) {
                List<EventDataRow> eventList = new ArrayList<>();
                eventTypeListMap.put(eventType, eventList);
            }
        }

        public static StatisticStorage getInstance() {
            if (instance == null) {
                instance = new StatisticStorage();
            }
            return instance;
        }

        private void put(EventDataRow data) {
            EventType eventType = data.getType();
            eventTypeListMap.get(eventType).add(data);
        }

        private List<EventDataRow> get(EventType eventType) {
            return eventTypeListMap.get(eventType);
        }
    }
    public Map<Date, Double> getAdvertisementProfit() {
        Map<Date, Double> resultMap = new TreeMap<>(new ComparatorDate());
        List<EventDataRow> listEvent = statisticStorage.get(EventType.SELECTED_VIDEOS);
        for (EventDataRow v : listEvent) {
            if (listEvent == null) continue;
            VideoSelectedEventDataRow videoEvent = (VideoSelectedEventDataRow) v;
            Date date = getDay(videoEvent.getDate());
            long amount = videoEvent.getAmount();
            if (amount==0) continue;
            double profit = amount * 1d / 100d;
            if (resultMap.containsKey(date)) {
                profit += resultMap.get(date);
            }
            resultMap.put(date, profit);
        }
        return resultMap;
    }
    private Date getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        GregorianCalendar g = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        return g.getTime();
    }

    private class ComparatorDate implements Comparator<Date> {
        @Override
        public int compare(Date o1, Date o2) {
            return o2.compareTo(o1);
        }
    }




}