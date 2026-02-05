/**
 * CSV formatting strategy.
 * 
 * Shows how behavior differences are encapsulated, not scattered.
 */
package com.codesmells.changepreventers.divergentchange.good;

public class CsvFormatter implements Formatter {
    @Override
    public String format(String content) {
        return content.replace(":", ",");
    }
}
