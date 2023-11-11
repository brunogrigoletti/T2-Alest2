package graph;

public class Edge {
    private Vertex from;
    private Vertex to;
    private long weight;

    public Edge(Vertex from, Vertex to, long weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Vertex getFrom() {
        return from;
    }

    public Vertex getTo() {
        return to;
    }

    public long getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return from + " -> " + to + " [label=" + weight + "]";
    }
}