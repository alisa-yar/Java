//Using a class to represent a Car object

public class Car {

/*********** Declarations ***********/
	
//Instance Variables:
	
  private int _id; //The license number of the car
  private char _type; //The rank of the car
  private String _brand; //The manufacturer of the car
  private boolean _isManual; //boolean value representing whether the car is manual or not

//Constant Values:
	
  public static final int ID = 9999999; //the deafult id, if the input is invalid
  public static final char TYPE = 'A';  //the deafult type, if the input is invalid
 

/*********** Constructors ***********/
	
/*Creates a new Car object  

id - The license number of the car (7 digits number).
id should be a 7 digits number, otherwise set it to 9999999.

type - The rank of the car ('A','B','C' or 'D').
type should be 'A','B','C' or 'D', otherwise set it to 'A'.

brand - The manufacturer of the car.
we can assume that car's brand is not 'null'.

isManual - boolean value representing whether the car is manual or not*/
	
  public Car (int id, char type, String brand, boolean isManual) {
    this._brand = brand;
    this._isManual = isManual;
    if (validId(id)) //if the id is valid
      this._id = id;
    else //if the id is invalid
        this._id = ID;
    if (validType(type)) //if the type is valid
      this._type = type;
    else //if the type is invalid
        this._type = TYPE;
  }

//Copy Constructor:
//Construct a car with the same coordinates as other car.

  public Car (Car other) {
    this._id = other._id;
    this._type = other._type;
    this._brand = other._brand;
    this._isManual = other._isManual;
  }


/*********** Methods ***********/
	
//Get() Method:
 
  public int getId() {
    return this._id;
  }

  public char getType() {
    return this._type;
  }

  public String getBrand() {
    return this._brand;
  }

  public boolean isManual() {
    return this._isManual;
  }


//Set() Method:
 
  public void setId (int id) {
    if (validId(id)) //if the id is valid
      this._id = id;
  }

  public void setType (char type) {
    if (validType(type)) //if the type is valid
      this._type = type;
  }

  public void setBrand (String brand) {
    this._brand = brand;
  }

  public void setIsManual (boolean manual) {
    this._isManual = manual;
  }

//toString() Method:
/*Returns a String object that represents this car in the following format:
id:1234567 type:B brand:Toyota gear:manual (or auto)*/
  
  public String toString () {
    String gear = ""; //new string to represent the gear
    if (this._isManual) //if the car is manual
      gear = "manual";
    else //if the car is automatic
      gear = "auto";
  
    return ("id:" + this._id + " type:" + this._type + " brand:" +
	    this._brand + " gear:" + gear);
  }

//equals() Method:
/*Comparison between strings is performed using the equals method of the String class.
Cars considered as same if they have the same type, brand and gear.
returns true - if the cars are the same, otherwise false.*/
  
  public boolean equals (Car other) {
    if (this._type == other.getType() &&
    this._brand.equals(other.getBrand()) &&
    this._isManual == other.isManual())          
      return true; //if the type, the brand and the manual/or not is same
    else
      return false; //if the cars aren't equal 
  }

//better() Method:
/*Checks if 'this' car is better than the 'other' car.
A car is considered better than another car if it has a higher type (rank).
A < B < C < D (D is the highest and A is the lowest).
If both cars have the same type, the automated car is better than the manual.
return true - if 'this' car is better than the 'other' car, otherwise false.*/
  
  public boolean better (Car other) {
    if (this._type == other.getType()) { //if the cars have the same type			
	    
      if (this._isManual == other.isManual()) //if they have the same gear
	      return false;	//the cars are the same and there isn't a better car
      
      else //if (this._isManual != other.isManual()) {
        return (other.isManual());
        /*automated car is better than manual car.
        if 'other' car is manual then 'this' car is automated 
        and it'll return true,
        which means that true is equal to saying that: 
        'this' car is automated and thus it's better*/
    }
    else //if (this._type != other.getType())	//The cars have different types
      return (this._type > other.getType());	//true: 'this' has a higher type 
  }

//worse() Method:
//return true - if 'this' car is worse than the 'other' car, otherwise false.
  
  public boolean worse (Car other) {
    return (other.better(this));
    //true = 'this' car is worse if the 'other' car is better
  }

//validId() Method:
/*Checks if the id is valid (7 digits and positive)
return true - if the id is valid.*/
  
  public boolean validId (int id) {
    String strId = "" + id;
    if (id > 0 && strId.length() == 7) //valid id
      return true;
    else //invalid id
      return false;
  }


//validType() Method:
/*Checks if the type is valid
Type should be 'A','B','C' or 'D'
return true - if the type is valid.*/
  
  public boolean validType (char type) { 
    //if the type is valid
    if (type == 'A' || type == 'B' || type == 'C' || type == 'D') 
      return true;
    else //invalid type
      return false;
  }


} //end of class Car

