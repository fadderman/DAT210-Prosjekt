package business.search;

public class UserSuggestion {
	
	private int userID;
	private String firstname, lastname;
	
	public UserSuggestion(int userID, String firstname, String lastname) {
		super();
		this.userID = userID;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public int getUserID() {
		return userID;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}
	
	
	
}
