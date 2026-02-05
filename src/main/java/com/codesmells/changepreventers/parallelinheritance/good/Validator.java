/**
 * Validator abstraction used via composition.
 * 
 * Parsers accept a Validator instance, avoiding parallel class trees.
 */
package com.codesmells.changepreventers.parallelinheritance.good;

public interface Validator {
    boolean isValid(String input);
}
