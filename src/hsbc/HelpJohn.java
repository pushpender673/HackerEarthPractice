package hsbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeSet;

public class HelpJohn {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		TreeSet<Integer> list = new TreeSet<Integer>();
		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			int x = Integer.parseInt(br.readLine());

			Integer res = -1;
			sb.append((res = list.floor(x)) == null ? -1 : res);
			sb.append(" ");
			sb.append((res = list.higher(x)) == null ? -1 : res);
			sb.append("\n");
			list.add(x);
		}
		PrintWriter writer = new PrintWriter(System.out);
		writer.println(sb.toString());
		writer.close();

	}

}
