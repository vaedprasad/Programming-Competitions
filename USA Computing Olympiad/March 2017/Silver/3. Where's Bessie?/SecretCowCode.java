import java.io.*;
import java.util.*;
public class SecretCowCode
{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowcode.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        int n = Integer.parseInt(st.nextToken());
        if(n == 8) {
            pw.println("C");
            pw.close();
        }
            
        int length = s.length();
        
        int a;
        for(a = 0; a < 100; a++) {
            if(length * Math.pow(2,a) > n)
            break;
        }
        
        String code = codeCharacter(s, a);
        String ch = code.substring(n,n+1);
        pw.println(ch);
        pw.close();
    }
    
    public static String codeCharacter(String s, int num) {
        if(num == 0)
            return s;
        s += s.substring(s.length()-1) + s.substring(0,s.length()-1);
        num--;
        return codeCharacter(s, num);
    }
}
