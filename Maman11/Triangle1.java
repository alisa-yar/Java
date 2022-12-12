/*This programm calculating the area and the scope of a triangle
*/
import java.util.Scanner;
public class Triangle1 {
    public static void main (String[] args) {

        Scanner scan = new Scanner (System.in);

        System.out.println("This program calculates the area" 
        + "and the perimeter of a given triangle.");

        System.out.println("Please enter the three lengths"
        + "of the triangle's sides");
        int a = scan.nextInt(); //receives the 1st length from the input
        int b = scan.nextInt(); //receives the 2nd length from the input
        int c = scan.nextInt(); //receives the 3rd length from the input

        int Scope = (a+b+c); //the triangle's scope (perimeter)
        double s = Scope/2.0; //half of the triangle's scope

        //we're calculating triangle's area using Heron's formula:
        double Heron = s*(s-a)*(s-b)*(s-c);
        double Area = Math.sqrt(Heron); 

        System.out.println("The lengths of the triangle sides are: "
        + a + "," + b + "," + c + ".");
        System.out.println("The perimeter of the triangle is: " + Scope);
        System.out.println ("The area of the triangle is: " + Area);

    } //end of method main
} //end of class Triangle1
