package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Map;

/**
 * Created by Александр on 17.10.2015.
 */
public class DirectorTablet
{
    public void printAdvertisementProfit() {
        Map<Date, Double> advertisementProfit = StatisticManager.getInstance().getAdvertisementProfit();
        BigDecimal totalProfit = new BigDecimal("0").setScale(2, RoundingMode.HALF_UP);
        for (Map.Entry<Date, Double> entry : advertisementProfit.entrySet()) {
            BigDecimal profit = new BigDecimal(entry.getValue()).setScale(2, RoundingMode.HALF_UP);
            ConsoleHelper.writeMessage(String.format(
                    "%1$td-%1$tb-%1$TY - %2$.2f",
                    entry.getKey(),
                    profit.doubleValue()
            ));
            totalProfit = totalProfit.add(profit);
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f", totalProfit.doubleValue()));
        ConsoleHelper.writeMessage("");
    }
    public void printCookWorkloading() {

    }
    public void printActiveVideoSet() {

    }
    public void printArchivedVideoSet() {

    }
}
