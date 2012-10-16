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
	
	public String getFirsttime_table_course() {
		return chosenLanguage.getFirsttime_table_course();
	}
	public String getFirsttime_table_subject() {
		return chosenLanguage.getFirsttime_table_subject();
	}
	
}


