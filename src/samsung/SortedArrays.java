package samsung;

import java.io.*;
import java.util.*;


public class SortedArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            int[] A = new int[N];
            for(int i_A=0; i_A<arr_A.length; i_A++)
            {
            	A[i_A] = Integer.parseInt(arr_A[i_A]);
            }
            long K = Long.parseLong(br.readLine().trim());

            int out_ = solve(A, N, K);
            wr.println(out_);
         }

         wr.close();
         br.close();
    }
    static int solve(int[] a, int N, long k){
        
        Map<Integer, Long> arr = new TreeMap<>();
        int i = N, r= 1;
        long noOfEle = 0;
        
        while(i>0){
            
            noOfEle+= i*r*N;
            for(int j=0;j<i;j++){
                arr.put(a[j] , (arr.getOrDefault(a[j],0l) + r*N) );
            }
            i/=2;
            r++;
        }
        if(noOfEle<k)
            return -1;
       // System.out.println(arr);
        long sum =0; 
        for(Map.Entry<Integer, Long> m : arr.entrySet() ){
            sum+=m.getValue();
            if( sum >= (k-1))
                return m.getKey();
            //System.out.println("sum : "+ sum);
        }
       
        return -1;
    
    }
}