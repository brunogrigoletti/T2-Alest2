package app;

import graph.Digraph;
import graph.Vertex;

public class App{
    Digraph g;

    public App(){
        this.g = new Digraph("cases\\casoteste.txt");
    }

    public void runCase(){
        for (Vertex v : g.getVerts()){
            System.out.print(v.getWeight()+"-"+v.getElement() + " - ");
            for (Vertex w : g.getAdj(v)){
                System.out.println(w.getWeight()+"-"+w.getElement() + " ");
            }
        }
        System.out.println(g.toDot());
    }
}