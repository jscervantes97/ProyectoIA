import java.util.*;


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

        Node df = new Node("DF");
        Node toluca = new Node("Toluca");
        Node cuernavaca = new Node("Cuernavaca");
        Node puebla = new Node("Puebla");
        Node tlaxcala = new Node("Tlaxcala");
        Node cancun = new Node("Cancún");


        df.addEdge(new Edge(df, toluca, 100));
        df.addEdge(new Edge(df, cuernavaca, 90));

        toluca.addEdge(new Edge(toluca, cuernavaca, 150));
        toluca.addEdge(new Edge(toluca, df, 100));
        toluca.addEdge(new Edge(toluca, puebla, 350));
        toluca.addEdge(new Edge(toluca, tlaxcala, 340));


        cuernavaca.addEdge(new Edge(cuernavaca, puebla, 100));
        cuernavaca.addEdge(new Edge(cuernavaca, df, 90));


        puebla.addEdge(new Edge(puebla, tlaxcala, 20));
        puebla.addEdge(new Edge(puebla, toluca, 350));

        System.out.println(toluca.getAdjacents());
        toluca.ordenarMayor();
        System.out.println(toluca.getAdjacents());
    }
}