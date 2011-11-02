import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class UserTest extends UnitTest {
    private String name = "Bob";
	private String email = "test@gmail.com";
	private String password = "secret";

	@Before
    public void setup() {
    	Fixtures.deleteAll();
		
		new User(email, password, name).save();
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
	
	@Test
	public void tryConnectAsUser() {
	    assertNotNull(User.connect(email, password));
	    assertNull(User.connect(email, "badpassword"));
	    assertNull(User.connect("tom@gmail.com", password));
	}
}
