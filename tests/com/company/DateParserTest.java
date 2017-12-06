package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateParserTest {
    @Test
    public void testGetDateFromString() {
        DateParser parser = new DateParser();

        try {
            Date date = parser.getDateFromString("10.12.1994");

            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);

            Assert.assertEquals(10, calendar.get(Calendar.DAY_OF_MONTH));
            Assert.assertEquals(11, calendar.get(Calendar.MONTH));
            Assert.assertEquals(1994, calendar.get(Calendar.YEAR));
        } catch (ParseException exception) {
            Assert.fail();
        }
    }

    @Test(expected = ParseException.class)
    public void testGetDateFromStringWithError() throws ParseException {
        DateParser parser = new DateParser();
        parser.getDateFromString("10/12/1994");
    }
}
