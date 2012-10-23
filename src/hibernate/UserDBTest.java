package hibernate;

public class UserDBTest {

	public static void main(String[] args) {
		
		UserManagement um = new UserManagement();
<<<<<<< HEAD
<<<<<<< HEAD
=======
		um.createUser("John", "Doe", "johndoe@anonymous.xxx", "Undisclosed", "Neverland", "");
		um.createUser("Jane", "Doe", "sexyjane@anonymous.xxx", "Also Undisclosed", "Saturn", "");
		um.createUser("George", "Baptista", "awesomepriest@church.chr", "On his way to heaven", "Center of the Earth", "");
		
		String str = um.getByName("John", "Doe").get(0).getEmail();
		
		System.out.println(str);
=======
>>>>>>> origin/david
<<<<<<< HEAD
		um.createUser("", "John", "Doe", "johndoe@anonymous.xxx", "Undisclosed");
		um.createUser("", "Jane", "Doe", "sexyjane@anonymous.xxx", "Also Undisclosed");
		um.createUser("", "George", "Baptista", "awesomepriest@church.chr", "On his way to heaven");
=======
		um.createUser("John", "Doe", "johndoe@anonymous.xxx", "Undisclosed", "");
		um.createUser("Jane", "Doe", "sexyjane@anonymous.xxx", "Also Undisclosed", "");
		um.createUser("George", "Baptista", "awesomepriest@church.chr", "On his way to heaven", "");
>>>>>>> origin/Hibernate
<<<<<<< HEAD
=======
		um.createUser("John", "Doe", "johndoe@anonymous.xxx", "Undisclosed", "Neverland", "");
		um.createUser("Jane", "Doe", "sexyjane@anonymous.xxx", "Also Undisclosed", "Saturn", "");
		um.createUser("George", "Baptista", "awesomepriest@church.chr", "On his way to heaven", "Center of the Earth", "");
		
		String str = um.getByName("John", "Doe").get(0).getEmail();
		
		System.out.println(str);
>>>>>>> origin/david
=======
>>>>>>> origin/lordAlek
>>>>>>> origin/david
		
	}

}
