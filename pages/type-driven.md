# Type-Driven Design

### Making illegal states in the domain model unrepresentable

---
---

# Traditionally

```scala
case class Invoice(
                    companyName: String,
                    taxId: String,
                    street: String,
                    zipCode: String,
                    city: String,
                    country: String,
                    amount: BigDecimal,
                    currency: String,
                    payableUntil: ZonedDateTime
                  )
```
---
---
# With Types

```scala
case class InvoiceId(value: UUID)

case class Company(name: CompanyName, billingAddress: BillingAddress, taxId: TaxId)

case class BillingAddress(street: Street, zipCode: ZipCode, city: City, country: Country)

sealed trait Currency

case object PLN extends Currency

case object EUR extends Currency

case object GBP extends Currency

case class Money(amount: BigDecimal, currency: Currency)

case class Invoice(invoiceId: InvoiceId, company: Company, amount: Money, payableUntil: ZonedDateTime)
```

Go further with Cats Validated, Refined, and Shapeless

<!--
Compile time feedback
-->