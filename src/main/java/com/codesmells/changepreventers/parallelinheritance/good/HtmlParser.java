/**
 * GOOD EXAMPLE: Parser composed with Validator.
 * 
 * Composition avoids creating a parallel subtype for every new parser,
 * reducing change coordination and class explosion.
 */
package com.codesmells.changepreventers.parallelinheritance.good;

public class HtmlParser {
    private final Validator validator;

    public HtmlParser(Validator validator) {
        this.validator = validator;
    }

    public String parse(String input) {
        if (!validator.isValid(input)) throw new IllegalArgumentException("Invalid input");
        return "HTML:" + input.trim();
    }
}
