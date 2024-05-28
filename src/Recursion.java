public class Recursion{
    // calculates the sum of the given terms of each mathematical series using recursive functions

    public static double arithmeticSum(double start, double comDiff, int numTerms, int term, double sum){
        if(term > numTerms){
            return sum;
        }
        return arithmeticSum(start+comDiff, comDiff, numTerms, ++term, sum+start);
    }

    public static double geometricSum(double start, double comRatio, int numTerms, int term, double sum){
        if(term > numTerms){
            return sum;
        }
        return geometricSum(start*comRatio, comRatio, numTerms, ++term, sum+start);
    }

    public static double fibonacciSum(double start, double second, int numTerms, int term, double sum){
        if(term > numTerms){
            return sum;
        }
        return fibonacciSum(start+second, start, numTerms, ++term, sum+start);
    }

    public static double harmonicSum(double start, double intervalChange, int numTerms, int term, double sum){
        if(term > numTerms){
            return sum;
        }
        return harmonicSum(start+intervalChange, intervalChange, numTerms, ++term, sum + 1/(start));
    }
}