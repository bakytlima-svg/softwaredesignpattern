package edu.builder.email;

import java.util.List;

/** Immutable product created through an EmailBuilder implementation. */
public final class Email {
    private final String recipient;
    private final List<String> carbonCopyRecipients;
    private final String subject;
    private final String body;
    private final EmailPriority priority;
    private final List<String> attachments;

    Email(
            String recipient,
            List<String> carbonCopyRecipients,
            String subject,
            String body,
            EmailPriority priority,
            List<String> attachments) {
        this.recipient = recipient;
        this.carbonCopyRecipients = List.copyOf(carbonCopyRecipients);
        this.subject = subject;
        this.body = body;
        this.priority = priority;
        this.attachments = List.copyOf(attachments);
    }

    public String getRecipient() {
        return recipient;
    }

    public List<String> getCarbonCopyRecipients() {
        return carbonCopyRecipients;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public EmailPriority getPriority() {
        return priority;
    }

    public List<String> getAttachments() {
        return attachments;
    }
}
