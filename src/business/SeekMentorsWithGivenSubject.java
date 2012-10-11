package business;

import java.util.LinkedList;

import models.User;

public class SeekMentorsWithGivenSubject<E> implements Comparable<E> {
	
	//skal bruken en metode fra Controlleren får å få inn i hvilket faget mentor bli søkt i
	//tom for nå
	private String subject = "";
	//skal bruk en metode fra usermanagement for å få
	private LinkedList<User> mentors;
	
	
	
	
	
	
	@Override
	public int compareTo(E object) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
