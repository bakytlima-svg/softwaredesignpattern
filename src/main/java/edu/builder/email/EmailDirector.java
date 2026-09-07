package edu.builder.email;

/** Contains reusable email recipes and depends only on the EmailBuilder interface. */
public final class EmailDirector {
    private static final String SUPPORT_EMAIL = "support@example.com";
    private static final String WELCOME_SUBJECT = "Welcome to our service";
    private static final String ORDER_SUBJECT = "Your order has been confirmed";

    public void makeWelcomeEmail(EmailBuilder builder) {
        builder.setRecipient("new.customer@example.com")
                .addCarbonCopy(SUPPORT_EMAIL)
                .setSubject(WELCOME_SUBJECT)
                .setBody("Welcome! Your account is ready to use.")
                .setPriority(EmailPriority.NORMAL)
                .addAttachment("Getting-Started.pdf");
    }

    public void makeOrderConfirmation(EmailBuilder builder) {
        builder.setRecipient("customer@example.com")
                .addCarbonCopy(SUPPORT_EMAIL)
                .setSubject(ORDER_SUBJECT)
                .setBody("Thank you for your order. We will send tracking details soon.")
                .setPriority(EmailPriority.HIGH)
                .addAttachment("Order-Receipt.pdf");
    }
}
