public class Recursion{

    public static double arithmetic(double start, double comDiff, int numTerms, int term, double sum){
        if(term > numTerms){
            return sum;
        }
        return arithmetic(start+comDiff, comDiff, numTerms, ++term, sum+start);
    }

    public static double geometric(double start, double comRatio, int numTerms, int term, double sum){
        if(term > numTerms){
            return sum;
        }
        return geometric(start*comRatio, comRatio, numTerms, ++term, sum+start);
    }

    public static double fibonacci(double start, double second, int numTerms, int term, double sum){
        if(term > numTerms){
            return sum;
        }
        return fibonacci(start+second, start, numTerms, ++term, sum+start);
    }

    public static double harmonic(double start, double commDiff, int numTerms, int term, double sum){
        if(term > numTerms){
            return sum;
        }
        return harmonic(start+commDiff, commDiff, numTerms, ++term, sum + 1/(start));
    }
}