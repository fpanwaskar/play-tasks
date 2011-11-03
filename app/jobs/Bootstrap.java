package jobs;

import play.jobs.*;
import models.*;
 
@OnApplicationStart
public class Bootstrap extends Job {
    
    public void doJob() {
		if (Task.count() == 0) {
			new User("feroz.panwaskar@gmail.com", "password", "feroz").save();
			User user = User.find("byEmail", "feroz.panwaskar@gmail.com").first();

			new Task(user, "Get some milk").save();
			new Task(user, "Clean the kitchen").save();
		}
    }
    
}