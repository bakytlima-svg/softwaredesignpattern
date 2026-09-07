package edu.builder.email;

public final class EmailBuilderTest {
    private EmailBuilderTest() {
    }

    public static void main(String[] args) {
        EmailDirector director = new EmailDirector();
        EmailObjectBuilder objectBuilder = new EmailObjectBuilder();
        director.makeWelcomeEmail(objectBuilder);
        Email email = objectBuilder.build();

        assertEquals("new.customer@example.com", email.getRecipient(), "recipient");
        assertEquals(EmailPriority.NORMAL, email.getPriority(), "priority");
        assertEquals(1, email.getAttachments().size(), "attachment count");

        EmailPreviewBuilder previewBuilder = new EmailPreviewBuilder();
        director.makeWelcomeEmail(previewBuilder);
        assertTrue(previewBuilder.getResult().contains("Welcome to our service"), "preview subject");

        expectInvalidEmail();
        System.out.println("All tests passed.");
    }

    private static void expectInvalidEmail() {
        try {
            new EmailObjectBuilder()
                    .setRecipient("not-an-email")
                    .setSubject("Hello")
                    .setBody("Text")
                    .build();
            throw new AssertionError("Invalid email should not be built");
        } catch (IllegalStateException expected) {
            assertEquals("Recipient must be a valid email address", expected.getMessage(), "validation message");
        }
    }

    private static void assertEquals(Object expected, Object actual, String label) {
        if (!expected.equals(actual)) {
            throw new AssertionError(label + ": expected " + expected + ", but was " + actual);
        }
    }

    private static void assertTrue(boolean condition, String label) {
        if (!condition) {
            throw new AssertionError(label + " should be true");
        }
    }
}
