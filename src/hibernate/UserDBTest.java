package hibernate;

public class UserDBTest {

	public static void main(String[] args) {
		
		UserManagement um = new UserManagement();
		um.createUser("JohnD", "John", "Doe", "johndoe@anonymous.xxx", "Undisclosed");
		um.createUser("JaneD", "Jane", "Doe", "sexyjane@anonymous.xxx", "Also Undisclosed");
		um.createUser("Churchman", "George", "Baptista", "awesomepriest@church.chr", "On his way to heaven");
		
		um.listAllUsers();
	}

}
