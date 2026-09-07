package edu.builder.email;

import java.util.ArrayList;
import java.util.List;

/** Creates an immutable Email object. */
public final class EmailObjectBuilder implements EmailBuilder {
    private String recipient;
    private final List<String> carbonCopyRecipients = new ArrayList<>();
    private String subject;
    private String body;
    private EmailPriority priority = EmailPriority.NORMAL;
    private final List<String> attachments = new ArrayList<>();

    @Override
    public EmailObjectBuilder setRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    @Override
    public EmailObjectBuilder addCarbonCopy(String carbonCopyRecipient) {
        carbonCopyRecipients.add(carbonCopyRecipient);
        return this;
    }

    @Override
    public EmailObjectBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    @Override
    public EmailObjectBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    @Override
    public EmailObjectBuilder setPriority(EmailPriority priority) {
        this.priority = priority;
        return this;
    }

    @Override
    public EmailObjectBuilder addAttachment(String attachmentName) {
        attachments.add(attachmentName);
        return this;
    }

    public Email build() {
        EmailValidator.validate(recipient, subject, body, priority);
        return new Email(recipient, carbonCopyRecipients, subject, body, priority, attachments);
    }
}
