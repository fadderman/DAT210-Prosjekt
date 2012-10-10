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
	
}


