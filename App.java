import graph.Graph;

public class App{
    Graph g;

    public App(){
        this.g = new Graph("cases\\minicaso.txt");
    }

    public void runCases(){ 
        System.out.println(g.getVerts());
    }
}