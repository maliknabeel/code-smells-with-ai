/**
 * Simple validator implementation used for demonstration.
 * 
 * Real projects may implement specialized validators without
 * forcing parallel parser hierarchies.
 */
package com.codesmells.changepreventers.parallelinheritance.good;

public class SimpleValidator implements Validator {
    @Override
    public boolean isValid(String input) {
        return input != null && !input.isBlank();
    }
}
