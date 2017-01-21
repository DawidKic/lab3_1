package lab3_1;

import org.junit.Test;

import pl.com.bottega.ecommerce.sales.domain.invoicing.BookKeeper;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceFactory;
import pl.com.bottega.ecommerce.sales.domain.invoicing.TaxPolicy;

public class TestCase1 {
	
	@Test
	public void stateTest() {
		//given
		InvoiceFactory invoiceFactory = new InvoiceFactory();
		BookKeeper bookKeeper = new BookKeeper(invoiceFactory);
		TaxPolicy taxPolicy;
		
	}

}
