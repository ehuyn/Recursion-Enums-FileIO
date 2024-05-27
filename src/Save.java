import java.io.*;
import java.util.logging.Logger;
import java.util.logging.Level;

// Saves sums to sums.txt file in the format below 
// Format: series category, starting value, number of terms, other variable (dependent on the given series), resulting sum

public class Save{
    public static void saveSum(String series, double start, int numTerms, double sum, String other){
        try{
            FileWriter fileWrite = new FileWriter("sums.txt", true);
            BufferedWriter buffWrite = new BufferedWriter(fileWrite);
            buffWrite.write(series + ", " + start + ", " + numTerms + ", " + other + ", " + sum);
            buffWrite.newLine();
            buffWrite.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
        catch (IOException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}