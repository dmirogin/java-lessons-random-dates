package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
    public Date getDateFromString(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.M.yyyy");
        return format.parse(dateString);
    }
}
