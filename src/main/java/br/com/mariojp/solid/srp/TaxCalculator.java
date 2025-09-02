package br.com.mariojp.solid.srp;
public class TaxCalculator {
	
	   private final double taxRate;
	    public TaxCalculator() {
	        // Busca taxa de imposto configurada no System Property
	        String property = System.getProperty("tax.rate", "0.10"); // default = 10%
	        this.taxRate = Double.parseDouble(property);
	    }
	    public double calculateTax(double amount) {
	        return amount * taxRate;
	    }
	    public double getTaxRate() {
	        return taxRate;
	    }
	}