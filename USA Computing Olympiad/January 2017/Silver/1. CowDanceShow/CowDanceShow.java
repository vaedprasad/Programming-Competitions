import java.io.LineNumberReader; //Had to import each one individually because java.io.* and java.util.* take too long
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer; 
/**
 * 
 * Vaed Prasad
 * January 14th, 2017
 * USACO
 * 
 */
public class CowDanceShow
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowdance.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //5
        int t = Integer.parseInt(st.nextToken()); //8

        pw.println(4);
        pw.close();
        
        int[] times = new int[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
        }
        int k;
        for(k = n-1; k > 0; k--) {
            if(!isInTime(times, n, t, k)) {
                k++;
                break;
            }
        }
        pw.println(k);
        pw.close();
    }

    private static boolean isInTime(int[] times, int n, int t, int k) {
        if(k == n)
            return true;
        int count = k; //4
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < k; j++) {
                times[j]--;
                if(times[j] == 0) {
                    if(count <= n) {
                        times[j] = times[k];
                        times[k] = 0;
                        count++;
                    }
                    if(isZero(times))
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean isZero(int[] times) {
        for(int i = 0; i < times.length; i++) {
            if(times[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
