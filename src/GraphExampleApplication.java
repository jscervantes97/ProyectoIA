import java.util.*;


public class GraphExampleApplication {
    private Graph graph;
    public double distancia = 0 ;
    public GraphExampleApplication() {
        graph = MapBuilder.getGraph();
        //graph.ordenarRutas();
        graph.addNode(new Node("Navolato"));
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
        //System.out.println(source.getCity());
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
                this.distancia += edge.getDistance();
                nextToVisit.add(edge.getDestination());
            }
        }
        return false;
    }

    public static void AstarSearch(Node source, Node goal){

        Set<Node> explored = new HashSet<Node>();

        PriorityQueue<Node> queue = new PriorityQueue<Node>(20,
                new Comparator<Node>(){
                    //override compare method
                    public int compare(Node i, Node j){
                        if(i.f_scores > j.f_scores){
                            return 1;
                        }
                        else if (i.f_scores < j.f_scores){
                            return -1;
                        }
                        else{
                            return 0;
                        }
                    }

                }
        );

        //cost from start
        source.g_scores = 0;

        queue.add(source);

        boolean found = false;

        while((!queue.isEmpty())&&(!found)){

            //the node in having the lowest f_score value
            Node current = queue.poll();

            explored.add(current);

            //goal found
            if(current.getCity().equals(goal.getCity())){
                found = true;
            }

            //check every child of current node
            for(Edge e : current.getAdjacents()){
                Node child = e.getDestination();
                double cost = e.getDistance();
                double temp_g_scores = current.g_scores + cost;
                double temp_f_scores = temp_g_scores + child.h_scores;


                                /*if child node has been evaluated and
                                the newer f_score is higher, skip*/

                if((explored.contains(child)) &&
                        (temp_f_scores >= child.f_scores)){
                    continue;
                }

                                /*else if child node is not in queue or
                                newer f_score is lower*/

                else if((!queue.contains(child)) ||
                        (temp_f_scores < child.f_scores)){

                    child.parent = current;
                    child.g_scores = temp_g_scores;
                    child.f_scores = temp_f_scores;

                    if(queue.contains(child)){
                        queue.remove(child);
                    }

                    queue.add(child);

                }

            }

        }

    }

    public static List<Node> printPath(Node target){
        List<Node> path = new ArrayList<Node>();

        for(Node node = target; node!=null; node = node.parent){
            path.add(node);
        }

        Collections.reverse(path);

        return path;
    }

    public static void main(String[] args) {
        int opcion = 0 ;
        GraphExampleApplication grafo = new GraphExampleApplication();
        //grafo.graph.ordenarRutas();
        //grafo.graph.ordenarRutas();
        /*Graph frago = MapBuilder.getGraph();
        frago.ordenarRutas();
        for(int i = 0 ; i < frago.getNodes().size() ; i++){
            Node nodo = frago.getNodes().get(i);
            nodo.ordenarMayorMayor();
        }
        */
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

        System.out.println(String.format("From nuevoleon to culiacan %s", grafo.hasPathDfs("nuevoleon", "culiacan")));
        System.out.println("Distancia Recorrida " + grafo.distancia);
        grafo.distancia = 0 ;

        System.out.println(String.format("From cabos to ciudaddelicias %s", grafo.hasPathDfs("cabos", "ciudaddelicias")));
        System.out.println("Distancia Recorrida " + grafo.distancia);
        grafo.distancia = 0 ;
        */
        /*
        System.out.println(String.format("From Puebla to Cuernavaca %s", grafo.hasPathBfs("Puebla", "Cuernavaca")));
        System.out.println("Distancia Recorrida " + grafo.distancia);
        grafo.distancia = 0  ;
         */
        /*
        System.out.println(String.format("From culiacan to mochis %s", grafo.hasPathDfs("culiacan", "mochis")));
        System.out.println("Distancia Recorrida " + grafo.distancia);
        grafo.distancia = 0 ;

        Node df = new Node("DF");
        Node toluca = new Node("Toluca");
        Node cuernavaca = new Node("Cuernavaca");
        Node puebla = new Node("Puebla");
        Node tlaxcala = new Node("Tlaxcala");
        Node cancun = new Node("Cancún");


        df.addEdge(new Edge(df, cancun, 150));
        df.addEdge(new Edge(df, toluca, 100));
        df.addEdge(new Edge(df, cuernavaca, 90));
        df.ordenarMenorMayor();
        df.setH();
        System.out.println(df.h_scores);
        toluca.addEdge(new Edge(toluca, cuernavaca, 150));
        toluca.addEdge(new Edge(toluca, df, 100));
        toluca.addEdge(new Edge(toluca, puebla, 350));
        toluca.addEdge(new Edge(toluca, tlaxcala, 340));
        toluca.ordenarMenorMayor();

        cuernavaca.addEdge(new Edge(cuernavaca, puebla, 100));
        cuernavaca.addEdge(new Edge(cuernavaca, df, 90));


        puebla.addEdge(new Edge(puebla, tlaxcala, 20));
        puebla.addEdge(new Edge(puebla, toluca, 350));
        */

        //MapBuilder.hasAstartPath("Los Cabos","Culiacan");
        MapBuilder.hasBranchBoundPath("Los Cabos","Culiacan");
        System.out.println(MapBuilder.distancia);
        System.out.println(MapBuilder.ciudadesRecorridas);
    }
}