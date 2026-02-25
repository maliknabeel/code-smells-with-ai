package com.codesmells.bloaters.dataclumps.good;

public class DateRange {
    private String startDate;
    private String endDate;
    private String format;

    public DateRange(String startDate, String endDate, String format) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.format = format;
    }

    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public String getFormat() { return format; }
}
