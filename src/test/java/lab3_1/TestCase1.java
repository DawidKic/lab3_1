package lab3_1;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.Matchers.is;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.BookKeeper;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Invoice;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceFactory;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceRequest;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Tax;
import pl.com.bottega.ecommerce.sales.domain.invoicing.TaxPolicy;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class TestCase1 {
	
	@Mock ClientData clientData2;
	@InjectMocks InvoiceRequest invoiceRequest2;
	
	@Test
	public void stateTest() {
		//given
		InvoiceFactory invoiceFactory = new InvoiceFactory();
		BookKeeper bookKeeper = new BookKeeper(invoiceFactory);
		String name = "name";
		ClientData clientData = new ClientData(Id.generate(), name);
	
		InvoiceRequest invoiceRequest = new InvoiceRequest(clientData);
		Money money = new Money(10);
		TaxPolicy taxPolicy = Mockito.mock(TaxPolicy.class);
		Mockito.when(taxPolicy.calculateTax(ProductType.DRUG, money)).thenReturn(new Tax(money, ""));
		
		//when
		Invoice invoice = bookKeeper.issuance(invoiceRequest2, taxPolicy);
		
		//then
		Assert.assertThat(invoice.getItems().size(), is(equalTo(1)));
		
	}

}
