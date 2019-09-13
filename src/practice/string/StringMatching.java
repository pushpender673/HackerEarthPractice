package practice.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * ababcdabbabababad
 * abababa
 * 0 | 0 | 1 | 2 | 3 | 4 | 5 | 0 | 
 * Found at : 9
 * true
*/
public class StringMatching {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		String pattern = br.readLine();
		System.out.println(knuthMorisPrattStringSearch(text.toCharArray(), pattern.toCharArray()));

	}
	
	public static boolean bruteForcePatternSearch(char[] text, char[] pattern) {
		int i = 0;
	
		while( i <= text.length-pattern.length) {
			int j = 0;		
			while( j < pattern.length && text[i]==pattern[j]) {
				j++;
				i++;
			}
			
			if(j==pattern.length) {
				System.out.println("Found at : "+ (i-j));
				return true;
			}
			i = i - j + 1;
		}
		
		return false;
	}
	
	public static boolean knuthMorisPrattStringSearch(char[] t, char[] p) {
		
		// Prepare Suffix and Prefix Match array for Pattern P
 		int[] c = new int[p.length+1];
		int i = 0, j = 1;
		c[0] = 0;
		while( j < p.length) {
			if(p[i]==p[j])
				c[j++] = i++ +1;
			else {
				i = c[i];
				if(i==0)
					j++;
			}
		}
		
		for(int k =0;k<c.length;k++)
			System.out.print(c[k]+" | ");
		System.out.println();
		
		// Search for the Pattern in String
		i = 0;j=0;
		while(i < t.length) {
			if(j==0 && t[i]!=p[j])
				i++;
			else if(t[i]==p[j]) {
				i++;
				j++;
			} else {
				j = c[j-1];
			}
			
			if(j==p.length) {
				System.out.println("Found at : "+ (i-j));
				return true;
			}
			
		}
		
		return false;
	}

}
