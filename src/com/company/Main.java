package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Wazzup! Take me two date in special format 'dd.mm.yyyy'");

        SimpleDateFormat format = new SimpleDateFormat("dd.M.yyyy");
        Scanner scanner = new Scanner(System.in);

        try {
            Date start = format.parse(scanner.nextLine());
            Date end = format.parse(scanner.nextLine());

            DateRangeGenerator generator = new DateRangeGenerator(start, end);
            List<Date> dates = generator.getRange();
            for (Date date : dates) {
                System.out.println(format.format(date));
            }
        } catch (ParseException exception) {
            System.out.println("Wrong format. You are dumb!");
        }
    }
}
