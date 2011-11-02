import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class UserTest extends UnitTest {
    private String name = "Bob";
	private String email = "test@gmail.com";

	@Before
    public void setup() {
    	Fixtures.deleteAll();
		
		new User(email, "secret", name).save();
   	}

 	@Test
	public void createAndRetrieveUser() {
		User bob = User.find("byEmail", email).first();
	    
		assertNotNull(bob);
	    assertEquals(name, bob.fullname);
	}
	
	@Test
	public void deleteUser() {		
		User bob = User.find("byEmail", email).first();
		assertNotNull(bob);
		
		bob.delete();
		
	    assertEquals(0, User.count());
	}
}
