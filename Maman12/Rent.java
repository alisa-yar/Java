//Using a class to represent a Rent object

public class Rent {

/*********** Declarations ***********/

//Instance Variables:
    private String _name; //represent the clint's name
    private Car _car; //represent the rented car
    private Date _pickDate; //represent the client's pickup date of the car
    private Date _returnDate; //represent the client's return date of the car

//Constant Values:
  public static final int PRICE_A = 100; //the daily price of an 'A' car
  public static final int PRICE_B = 150; //the daily price of a'B' car
  public static final int PRICE_C = 180; //the daily price of a 'C' car
  public static final int PRICE_D = 240; //the daily price of a 'D' car
  public static final int DAYS_IN_WEEK = 7; 
  public static final double FULL_WEEK_PRICE = 0.9; //full week price after the 10% discount


/*********** Constructors ***********/

/*Creates a new Rent object
we can assume that the parameters different than 'null' and that client's name is valid
The return date must be at least one day after the pickup date, 
otherwise set it to one day after the pick up date.*/
    
  public Rent (String name, Car car, Date pick, Date ret) {
    this._name = name;
    this._car = car;
    this._pickDate = pick;
    
    if (ret.after(pick) && ret.difference(pick) > 1)
      this._returnDate = ret; 
      /*true - if the return date is after the pick up date
      and if the difference between them is more than 1 day */

    else //if the return day is invalid, we set up the return day to one day after the pick up date
      this._returnDate = pick.tomorrow();
  }

//Copy Constructor:

 public Rent (Rent other){
   this._name = other._name;
   this._car = other._car;
   this._pickDate = other._pickDate;
   this._returnDate = other._returnDate;
 }

    
/*********** Methods ***********/

//Get() Method:
  
  public String getName() {
    return this._name;
  }

  public Car getCar() {
    return this._car;
  }

  public Date getPickDate() {
    return this._pickDate;
  }

  public Date getReturnDate() {
    return this._returnDate;
   }

//Set() Method:
  public void setName (String name) {
    this._name = name;
  }

  public void setCar (Car car) {
    this._car = car;
  }

  public void setPickDate (Date pickDate) {
    if ((pickDate.difference(this._returnDate)) > 1)
      this._pickDate = pickDate;
  }

  public void setReturnDate (Date returnDate) {
    if ((returnDate.difference(this._pickDate)) > 1)
      this._returnDate = returnDate;
  }

//equals() Method:
/*Checks if 2 rents are the same
Rents considered as same if they have the client name, pick up & return dates and the same cars
return true - if the rents are the same, otherwise false*/
  
  public boolean equals (Rent other) {
    if (this._name.equals(other.getName()) &&
        this._pickDate.equals(other.getPickDate()) &&
        this._returnDate.equals(other.getReturnDate()) &&
        this._car.equals(other.getCar())) 
        return true;
     else
        return false;
  }
  
//howManyDays() Method:
//Returns the total number of the rent days
  public int howManyDays() {
    return (this._pickDate.difference(this._returnDate));
  }

//getPrice() Method:
//Returns the total rent price
  public int getPrice () {
    int totalDays = this.howManyDays();
    int discWeeks = totalDays / 7; //the days that are included in the discount, it'll return 0 if its less than 7
    int extraDays = (int)(totalDays % 7); //the days that aren't included in the discount
    //int extraDays = totalDays - discDays;
    int discPrice; //the price of the days that are included in the discount
    int extraPrice; //the price of the days that not included in the discount:

    int Price = 0;

    //finding the daily price of the rented car:
    if (this._car.getType() == 'A') {
      Price = (int)(discWeeks * PRICE_A * FULL_WEEK_PRICE * DAYS_IN_WEEK) + (extraDays * PRICE_A);
    }
    if (this._car.getType() == 'B') {
      Price = (int)(discWeeks * PRICE_B * FULL_WEEK_PRICE * DAYS_IN_WEEK) + (extraDays * PRICE_B);
    }
    if (this._car.getType() == 'C') {
      Price = (int)(discWeeks * PRICE_C * FULL_WEEK_PRICE * DAYS_IN_WEEK) + (extraDays * PRICE_C);
    }
    if (this._car.getType() == 'D') {
      Price = (int)(discWeeks * PRICE_D * FULL_WEEK_PRICE * DAYS_IN_WEEK) + (extraDays * PRICE_D);
    }
    
    return Price;
  }    

//upgrade() Method:
/*If possible, upgrade the car to a better car
If the given car is better than the current car of the rent, upgrade it 
and return the upgrade additional cost, otherwise, don't upgrade and return 0*/
  
  public int upgrade (Car newCar) {
    if (newCar.better(this._car)) {
      Rent newRent = new Rent (_name, newCar,_pickDate, _returnDate);
      return newRent.getPrice() - this.getPrice();
    }
    else //if 'this' car is better or equal to 'newCar'
      return 0;
  }      


//overlap() Method:
/*Check if there is a double listing of a rent for the same person and car with an overlap in the rental days.
If there is - return a new rent object with the unified dates, otherwise - return null.*/
  
  public Rent overlap (Rent other) {
    Date beforeDate = this._pickDate.returnBefore(other.getPickDate());
    Date afterDate = this._returnDate.returnAfter(other.getReturnDate());
    //if the names or the cars aren't equal:
    if (!(this._name.equals(other.getName()) || !(this._car.equals(other.getCar()))))
      return null;
    else { //if the name's and the car's are equal:
      if (this._car.equals(other.getCar()) && this._name.equals(other.getName()))
        if (beforeDate != null && afterDate != null) //if the dates aren't 'null'
          return (new Rent(this._name, this._car, beforeDate, afterDate));
    }
    return null;
  }  


//toString() Method:
/*Returns a String that represents this rent in the following format:
Name:Rama From:30/10/2022 To:12/11/2022 Type:B Days:13 Price:1845*/
  
  public String toString() {
    return ("Name:" + this._name + " From:" + this._pickDate + " To:" + this._returnDate + " Type:" + this._car.getType() + 
            " Days:" + this.howManyDays() + " Price:" + this.getPrice());
  }

}//end of Rent class
