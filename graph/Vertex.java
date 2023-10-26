package graph;

import java.math.BigInteger;

public class Vertex implements Comparable<Vertex>{
    private BigInteger weight;
    private String element;

    public Vertex(String weight, String element){
        this.weight = new BigInteger(weight);
        this.element = element;
    }

    public BigInteger getWeight(){
        return this.weight;
    }

    public String getElement(){
        return this.element;
    }

    @Override
    public int compareTo(Vertex other){
        return this.weight.compareTo(other.weight);
    }
}