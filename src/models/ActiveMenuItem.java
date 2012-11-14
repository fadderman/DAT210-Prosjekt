package models;


public class ActiveMenuItem {
	private String home, find, connections, profile;
	
	public ActiveMenuItem() {
		home = "active";
		find = "";
		connections = "";
		profile = "";
	}

	public void setHome() {
		home = "active";
		find = "";
		connections = "";
		profile = "";
	}
	
	public void setFind() {
		home = "";
		find = "active";
		connections = "";
		profile = "";
	}
	
	public void setConnections() {
		home = "";
		find = "";
		connections = "active";
		profile = "";
	}
	
	public void setProfile() {
		home = "";
		find = "";
		connections = "";
		profile = "active";
	}

	public String getHome() {
		return home;
	}

	public String getFind() {
		return find;
	}

	public String getConnections() {
		return connections;
	}

	public String getProfile() {
		return profile;
	}
	
	
	
}
