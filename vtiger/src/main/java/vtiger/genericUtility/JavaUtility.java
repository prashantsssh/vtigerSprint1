package vtiger.genericUtility;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;
import java.util.Random;

/**
 * This Class has all the java related generic methods
 * @author user
 *
 */
public class JavaUtility 
{
	/**
	 * This methods returns a random number depending on the user input
	 * @param limit
	 * @return
	 */
	public int generateRandom(int limit)
	{
		Random random = new Random();
		return random.nextInt(limit);
		//random.nextInt(1000);
	}
	/**
	 * This method generates system date and time
	 * @return
	 */
	public String generateSystemDateAndTime()
	{
		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", "_");
		//It is done to prevent File not found exception as we know it as we are experienced engineer.
	}
	
	public String generateDateInYYYY_MM_DD_Format()
	{
		LocalDateTime date = LocalDateTime.now();
		int year = date.getYear();
		int month = date.getMonthValue();
		int day = date.getDayOfMonth();
		String newDay;
		String newMonth;
		if(day<10)
		{
			newDay="0"+day;
			return year+"-"+month+"-"+newDay;
		}
		if(month<10)
		{
			newMonth="0"+month;
			return year+"-"+newMonth+"-"+day;
		}
		else
			return year+"-"+month+"-"+day;
	}
}
