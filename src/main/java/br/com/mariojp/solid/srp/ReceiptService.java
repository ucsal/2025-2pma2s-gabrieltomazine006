package br.com.mariojp.solid.srp;
public class ReceiptService {
	private final TaxCalculator taxcalculator ;
	private final ReceiptFormatter receiptformatter;

    public ReceiptService() {
        this.taxcalculator = new TaxCalculator(); 
        this.receiptformatter = new ReceiptFormatter(); 
    }
    public String generate(Order order) {
        double subtotal = order.getItems().stream().mapToDouble(i -> i.getUnitPrice() * i.getQuantity()).sum();
        double tax = taxcalculator.calculateTax(subtotal);
        double total = subtotal + tax;
        return receiptformatter.format(order, subtotal, tax, total);
    }
}
