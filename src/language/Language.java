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
	
	// ============== Home Strings ===================

	public String getHome_welcome() {
		return chosenLanguage.getHome_welcome();
	}

	public String getHome_please_search() {
		return chosenLanguage.getHome_please_search();
	}
	
	public String getConnections_welcome() {
		return chosenLanguage.getConnections_welcome();
	}
	
	// ============== Menu Strings ===================
			
	public String getMenu_logout() {
		return chosenLanguage.getMenu_logout();
	}
	
	public String getMenu_home() {
		return chosenLanguage.getMenu_home();
	}

	public String getMenu_fields() {
		return chosenLanguage.getMenu_fields();
	}

	public String getMenu_profile() {

		return chosenLanguage.getMenu_profile();
	}

	public String getMenu_connections() {

		return chosenLanguage.getMenu_connections();
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
	
	public String getFields_welcome() {
		return chosenLanguage.getFields_welcome();
	}
	
	public String getFields_header() {
		return chosenLanguage.getFields_header();
	}

	// ========= Fields strings ================
	public String getSearch_returned() {
		return chosenLanguage.getSearch_returned();
	}
	public String getSearch_name() {
		return chosenLanguage.getSearch_name();
	}
	
	public String getFields_findIn() {
		return chosenLanguage.getFields_findIn();
	}

	// =========== Profile Strings =============
	
	public String getProfile_name() {
		return chosenLanguage.getProfile_name();
	}
	
	public String getProfile_location() {
		return chosenLanguage.getProfile_location();
	}
	
	public String getProfile_city() {
		return chosenLanguage.getProfile_city();
	}
	
	public String getProfile_country() {
		return chosenLanguage.getProfile_country();
	}
	
	public String getProfile_edit() {
		return chosenLanguage.getProfile_edit();
	}
	
	public String getProfile_save() {
		return chosenLanguage.getProfile_save();
	}
	
	public String getProfile_email() {
		return chosenLanguage.getProfile_email();
	}
	
	// ============= Connections Strings ============
	public String getConnections_add() {
		return chosenLanguage.getConnections_add();
	}
	
	public String getConnections_noConnections() {
		return chosenLanguage.getConnections_noConnections();
	}
	
	public String getConnections_remove() {
		return chosenLanguage.getConnections_remove();
	}
	
	public String getConnections_you() {
		return chosenLanguage.getConnections_you();
	}
	
	public String getConnections_noMentor() {
		return chosenLanguage.getConnections_noMentor();
	}
	
	public String getConnections_noTrainee() {
		return chosenLanguage.getConnections_noTrainee();
	}
	
	public String getConnections_view() {
		return chosenLanguage.getConnections_view();
	}
	
	public String getConnections_contact() {
		return chosenLanguage.getConnections_contact();
	}
	
	// ============== Mentor/Trainee List Strings ===================
	
	public String getFindList_trainee_legend() {
		return chosenLanguage.getFindList_trainee_legend();
	}
	public String getFindList_mentor_legend() {
		return chosenLanguage.getFindList_mentor_legend();
	}
	public String getFindList_no_mentor() {
		return chosenLanguage.getFindList_no_mentor();
	}
	public String getFindList_no_trainee() {
		return chosenLanguage.getFindList_no_trainee();
	}		
	public String getFindList_connect() {
		// TODO Auto-generated method stub
		return chosenLanguage.getFindList_connect();
	}	
	
	// ============== Request Strings ===================

	public String getRequest_accept() {
		// TODO Auto-generated method stub
		return chosenLanguage.getRequest_accept();
	}

	public String getRequest_deny() {
		// TODO Auto-generated method stub
		return chosenLanguage.getRequest_deny();
	}
	
	public String getRequest_traniee() {
		// TODO Auto-generated method stub
		return chosenLanguage.getRequest_traniee();
	}

	public String getRequest_mentor() {
		// TODO Auto-generated method stub
		return chosenLanguage.getRequest_mentor();
	}
	
	public String getRequest_legend() {
		// TODO Auto-generated method stub
		return chosenLanguage.getRequest_legend();
	}
	
	public String getRequest_dinied() {
		// TODO Auto-generated method stub
		return chosenLanguage.getRequest_dinied();
	}

	public String getRequest_accepted() {
		// TODO Auto-generated method stub
		return chosenLanguage.getRequest_accepted();
	}
}


