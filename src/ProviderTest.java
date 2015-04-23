import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Matt
 *
 */

public class ProviderTest {

	private Provider p;
	private Record r;
	private Member m;

	@Before
	public void setUp() throws Exception {
		p = new Provider("Octavius",123456789,"417 Prince Avenue","Tuscaloosa","AL","35404");
		m = new Member("Randy Travis",234567890,"123 Third Street", "Tuscaloosa","AL","35404");
		r = new Record("12-12-1984 12:12:12","12-13-1987",123456789,234567890,666665,"comments",m);
	}

	@Test
	public void testAddServices() {
		assert(p.getServices().size()==0); //asserts that the provider has not yet provided services
		p.addServices(r); //add the record of service to the provider
		assert(p.getServices().size()==1); //asserts the service has been added successfully.
	}


}
