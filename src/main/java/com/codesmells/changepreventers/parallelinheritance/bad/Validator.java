/**
 * BAD EXAMPLE: Parallel Inheritance Hierarchies
 * 
 * Separate Validator hierarchy that mirrors Parser.
 * This coupling of hierarchies increases maintenance effort.
 */
package com.codesmells.changepreventers.parallelinheritance.bad;

public abstract class Validator {
    public abstract boolean isValid(String input);
}
