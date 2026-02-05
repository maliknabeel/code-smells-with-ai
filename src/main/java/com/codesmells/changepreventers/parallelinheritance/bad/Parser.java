/**
 * BAD EXAMPLE: Parallel Inheritance Hierarchies
 * 
 * Abstract Parser forces a mirrored Validator hierarchy elsewhere.
 * Adding a new parser type also requires adding a new validator type,
 * making changes ripple across two class trees.
 * 
 * Prefer composition: inject a validator into a concrete parser
 * instead of maintaining parallel hierarchies.
 */
package com.codesmells.changepreventers.parallelinheritance.bad;

public abstract class Parser {
    public abstract String parse(String input);
}
