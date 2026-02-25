
package com.codesmells.bloaters.dataclumps.good;

import org.springframework.stereotype.Service;

/**
 * BAD EXAMPLE: Data Clumps Code Smell
 * 
 * <h2>What are Data Clumps?</h2>
 * Groups of variables that always appear together in multiple places.
 * They should be extracted into their own class.
 * 
 * <h2>Problems:</h2>
 * <ul>
 *   <li>Same group of parameters repeated across methods</li>
 *   <li>If you need to change the group, must update all methods</li>
 *   <li>Missing abstraction for a cohesive concept</li>
 * </ul>
 * 
 * @see com.codesmells.bloaters.dataclumps.good for refactored version
 */
@Service
public class ReportService {

    public void generateSalesReport(DateRange dateRange) {
        System.out.println("Generating sales report from " 
            + dateRange.getStartDate() + " to " 
            + dateRange.getEndDate());
    }

    public void generateInventoryReport(DateRange dateRange) {
        System.out.println("Generating inventory report from " 
            + dateRange.getStartDate() + " to " 
            + dateRange.getEndDate());
    }

    public void emailReport(String recipient, DateRange dateRange) {
        System.out.println("Emailing report to " + recipient + " for date range " + dateRange.getStartDate() + " to " + dateRange.getEndDate());
    }
}