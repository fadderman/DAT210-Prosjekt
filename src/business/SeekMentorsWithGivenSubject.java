package business;

import java.util.LinkedList;

import models.User;

public class SeekMentorsWithGivenSubject<E> implements Comparable<E> {
	
	//skal bruken en metode fra Controlleren f�r � f� inn i hvilket faget mentor bli s�kt i
	//tom for n�
	private String subject = "";
	//skal bruk en metode fra usermanagement for � f�
	private LinkedList<User> mentors;
	
	
	
	
	
	
	@Override
	public int compareTo(E object) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
