package practice;

import java.time.LocalDateTime;


import vtiger.genericUtility.JavaUtility;

public class GetSysDate 

{
	public static void main(String[] args) 
	{	
		
		LocalDateTime date = LocalDateTime.now();
		System.out.println(date.getYear());
		System.out.println(date.getMonthValue());
		System.out.println(date.getDayOfMonth());
		
		
	//	System.out.println(jUtils.generateDateInYYYY_MM_DD_Format());

		System.out.println("Again updating");

	}
}
