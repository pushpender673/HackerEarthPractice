package practice.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PoerOfTime {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String l[] = br.readLine().split("\\s+");
		int c[] = new int[n];
		int search_arr[] = new int[100];
		for (int i = 0; i < l.length; i++) {
			c[i] = Integer.parseInt(l[i]);
			search_arr[c[i]] = i;
		}
		l = br.readLine().split("\\s+");
		int p[] = new int[n];
		for (int i = 0; i < l.length; i++)
			p[i] = Integer.parseInt(l[i]);
		
		print(calTotalExectionTime(c, p, search_arr));

	}

	public static int calTotalExectionTime(int c[], int p[], int s_arr[]) {
		int sum =0, j=0, i=0 ;
		
		while(j<p.length) {
			
			if(c[i]==p[j]) {
				sum++;
				i=(i+1)%c.length;
				j++;
			}
			else {
				int k = s_arr[p[j]];
				sum+=Math.abs(i-k);
				i = k;
			}
			
		}
		
		return sum;
	}


	public static void print(Object s) {
		PrintWriter writer = new PrintWriter(System.out);
		writer.println(s);
		writer.close();
	}
}
