import java.io.*;
import java.util.*;
public class BlockGame
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        String[] front = new String[n];
        String[] back = new String[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            front[i] = st.nextToken();
            back[i] = st.nextToken();
        }

        String total = "";
        for(int i = 0; i < n; i++) {
            total+=front[i];
            total+=back[i];
        }

        int[] alphabet = new int[26];

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < 26; i++) {
                int count1 = 0;
                int count2 = 0;
                for( int j = 0; j <front[k].length(); j++ ) {
                    if(front[k].charAt(j) == i+97 ) {
                        count1++;
                    } 
                }
                for( int j = 0; j <back[k].length(); j++ ) {
                    if(back[k].charAt(j) == i+97 ) {
                        count2++;
                    } 
                }
                alphabet[i] = alphabet[i] += Math.max(count1,count2);
            }
        }
        
        for(int i = 0; i < 26; i++) {
            pw.println(alphabet[i]);
        }

        pw.close();
    }
}
