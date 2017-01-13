import java.io.*;
import java.util.*;
public class Moocast
{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] x = new int[n];
        int[] y = new int[n];
        int[] power = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
            power[i] = Integer.parseInt(st.nextToken());
        }

        int[] num = new int[n];
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                double d =  Math.sqrt((x[i]-x[j])*(x[i]-x[j]) + (y[i]-y[j])*(y[i]-y[j]));
                if (d <= (double) power[i]) {
                    count++;
                    
                }
            }
            num[i]=count;
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(num[i] > max) {
                max = num[i];
            }
        }

        pw.println(max);
        pw.close();
    }
}
