import java.io.*;
import java.util.*;
public class CitiesAndStates
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        //String[] cities = new String[n];
        //String[] states = new String[n];
        List<String> cities = new ArrayList<String>();
        List<String> states = new ArrayList<String>();
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cities.add(st.nextToken());
            states.add(st.nextToken());
            //cities[i] = st.nextToken();
            //states[i] = st.nextToken();
        }
        int count = 0;
        for(int i = 0; i < n; i++) {//states
            for(int j = 0; j < n; j++) {//cities
                if(states.get(i).equals(cities.get(j).substring(0,2))&&states.get(j).equals(cities.get(i).substring(0,2))) {
                    count++;
                    //states.removeAll(Collections.singleton(states.get(i)));
                }
                
            }
        }

        

        pw.println(count/2);
        pw.close();
    }
}
