package graph;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch{
    private Set<String> marked;
    private Map<String,String> edgeTo;
    private Map<String,Integer> distTo;
    private String s;

    public BreadthFirstSearch(Graph g, String s){
        this.s = s;
        this.marked = new HashSet<>();
        this.edgeTo = new HashMap<>();
        this.distTo = new HashMap<>();
        bfs(g,s);
    }

    private void bfs(Graph g, String s){
        Queue<String> q = new LinkedList<>();
        q.add(s);
        marked.add(s);
        distTo.put(s,0);
        while (!q.isEmpty()){
            String v = q.remove();
            for (String w : g.getAdj(v)){
                if (!marked.contains(w)){
                    edgeTo.put(w,v);
                    distTo.put(w,distTo.get(v)+1);
                    q.add(w);
                    marked.add(w);
                }
            }
        }
    }

    public int distTo(String s){
        if (hasPathTo(s)){
            return distTo.get(s);
        }
        return -1;
    }

    public Iterable<String> pathTo(String v){
        List<String> path = new LinkedList<>();
        if (hasPathTo(v)){
            while (!v.equals(s)){
                path.add(0,v);
                v = edgeTo.get(v);
            }
            path.add(0,s);
        }
        return path;
    }

    public boolean hasPathTo(String v){
        return marked.contains(v);
    }
}