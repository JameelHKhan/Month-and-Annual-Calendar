/*
 * Jameel H. Khan
 * Module 4 - Problem 1
 * EN.605.201.83.SP21
 */

// import required packages
import java.util.Scanner;

public class Month 
{
  public static void main ( String [] args)
  {
	  // Define and initialize variables for values to be input
	  int m = 0;               // first value to be input, represents month
	  int y = 0;               // second value to be input, represents year
	  
	  // Use a Scanner to input month and year values
	  Scanner input = new Scanner( System.in );
	  System.out.println( "\n");
	  System.out.print( "Enter a numerical value for a month between 1 and 12: ");
	  m = input.nextInt();     // Input month
	  System.out.print( "Enter a four-digit number for the year (e.g. 2012): " );
	  y = input.nextInt();     // Input year
	  
	  // output using method printMonthCalendar()
	  printMonthCalendar( m, y );
  } // end of main method

/*
 * The method printMonthCalendar() declares three int variables and calls four methods
 * to print a formatted monthly calendar.
 * 
 * @param m is the name of the month chosen by the user
 * @param y is the year chosen by the user
 * @param d is a value for day of the month, but must always be assigned to int 1
 * @param startDay is the 1st day of the month. The value is assigned the returned
 *                 value of the getStartDay() method
 * @param numDaysInMo is the number of days in the given month. The value is
 *                 assigned the returned value of the getNumDaysInMonth() method
 * @return a standard calendar for the month, delineated by a seven-day week is returned
 * 
 * Preconditions: m is a string, although at the start of the program it was an int
 *                y is a four-digit int
 *                
 * Postcondition: A visual display of the selected month within the selected year
 *                is prepared to be output for the user
 * 
 * @author: this was provided by Dr. Rubey during the week 4 office hours session
 */

  public static void printMonthCalendar( int m, int y )
  {
	  int d = 1; // declare variable d, which is used in getStartDay() method
	  int startDay = getStartDay( m, d, y );   // determine 1st day of month
	  int numDaysInMo = getNumDaysInMonth( m, y ); // determine # of days in month
	  System.out.println( "\n");
	  printMonthHeader( m, y );                // Print the header information
	  printMonthBody( startDay, numDaysInMo ); // Print the body of the month calendar
  } // end of method printMonthCalendar()

/*
 * The method printMonthHeader() prints the first three lines of the monthly 
 * calendar selected by the user. It displays the month and year, then a line 
 * of hyphens, and then lists the seven-day week.
 * 
 * @param m is the name of the month chosen by the user
 * @param y is the year chosen by the user
 * @return the first three lines of a standard seven-day calendar for the month 
 *         is returned
 * 
 * Preconditions: m is a string, although at the start of the program it was an int
 *                y is a four-digit int
 *                
 * Postcondition: A visual display of the first three lines of a standard seven-day 
 *                calendar for the month selected within the selected year is printed 
 *                for the user
 * 
 */

  public static void printMonthHeader( int m, int y )
  {
	  System.out.println( "         " + getMonthName( m ) + "  " + y );
	  System.out.println( "-----------------------------" );
	  System.out.println( " Sun Mon Tue Wed Thu Fri Sat" );
  } // end of method printMonthHeader()

/*
 * The method printMonthBody() prints the numerical dates of the month according 
 * to the respective day of the week in the standard grid/matrix format.
 * 
 * @param startDay indicates which of the seven days of the week the first day of 
 *        the month begins. The value is determined by the getStartDay() method
 * @param numDaysInMo is the number of days within the given month (i.e. 28, 29, 
 *                    30, or 31). The value is determined by the getNumDaysinMonth()
 *                    method
 * @param i is a integer used to regulate the for loop iterations
 * 
 * Preconditions: startDay is an int value between 1 through 7
 *                numDaysInMo is an int value of 28, 29, 30, or 31
 *                
 * Postcondition: A visual display of a monthly calendar, delineated by the seven-
 *                day week, is printed for the user
 */
  
  public static void printMonthBody( int startDay, int numDaysInMo )
  {
	  int i = 0; // declare variable i to iterate in for loops
	  /* this if statement resets the startDay to 0 if the first day of the month 
	   * is a Sunday. Otherwise, the first for loop will have an error and print 
	   * extra white spaces for the first seven days of the calendar */
	  if (startDay == 7)
	  {
		  startDay = 0;
	  }
	  // prints white space for the first few days of the week prior to start date
	  for (i = 0; i < startDay; i++)
	  {
		  System.out.print("    ");
	  }
	  /* iterates printouts of date values starting from 1 to the last day of the 
	   * month counting from the first day of the month */
	  for (i = 1; i <= numDaysInMo; i++) 
	  {
		  if (i < 10)
		  { // prints extra space for single-date digits
			  System.out.print("   " + i);
		  }
		  else
		  { // prints one less space for double-date digits
			  System.out.print("  " + i);
		  }
		  if ((i + startDay) % 7 == 0)
		  { // moves cursor to new line after completing seven-day week
			  System.out.println();
		  }
	  }
	  System.out.println();
  } // end of method printMonthBody()

/*
 * The method getMonthName() determines the name of the month based on the digit
 * value of the month inputed by the user.
 * 
 * @param m is the name of the month chosen by the user, inputed as an int
 * @param monthName is a variable string that is assigned the corresponding name 
 * of the month the user chose
 * 
 * Pre-condition: m is an int value between 1 and 12
 * 
 * Postcondition: returns monthName, which is a string containing the name of 
 *                 the month that corresponds to the int m that the user inputed
 * 
 */
  
