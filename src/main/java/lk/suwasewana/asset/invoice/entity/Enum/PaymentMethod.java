package lk.suwasewana.asset.invoice.entity.Enum;


public enum PaymentMethod {
    CASH("Cash"),
    CREDITCARD("Card Payment"),
    CHEQUE("Cheque");

private final String paymentMethod;

    PaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
