package edu.builder.email;

/** Common fluent steps for all email representations. */
public interface EmailBuilder {
    EmailBuilder setRecipient(String recipient);

    EmailBuilder addCarbonCopy(String carbonCopyRecipient);

    EmailBuilder setSubject(String subject);

    EmailBuilder setBody(String body);

    EmailBuilder setPriority(EmailPriority priority);

    EmailBuilder addAttachment(String attachmentName);
}
