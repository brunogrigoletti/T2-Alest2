package app;

import java.math.BigInteger;
import graph.Digraph;
import graph.HydrogenCalculator;
import graph.Vertex;

public class App {
    Digraph g;

    public App() {
        this.g = new Digraph();
    }

    public void readFile() {
        try {
            g.loadFromFile("cases/casof360.txt");
        }
        catch (Exception e) {
            System.out.println("Erro ao ler o arquivo.");
        }
    }

    public void digraph() {
        System.out.println(g.toString());
    }

    public void getHydrogenCount() {
        Vertex start = g.getHydrogen();
        HydrogenCalculator hc = new HydrogenCalculator(g);
        BigInteger result = hc.sumProduct(start);
        System.out.println("Hidrogênios: " + result.toString());
    }
}