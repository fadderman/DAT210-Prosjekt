package hibernate;

import java.util.Iterator;
import java.util.List;

import models.User;

public class UserDBTest {

	public static void main(String[] args) {

		UserManagement um = new UserManagement();
		um.createUser("John", "Doe", "johndoe@anonymous.xxx", "Undisclosed", "Neverland", "");
		um.createUser("Jane", "Doe", "sexyjane@anonymous.xxx", "Also Undisclosed", "Saturn", "");
		um.createUser("George", "Baptista", "awesomepriest@church.chr", "On his way to heaven", "Center of the Earth", "");

		String str = um.getByName("John", "Doe").get(0).getEmail();

		List<User> list = um.listAllUsers();

		for(Iterator<User> iterator = list.iterator(); iterator.hasNext();){
			User current = iterator.next();
			System.out.println(current.getFullName());
		}


		System.out.println(str);

	}

}