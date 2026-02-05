/**
 * BAD: Concrete parser tied to parallel validator subtype.
 */
package com.codesmells.changepreventers.parallelinheritance.bad;

public class HtmlParser extends Parser {
    @Override
    public String parse(String input) {
        return "HTML:" + input.trim();
    }
}
