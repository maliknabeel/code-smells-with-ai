package com.codesmells.bloaters.dataclumps.good;

import org.springframework.stereotype.Service;

/**
 * GOOD EXAMPLE: Refactored using Parameter Object
 * 
 * <h2>Benefits:</h2>
 * <ul>
 *   <li>Single object represents cohesive concept</li>
 *   <li>Easy to add new parameters to the group</li>
 *   <li>Method signatures are cleaner</li>
 * </ul>
 */
@Service
public class ReportService {
    
    public void generateSalesReport(ReportParameters params) {
        System.out.println("Generating sales report from " + params.getStartDate() 
            + " to " + params.getEndDate());
    }
    
    public void generateInventoryReport(ReportParameters params) {
        System.out.println("Generating inventory report from " + params.getStartDate() 
            + " to " + params.getEndDate());
    }
    
    public void emailReport(String recipient, ReportParameters params) {
        System.out.println("Emailing report to " + recipient);
    }
}
