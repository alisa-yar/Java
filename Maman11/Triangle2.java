/*This programm checks whether 3 given numbers can form the sides of a triangle
*/
import java.util.Scanner;

class Triangle2 {
    public static void main (String[] args) {

        Scanner scan = new Scanner (System.in);

        System.out.println("This program checks whether the lengths represent a triangle" 
        + "or not, and if they are - what type of triangle they representing.");

        System.out.println("Please enter the three lengths "
        + "of the triangle's sides:");
        int a = scan.nextInt(); //receives the 1st length from the input
        int b = scan.nextInt(); //receives the 2nd length from the input
        int c = scan.nextInt(); //receives the 3rd length from the input

        if (a<=0 || b<=0 || c<=0){ //checking if the lengths are negative or zero
            System.out.println("The numbers: " + a + " , " + b + " and " + c 
            + " cannot represent a triangle");}

        if (a+b>=c && a+c>=b && b+c>=a){ //checking if the lengths can represent a triangle
            if (a==b || a==c || b==c){ //checking if 2 out 3 lengths are equal
                if (a==b && a==c && b==c){ //checking if all the lengths are equal
                    System.out.println("The numbers: " + a + " , " + b + " and " + c 
                    + " represent an equilateral triangle");
                }
                else { //if just 2 out of 3 lengths are equal
                    System.out.println("The numbers: " + a + " , " + b + " and " + c 
                    + " represent an isosceles triangle");
                }
            }//the first "if" inside the first "else if" (checks if 2/3 are equal)

            // right-angle triangle check
            else if ((Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) ||
                     (Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2)) || 
                     (Math.pow(c, 2) + Math.pow(b, 2) == Math.pow(a, 2))){
                    
                System.out.println("The numbers: " + a + " , " + b + " and " + c 
                    + " represent a right-angle triangle");
            }
            else {
                System.out.println("The numbers: " + a + " , " + b + " and " + c 
                + " represent a common triangle");
            }
        }//the "else if" that checking if the lengths can represent a triangle
    }//end of the main class
} //end of the Triangle2 class
