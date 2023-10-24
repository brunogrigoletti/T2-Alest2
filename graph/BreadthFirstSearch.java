package graph;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch{
    private Set<Vertex> marked;
    private Map<Vertex,Vertex> edgeTo;
    private Map<Vertex,Integer> distTo;
    private Vertex v;

    public BreadthFirstSearch(Graph g, Vertex v){
        this.v = new Vertex();
        this.marked = new HashSet<>();
        this.edgeTo = new HashMap<>();
        this.distTo = new HashMap<>();
        bfs(g,v);
    }

    private void bfs(Graph g, Vertex v){
        Queue<Vertex> q = new LinkedList<>();
        q.add(v);
        marked.add(v);
        distTo.put(v,0);
        while (!q.isEmpty()){
            Vertex s = q.remove();
            for (Vertex w : g.getAdj(s)){
                if (!marked.contains(w)){
                    edgeTo.put(w,s);
                    distTo.put(w,distTo.get(s)+1);
                    q.add(w);
                    marked.add(w);
                }
            }
        }
    }

    public int distTo(Vertex v){
        if (hasPathTo(v)){
            return distTo.get(v);
        }
        return -1;
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