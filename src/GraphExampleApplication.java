import java.util.HashSet;
import java.util.LinkedList;
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

    public boolean hasPathBfs(String source, String destination) {

        Node start = getNode(source);
        Node end = getNode(destination);

        if (start != null && end!= null) {
            return hasPathBfs(start, end);
        } else {
            return false;
        }
    }

    public boolean hasPathBfs(Node source, Node destination) {

        LinkedList<Node> nextToVisit = new LinkedList<>();

        HashSet<String> visited = new HashSet<>();
        nextToVisit.add(source);
        while (!nextToVisit.isEmpty()) {
            Node node = nextToVisit.remove();
            System.out.println(node.getCity());
            if (node.getCity().equals(destination.getCity())) {
                return true;
            }
            if (visited.contains(node.getCity())) {
                continue;
            }
            visited.add(node.getCity());
            for (Edge edge : node.getAdjacents()) {
                nextToVisit.add(edge.getDestination());
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
        System.out.println(String.format("From DF to Tlaxcala %s", grafo.hasPathBfs("DF", "Tlaxcala")));
    }
}