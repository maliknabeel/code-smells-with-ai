/**
 * GOOD EXAMPLE: Divergent Change fixed by separation of concerns.
 * 
 * Responsibilities:
 * - Generate base content by type
 * - Delegate variable formatting to Formatter (strategy)
 * - Delegate emailing and archiving to dedicated services
 * 
 * Benefits:
 * - Adding a new format doesn't modify this class
 * - Notification/storage changes are localized
 * - Reduces reasons-for-change per class
 */
package com.codesmells.changepreventers.divergentchange.good;

import java.util.Map;

public class DocumentGenerator {
    private final Formatter formatter;
    private final EmailNotifier notifier;
    private final Archiver archiver;

    public DocumentGenerator(Formatter formatter, EmailNotifier notifier, Archiver archiver) {
        this.formatter = formatter;
        this.notifier = notifier;
        this.archiver = archiver;
    }

    public String generate(String type, Map<String, Object> data) {
        String content = ("invoice".equalsIgnoreCase(type) ? "INVOICE:" : "RECEIPT:")
                + data.getOrDefault("id", "");
        return formatter.format(content);
    }

    public void send(String recipient, String content) {
        notifier.send(recipient, content);
    }

    public void archive(String content, String target) {
        archiver.store(content, target);
    }
}
