package practice.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MemoriseMe {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr_line = br.readLine().split("\\s+");
		int[] f = new int[1001];
		for (int i = 0; i < arr_line.length; i++) {
			f[Integer.parseInt(arr_line[i])]++;
		}

		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (q-- > 0) {
			int m = Integer.parseInt(br.readLine());
			if (f[m] > 0)
				sb.append(f[m]);
			else
				sb.append("NOT PRESENT");
			sb.append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

}
