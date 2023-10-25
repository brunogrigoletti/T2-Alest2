package graph;
public class Digraph extends Graph{

  public Digraph(String filename){
    super(filename);
  }

  @Override
  public void addEdge(Vertex v, Vertex w){
    addToList(v, w);
  }

  @Override
  public String toDot(){
    StringBuilder sb = new StringBuilder();
    sb.append("digraph {"+NEWLINE);
    sb.append("rankdir = LR;"+NEWLINE);
    sb.append("node [shape = circle];"+NEWLINE);
    for(Vertex v: getVerts().stream().sorted().toList())
      for (Vertex w: getAdj(v))
        sb.append(v.getElement()+v.getWeight() + " -> " + w.getElement()+w.getWeight() + NEWLINE);
    sb.append("}" + NEWLINE);
    return sb.toString();
  }
}