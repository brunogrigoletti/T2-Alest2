import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HydrogenCalculator {
    private Map<Vertex, BigInteger> hydrogenCount = new HashMap<>();
    private Set<Vertex> visited = new HashSet<>();
    private Digraph graph;

    public HydrogenCalculator(Digraph graph) {
        this.graph = graph;
    }

    public BigInteger sumProduct(Vertex start) {
        if (hydrogenCount.containsKey(start)) {
            return hydrogenCount.get(start);
        }

        if (graph.getEdges(start).isEmpty()) {
            hydrogenCount.put(start, BigInteger.ONE);
            return BigInteger.ONE;
        }

        visited.add(start);
        BigInteger result = BigInteger.ZERO;

        for (Edge edge : graph.getEdges(start)) {
            if (!visited.contains(edge.getTo())) {
                BigInteger subtreeResult = BigInteger.valueOf(edge.getWeight()).multiply(sumProduct(edge.getTo()));
                result = result.add(subtreeResult);
            }
        }

        hydrogenCount.put(start, result);

        visited.remove(start);
        return result;
    }

    public Map<Vertex, BigInteger> getHydrogenCount() {
        return hydrogenCount;
    }
}
