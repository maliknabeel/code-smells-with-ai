/**
 * Single-responsibility archiver.
 * 
 * Keeps storage concerns independent of formatting and emailing.
 */
package com.codesmells.changepreventers.divergentchange.good;

public class Archiver {
    public void store(String content, String target) {
        System.out.println("Archive to " + target + ": " + content.hashCode());
    }
}
