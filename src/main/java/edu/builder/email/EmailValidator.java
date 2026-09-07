package edu.builder.email;

final class EmailValidator {
    private EmailValidator() {
    }

    static void validate(String recipient, String subject, String body, EmailPriority priority) {
        if (recipient == null || !recipient.contains("@")) {
            throw new IllegalStateException("Recipient must be a valid email address");
        }
        requireText(subject, "Subject is required");
        requireText(body, "Body is required");
        if (priority == null) {
            throw new IllegalStateException("Priority is required");
        }
    }

    private static void requireText(String value, String errorMessage) {
        if (value == null || value.isBlank()) {
            throw new IllegalStateException(errorMessage);
        }
    }
}
