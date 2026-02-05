/**
 * BAD EXAMPLE: Divergent Change
 * 
 * One class is responsible for multiple reasons to change:
 * - Document content generation by type (invoice, receipt)
 * - Output formatting (CSV, JSON, plain)
 * - Notification (email)
 * - Archiving
 * 
 * Any modification in one area (e.g., add a new format) forces edits here,
 * increasing risk and maintenance cost. This violates Single Responsibility.
 * 
 * Refactor by extracting responsibilities into focused classes and
 * choosing strategies (e.g., Formatter) for variable behavior.
 */
package com.codesmells.changepreventers.divergentchange.bad;

import java.util.Map;

public class DocumentService {
    public String generate(String type, Map<String, Object> data, String format) {
        String content;
        if ("invoice".equalsIgnoreCase(type)) {
            content = "INVOICE:" + data.getOrDefault("id", "");
        } else if ("receipt".equalsIgnoreCase(type)) {
            content = "RECEIPT:" + data.getOrDefault("id", "");
        } else {
            content = "DOC:" + data.getOrDefault("id", "");
        }
        if ("CSV".equalsIgnoreCase(format)) {
            content = content.replace(":", ",");
        } else if ("JSON".equalsIgnoreCase(format)) {
            content = "{\"doc\":\"" + content + "\"}";
        } else {
            content = content;
        }
        return content;
    }

    public void email(String recipient, String content) {
        System.out.println("Email to " + recipient + ": " + content);
    }

    public void archive(String content, String target) {
        System.out.println("Archive to " + target + ": " + content.hashCode());
    }
}
