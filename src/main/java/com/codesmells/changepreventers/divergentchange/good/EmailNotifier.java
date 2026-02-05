/**
 * Single-responsibility notifier.
 * 
 * Demonstrates separating notification concerns from document creation.
 */
package com.codesmells.changepreventers.divergentchange.good;

public class EmailNotifier {
    public void send(String recipient, String content) {
        System.out.println("Email to " + recipient + ": " + content);
    }
}
