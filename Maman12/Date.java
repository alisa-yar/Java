//Using a class to represent a Date object
 
public class Date {

/*********** Declarations ***********/
  
//Instance Variables:
  
  private int _day; //represent the day
  private int _month; //represent the month
  private int _year; //represent the year 

//Constant Values:
  
  //the minimum valid date:
  public static final int MIN_DAY = 1; 
  public static final int MIN_MONTH = 1;
  public static final int MIN_YEAR = 1000;
  
  //the maximum valid date:
  public static final int MAX_DAY = 31;
  public static final int MAX_MONTH = 12;
  public static final int MAX_YEAR = 9999; 
  
  //the deafult date, in case the date is invalid:
  public static final int DAY = 1;
  public static final int MONTH = 1;
  public static final int YEAR = 2000; 
  
  //the first day of the month:
  public static final int FIRST_DAY = 1;
  
  //the first month of the year:
  public static final int FIRST_MONTH = 1;

  private final int DAY28=28;
  private final int FEB = 2;

  //months with 30 days:
  private final int DAY30 = 30;
  private final int APRIL = 4, JUN = 6, SEP = 9, NOV = 11;

  //months with 31 days:
  private final int DAY31=31;
  private final int JAN = 1, MARCH = 3, MAY = 5, JUL = 7;
  private final int AUG = 8, OCT = 10, DEC = 12;

/*********** Constructors ***********/
  
/*Creates a new Date object
If the given date is valid - creates a new Date object, otherwise creates the date 1/1/2000
day - represent the day (1-31)
month - represent the month (1-12)
year - represent the year (consists of 4 positive digits)*/
  
  public Date (int day, int month, int year) {
    if (isValid(day, month, year)) { //if the date is a valid date
      this._day = day;
      this._month = month;
      this._year = year;
    }
    else 
    if (!(isValid(day, month, year))) { //if the 'other' date is an invalid date
      this._day = DAY;
      this._month = MONTH;
      this._year = YEAR;
    }
  }


//Copy Constructor:
//Construct a date with the same coordinates as other date.
  
  public Date (Date other) {
    this._day = other._day;
    this._month = other._month;
    this._year = other._year;
  }


/*********** Methods ***********/

//Get() Method:
 
  public int getDay() {
    return this._day;
  }

  public int getMonth() {
    return this._month;
  }

  public int getYear() {
    return this._year;
  }


//Set() Method:
 
  public void setDay (int dayToSet) {
    if (isValid(dayToSet, this._month, this._year))
      this._day = dayToSet;
  }

  public void setMonth (int monthToSet) {
    if (isValid(this._day, monthToSet, this._year))
      this._month = monthToSet;
  }
  
  public void setYear (int yearToSet) {
    if (isValid(this._day, this._month, yearToSet))
      this._year = yearToSet;
  }


//equals() Method:
//return true - if the cars are the same, otherwise false
  
  public boolean equals (Date other) {
    return (this._day == other.getDay() && 
            this._month == other.getMonth() &&
            this._year == other.getYear());
  }


//before() Method
/*checks if this date comes before a given date
return true - if 'this' date comes before 'other' date ('this'<'other')*/
  
  public boolean before (Date other) { 
    
    if (this._year < other.getYear()) //if 'this' year is earlier than 'other' year
      return true;
    else if (this._year == other.getYear()) { //if they both have the same years
      if (this._month < other.getMonth()) //if 'this' month is earlier than 'other' month
        return true;
      if (this._month == other.getMonth() &&
      this._day < other.getDay()) //'this' day is earlier than 'other' day
        return true;      
    }
    return false; 
  }


//after() Method
/*checks if this date comes after a given date
return true - if 'this' date comes after 'other' date*/
  
  public boolean after (Date other) {
    return (other.before(this));
  }


//difference() Method
/*Calculates the difference between 'this' date and 'other' date
the difference should be positive no matter which date came first*/
  
  public int difference (Date other) {
    /*total number of 'this' days since the beginning 
    of the Christian counting of years: */
    int thisDays = calculateDate(this._day, this._month, this._year); 
    /*total number of 'other' days since the beginning 
    of the Christian counting of years: */
    int otherDays = calculateDate(other.getDay(), other.getMonth(), other.getYear());
    //the absolute value of the difference between 'this' days and 'other' days 
    int diff = Math.abs(thisDays - otherDays);
    return diff;
  }


//toString() Method:
/*Returns String that represents 'this' date 
in the following format: day.month.year (12/05/2019)*/
  
