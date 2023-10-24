package graph;
public class Digraph extends Graph{

  public Digraph(String filename){
    super(filename);
  }

  @Override
  public void addEdge(Vertex v, Vertex w){
    addToList(v, w);
  }
}