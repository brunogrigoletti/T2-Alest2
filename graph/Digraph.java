package graph;

import java.io.FileNotFoundException;
import java.util.*;

public class Digraph {
    private Map<Vertex, List<Edge>> adjList;
    private Vertex hydrogen;
    private boolean hydrogenRead;

    public Digraph() {
        this.adjList = new HashMap<>();
        this.hydrogenRead = false;
    }

    public void addEdge(Vertex from, Vertex to, long weight) {
        this.adjList.computeIfAbsent(from, k -> new ArrayList<>()).add(new Edge(from, to, weight));
    }

    public List<Edge> getEdges(Vertex vertex) {
        return adjList.getOrDefault(vertex, Collections.emptyList());
    }

    public void loadFromFile(String filename) throws FileNotFoundException {
        In in = new In(filename);
        String line;
        while ((line = in.readLine()) != null) {
            String[] parts = line.split("->");
            String[] from = parts[0].trim().split(" ");
            String[] to = parts[1].trim().split(" ");
            for (int i = 0; i < from.length; i += 2) {
                long fromWeight = Long.parseLong(from[i]);
                Vertex fromVertex = new Vertex(from[i + 1]);
                if (!hydrogenRead && fromVertex.getName().equals("hidrogenio")) {
                    hydrogen = fromVertex;
                    hydrogenRead = true;
                }
                long toWeight = Long.parseLong(to[0]);
                Vertex toVertex = new Vertex(to[1]);
                addEdge(fromVertex, toVertex, fromWeight * toWeight);
            }
        }
    }

    public Vertex getHydrogen() {
        return hydrogen;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Vertex, List<Edge>> entry : adjList.entrySet()) {
            for (Edge edge : entry.getValue()) {
                sb.append(edge).append('\n');
            }
        }
        return sb.toString();
    }
}