  public String toString() {
    String strDay = "" + this._day; //converting the day from int to string
    String strMonth = "" + this._month; //converting the month to a string
    String strYear = "" + this._year; //converting the year to a string

    if (this._day < 10) { //if the day number is less than 10
      strDay = "0" + this._day; //adding '0' to the day
    }
    if (this._month < 10) { //if the month number is less than 10
      strMonth = "0" + this._month; //adding '0' to the month
    }
    return (strDay + "/" + strMonth + "/" + strYear);
  }


//tomorrow() Method:
/*Returns new date object of the day after 'this' date
in the following format: day.month.year (15/12/2019)
we can assume that: 'this' date != 31/12/9999
(example: 28/02/2021 -> 01/03/2021)*/
  
  public Date tomorrow() { 
    //creating new date object that'll represent the next date  
    if (!(isValid(this._day+1, this._month, this._year))) {//next day invalid
      if (isValid(MIN_DAY, this._month+1, this._year))
        return (new Date(MIN_DAY, this._month+1, this._year));
      else
        return (new Date (MIN_DAY, MIN_MONTH, this._year+1)); //next year
    }
    else //valid next day
      return (new Date(this._day+1, this._month, this._year));
  }      
          

//calculateDate Method:
//Computes the day number since the beginning of the Christian counting of years
  private int calculateDate (int day, int month, int year) {
    if (month < 3) {
      year--; 
      month = month + 12;
    }
    return (365 * year + year / 4 - year / 100 + year / 400 +
      ((month + 1) * 306) / 10 + (day - 62));
  }


//isDayValid() Method:
//Checks if given day is valid
  
  private boolean isDayValid (int day) {
    if (day < MIN_DAY || day > MAX_DAY)
      return false;
    else
      return true;
  }


//isMonthValid() Method:
/*Checks if given month is valid:
A century year (ending with 00) is a leap year only if it is divisible by 400.
A century year should be divisible by 4 and 100 both.
A leap year (except a century year) can be identified if it is exactly divisible by 4.
A non-century year should be divisible only by 4.*/
 
  private boolean isMonthValid (int day, int month, int year) {
    if (month < MIN_MONTH || month > MAX_MONTH)
      return false;
    if (month == 2 && day >= 29) { //the 29/02 is valid only if it's a leap year
      if (year % 4 == 0 && year % 100 != 0 || //it's a regular leap year
      year % 400 == 0) //it's a century, thus, it's a leap year
        return true; 
    }
    else if (day == DAY30) {
      if (month == APRIL || month == JUN || month == SEP || month == NOV)
        return true;
      else 
        return false;
    }
    else if (day == DAY31) {
      if (month == JAN || month == MARCH || month == MAY || month == JUL ||
      month == AUG || month == OCT || month == DEC )
        return true;
      else         
        return false;
    }
    return true;
  }


//isValid() Method:
//Checks if given date is valid
  
  private boolean isValid (int day, int month, int year) {
    if (isDayValid(day) && //if the day is valid
    (month >= MIN_MONTH && month <= MAX_MONTH) && //if the month is valid
    (year >= MIN_YEAR || year <= MAX_YEAR)) //if the year is valid
      return true;
    else //the date is invalid
      return false;
  }

//returnBefore() Method:
/*Checks if 'this' date is before 'other' date
Returns new date object representing the earlier date
if the dates are equal - return 'null'*/
  
  public Date returnBefore (Date other) {
    if (!(this.equals(other))) { //if the dates are unequal
      if (this.before(other)) //if 'this' is earlier than 'other'
        return (new Date(this._day, this._month,this._year));
      else //if 'other' is earlier than 'this' return other date
        return (new Date(other.getDay(), other.getMonth(), other.getYear()));
    } 
    else //if the dates are equal
      return null;
  }
    
//returnAfter() Method:
/*Checks if 'this' date is after 'other' date
Returns new date object representing the latest date
if the dates are equal - return 'null'*/
  
  public Date returnAfter (Date other) {
    if (!(this.equals(other))) { //if the dates are unequal
      if (this.after(other)) //if 'this' is later than 'other'
        return (new Date(this._day, this._month,this._year));
      else //if 'other' is later than 'this' return 'other' date
        return (new Date(other.getDay(), other.getMonth(), other.getYear()));
    } 
    else //if the dates are equal
      return null;
  }

}//end Date class

