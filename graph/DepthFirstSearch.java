package graph;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DepthFirstSearch{
    private Set<Vertex> marked;
    private Map<Vertex, Vertex> edgeTo;
    private Vertex v;

    public DepthFirstSearch(Digraph g, Vertex v){
        this.v = v;
        this.marked = new HashSet<>();
        this.edgeTo = new HashMap<>();
        dfs(g,v);
    }

    private void dfs(Digraph g, Vertex v){
        marked.add(v);
        for (Vertex w : g.getAdj(v)){
            if (!marked.contains(w)){
                edgeTo.put(w,v);
                dfs(g,w);
            }
        }
    }

    public Iterable<Vertex> pathTo(Vertex v){
        List<Vertex> path = new LinkedList<>();
        if (hasPathTo(v)){
            while (!v.equals(v)){
                path.add(0,v);
                v = edgeTo.get(v);
            }
            path.add(0,v);
        }
        return path;
    }

    public boolean hasPathTo(Vertex v){
        return marked.contains(v);
    }
}