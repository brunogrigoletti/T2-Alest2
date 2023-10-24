package app;

import graph.Graph;
import graph.Vertex;

public class App{
    Graph g;

    public App(){
        this.g = new Graph("cases\\minicaso.txt");
    }

    public void runCases(){
        for (Vertex v : g.getVerts()){
            System.out.println(v.getWeight()+"-"+v.getElement());
        }
    }
}