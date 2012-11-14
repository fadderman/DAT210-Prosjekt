package business.sort;

import java.util.Comparator;

import models.Field;

public class FieldComparator implements Comparator<Field> {

	@Override
	public int compare(Field f1, Field f2) {
		
		String fieldTitle1 = f1.getTitle();
		String fieldTitle2 = f2.getTitle();
		return fieldTitle1.compareTo(fieldTitle2);
	}


}
