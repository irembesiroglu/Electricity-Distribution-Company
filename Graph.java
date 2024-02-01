import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {
	List<City> cities;
	List<Edge> edges;

	public Graph() {
		this.cities = new ArrayList<>();
		this.edges = new ArrayList<>();
	}

	public void addCity(String name, int x, int y) {
		cities.add(new City(name, x, y));
	}

	public void addEdge(int c1, int c2) {
		edges.add(new Edge(c1, c2, betweenC1andC2(cities.get(c1), cities.get(c2)), this));
	}

	public double betweenC1andC2(City c1, City c2) {
		return Math.sqrt(Math.pow(c1.x - c2.x, 2.0) + Math.pow(c1.y - c2.y, 2.0));
	}

	public boolean areNeighbors(City c1, City c2) {
		double closeness = betweenC1andC2(c1, c2);
		return closeness <= 10.0;
	}

	public List<Edge> MST(Graph g) {
		List<Edge> mst = new ArrayList<>();
		List<Edge> edges = new ArrayList<>(g.edges);
		Collections.sort(edges);
		int[] parent = new int[g.cities.size()];
		int cc = g.cities.size();
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		for (Edge edge : edges) {
			int c1 = roots(parent, edge.city1);
			int c2 = roots(parent, edge.city2);

			if (c1 != c2) {
				mst.add(edge);
				union(parent, c1, c2);
				cc--;
				if (cc == 1) {
					break;
				}
			}
		}

		// Calculate distances after adding edges to the minimum spanning tree
		for (Edge edge : mst) {
			edge.distance = betweenC1andC2(g.cities.get(edge.city1), g.cities.get(edge.city2));
		}

		return mst;
	}

	
	public int roots(int[] parent, int c) {
		while (parent[c] != c) {
			c = parent[c];
		}
		return c;
	}

	public void union(int[] parent, int c1, int c2) {
		parent[c1] = c2;
	}

	public Graph fileReader(String input) {
		Graph g = new Graph();

		try (BufferedReader br = new BufferedReader(new FileReader(new File(input)))) {
			String l;
			while ((l = br.readLine()) != null) {
				String[] parts = l.split(",");
				if (parts.length == 3) {
					g.addCity(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
				}
			}
			for (int i = 0; i < g.cities.size(); i++) {
				for (int j = i + 1; j < g.cities.size(); j++) {
					g.addEdge(i, j);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return g;
	}
}
