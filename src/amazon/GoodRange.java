package amazon;
import java.io.*;
import java.util.*;
public class GoodRange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String input1 = br.readLine().trim();
        String[] input = input1.split(" ");
        long N = Long.parseLong(input[0]);
        long M = Long.parseLong(input[1]);
        TreeSet<Long> set = new TreeSet<>();
        while(M > 0){
            long X = Long.parseLong(br.readLine().trim());
            set.add(X);
            long out_ = getOutput(set, N);
            System.out.println(out_);
            M--;
        }
        wr.close();
        br.close();
    }
    static long getOutput(TreeSet<Long> set, Long n){
        long sum = 1+n;
        Long[] a = set.toArray(new Long[set.size()]);
        for(int i =0;i<a.length-1;i++) {
        	sum += (a[i]+1)+ (a[i+1]-1);
        }
        return sum;
    }
}