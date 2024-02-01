import java.util.List;
import java.util.Scanner;

public class ElectricityDistributionCompany{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input;
		Graph g = new Graph();
		List<Edge> MST;

		if (args.length == 0) {

			input = scanner.nextLine();
			scanner.close();
		} else {
			input = args[0];
		}
		g = g.fileReader(input);
		MST = g.MST(g);

		System.out.println("Paths are:");
		for (Edge edge : MST) {
			int c1 = Math.min(edge.city1, edge.city2);
			int c2 = Math.max(edge.city1, edge.city2);
			System.out.printf("%s-%s: %.1f%n", g.cities.get(c1).name, g.cities.get(c2).name, edge.distance);
		}
	}

}
