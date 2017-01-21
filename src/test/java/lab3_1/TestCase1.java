package lab3_1;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.ArrayList;

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

	@Test
	public void stateTest() {
		//given
		InvoiceFactory invoiceFactory = new InvoiceFactory();
		BookKeeper bookKeeper = new BookKeeper(invoiceFactory);
		String name = "name";
		ClientData clientData = new ClientData(Id.generate(), name);
		InvoiceRequest invoiceRequest = Mockito.mock(InvoiceRequest.class);
		ArrayList<RequestItem> requestItems = new ArrayList<>();
		Mockito.when(invoiceRequest.getItems().thenReturn(requestItems);
		Money money = new Money(10);
		TaxPolicy taxPolicy = Mockito.mock(TaxPolicy.class);
		Mockito.when(taxPolicy.calculateTax(ProductType.DRUG, money)).thenReturn(new Tax(money, ""));
		
		//when
		Invoice invoice = bookKeeper.issuance(invoiceRequest, taxPolicy);
		
		//then
		Assert.assertThat(invoice.getItems().size(), is(equalTo(1)));
		
	}

}
