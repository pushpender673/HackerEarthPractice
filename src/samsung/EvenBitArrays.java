package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.Box.Filler;

public class EvenBitArrays {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		/*
		 * while(t-->0) { int n = Integer.parseInt(br.readLine()); String l[] =
		 * br.readLine().split("\\s+"); int a[] = new int[n]; for(int i
		 * =0;i<l.length;i++) a[i] = Integer.parseInt(l[i]);
		 * 
		 * }
		 */

		System.out.println(findNext(t));;
	}

	public static long minSum(int a[], int n) {
		long sum = 0;

		for (int i = 0; i < n; i++) {
			if (a[0] != -1 && a[i] == -1) {
				a[i] = findNext(a[i - 1]);
			}
		}

		return sum;
	}

	private static int findNext(int n) {
		int r = 2, c = 1, t = n;
		// flip Odds to zero
		while (c < n) {

			if ((t & c) > 0) {
				t = t ^ c;
			}
			c <<= 2;
		}

		return countFromRight(n, t);
	}

	private static int countFromRight(int n, int f) {
		int c = 2;
		while (f < n) {

			if( (f & c) > 0 ) {
				f |= c;
			}
			c <<= 2;
			
		}

		return f;
	}

}
