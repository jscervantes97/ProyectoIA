import java.util.*;


public class GraphExampleApplication {
    private Graph graph;

    public GraphExampleApplication() {
        graph = MapBuilder.getGraph();
        //graph.ordenarRutas();
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
        if (start != null && end != null) {
            return hasPathDfs(start, end, new HashSet());
        } else {
            return false;
        }
    }

    public double distancia = 0 ;
    private boolean hasPathDfs(Node origen, Node destination, HashSet visited) {
        if (visited.contains(origen.getCity())) {
            return false;
        }
        System.out.println(origen.getCity());
        visited.add(origen.getCity());
        if (origen == destination) {
            return true;
        }
        for (Edge edge : origen.getAdjacents()) {
            this.distancia += edge.getDistance();
            if(visited.contains(edge.getDestination())){
                this.distancia -= edge.getDistance();
            }
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
            //System.out.println(node.getCity());
            if (node.getCity().equals(destination.getCity())) {
                return true;
            }
            if (visited.contains(node.getCity())) {
                continue;
            }
            visited.add(node.getCity());
            for (Edge edge : node.getAdjacents()) {
                this.distancia += edge.getDistance();
                nextToVisit.add(edge.getDestination());
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int opcion = 0 ;
        GraphExampleApplication grafo = new GraphExampleApplication();

        Scanner Lee = new Scanner(System.in);
        System.out.println("********************");



        /*
        System.out.println("\n\t Paths from DF \n");
        System.out.println(String.format("From DF to Tlaxcala %s", grafo.hasPathDfs("DF", "Tlaxcala")));
        System.out.println("Distancia Recorrida " + grafo.distancia);
        grafo.distancia = 0  ;
        System.out.println(String.format("From DF to Tlaxcala %s", grafo.hasPathBfs("DF", "Tlaxcala")));
        System.out.println("Distancia Recorrida " + grafo.distancia);
        grafo.distancia = 0  ;


        System.out.println(String.format("From Toluca to Tlaxcala %s", grafo.hasPathDfs("Toluca", "Tlaxcala")));
        System.out.println("Distancia Recorrida " + grafo.distancia);
        grafo.distancia = 0  ;
        */
        System.out.println(String.format("From nuevoleon to culiacan %s", grafo.hasPathDfs("nuevoleon", "culiacan")));
        System.out.println("Distancia Recorrida " + grafo.distancia);
        grafo.distancia = 0 ;

        System.out.println(String.format("From cabos to ciudaddelicias %s", grafo.hasPathDfs("cabos", "ciudaddelicias")));
        System.out.println("Distancia Recorrida " + grafo.distancia);
        grafo.distancia = 0 ;
    }
}