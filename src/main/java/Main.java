import br.com.mariojp.solid.srp.*;

public class Main {
    public static void main(String[] args) {
        System.setProperty("tax.rate", "0.08"); // 8%
        Order o = new Order();
        o.add(new Item("Café", 8.0, 2));  // 16.0
        o.add(new Item("Bolo", 12.5, 1)); // 12.5 -> subtotal = 28.5
        // Instancia as dependências
        TaxCalculator taxcalculator = new TaxCalculator();
        ReceiptFormatter receiptformatter = new ReceiptFormatter();
        
        // Injeta as dependências no ReceiptService
        ReceiptService receiptService = new ReceiptService();
        String receipt = receiptService.generate(o);
        System.out.println(receipt);
    }
}