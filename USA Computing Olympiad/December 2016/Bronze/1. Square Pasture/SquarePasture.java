import java.io.*;
import java.util.*;
public class SquarePasture
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("square.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());
        int y4 = Integer.parseInt(st.nextToken());

        int width, height;
        int width1 = Math.abs(x1-x4);
        int width2 = Math.abs(x2-x3);
        int width3 = Math.abs(x1-x2);
        int width4 = Math.abs(x3-x4);

        width = Math.max(Math.max(Math.max(width1, width2), width3),width4);

        int height1 = Math.abs(y1-y4);
        int height2 = Math.abs(y2-y3);
        int height3 = Math.abs(y1-y2);
        int height4 = Math.abs(y3-y4);

        height = Math.max(Math.max(Math.max(height1, height2), height3),height4);
        
        int side = Math.max(width,height);
        int area = side * side;
        
        pw.println(area);
        pw.close();
    }
}