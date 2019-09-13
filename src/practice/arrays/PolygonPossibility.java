package practice.arrays;

import java.io.PrintWriter;

/*You are given length of n sides, 
you need to answer whether it is possible to make n sided convex polygon with it.*/


/*Solution
 * 
 *  Largest Side < Sum of other Sides
 * 
 * */
public class PolygonPossibility {

	public static void main(String[] args) throws Exception {
	
			FastReader sc = new FastReader();
			int t = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			while (t-- > 0) {
				int n = sc.nextInt();
				int[] a = new int[n];
				int max = Integer.MIN_VALUE;
				int sum = 0;
				for (int i = 0; i < n; i++) {
					a[i] = sc.nextInt();
					if(a[i]>max)
						max = a[i];
					sum+=a[i];
				}
				
				if((sum-max)>max)
					sb.append("Yes\n");
				else sb.append("No\n");
			}
			
			PrintWriter writer = new PrintWriter(System.out);
			writer.print(sb.toString());
			writer.close();

	}

}
