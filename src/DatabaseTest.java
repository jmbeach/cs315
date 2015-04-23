

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author dillonwastrack
 * Unit test to test adding/removing members
 */
public class DatabaseTest {
	Database d;
	Member m;
	@Before
	public void setUp() throws Exception {
		d = new Database();
		m = new Member("Bob Johnson",123456789,"417 Prince Avenue","Tuscaloosa","AL","35404");
	}

	@Test
	public void testAddMember() {
		assertFalse(d.getMember(m.getNumber())!=null); //Asserts that member is not already in database
		d.addMember(m); //Adds the member to the database
		assert(d.getMember(m.getNumber())!=null); //Asserts the member is now in the database
	}
	public void testRemoveMember(){
		d.addMember(m); //Adds the member to the database
		assert(d.getMember(m.getNumber())!=null); //Asserts that member is in database
		d.removeMember(m);
		assertFalse(d.getMember(m.getNumber())!=null); //Asserts the member is no longer in the database
	}

}
