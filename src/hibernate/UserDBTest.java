package hibernate;

public class UserDBTest {

	public static void main(String[] args) {
		
		UserManagement um = new UserManagement();
		um.UserCreate("JohnD", "John", "Doe", "johndoe@anonymous.xxx", "Undisclosed");
		um.UserCreate("JaneD", "Jane", "Doe", "sexyjane@anonymous.xxx", "Also Undisclosed");
		um.UserCreate("Churchman", "George", "Baptista", "awesomepriest@church.chr", "On his way to heaven");
		
		um.listAllUsers();
	}

}
