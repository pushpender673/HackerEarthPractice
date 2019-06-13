package practice.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Input 
 * 
 * 3
 * hlleo 1 3
 * ooneefspd 0 8
 * effort 1 4
 * 
 * Output
 * 
 * hlleo
 * spoonfeed
 * erofft
 * */

public class SortSubString {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String line[] = br.readLine().split("\\s+");
			int n = Integer.parseInt(line[1]);
			int m = Integer.parseInt(line[2]);
			System.out.println(sortSubString(line[0].toCharArray(), n, m));
		}
		
	}
	
	public static String sortSubString(char[] s, int n , int m) {
		StringBuilder sb = new StringBuilder();
		
		// Sort the Intermediate Characters, Using Insertion Sort
		for(int i = n;i<=m;i++) {
			int j = n;
			while(s[j] > s[i] ) {
				j++;
			}
		}
		
		
		return sb.toString();
	}

}
