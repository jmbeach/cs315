import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Kalyn-Wright
 *
 */

public class ProviderReportTest {

	private Member m;
	private Provider p;
	private Record r;
	private ProviderReport rep;

	@Before
	public void setUp() throws Exception {
		m = new Member("Randy Travis",234567890,"123 Third Street", "Tuscaloosa","AL","35404");
		p = new Provider("Octavius",123456789,"417 Prince Avenue","Tuscaloosa","AL","35404");
		r = new Record("12-12-1984 12:12:12","12-13-1987",123456789,234567890,666665,"comments",m);
		p.addServices(r); //add the service to the provider
		rep = new ProviderReport(p);
		
		/*
		 * service code is 666665, which has a fee of $50.45
		 */
	}

	@Test
	public void testGetServiceFee() {
		assert(rep.getServiceFee()==50.45); //asserts that the service fee should be $50.45
	}

}
