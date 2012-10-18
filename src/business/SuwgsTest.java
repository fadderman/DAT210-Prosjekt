package business;

import java.util.ArrayList;
import java.util.LinkedList;

import models.MentorsWithSubject;
import models.User;

public class SuwgsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MentorsWithSubject mws = new MentorsWithSubject("Java 2D");
		ArrayList<User> seekedMentors = mws.getMentorsWithSubject();
		for(User user : seekedMentors){
			String str = user.getFirstName();
			str += " " + user.getLastName();
			System.out.println(str);
			str = null;
		}
	}

}
