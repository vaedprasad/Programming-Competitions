import java.io.*;
import java.util.*; 
/**
 * 
 * Vaed Prasad
 * April 8th, 2017
 * Google Code Jam
 * 
 */
public class PancakeFlipper
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pancake.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pancake.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            String pancakes = st.nextToken();
            int size = Integer.parseInt(st.nextToken());
            pw.println("Case #" + (i+1) + ": " + solve(pancakes, size));
        }
        pw.close();
    }

    public static String solve(String str, int size) {
        int length = str.length();
        int counter = 0;
        boolean[] pancakes = new boolean[length];
        for(int i = 0; i < length; i++) {
            if(str.substring(i,i+1).equals("-"))
                pancakes[i] = false;
            else
                pancakes[i] = true;                
        }

        for(int i = 0; i < length; i++) {
            if(pancakes[i] == false && i + size <= length){
                for(int j = 0; j < size; j++) {
                    pancakes[i+j] = !pancakes[i+j];
                }
                counter++;
            }
        }

        for(int i = 0; i < length; i++) {
            if(pancakes[i] == false) {
                return "IMPOSSIBLE";
            }
        }
        return "" + counter;
    }
}