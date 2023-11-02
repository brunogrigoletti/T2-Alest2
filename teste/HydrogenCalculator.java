
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HydrogenCalculator {
    private Map<Vertex, BigInteger> hydrogenCount = new HashMap<>();
    private Set<Vertex> visited = new HashSet<>();
    private Digraph graph;
    BigInteger result = BigInteger.ZERO;

    public HydrogenCalculator(Digraph graph) {
        this.graph = graph;
    }

    public BigInteger sumProduct(Vertex start) {
        if (visited.contains(start)) {
            return BigInteger.ZERO;
        }

        if (graph.getEdges(start).isEmpty()) {
            return BigInteger.ONE;
        }

        visited.add(start);
        BigInteger result = BigInteger.ZERO;

        for (Edge edge : graph.getEdges(start)) {
            if (!visited.contains(edge.getTo())) {
                BigInteger subtreeResult = BigInteger.valueOf(edge.getWeight()).multiply(sumProduct(edge.getTo()));
                hydrogenCount.put(edge.getFrom(), subtreeResult);
                result = result.add(subtreeResult);
            }
        }

        visited.remove(start); // Remover da lista de visitados para permitir outras buscas
        return result;
    }

    public Map<Vertex, BigInteger> getHydrogenCount() {
        return hydrogenCount;
    }
}
