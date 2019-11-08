/*
 
    Students will utilize this application to input the number of credit units (CUs) remaining in their degree (must be greater than 0)
    and the number of CUs they plan to complete each term (Must be 12 of greater).  Based on student input, the application will determine the
    number of CUs remaining to graduate, how many terms it will take to graduate, how many months it will take to graduate, and the cost of tuition
    based on terms remaining.
 
Written by:  Ashley Carbone
TXP1 - Project in Introduction to Programming
 
*/

package gradplan;
import java.util.ArrayList;
import java.util.Scanner;
 
public class GradPlan
{
   
    public static void main(String[] args)
    {
       
        double cuPerTerm = 0;
        double tuitionPerTerm = 2890.00;  //Cost of tuition per term.
        int monthsPerTerm = 6;  //One term is six months.
       
        System.out.println("----------------------------");
        System.out.println("Uni Graduation Calculator");
        System.out.println("----------------------------");
        System.out.println("");
    
        Scanner inputCU = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter the number of credit units (CU's) for each class remaining in your degree.");
        System.out.println("Press Enter after each CU entered.");
        System.out.println("Type q and press Enter when finished adding all CU's: ");
      
        while (inputCU.hasNextInt())  //Will loop while user inputs ints.
        {
            int tmp = inputCU.nextInt();  //Converts user input to int with tmp variable so we can complete arithmetic functions later in the program.
            if (tmp > 0)  //CU must be greater than 0.
            {
                list.add(tmp);
            } else
            {
                System.out.println("You must enter a CU greater than 0.");
            }
        }
        inputCU.next();
        
       int totalCU = 0;
        //This will remove the q from input.
        for (int i = 0; i < list.size(); i++)
        {
            totalCU += list.get(i);  //Adds all arrayList inputs and places in totalCU variable.
        }
       
        
        do  //Will prompt user for input even after entering invalid input of less than 12.
        {
            System.out.println("\nPlease enter the number of planned credit units (CUs) you will complete each term. Minimum of 12 units required:");
            if (inputCU.hasNextInt()) //forces the scanner to wait for next int input.
                cuPerTerm = inputCU.nextInt();
        } while (cuPerTerm < 12);  //Minimum CU required per term is 12.
       
        int termsToComplete = (int) Math.ceil(totalCU / cuPerTerm);  //Computes number of terms user will need to complete for graduation.
        double finalCost = (tuitionPerTerm * termsToComplete);  //Computes total cost of tution - $2890 * remaining terms in degree.
        int monthsToComplete = (int)(termsToComplete * monthsPerTerm);  //Computes how many months user will complete for completion.
       
        System.out.println("----------------------------------------------------------------------");
        System.out.println("You have " + totalCU + " CU(s) to complete for graduation.\n"
               + "You will complete your degree in " + termsToComplete + " term(s).\n"
               + "You are on track to graduate in " + monthsToComplete +" month(s).\n"
               + "The cost of tuition based on your remaining term(s) is $" + String.format("%.2f", finalCost));  //Float with two decimal places.
        System.out.println("----------------------------------------------------------------------");
    }      
}