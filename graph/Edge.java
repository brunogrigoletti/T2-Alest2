package graph;

public class Edge implements Comparable<Edge> {
    private Vertex v;
    private Vertex w;
    private double weight;

    public Edge(Vertex v, Vertex w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public Vertex getV() {
        return this.v;
    }

    public Vertex getW() {
        return this.w;
    }

    public double getWeight() {
        return this.weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return this.v + "-" + this.w + " (" + this.weight + ")";
    }
}