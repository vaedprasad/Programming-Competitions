import java.io.*;
import java.util.*;
public class Haybales
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Integer[] haybales = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            haybales[i] = Integer.parseInt(st.nextToken());
        }

        int[] start = new int[q];
        int[] end = new int[q];

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
        }
        int[] numHaybales = new int[q];

        for(int i = 0; i < q; i++) {
            int min = start[i];
            int max = end[i];
            numHaybales[i] = sort(haybales, min, max, n);
        }

        for(int i = 0; i < q; i++) {
            pw.println(numHaybales[i]);
        }
        pw.close();
    }

    private static int sort(Integer[] haybales, int min, int max, int n) {
        int count = 0;
        int low = 0;
        int high = n - 1;
        int mid = 0;

        while (high >= low) {
            mid = (low + high) / 2;
            if (high - low > 1)
                if (haybales[mid] > min) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            else {
                break;
            }
        }
        for (int j = mid; j < haybales.length && haybales[j] <= max; j++) {
            if (haybales[j] >= min) {
                count++;
            }
        }
        return count;
    }

}
