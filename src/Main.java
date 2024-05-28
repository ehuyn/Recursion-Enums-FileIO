import java.util.Scanner;
import java.lang.IllegalArgumentException;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SeriesCategory theSeries = null;
        boolean flag;
        String other = "";
        String series = "";
        double startVal = 0.0;
        double var;
        double sum = 0;
        int numTerms = 0;
        int play;

        do{
            flag = true;
            while(flag){
                System.out.print("Series Categories: ");
                SeriesCategory.printSeriesCategories();

                // Get values for parameters that are common to all series categories from the user
                // ie. series category, starting value, number of terms
                try{
                    System.out.print("Choose a series category: ");
                    flag = false;
                    series = in.next();
                    theSeries = SeriesCategory.valueOf(series);
                    startVal = getValidDoubleInput("\nStarting Value: ");
                    numTerms = getValidIntInput("Number of Terms: ", 2, Integer.MAX_VALUE);
                } catch (IllegalArgumentException e){
                    System.out.println("Not a valid series category.\n");
                    flag = true;
                }
            }

            switch(theSeries){
                case ARITHMETIC:
                    // Get common difference
                    var = getValidDoubleInput("Common Difference: ");
                    // Calculate sum of the given terms in this series
                    sum = Recursion.arithmeticSum(startVal, var, numTerms, 1, 0.0);
                    other = "" + var;
                    break;
                case GEOMETRIC:
                    // Get common ratio
                    var = getValidDoubleInput("Common Ratio: ");
                    // Calculate sum of the given terms in this series
                    sum = Recursion.geometricSum(startVal, var, numTerms, 1, 0.0);
                    other = "" + var;
                    break;
                case FIBONACCI:
                    // Get second term
                    var = getValidDoubleInput("Second Term: ");
                    // Calculate sum of the given terms in this series
                    sum = Recursion.fibonacciSum(startVal, var, numTerms, 1, 0.0);
                    other = "" + var;
                    break;
                case HARMONIC:
                    // Get change in interval
                    var = getValidDoubleInput("Change in Interval: ");
                    // Calculate sum of the given terms in this series
                    sum = Recursion.harmonicSum(startVal, var, numTerms, 1, 0.0);
                    other = "" + var;
                    break;
            }

            System.out.println("The sum of the given terms in this series is " + sum + ".");
            Save.saveSum(series, startVal, numTerms, sum, other);
            System.out.println();
            play = getValidIntInput("Would you like to run the program again (0 for no, 1 for yes)? ", 0, 1);
            System.out.println();
        } while(play == 1);
        System.out.println("Goodbye!");
    }

    // Get valid integer input from user for the desired number of terms and for confirmation to play again
    private static int getValidIntInput(String prompt, int min, int max){
        Scanner in = new Scanner(System.in);
        int input = -1;
        boolean isInvalid;

        do{
            isInvalid = false;

            try{
                System.out.print(prompt);
                input = Integer.parseInt(in.nextLine());

                if(input < min && max == Integer.MAX_VALUE){
                    isInvalid = true;
                    System.out.println("Integer must be greater than " + min + ".\n");
                }
                else if(input < min || input > max){
                    isInvalid = true;
                    System.out.println("Input must be " + min + " or " + max + ".\n");
                }
                else if(String.valueOf(input).equals(null)){
                    isInvalid = true;
                    System.out.println("Invalid input. Nothing entered.\n");
                }

            } catch (NumberFormatException e){
                System.out.println("Invalid input. Only integers allowed.\n");
                isInvalid = true;
            }

        }while(isInvalid);
        return input;
    }

    // Get valid double input from user for start values and series-specific variable values
    private static double getValidDoubleInput(String prompt){
        Scanner in = new Scanner(System.in);
        Double input = -1.0;
        boolean isInvalid;

        do{
            isInvalid = false;

            try{
                System.out.print(prompt);
                input = Double.parseDouble(in.nextLine());

                if(String.valueOf(input).equals(null)){
                    isInvalid = true;
                    System.out.println("Invalid input. Nothing entered.");
                }

            } catch (NumberFormatException e){
                System.out.println("Invalid input. Only integers allowed.");
                isInvalid = true;
            }

        }while(isInvalid);
        return input;
    }
}