package Main;
// "if this" ? "is true, do this" : "if not then do this"
// how the "? :" stuff works^ 

import java.util.Calendar;

public class Main
{
	public static final int lastMonth = 5;//January = 1
	public static final int lastDay = 24;//first day = 1

	public static int[][] daysOn() //first number (rows) = month, second number (cols) = day of month, 1 if you work, 0 if not
	{
		int[][] arrayOfDays = 
		{
			{}, //January

			{28, 
			                1, 0, //February
			 0, 1, 1, 1, 1, 1, 0,	
			 0, 1, 1, 1, 1, 1, 0, 
			 0, 1, 1, 1, 1, 1, 0,
			 0, 1, 1, 1, 1, 
			},

			{31, 
			                1, 0, //March
			 0, 1, 1, 1, 1, 1, 0,
			 0, 1, 1, 1, 1, 1, 0, 
			 0, 1, 1, 1, 1, 1, 0, 
			 0, 0, 0, 0, 0, 0, 0, 
			 0, 
			},

			{30, 
			    1, 1, 1, 1, 1, 0, //April
			 0, 1, 1, 1, 1, 1, 0, 
			 0, 1, 1, 1, 1, 0, 0, 
			 0, 1, 1, 1, 1, 1, 0, 
			 0, 1, 1, 
			},

			{31, 
			          1, 1, 1, 0, //May
			 0, 1, 1, 1, 1, 1, 0, 
			 0, 1, 1, 1, 1, 1, 0, 
			 0, 1, 1, 1, 1, 1, 0, 
			 0, 0, 1, 1, 1, 1, 0, 
			},

			{30, 
			                   0, //June
			 0, 1, 1, 1, 1, 1, 0,
			 0, 1, 1, 1, 1, 1, 0, 
			 0, 1, 1, 1, 1, 1, 0, 
			 0, 1, 1, 1, 1, 1, 0, 
			 0, 
			},

			{}, //July
			
			{}, //August
			
			{}, //September

			{}, //October

			{}, //November

			{}, //December
		};
		return arrayOfDays;
	}
	
	public static int daysOnUntil(int currentDay, int currentMonth, int targetDay, int targetMonth) //calculates the number of work days between 2 days
	{
		int daysLeft = 0;
		int[][] arrayOfDays = daysOn(); //gets the array of work days/days off (modify that if I marked days wrong)
		for(int i = targetMonth; i >= currentMonth; i--) //runs once for every month
		{
			for(int g = (i == targetMonth ? targetDay : arrayOfDays[i][0]); g >= (i == currentMonth ? currentDay : 1); g--) //runs once for every day
			{
				daysLeft += arrayOfDays[i][g];
			}
		}
		return daysLeft;
	}
	
	public static void main(String [] args)
	{
		Calendar cal = Calendar.getInstance();
		int daysLeft = daysOnUntil(cal.get(Calendar.DAY_OF_MONTH), cal.MONTH - 1, lastDay, lastMonth - 1); //months in my array start at 0 (jan = 0), but days start at 1 ([0] = length of the month (ik, its unnecessary))
		System.out.print(daysLeft);
	}
}