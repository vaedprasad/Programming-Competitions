import java.io.*;
import java.util.*; 
/**
 * 
 * Vaed Prasad
 * April 8th, 2017
 * Google Code Jam
 * 
 */
public class TidyNumbers
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("tidy.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tidy.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            pw.println("Case #" + (i+1) + ": " + solve(n));
        }
        pw.close();
    }

    public static long solve(long n) {
        long maxTidy = -1;
        for(long i = n; i >= 1; i--) {
            if(increasingDigits(i)) {
                maxTidy = i;
                break;
            }
        }
        return maxTidy;
    }

    public static boolean increasingDigits(long input) {
        long lastSeen = 10; // always greater than any digit
        long current;

        while (input > 0) {
            current = input % 10;
            if (lastSeen < current)
                return false;
            lastSeen = current;
            input /= 10;
        }
        return true;
    }
}