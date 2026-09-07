package edu.builder.email;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        EmailDirector director = new EmailDirector();

        EmailObjectBuilder objectBuilder = new EmailObjectBuilder();
        director.makeOrderConfirmation(objectBuilder);
        Email email = objectBuilder.build();

        EmailPreviewBuilder previewBuilder = new EmailPreviewBuilder();
        director.makeOrderConfirmation(previewBuilder);
        String preview = previewBuilder.getResult();

        System.out.println("Created email for: " + email.getRecipient());
        System.out.println(preview);
    }
}
