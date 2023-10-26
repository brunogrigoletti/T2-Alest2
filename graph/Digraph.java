package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Digraph {
  protected static final String NEWLINE = System.getProperty("line.separator");
  protected Map<Vertex, List<Vertex>> graph;

  public Digraph() {
    graph = new HashMap<>();
  }

  public Digraph(String filename) {
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
          addEdge(v, w);
        }
      }
    }
    in.close();
  }

  public void addEdge(Vertex v, Vertex w) {
    addToList(v, w);
  }

  public Iterable<Vertex> getAdj(Vertex v) {
    return graph.get(v);
  }

  public Set<Vertex> getVerts() {
    return graph.keySet();
  }

  protected List<Vertex> addToList(Vertex v, Vertex w) {
    List<Vertex> list = graph.get(v);
    if (list == null)
      list = new LinkedList<>();
    list.add(w);
    graph.put(v, list);
    return list;
  }

  public String toDot() {
    StringBuilder sb = new StringBuilder();
    sb.append("digraph {" + NEWLINE);
    sb.append("rankdir = LR;" + NEWLINE);
    sb.append("node [shape = circle];" + NEWLINE);
    for (Vertex v : getVerts().stream().sorted().toList())
      for (Vertex w : getAdj(v))
        sb.append(v.getElement() + " -> " + w.getElement() + NEWLINE);
    sb.append("}" + NEWLINE);
    return sb.toString();
  }
}