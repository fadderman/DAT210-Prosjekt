package language;

public class NO extends Lang{
	// ============== SignInPage Strings ===================
	private String login_btn_lang = "Språk";
	private String login_btn_learn = "Lær mer";
	private String login_signIn = "Logg inn med:";
	private String login_moto = "Finn mentorer og trainees med de rette kvalifikasjonene og del kunnskap, alt på en plass.";
									
	public String getLogin_btn_lang() {
		return login_btn_lang;
	}
	public String getLogin_btn_learn() {
		return login_btn_learn;
	}
	public String getLogin_signIn() {
		return login_signIn;
	}
	public String getLogin_moto() {
		return login_moto;
	}
	
	// ============== FirstTimeLogIn Strings ===================
	private String firsttime_label_personal = "Personal";
	private String firsttime_label_fName = "Fornavn:";
	private String firsttime_label_lName = "Etternavn:";
	private String firsttime_label_email = "Epost:";
	private String firsttime_label_country = "Land:";
	private String firsttime_label_city = "By:";
	private String firsttime_label_connections = "Koblinger";
	private String firsttime_label_subject = "Emne:";
	private String firsttime_label_field = "Felt:";
	private String firsttime_radio_mentor = "Mentor";
	private String firsttime_radio_trainee = "Trainee";
	private String firsttime_label_addInfo = "ekstra info:";
	private String firsttime_label_experience = "erfaring:";
	private String firsttime_drop_novice = "Nybegynner";
	private String firsttime_drop_intermediate = "Mellomnivå";
	private String firsttime_drop_expert = "Ekspert";
	private String firsttime_drop_loreMaster = "Guru";
	private String firsttime_btn_add = "Legg til";
	private String firsttime_btn_submit = "Send";
	
	public String getFirsttime_label_personal() {
		return firsttime_label_personal;
	}
	public String getFirsttime_label_fName() {
		return firsttime_label_fName;
	}
	public String getFirsttime_label_lName() {
		return firsttime_label_lName;
	}
	public String getFirsttime_label_email() {
		return firsttime_label_email;
	}
	public String getFirsttime_label_country() {
		return firsttime_label_country;
	}
	public String getFirsttime_label_city() {
		return firsttime_label_city;
	}
	public String getFirsttime_label_connections() {
		return firsttime_label_connections;
	}
	public String getFirsttime_label_subject() {
		return firsttime_label_subject;
	}
	public String getFirsttime_label_field() {
		return firsttime_label_field;
	}
	public String getFirsttime_radio_mentor() {
		return firsttime_radio_mentor;
	}
	public String getFirsttime_radio_trainee() {
		return firsttime_radio_trainee;
	}
	public String getFirsttime_label_addInfo() {
		return firsttime_label_addInfo;
	}
	public String getFirsttime_label_experience() {
		return firsttime_label_experience;
	}
	public String getFirsttime_btn_add() {
		return firsttime_btn_add;
	}
	public String getFirsttime_btn_submit() {
		return firsttime_btn_submit;
	}
	public String getFirsttime_drop_novice() {
		return firsttime_drop_novice;
	}
	public String getFirsttime_drop_intermediate() {
		return firsttime_drop_intermediate;
	}
	public String getFirsttime_drop_expert() {
		return firsttime_drop_expert;
	}
	public String getFirsttime_drop_loreMaster() {
		return firsttime_drop_loreMaster;
	}
	
	// ============== Home Strings ===================
		private String home_welcome = "Velkommen til MentorFind";
		private String home_please_search = "Skriv i søkefeltet for å starte";
		
		@Override
		public String getHome_welcome() {
			return home_welcome;
		}
		@Override
		public String getHome_please_search() {
			return home_please_search;
		}
		
		
		// ============== Menu Strings ===================
			private String menu_home = "Hjem";
			private String menu_find = "Finn";
			private String menu_profile = "Profil";
			private String menu_settings = "Instillinger";
			private String menu_search = "Søk";
			
		public String getMenu_home() {
			return menu_home;
		}

		public String getMenu_find() {
			return menu_find;
		}

		public String getMenu_profile() {

			return menu_profile;
		}

		public String getMenu_settings() {

			return menu_settings;
		}

		public String getMenu_search() {
			return menu_search;
		}
		
		// ============== Search Results Strings ===================
		private String search_sResult = "Søke resultater";
		private String search_fResult = "Filter resultater";
		private String search_location = "Lokasjon";
		private String search_user = "Bruker";
		private String search_title = "Tittel";
		private String search_description = "Beskrivelse";
		private String search_error = "Du skrev ikke noe i søkefeltet, prøv igjen.";
		private String search_resultStart = "Ditt søk for '";
		private String search_returned = "' retunerte ";
		private String search_success = " resultat(er).";
		private String search_noResults = "' gav ingen resultater, prøv igjen.";
		private String search_name = "Navn";
		@Override
		public String getSearch_sResult() {
			return search_sResult;
		}
		@Override
		public String getSearch_fResult() {
			return search_fResult;
		}
		@Override
		public String getSearch_location() {
			return search_location;
		}
		@Override
		public String getSearch_user() {
			return search_user;
		}
		@Override
		public String getSearch_title() {
			return search_title;
		}
		@Override
		public String getSearch_description() {
			return search_description;
		}
		@Override
		public String getSearch_error() {
			return search_error;
		}
		@Override
		public String getSearch_success() {
			return search_success;
		}
		@Override
		public String getSearch_resultStart() {
			return search_resultStart;
		}
		@Override
		public String getSearch_noResults() {
			return search_noResults;
		}
		@Override
		public String getSearch_returned() {
			return search_returned;
		}
		@Override
		public String getSearch_name() {
			return search_name;
		}
}
