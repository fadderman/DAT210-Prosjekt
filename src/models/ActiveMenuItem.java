package models;


public class ActiveMenuItem {
	private String home, find, settings, profile;
	
	public ActiveMenuItem() {
		home = "active";
		find = "";
		settings = "";
		profile = "";
	}

	public void setHome() {
		home = "active";
		find = "";
		settings = "";
		profile = "";
	}
	
	public void setFind() {
		home = "";
		find = "active";
		settings = "";
		profile = "";
	}
	
	public void setSettings() {
		home = "";
		find = "";
		settings = "active";
		profile = "";
	}
	
	public void setProfile() {
		home = "";
		find = "";
		settings = "";
		profile = "active";
	}

	public String getHome() {
		return home;
	}

	public String getFind() {
		return find;
	}

	public String getSettings() {
		return settings;
	}

	public String getProfile() {
		return profile;
	}
	
	
	
}
