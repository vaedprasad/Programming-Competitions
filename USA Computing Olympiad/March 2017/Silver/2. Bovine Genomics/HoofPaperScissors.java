import java.util.Arrays;
import java.io.LineNumberReader; //Had to import each one individually because java.io.* and java.util.* take too long
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer; 
public class HoofPaperScissors
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hps.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        String[] moves = new String[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            moves[i] = st.nextToken();
        }

        int a, b;
        int max = 0;
        /**
        pw.println(n);
        for(int i = 0; i < n; i++) {
        pw.println(moves[i]);
        }
         */
        for(int i = 1; i < moves.length; i++) {
            a = maxNum(Arrays.copyOfRange(moves, 0, i));
            b = maxNum(Arrays.copyOfRange(moves, i, moves.length));
            int sum = a + b;
            if (sum > max)
                max=sum;
        }
        pw.println(max);
        pw.close();
    }

    public static int maxNum(String[] moves) {
        int a = 0, b = 0, c = 0;
        for(int i = 0; i < moves.length; i++) {
            if(moves[i].equals("P"))
                a++;
            if(moves[i].equals("S"))
                b++;
            if(moves[i].equals("H"))
                c++;
        }
        return Math.max(Math.max(a,b),c);
    }
}
