package edu.builder.email;

import java.util.ArrayList;
import java.util.List;

/** Creates a readable text preview from the same email construction steps. */
public final class EmailPreviewBuilder implements EmailBuilder {
    private String recipient;
    private final List<String> carbonCopyRecipients = new ArrayList<>();
    private String subject;
    private String body;
    private EmailPriority priority = EmailPriority.NORMAL;
    private final List<String> attachments = new ArrayList<>();

    @Override
    public EmailPreviewBuilder setRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    @Override
    public EmailPreviewBuilder addCarbonCopy(String carbonCopyRecipient) {
        carbonCopyRecipients.add(carbonCopyRecipient);
        return this;
    }

    @Override
    public EmailPreviewBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    @Override
    public EmailPreviewBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    @Override
    public EmailPreviewBuilder setPriority(EmailPriority priority) {
        this.priority = priority;
        return this;
    }

    @Override
    public EmailPreviewBuilder addAttachment(String attachmentName) {
        attachments.add(attachmentName);
        return this;
    }

    public String getResult() {
        EmailValidator.validate(recipient, subject, body, priority);
        StringBuilder preview = new StringBuilder();
        preview.append("=== Email Preview ===\n")
                .append("To: ").append(recipient).append('\n')
                .append("Cc: ").append(carbonCopyRecipients.isEmpty() ? "None" : String.join(", ", carbonCopyRecipients)).append('\n')
                .append("Priority: ").append(priority).append('\n')
                .append("Subject: ").append(subject).append("\n\n")
                .append(body).append('\n')
                .append("Attachments: ").append(attachments.isEmpty() ? "None" : String.join(", ", attachments));
        return preview.toString();
    }
}
