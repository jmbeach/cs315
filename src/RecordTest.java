import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Jared
 *
 */

public class RecordTest {
	private Record r;
	private Member m;
	
	@Before
	public void setUp() throws Exception {
		m = new Member("Randy Travis",234567890,"123 Third Street", "Tuscaloosa","AL","35404");
		r = new Record("12-12-1984 12:12:12","12-13-1987",123456789,234567890,666665,"comments",m);
		r.createRecord();
		/*
		 * service code is 666665, which has a fee of $50.45
		 */
	}

	@Test
	public void testCalculateFee() {
		assert(r.calculateFee(r.getServiceCode())==50.45); //asserts that the fee should be $50.45
	}

}
