package app;

import java.util.HashSet;
import java.util.Set;
import graph.Digraph;
import graph.Edge;
import graph.EdgeWeightedGraph;
import graph.Vertex;

public class App {
    Digraph g;

    public App() {
        this.g = new Digraph("cases\\casoteste.txt");
    }

    public void digraph() {
        for (Vertex v : g.getVerts()) {
            System.out.print(v.getWeight() + "-" + v.getElement() + " - ");
            for (Vertex w : g.getAdj(v)) {
                System.out.println(w.getWeight() + "-" + w.getElement() + " ");
            }
        }
        System.out.println("\n" + g.toDot());
    }

    public void edgeWeightedGraph() {
        EdgeWeightedGraph g = new EdgeWeightedGraph("cases\\casoteste.txt");
        Set<String> processedConnections = new HashSet<>();
        for (Vertex v : g.getVerts()) {
            for (Edge e : g.getAdj(v)) {
                String connection = v.getWeight() + "-" + v.getElement() + " - " + e.getW().getWeight() + "-"
                        + e.getW().getElement();
                if (!processedConnections.contains(connection) && !v.getElement().equals(e.getW().getElement())) {
                    System.out.print(v.getWeight() + "-" + v.getElement() + " - ");
                    System.out.print(e.getW().getWeight() + "-" + e.getW().getElement() + " " + "\n");
                    processedConnections.add(connection);
                }
            }
        }
        System.out.println("\n" + g.toDot());
    }
}