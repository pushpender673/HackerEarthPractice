package practice.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/*In a parallel universe, there are not just two charges like positive and negative, 
 * but there are charges represented by   english alphabets.
 * Charges have a property of killing each other or in other words neutralizing each other 
 * if they are of same charge and next to each other.
 * You are given a string  where each  represents a charge, where .
 * You need to output  of final string followed by string after 
 * which no neutralizing is possible.
 * 
 * e.g 
 * aaacccbbcccd -> accd -> ad
 * 
 * */

public class NeturisingCharge {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		char[] s = br.readLine().trim().toCharArray();
		StringBuilder sb = new StringBuilder();
		Deque<Character> st = new ArrayDeque<Character>();
		
		for(int i =0;i<s.length;i++) {
			
			if( st.isEmpty() || st.getLast()!=s[i])
				st.add(s[i]);
			else if(st.getLast()==s[i])
				st.removeLast();
		}
		
		for(Character c: st)
			sb.append(c);
		String res = sb.toString();
		PrintWriter writer = new PrintWriter(System.out);
		writer.print(res.length());
		writer.print("\n");
		writer.println(res);
		writer.close();
	}

}
