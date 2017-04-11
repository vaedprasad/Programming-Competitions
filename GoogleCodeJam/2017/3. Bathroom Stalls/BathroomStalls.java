import java.io.*;
import java.util.*; 
/**
 * 
 * Vaed Prasad
 * April 8th, 2017
 * Google Code Jam
 * 
 */
public class BathroomStalls
{
    private static int Y = 0; //y is max(LS, RS)
    private static int Z = 0; //z is min(LS, RS)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("tidy.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tidy.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            pw.println("Case #" + (i+1) + ": " + solve(n));
        }
        pw.close();
    }

    public static int solve(int n, int k) {
        boolean[] stalls = new boolean[n+2];
        for(int i = 0; i < n+2; i++) {
            if (i==0 || i == n+1)
                stalls[i] = true;
            else
                stalls[i] = false;
        }

        for(int numPeople = k; numPeople > 1; numPeople--) {
            int[] leftSide = new int[n+2];
            int[] rightSide = new int[n+2];
            for(int i = 0; i < n+2; i++) {
                if (stalls[i]==true) {
                    leftSide[i] = -1;
                    rightSide[i] = -1;
                }
                else {
                    int counter = 0;
                    for(int j = 0; j < i; j++) {
                        if (stalls[j]==false)
                            counter++;
                        else
                            counter = 0;
                    }
                    leftSide[i] = counter;
                    counter = 0;
                    for(int j = i + 1; j < n+2; j++) {
                        if (stalls[j]==false)
                            counter++;
                        else
                            break;
                    }
                    rightSide[i] = counter;
                }
            }
            int max = -1;
            for(int i = 0; i < n+2; i++) {
                if(Math.abs(leftSide[i]-rightSide[i]) > max)
                    max = Math.abs(leftSide[i]-rightSide[i])
                
            }
        }
    }
}