  public static String getMonthName( int m )
  {
	  String monthName = null;
	  switch( m ) // correlates name of month to selected int input
	  {
	   case 1:
		   monthName = "January";
		   break;
	   case 2:
		   monthName = "February";
		   break;
	   case 3:
		   monthName = "March";
		   break;
	   case 4:
		   monthName = "April";
		   break;
	   case 5:
		   monthName = "May";
		   break;
	   case 6:
		   monthName = "June";
		   break;
	   case 7:
		   monthName = "July";
		   break;
	   case 8:
		   monthName = "August";
		   break;
	   case 9:
		   monthName = "September";
		   break;
	   case 10:
		   monthName = "October";
		   break;
	   case 11:
		   monthName = "November";
		   break;
	   case 12:
		   monthName = "December";
		   break;
	  }
	  return monthName; // started with int m, returns string of month name
  } // end of method getMonthName()

/*
 * The method getStartDay() implements Zeller's Algorithm for determining the day of the
 * week the first day of a month is. The method adjusts Zeller's numbering scheme
 * for day of week ( 0=Saturday, ..., 6=Friday ) to conform to a day of week number
 * that corresponds to ISO conventions (i.e., 1=Monday, ..., 7=Sunday)
 *
 * Pre-Conditions: The month value, m,  is 1-12
 *                 The day value, d, is 1-31, or 1-28, 1-29 for February
 *                 The year value, y, is the full year (e.g., 2012)
 *                 
 * Postconditions: A value of 1-7 is returned, representing the first day of the month
 *                       1 = Monday, ..., 7 = Sunday
 */

  public static int getStartDay( int m, int d, int y )
  {
      // Adjust month number & year to fit Zeller's numbering system
      if (m < 3) 
      {
          m = m + 12;
          y = y - 1;
      }
      
      int k = y % 100;      // Calculate year within century
      int j = y / 100;      // Calculate century term
      int h = 0;            // Day number of first day in month 'm'
      
      h = ( d + ( 13 * ( m + 1 ) / 5 ) + k + ( k / 4 ) + ( j / 4 ) +
          ( 5 * j ) ) % 7;
      
      // Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
      int dayNum = ( ( h + 5 ) % 7 ) + 1;     
      
      return dayNum;
  } // end of method getStartDay()

/*
 * The method getNumDaysinMonth() determines the total number of days within 
 * the month that was selected by the user.
 * 
 * @param m is the name of the month chosen by the user
 * @param y is the year chosen by the user
 * 
 * Pre-conditions: m is an int value between 1 and 12
 *                 y is an four-digit int corresponding to a year
 *                 
 * Postcondition: A value of 31, 30, 29, or 28 is returned representing the number
 *                of days within the user selected month
 */
  
  public static int getNumDaysInMonth( int m, int y )
  {
	  if( m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12 )
	  {
		  return 31; // these months have 31 days
	  }
	  else if( m == 4 || m == 6 || m == 9 || m == 11)
	  {
		  return 30; // these months have 30 days
	  }
	  else if( m == 2 )
	  {
		  return isLeapYear( y ) ? 29 : 28;
	  }
	  else
	  {
	  /* This portion of the if statement may not be necessary, however without it
	   * being here I kept on getting an error, that's why it is included */
		  return 0;
	  }
  } // end of method getNumDaysInMonth()

/*
 * The method isLeapYear() determines whether the year inputed by the user is a leap
 * year (i.e. a year where February has 29 days instead of 28 days) or not. It 
 * evaluates the input y value based on the leap year formula/criteria and returns 
 * as True or False.
 * 
 * @param y is the year chosen by the user
 * 
 * Pre-condition: y is an four-digit int corresponding to a year
 * 
 * Postcondition: A True or False is returned, True if the y value is a leap year,
 *                False if the y value is not a leap year
 */
  
  public static boolean isLeapYear( int y )
  {
	  return y % 400 == 0 || (y % 4 == 0 && y % 100 != 0);
  } // end of method isLeapYear()

} // end of main method