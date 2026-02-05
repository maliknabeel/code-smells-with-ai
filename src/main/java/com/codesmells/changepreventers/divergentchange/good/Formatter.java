/**
 * Strategy interface for output formatting.
 * 
 * Students: swapping implementations (CSV, JSON) avoids editing the caller,
 * keeping changes localized to the selected strategy.
 */
package com.codesmells.changepreventers.divergentchange.good;

public interface Formatter {
    String format(String content);
}
