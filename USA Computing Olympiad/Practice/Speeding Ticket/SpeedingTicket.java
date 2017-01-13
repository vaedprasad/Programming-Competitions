/*
ID: vaedprasad
LANG: JAVA
TASK: speedingticket
 */
import java.io.*;
import java.util.*;
public class SpeedingTicket
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("paint.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int min, max;
        if(a<c)
            min=a;
        else
            min=c;
        if(b>d)
            max=b;
        else
            max=d;

        if(c>b || a>d) {
            int rv = (b-a)+(d-c);
            pw.println(rv);
            pw.close();
        }

        if(a==min && d>b) {
            int rv = d-a;
            pw.println(rv);
            pw.close();
        }

        if(a==min && b>=d) {
            int rv = b-a;
            pw.println(rv);
            pw.close();
        }

        if(c==min && b>d) {
            int rv = b-c;
            pw.println(rv);
            pw.close();
        }

        if(c==min && d>=b) {
            int rv = d-c;
            pw.println(rv);
            pw.close();
        }
        int count = 0;
        for(int i = 0; i < 101; i++) {
            if(i >= a && i <= b || i >= c && i <= d)
                count++;
        }
        pw.println(count);

        pw.close();
    }
}