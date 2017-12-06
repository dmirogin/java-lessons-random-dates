package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DateRangeGeneratorTest {
    @Test
    public void testGenerateWith() {
        Calendar start = new GregorianCalendar(2017, 10, 28);
        Calendar end = new GregorianCalendar(2017, 10, 30);

        DateRangeGenerator generator = new DateRangeGenerator(start.getTime(), end.getTime());
        List<Date> result = generator.getRange();

        Assert.assertEquals(1, result.size());
        Assert.assertTrue(result.get(0).after(start.getTime()));
        Assert.assertTrue(result.get(0).before(end.getTime()));
    }

    @Test
    public void testGenerateWhenEndDateMoreThanStartDate() {
        Calendar start = new GregorianCalendar(2017, 10, 30);
        Calendar end = new GregorianCalendar(2017, 10, 28);

        DateRangeGenerator generator = new DateRangeGenerator(start.getTime(), end.getTime());
        List<Date> result = generator.getRange();

        Assert.assertEquals(0, result.size());
    }
}
