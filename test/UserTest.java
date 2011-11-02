import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class UserTest extends UnitTest {

 	@Test
	public void createAndRetrieveUser() {
		String name = "Bob";
		String email = "test@gmail.com";

	    new User(email, "secret", name).save();

		User bob = User.find("byEmail", email).first();
	    assertNotNull(bob);
	    assertEquals(name, bob.fullname);
	}
}
