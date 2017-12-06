package com.company;

import java.util.*;

public class DateRangeGenerator {
    private int amount = 100;
    private Date start;
    private Date end;

    public DateRangeGenerator(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public List<Date> getRange() {
        List<Date> dates = new ArrayList<Date>();

        int daysInterval = getDayInterval();

        // Prevent cases when date is equals or difference btw them is 1
        if (daysInterval <= 1) {
            return dates;
        }

        for (int i = 0; i < amount; i++) {
            int randomDays = getRandomIntInInterval(1, daysInterval - 1);
            Date generated = addDays(start, randomDays);
            if (dates.indexOf(generated) == -1) {
                dates.add(generated);
            }
        }

        return dates;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    private int getDayInterval() {
        long startTimestamp = start.getTime();
        long endTimestamp = end.getTime();
        long interval = endTimestamp - startTimestamp;

        return (int) interval / (1000 * 60 * 60 * 24);
    }

    private int getRandomIntInInterval(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    private Date addDays(Date date, int days) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);

        return calendar.getTime();
    }
}
