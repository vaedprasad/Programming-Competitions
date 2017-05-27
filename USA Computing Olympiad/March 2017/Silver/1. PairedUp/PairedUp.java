import java.io.*;
import java.util.*; 
/**
 * 
 * Vaed Prasad
 * March 12th, 2017
 * USACO
 * 
 */
public class PairedUp
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pairup.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //number of lines
        int [] cows = new int[n]; //index 0 is the number of cows, index 1 is the output of these cows
        int [] outputs = new int[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i] = Integer.parseInt(st.nextToken());
            outputs[i] = Integer.parseInt(st.nextToken());
        }
        
        List<Integer> intList = new ArrayList<Integer>(cows.length);
        for (int i=0; i<cows.length; i++) {
            intList.add(cows[i]);
        }
        Collections.sort(cows, (w1, w2) -> new Integer(outputs[w1]).compareTo(new Integer(outputs[w2])));

        pw.close();
    }

    public static void sort(List<Integer> list, Integer listMin,  Integer listMax) {
        int numBuckets = (int) Math.ceil(list.size() / 30); // ~ 30 items/bucket

        // initialize the buckets
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>(numBuckets);
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        // go through the list and put each item in the correct bucket
        for (int i = 0; i < list.size(); i++) {
            int bucket = bucketForNumber(list.get(i), listMin, listMax, numBuckets);
            buckets.get(bucket).add(list.get(i));
        }

        // sort each of the buckets using insertion sort
        int listIndex = 0;
        for (ArrayList<Integer> bucket : buckets) {
            InsertionSort.sort(bucket);
            for (Integer item : bucket) {
                list.set(listIndex++, item);
            }
        }
    }

    private static int bucketForNumber(Integer number, Integer listMin, Integer listMax, Integer numBuckets) {
        Long difference = (long)listMax - listMin;
        int increment = (int)Math.ceil(difference / numBuckets);
        increment = increment <= 0 ? 1 : increment;
        int bucket = number / increment;
        if (bucket >= numBuckets) {
            bucket = numBuckets - 1;
        } else if (bucket < 0) {
            bucket = 0;
        }
        return bucket;
    }

    public static void sort(ArrayList<Integer> a, int maxVal) {
        int [] bucket=new int[maxVal+1];

        for (int i=0; i<bucket.length; i++) {
            bucket[i]=0;
        }

        for (int i=0; i<a.size(); i++) {
            bucket[a.get(i)]++;
        }

        int outPos=0;
        for (int i=0; i<bucket.length; i++) {
            for (int j=0; j<bucket[i]; j++) {
                outPos++;
                a[outPos++]=i;
            }
        }
    }
    /**ArrayList<Integer> outputs = new ArrayList<Integer>();
    int maxOutput = 0;
    int minOutput = Integer.MAX_VALUE;
    for(int i = 0; i < n; i++) {
    st = new StringTokenizer(br.readLine());
    int numCows = Integer.parseInt(st.nextToken());
    int numOutput = Integer.parseInt(st.nextToken());
    if(numOutput > maxOutput) maxOutput = numOutput;
    for(int j = 0; j < numCows; j++) {
    outputs.add(numOutput);
    }
    }

    Collections.sort(outputs);

    int maxTime = 0;
    while(outputs.size() != 0) {
    int size = outputs.size();
    if(outputs.get(0)+outputs.get(size-1) > maxTime) {
    maxTime = outputs.get(0) + outputs.get(size-1);                
    }
    outputs.remove(size-1);
    outputs.remove(0);
    }
    pw.println(maxTime);

    /**for(int i = 0; i < outputs.size(); i++) {
    pw.println(outputs.get(i));
    }*/
}
