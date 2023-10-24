package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph{
  protected static final String NEWLINE = System.getProperty("line.separator");
  protected Map<Vertex, List<Vertex>> graph;

  public Graph(){
    graph = new HashMap<>();
  }

  public Graph(String filename){
    this();
    In in = new In(filename);
    String line;
    while((line = in.readLine())!=null){
      String[] edge = line.split("->");
      String[] left = edge[0].trim().split(" ");
      String leftWeight = null;
      Vertex leftVertex = null;
      for (String s : left){
        if (s.matches("-?\\d+"))
          leftWeight = s;
        leftVertex = new Vertex(leftWeight, s);
      }
      String[] right = edge[1].trim().split(" ");
      String rightWeight = null;
      Vertex rightVertex = null;
      for (String s : right){
        if (s.matches("-?\\d+"))
          rightWeight = s;
        rightVertex = new Vertex(rightWeight, s);
      }
      addEdge(leftVertex, rightVertex);
    }
    in.close();
  }

  public void addEdge(Vertex v, Vertex w){
    addToList(v, w);
    addToList(w, v);
  }

  public Iterable<Vertex> getAdj(Vertex v){
    return graph.get(v);
  }

  public Set<Vertex> getVerts(){
    return graph.keySet();
  }

  protected List<Vertex> addToList(Vertex v, Vertex w){
    List<Vertex> list = graph.get(v);
    if (list == null)
      list = new LinkedList<>();
    list.add(w);
    graph.put(v, list);
    return list;
  }
}