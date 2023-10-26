package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EdgeWeightedGraph {
    protected static final String NEWLINE = System.getProperty("line.separator");
    protected Map<Vertex, List<Edge>> graph;

    public EdgeWeightedGraph() {
        this.graph = new HashMap<>();
    }

    public EdgeWeightedGraph(String filename) {
        this();
        In in = new In(filename);
        String line;
        while ((line = in.readLine()) != null) {
            String[] edge = line.split("->");
            String[] left = edge[0].trim().split(" ");
            String leftWeight = null;
            String leftElement = null;
            Vertex leftVertex = null;
            LinkedList<Vertex> leftVertices = new LinkedList<>();
            LinkedList<Vertex> rightVertices = new LinkedList<>();
            for (String s : left) {
                if (s.matches("-?\\d+"))
                    leftWeight = s;
                else {
                    leftElement = s;
                    leftVertex = new Vertex(leftWeight, leftElement);
                    leftVertices.add(leftVertex);
                }
            }
            String[] right = edge[1].trim().split(" ");
            String rightWeight = null;
            String rightElement = null;
            Vertex rightVertex = null;
            for (String s : right) {
                if (s.matches("-?\\d+"))
                    rightWeight = s;
                else {
                    rightElement = s;
                    rightVertex = new Vertex(rightWeight, rightElement);
                    rightVertices.add(rightVertex);
                }
            }
            for (Vertex v : leftVertices) {
                for (Vertex w : rightVertices) {
                    addEdge(v, w, Double.parseDouble(v.getWeight().toString()));
                }
            }
        }
        in.close();
    }

    public void addEdge(Vertex v, Vertex w, double weight) {
        Edge e = new Edge(v, w, weight);
        addToList(v, e);
        addToList(w, e);
    }

    public Iterable<Edge> getAdj(Vertex v) {
        return graph.get(v);
    }

    public Set<Vertex> getVerts() {
        return graph.keySet();
    }

    protected List<Edge> addToList(Vertex v, Edge e) {
        List<Edge> list = graph.get(v);
        if (list == null)
            list = new LinkedList<>();
        list.add(e);
        graph.put(v, list);
        return list;
    }

    public String toDot() {
        Set<String> edges = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        sb.append("graph {" + NEWLINE);
        sb.append("rankdir = LR;" + NEWLINE);
        sb.append("node [shape = circle];" + NEWLINE);
        for (Vertex v : getVerts().stream().sorted().toList()) {
            for (Edge e : getAdj(v)) {
                String edge = e.toString();
                if (!edges.contains(edge)) {
                    sb.append(String.format("%s -- %s [label=\"%.0f\"]", e.getV().getElement(), e.getW().getElement(),
                            e.getWeight()) + NEWLINE);
                    edges.add(edge);
                }
            }
        }
        sb.append("}" + NEWLINE);
        return sb.toString();
    }
}