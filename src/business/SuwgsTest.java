package business;

import java.util.ArrayList;
import java.util.LinkedList;

import models.User;

public class SuwgsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<User> seekedMentors = new SeekUsersWithGivenSubject("java").getMentorsWithSbject();
		for(User user :seekedMentors){
			String str = user.getFirstName();
			str += user.getLastName();
			System.out.println(str);
			str = null;
		}
	}

}
