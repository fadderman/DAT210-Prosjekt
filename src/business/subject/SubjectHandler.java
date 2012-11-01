package business.subject;

import java.util.ArrayList;

import models.Subject;

public class SubjectHandler {

	private static ArrayList<Subject> subjectList= new ArrayList<Subject>();
	
	public SubjectHandler(){
		
	}
	
	public void addSubject(Subject subjectToAdd){
		synchronized (subjectList) {
			subjectList.add(subjectToAdd);
		}
	}
	
	public Subject getSubjectByIndex(int index){
		return subjectList.get(index);
	}
	
	public int getSubjectListSize(){
		return subjectList.size();
	}
	
}
