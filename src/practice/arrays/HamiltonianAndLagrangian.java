/*Output all the integers separated in the array from left to right 
that are not smaller than those on its right side.*/

package practice.arrays;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class HamiltonianAndLagrangian {

	public static void main(String[] args) throws Exception {
		/*
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); int
		 * n = Integer.parseInt(br.readLine()); int a[] = new int[n]; String l[] =
		 * br.readLine().split("\\s+"); for (int i = 0; i < l.length; i++) a[i] =
		 * Integer.parseInt(l[i]);
		 */
		FastReader sc = new FastReader();

		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		findRightToLeftHigherEle(a, n);

	}

	static void findRightToLeftHigherEle(int a[], int n) {

		Deque<Integer> stack = new ArrayDeque<Integer>();
		for (int i = n - 1; i >= 0; i--)
			if (stack.peekLast() == null || stack.peekLast() < a[i])
				stack.addLast(a[i]);

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pollLast());
			sb.append(" ");
		}
		PrintWriter out = new PrintWriter(System.out);

		out.println(sb.toString());
		out.close();
	}

}
