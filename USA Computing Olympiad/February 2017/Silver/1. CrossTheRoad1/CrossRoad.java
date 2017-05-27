import java.io.*;
import java.util.*; 
/**
 * 
 * Vaed Prasad
 * February 17th, 2017
 * USACO Silver
 * 
 */
public class CrossRoad
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] chick = new int[c];
        for(int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            chick[i] = Integer.parseInt(st.nextToken());
        }
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(chick);

        int max = maxPairs(c, n, chick, start, end);
        pw.print(max);
        pw.close();
    }

    public static int maxPairs2(int c, int n, int[] chick, int[] start, int[] end) {
        int max = 0, j = 0;
        for(int i = 0; i < c; i++) {
            if (j > n-1)
                break;
            else {
                int count = 0; int s = 0; int e = 0;
                while (j <= n-1 && start[j] <= chick[i]) {
                    if(end[j] >= chick[i]) {
                        max++;
                        start[j] = -1;
                        end[j] = -1;
                        j++;
                        break;
                    }
                    j++;
                }
            }
        }
        return max;
    }

    public static int maxPairs(int c, int n, int[] chick, int[] start, int[] end) {
        int max = 0, j = 0;
        for(int i = 0; i < c; i++) {
            if (j > n-1)
                break;
            else {
                while (j <= n-1 && start[j] <= chick[i]) {
                    if(end[j] >= chick[i]) {
                        max++;
                        start[j] = -1;
                        end[j] = -1;
                        j++;
                        break;
                    }
                    j++;
                }
            }
        }
        return max;
    }
}