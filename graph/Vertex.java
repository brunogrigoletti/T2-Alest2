package graph;

import java.math.BigInteger;

public class Vertex{
    private BigInteger weight;
    private String element;

    public Vertex(){
        this.weight = new BigInteger("0");
        this.element = null;
    }

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
}