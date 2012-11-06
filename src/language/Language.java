package language;

public class Language {
	private Lang chosenLanguage = new EN();
	private String languageString;

	public void setLanguage(String language){
		languageString = language;
		if(language == null) languageString = "";
		if (language.equalsIgnoreCase("english")) {
			chosenLanguage = new EN();//languages.en;
		}
		else if(language.equalsIgnoreCase("norsk")) {
			chosenLanguage = new NO();//languages.no;
		}
		else {
			chosenLanguage = new EN();//languages.en;
		}
	}
	
	public String getLanguageString(){
		return languageString;
	}
	
	public String getLogin_btn_lang(){
		return chosenLanguage.getLogin_btn_lang();
	}
	public String getLogin_btn_learn(){
		return chosenLanguage.getLogin_btn_learn();
	}
	public String getLogin_signIn() {
		return chosenLanguage.getLogin_signIn();
	}
	public String getLogin_moto(){
		return chosenLanguage.getLogin_moto();
	}
	
	// ============== FirstTimeLogIn Strings ===================
	public String getFirsttime_label_personal() {
		return chosenLanguage.getFirsttime_label_personal();
	}
	public String getFirsttime_label_fName() {
		return chosenLanguage.getFirsttime_label_fName();
	}
	public String getFirsttime_label_lName() {
		return chosenLanguage.getFirsttime_label_lName();
	}
	public String getFirsttime_label_email() {
		return chosenLanguage.getFirsttime_label_email();
	}
	public String getFirsttime_label_country() {
		return chosenLanguage.getFirsttime_label_country();
	}
	public String getFirsttime_label_city() {
		return chosenLanguage.getFirsttime_label_city();
	}
	public String getFirsttime_label_connections() {
		return chosenLanguage.getFirsttime_label_connections();
	}
	public String getFirsttime_label_subject() {
		return chosenLanguage.getFirsttime_label_subject();
	}
	public String getFirsttime_label_field() {
		return chosenLanguage.getFirsttime_label_field();
	}
	public String getFirsttime_radio_mentor() {
		return chosenLanguage.getFirsttime_radio_mentor();
	}
	public String getFirsttime_radio_trainee() {
		return chosenLanguage.getFirsttime_radio_trainee();
	}
	public String getFirsttime_label_addInfo() {
		return chosenLanguage.getFirsttime_label_addInfo();
	}
	public String getFirsttime_label_experience() {
		return chosenLanguage.getFirsttime_label_experience();
	}
	public String getFirsttime_btn_add() {
		return chosenLanguage.getFirsttime_btn_add();
	}
	public String getFirsttime_btn_submit() {
		return chosenLanguage.getFirsttime_btn_submit();
	}
	public String getFirsttime_drop_novice() {
		return chosenLanguage.getFirsttime_drop_novice();
	}
	public String getFirsttime_drop_intermediate() {
		return chosenLanguage.getFirsttime_drop_intermediate();
	}
	public String getFirsttime_drop_expert() {
		return chosenLanguage.getFirsttime_drop_expert();
	}
	public String getFirsttime_drop_loreMaster() {
		return chosenLanguage.getFirsttime_drop_loreMaster();
	}
	
<<<<<<< HEAD
=======
	// ============== Home Strings ===================

	public String getHome_welcome() {
		return chosenLanguage.getHome_welcome();
	}

	public String getHome_please_search() {
		return chosenLanguage.getHome_please_search();
	}
	
	// ============== Menu Strings ===================
				
	public String getMenu_home() {
		return chosenLanguage.getMenu_home();
	}

	public String getMenu_find() {
		return chosenLanguage.getMenu_find();
	}

	public String getMenu_profile() {

		return chosenLanguage.getMenu_profile();
	}

	public String getMenu_settings() {

		return chosenLanguage.getMenu_settings();
	}

	public String getMenu_search() {
		return chosenLanguage.getMenu_search();
	}
	
	// ============== Search Results Strings ===================

	public String getSearch_sResult() {
		return chosenLanguage.getSearch_sResult();
	}
	public String getSearch_fResult() {
		return chosenLanguage.getSearch_fResult();
	}

	public String getSearch_location() {
		return chosenLanguage.getSearch_location();
	}

	public String getSearch_user() {
		return chosenLanguage.getSearch_user();
	}

	public String getSearch_title() {
		return chosenLanguage.getSearch_title();
	}

	public String getSearch_description() {
		return chosenLanguage.getSearch_description();
	}

	public String getSearch_error() {
		return chosenLanguage.getSearch_error();
	}

	public String getSearch_success() {
		return chosenLanguage.getSearch_success();
	}

	public String getSearch_resultStart() {
		return chosenLanguage.getSearch_resultStart();
	}

	public String getSearch_noResults() {
		return chosenLanguage.getSearch_noResults();
	}

	public String getSearch_returned() {
		return chosenLanguage.getSearch_returned();
	}
	public String getSearch_name() {
		return chosenLanguage.getSearch_name();
	}

>>>>>>> origin/OpenID
}


