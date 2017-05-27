import java.io.*;
import java.util.*; 
/**
 * 
 * Vaed Prasad
 * February 17th, 2017
 * USACO Silver
 * 
 */
public class MaxCross
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("maxcross.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] broken = new int[b];
        for(int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            broken[i] = Integer.parseInt(st.nextToken());
        }

        int max = maxCross(n, k, b, broken, pw);
        pw.println(max);
        pw.close();
    }

    public static int maxCross(int n, int k, int b, int[] broken, PrintWriter pw) {
        boolean[] signs = new boolean[n];
        for(int i = 0; i < n; i++) {
            signs[i] = true;
        }
        for(int i = 0; i < b; i++) {
            signs[broken[i]-1] = false;
        }

        int passes = 0;
        int max = numConsecutive(n, signs, passes);
        while (max < k) {
            passes++;
            max = numConsecutive(n, signs, passes);
            if(passes > b)
                break;
        }
        return passes;
    }

    public static int numConsecutive(int n, boolean[] signs, int passes) {
        int numConsecutive = 0;
        int count = 0;
        int p = passes;
        int start = -1;
        for(int i = 0; i < n; i++) {
            if(signs[i]) {
                count++;
                if(count > numConsecutive)
                    numConsecutive = count;
            }
            else {
                if(start == -1)
                    start = i;
                if(p > 0) {
                    p--;
                    count++;
                    if(count > numConsecutive)
                        numConsecutive = count;
                }
                else {    
                    count = 0;
                    p = passes;
                    i = start;
                    start = -1;
                }
            }
        }
        return numConsecutive;
    }
}