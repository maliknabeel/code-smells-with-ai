/**
 * BAD: Validator hierarchy mirrors parser hierarchy, causing lock-step changes.
 */
package com.codesmells.changepreventers.parallelinheritance.bad;

public class PdfValidator extends Validator {
    @Override
    public boolean isValid(String input) {
        return input != null && input.startsWith("%PDF");
    }
}
