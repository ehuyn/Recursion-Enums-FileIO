import java.util.Scanner;
import java.lang.IllegalArgumentException;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SeriesCategory theSeries;
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

                try{
                    System.out.print("Choose a series category: ");
                    flag = false;
                    series = in.next();
                    theSeries = SeriesCategory.valueOf(series);
                    startVal = getValidDoubleInput("\nStarting Value: ");
                    numTerms = getValidIntInput("Number of Terms: ", 2, Integer.MAX_VALUE);

                    switch(theSeries){
                        case ARITHMETIC:
                            var = getValidDoubleInput("Common Difference: ");
                            sum = Recursion.arithmetic(startVal, var, numTerms, 1, 0.0);
                            other = "" + var;
                            break;
                        case GEOMETRIC:
                            var = getValidDoubleInput("Common Ratio: ");
                            sum = Recursion.geometric(startVal, var, numTerms, 1, 0.0);
                            other = "" + var;
                            break;
                        case FIBONACCI:
                            var = getValidDoubleInput("Second Term: ");
                            sum = Recursion.fibonacci(startVal, var, numTerms, 1, 0.0);
                            other = "" + var;
                            break;
                        case HARMONIC:
                            var = getValidDoubleInput("Common Difference: ");
                            sum = Recursion.harmonic(startVal, var, numTerms, 1, 0.0);
                            other = "" + var;
                            break;
                    }
                } catch (IllegalArgumentException e){
                    System.out.println("Not a valid series category.\n");
                    flag = true;
                }
            }
            System.out.println("The sum of the given terms in this series is " + sum + ".");
            Save.saveSum(series, startVal, numTerms, sum, other);
            System.out.println();
            play = getValidIntInput("Would you like to run the program again (0 for no, 1 for yes)? ", 0, 1);
            System.out.println();
        } while(play == 1);
        System.out.println("Goodbye!");
    }

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