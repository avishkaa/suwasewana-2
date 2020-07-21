package lk.suwasewana.asset.invoice.entity.Enum;

public enum InvoicePrintOrNot {
    PRINT("Required"),
    NOT("Not required");

    private final String invoicePrintOrNot;

    InvoicePrintOrNot(String invoicePrintOrNot) {
        this.invoicePrintOrNot = invoicePrintOrNot;
    }

    public String getInvoicePrintOrNot() {
        return invoicePrintOrNot;
    }
}

