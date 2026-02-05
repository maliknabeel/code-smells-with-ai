/**
 * JSON formatting strategy.
 * 
 * New formats are added by creating new implementations without modifying
 * the generator class, reducing divergence.
 */
package com.codesmells.changepreventers.divergentchange.good;

public class JsonFormatter implements Formatter {
    @Override
    public String format(String content) {
        return "{\"doc\":\"" + content + "\"}";
    }
}
