/**
 * GOOD EXAMPLE: Parser composed with Validator.
 * 
 * Keeps validation concerns reusable without parallel inheritance.
 */
package com.codesmells.changepreventers.parallelinheritance.good;

public class PdfParser {
    private final Validator validator;

    public PdfParser(Validator validator) {
        this.validator = validator;
    }

    public String parse(String input) {
        if (!validator.isValid(input)) throw new IllegalArgumentException("Invalid input");
        return "PDF:" + input.trim();
    }
}
