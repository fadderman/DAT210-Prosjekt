package models;


public class ActiveMenuItem {
	private String home, fields, connections, profile;
	
	public ActiveMenuItem() {
		home = "active";
		fields = "";
		connections = "";
		profile = "";
	}

	public void setHome() {
		home = "active";
		fields = "";
		connections = "";
		profile = "";
	}
	
	public void setFields() {
		home = "";
		fields = "active";
		connections = "";
		profile = "";
	}
	
	public void setConnections() {
		home = "";
		fields = "";
		connections = "active";
		profile = "";
	}
	
	public void setProfile() {
		home = "";
		fields = "";
		connections = "";
		profile = "active";
	}

	public String getHome() {
		return home;
	}

	public String getFields() {
		return fields;
	}

	public String getConnections() {
		return connections;
	}

	public String getProfile() {
		return profile;
	}
	
	
	
}
