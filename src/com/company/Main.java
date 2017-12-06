package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Wazzup! Take me two date in special format 'dd.mm.yyyy'");


        DateParser parser = new DateParser();
        Scanner scanner = new Scanner(System.in);
        try {
            Date start = parser.getDateFromString(scanner.nextLine());
            Date end = parser.getDateFromString(scanner.nextLine());

            DateRangeGenerator generator = new DateRangeGenerator(start, end);
            List<Date> dates = generator.getRange();
            for (Date date: dates) {
                System.out.println(date);
            }
        } catch (ParseException exception) {
            System.out.println("Wrong format. You are dumb!");
        }
    }
}
