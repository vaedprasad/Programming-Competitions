import java.io.*;
import java.util.*;
public class CowSignal
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] signal = new String[m];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            signal[i] = st.nextToken();
        }

        String[] newSignal = new String[m];
        for(int i = 0; i < m; i++) {
            newSignal[i]="";
            for(int j = 0; j < n; j++) {
                String character = Character.toString(signal[i].charAt(j));
                String newString = "";
                for(int a = 0; a < k; a++) {
                    newString += character;
                }
                newSignal[i] += newString;
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < k; j++) {
                pw.println(newSignal[i]);
            }
        }

        pw.close();
    }
}