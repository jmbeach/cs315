import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author hannah
 * Unit test for adding/subtracting member funds
 */

public class MemberTest {

	private Member m;

	@Before
	public void setUp() throws Exception {
		m = new Member("Bob Johnson",123456789,"417 Prince Avenue","Tuscaloosa","AL","35404");
	}

	@Test
	public void testAddFunds() {
		assert(m.getAccountFunds()==0); //asserts that the member starts with 0 funds
		m.addFunds(50000); //add $50,000 to the members funds
		assert(m.getAccountFunds()==50000); //asserts the member now has $50,000
	}

	@Test
	public void testSubtractFunds() {
		m.addFunds(50000); //add $50,000 to the members funds
		assert(m.getAccountFunds()==50000); //asserts that the member starts with $50,000
		m.subtractFunds(50000);
		assert(m.getAccountFunds()==0); //asserts the member now has $0
	}

}
