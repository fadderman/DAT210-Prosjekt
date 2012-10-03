package hibernate;

public class UserDBTest {

	public static void main(String[] args) {
		
		UserManagement um = new UserManagement();
		um.createUser("John", "Doe", "johndoe@anonymous.xxx", "Undisclosed", "");
		um.createUser("Jane", "Doe", "sexyjane@anonymous.xxx", "Also Undisclosed", "");
		um.createUser("George", "Baptista", "awesomepriest@church.chr", "On his way to heaven", "");
		
		um.listAllUsers();
	}

}
