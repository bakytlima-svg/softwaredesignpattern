# Email Builder Pattern

This project implements the Builder design pattern in Java.

The same construction steps create two different representations:

1. An immutable `Email` object.
2. A text email preview (`String`).

## Main classes

- `Email` — immutable product.
- `EmailBuilder` — common fluent Builder interface.
- `EmailObjectBuilder` — creates an `Email` object.
- `EmailPreviewBuilder` — creates a text preview.
- `EmailDirector` — contains `makeWelcomeEmail()` and `makeOrderConfirmation()` configurations.
- `EmailValidator` — validates required fields.
- `Main` — demonstrates the program.

## Builder Pattern Requirements

- Fluent API: every builder method returns `this`.
- Two concrete builders produce different result types.
- Director works only with the `EmailBuilder` interface.
- Product fields are final and there are no public setters.
- Invalid email data throws a clear exception.
