package cz.uhk.raidplanner.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateManipulation {

	
	public Date joinDateAndTime(Date date, String time) {
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = df.format(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date newDate;
		try {
			newDate = sdf.parse(dateInString + " " + time);
		} catch (ParseException e) {
			newDate = date;
			e.printStackTrace();
		}		
		return newDate;
	}
}
