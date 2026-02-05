/**
 * BAD: Concrete parser tied to parallel validator subtype.
 */
package com.codesmells.changepreventers.parallelinheritance.bad;

public class PdfParser extends Parser {
    @Override
    public String parse(String input) {
        return "PDF:" + input.trim();
    }
}
