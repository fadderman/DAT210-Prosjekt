package business.sort;

import java.util.Comparator;

import models.User;

public class UserComparator implements Comparator<User> {

	@Override
	public int compare(User u1, User u2) {
		// location
		String country1 = u1.getLocationCountry().toLowerCase();
		String country2 = u2.getLocationCountry().toLowerCase();
		
		int countryComparison = country1.compareTo(country2);
		if(countryComparison != 0) {
			return countryComparison;
		}
		
		String city1 = u1.getLocationCity().toLowerCase();
		String city2 = u2.getLocationCity().toLowerCase();
		
		int cityComparison = city1.compareTo(city2);
		if(cityComparison != 0) {
			return cityComparison;
		}
		
		// name
		String firstName1 = u1.getFirstName().toLowerCase();
		String firstName2 = u2.getFirstName().toLowerCase();
		
		int firstNameComparison = firstName1.compareTo(firstName2);
		if(firstNameComparison != 0) {
			return firstNameComparison;
		}
		
		String lastName1 = u1.getLastName().toLowerCase();
		String lastName2 = u2.getLastName().toLowerCase();
		
		int lastNameComparison = lastName1.compareTo(lastName2);
		if(lastNameComparison != 0) {
			return lastNameComparison;
		}
		
		return 0;
	}

}
