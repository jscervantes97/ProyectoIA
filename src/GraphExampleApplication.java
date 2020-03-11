import java.util.HashSet;
import java.util.List;
import java.util.Optional;



public class GraphExampleApplication {
    private Graph graph;

    public GraphExampleApplication() {
        graph = MapBuilder.getGraph();
    }

    private Node getNode(String city) {
        List<Node> nodes = graph.getNodes();
        for (Node node : nodes) {
            if (node.getCity().equals(city)) {
                return node;
            }
        }
        return null;
    }

    public boolean hasPathDfs(String source, String destination) {
        Node start = getNode(source);
        Node end = getNode(destination);
        if (start != null && end!= null) {
            return hasPathDfs(start, end, new HashSet());
        } else {
            return false;
        }
    }

    public double distancia = 0 ;
    private boolean hasPathDfs(Node source, Node destination, HashSet visited) {
        if (visited.contains(source.getCity())) {
            return false;
        }
        System.out.println(source.getCity());
        visited.add(source.getCity());
        if (source == destination) {
            return true;
        }
        for (Edge edge : source.getAdjacents()) {
            this.distancia += edge.getDistance();
            if (hasPathDfs(edge.getDestination(), destination, visited)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        GraphExampleApplication grafo = new GraphExampleApplication();
        System.out.println("\n\t Paths from DF \n");
        System.out.println(String.format("From DF to Tlaxcala %s", grafo.hasPathDfs("DF", "Tlaxcala")));
        System.out.println("Distancia Recorrida " + grafo.distancia);
        grafo.distancia = 0  ;

        System.out.println("\n\t RUTA TOLUCA - TLAXCALA \n");
        System.out.println(String.format("De Toluca a Tlaxcala %s", grafo.hasPathDfs("Toluca", "Tlaxcala")));
        System.out.println("Distancia Recorrida " + grafo.distancia);

    }
}