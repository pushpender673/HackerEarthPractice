package hsbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class SamHeight {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(t--> 0) {
			String[] l = br.readLine().split("\\s+");
			int n = Integer.parseInt(l[0]);
			int s = Integer.parseInt(l[1]);
			int[] a = new int[n+1];
			a[0] = s;
			l = br.readLine().split("\\s+");
			for(int i =1;i<=n;i++)
				a[i] = Integer.parseInt(l[i-1]);
			Arrays.sort(a);
			int j = Arrays.binarySearch(a, s);
			sb.append(Math.abs( ( a.length - j-1) - j  ));
			sb.append("\n");
		}
		PrintWriter writer = new PrintWriter(System.out);
		writer.print(sb.toString());
		writer.close();
	}

}
