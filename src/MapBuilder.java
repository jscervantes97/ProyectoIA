



import java.util.*;

/**
 * @author raidentrance
 *
 */
public class MapBuilder {
    public static  Graph instance = getGraph();

    public static Graph aux = getGraph();

    public static double distancia = 0 ;
    public static List<String> ciudadesRecorridas = new ArrayList<>();

    private MapBuilder() {
        instance = getGraph();
        aux = getGraph();
        System.out.println(instance);
    }

    public static Graph getGraph() {
        Graph instance = new Graph();
         Node df = new Node("DF");
         Node toluca = new Node("Toluca");
         Node cuernavaca = new Node("Cuernavaca");
         Node puebla = new Node("Puebla");
         Node tlaxcala = new Node("Tlaxcala");
         Node cancun = new Node("Cancún");

        //-------------------------------
        // Node df = new Node("DF");
        // Node toluca = new Node("Toluca");
        // Node cuernavaca = new Node("Cuernavaca");
        // Node puebla = new Node("Puebla");
        // Node tlaxcala = new Node("Tlaxcala");
        // Node cancun = new Node("Cancún");

        //-------------------------------
        Node	cabos	= new Node("Los Cabos");
        Node	ciudaddelicias	= new Node("Ciudad Delicias");
        Node	ciudadjaloa	= new Node("Ciudad Jaloa");
        Node	ciudadlerdo	= new Node("Ciudad Lerdo");
        Node	ciudadojocaliente	= new Node("Ciudado Jocaliente");
        Node	ciudadjuarez	= new Node("Ciudad Juarez");
        Node	ciudadvalles	= new Node("Ciudad Valles");
        Node	ciudadvictoria	= new Node("Ciudad Victoria");
        Node	culiacan	= new Node("Culiacan");
        Node	fresnillo	= new Node("Fresnillo");
        Node	gomezpalacio	= new Node("Gomez Palacio");
        Node	hermosillo	= new Node("Hermosillo");
        Node	lapaz	= new Node("La paz"); //nunca fue una opcion ??
        Node	lareto 	= new Node("Lareto");
        Node	mazatlan	= new Node("Mazatlan");
        Node	mexicali	= new Node("Mexicali");
        Node	mochis	= new Node("Los Mochis");
        Node	monclova	= new Node("Monclova");
        Node	monterrey	= new Node("Monterrey");
        Node	navojoa	= new Node("Navojoa");
        Node	nuevolaredo	= new Node("Nuevo Laredo");
        Node	nuevoleon	= new Node("Nuevo Leon");
        Node	obregon	= new Node("Ciudad Obregon");
        Node	parral	= new Node("Parral");
        Node	saltillo	= new Node("Saltillo");
        Node	sanblas	= new Node("San blas");
        Node	sanluispotosi	= new Node("San Luis Potosi");
        Node	santamariaoro	= new Node("Santa Mariaoro");
        Node	sanvicente	= new Node("San Vicente");
        Node	tampico	= new Node("Tampico");
        Node	tecate	= new Node("Tecate");
        Node	tepic	= new Node("Tepic");
        Node	tijuana	= new Node("Tijuana");
        Node	torreon	= new Node("Torreon");
        Node	victoriadurango	= new Node("Victoria Durango");
        Node	zaragoza 	= new Node("Zaragoza");



        //-------------------------------


        cabos.addEdge(new Edge(cabos,tijuana,1279));
        cabos.addEdge(new Edge(cabos,lapaz,146));

        ciudaddelicias.addEdge(new Edge(ciudaddelicias,torreon,442));
        ciudaddelicias.addEdge(new Edge(ciudaddelicias,monclova,506));
        ciudaddelicias.addEdge(new Edge(ciudaddelicias,hermosillo,470));
        ciudaddelicias.addEdge(new Edge(ciudaddelicias,navojoa,546));

        ciudadjuarez.addEdge(new Edge(ciudadjuarez,hermosillo,481));

        ciudadjaloa.addEdge(new Edge(ciudadjaloa,sanvicente	,416));
        ciudadjaloa.addEdge(new Edge(ciudadjaloa,torreon	,328));

        ciudadlerdo.addEdge(new Edge(ciudadlerdo,torreon,199));
        ciudadlerdo.addEdge(new Edge(ciudadlerdo,parral,551));

        ciudadojocaliente.addEdge(new Edge(	ciudadojocaliente,sanluispotosi	,270));
        ciudadojocaliente.addEdge(new Edge(	ciudadojocaliente,sanvicente	,426));
        ciudadojocaliente.addEdge(new Edge(	ciudadojocaliente,fresnillo	,52));
        ciudadojocaliente.addEdge(new Edge(	ciudadojocaliente,santamariaoro	,262));

        ciudadvalles.addEdge(new Edge(ciudadvalles,sanluispotosi,419));
        ciudadvalles.addEdge(new Edge(ciudadvalles,ciudadvictoria,134));

        ciudadvictoria.addEdge(new Edge(ciudadvictoria,ciudadvalles,134));

        culiacan.addEdge(new Edge(culiacan,mazatlan,204));
        culiacan.addEdge(new Edge(culiacan,mochis,194));

        fresnillo.addEdge(new Edge(fresnillo,ciudadojocaliente,52));
        fresnillo.addEdge(new Edge(fresnillo,victoriadurango,206));
        fresnillo.addEdge(new Edge(fresnillo,gomezpalacio,205));

        gomezpalacio.addEdge(new Edge(gomezpalacio,fresnillo,205));
        gomezpalacio.addEdge(new Edge(gomezpalacio,torreon,213));


        hermosillo.addEdge(new Edge(hermosillo,obregon,358));
        hermosillo.addEdge(new Edge(hermosillo,	ciudadjuarez	,481));
        hermosillo.addEdge(new Edge(hermosillo,ciudaddelicias,470));
        hermosillo.addEdge(new Edge(hermosillo,mexicali,585));

        lapaz.addEdge(new Edge(lapaz,lareto,270));
        lapaz.addEdge(new Edge(lapaz,tecate,1120));
        lapaz.addEdge(new Edge(lapaz,cabos,146));

        lareto.addEdge(new Edge(lareto,mexicali,838));
        lareto.addEdge(new Edge(lareto,lapaz,270));

        mazatlan.addEdge(new Edge(mazatlan,victoriadurango,200));
        mazatlan.addEdge(new Edge(mazatlan,culiacan,204));

        mexicali.addEdge(new Edge(mexicali,hermosillo,585));
        mexicali.addEdge(new Edge(mexicali,tecate,108));
        mexicali.addEdge(new Edge(mexicali,lareto,838));


        mochis.addEdge(new Edge(mochis,culiacan,194));
        mochis.addEdge(new Edge(mochis,navojoa,644));

        monclova.addEdge(new Edge(monclova,nuevoleon,187));
        monclova.addEdge(new Edge(monclova,saltillo,169));
        monclova.addEdge(new Edge(monclova,torreon,253));
        monclova.addEdge(new Edge(monclova,ciudaddelicias,506));

        monterrey.addEdge(new Edge(monterrey,zaragoza,71));
        monterrey.addEdge(new Edge(monterrey,saltillo,74));
        monterrey.addEdge(new Edge(monterrey,nuevoleon,15));

        navojoa.addEdge(new Edge(navojoa,mochis,644));
        navojoa.addEdge(new Edge(navojoa,parral,551));
        navojoa.addEdge(new Edge(navojoa,ciudaddelicias,546));
        navojoa.addEdge(new Edge(navojoa,obregon,188));

        nuevolaredo.addEdge(new Edge(nuevolaredo,tampico,605));
        nuevolaredo.addEdge(new Edge(nuevolaredo,nuevoleon,214));

        nuevoleon.addEdge(new Edge(nuevoleon,monterrey,15));
        nuevoleon.addEdge(new Edge(nuevoleon,nuevolaredo	,214));

        obregon.addEdge(new Edge(obregon,navojoa,188));
        obregon.addEdge(new Edge(obregon,hermosillo,358));

        parral.addEdge(new Edge(parral,ciudadlerdo,533));
        parral.addEdge(new Edge(parral,navojoa,551));

        saltillo.addEdge(new Edge(saltillo,monterrey,74));
        saltillo.addEdge(new Edge(saltillo,monclova,169));

        sanblas.addEdge(new Edge(sanblas,santamariaoro,75));
        sanblas.addEdge(new Edge(sanblas,tepic,40));

        santamariaoro.addEdge(new Edge(santamariaoro,ciudadojocaliente,262));
        santamariaoro.addEdge(new Edge(santamariaoro,sanblas,75));

        sanvicente.addEdge(new Edge(sanvicente,ciudadojocaliente,426));
        sanvicente.addEdge(new Edge(sanvicente,zaragoza,406));
        sanvicente.addEdge(new Edge(sanvicente,ciudadjaloa,416));

        tampico.addEdge(new Edge(tampico,ciudadvictoria,3));
        tampico.addEdge(new Edge(tampico,nuevolaredo,605));

        tecate.addEdge(new Edge(tecate,mexicali,108));
        tecate.addEdge(new Edge(tecate,tijuana,39));

        tepic.addEdge(new Edge(tepic,sanblas,40));
        tepic.addEdge(new Edge(tepic,victoriadurango,280));

        tijuana.addEdge(new Edge(tijuana,cabos,1279));
        tijuana.addEdge(new Edge(tijuana,tecate,39));

        torreon.addEdge(new Edge(torreon,monclova,253));
        torreon.addEdge(new Edge(torreon,gomezpalacio,213));
        torreon.addEdge(new Edge(torreon,ciudadjaloa,328));
        torreon.addEdge(new Edge(torreon,ciudaddelicias,442));
        torreon.addEdge(new Edge(torreon,ciudadlerdo,199));

        victoriadurango.addEdge(new Edge(victoriadurango,fresnillo,206));
        victoriadurango.addEdge(new Edge(victoriadurango,tepic,280));
        victoriadurango.addEdge(new Edge(victoriadurango,mazatlan,200));

        sanluispotosi.addEdge(new Edge(sanluispotosi,ciudadojocaliente	,270));
        sanluispotosi.addEdge(new Edge(sanluispotosi,ciudadvalles,419));

        zaragoza.addEdge(new Edge(zaragoza,ciudadvictoria,386));
        zaragoza.addEdge(new Edge(zaragoza,sanvicente,426));
        zaragoza.addEdge(new Edge(zaragoza,monterrey,71));

        //-------------------------------

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

        // -------------------------
        instance.addNode(cabos);
        instance.addNode(ciudaddelicias);
        instance.addNode(ciudadjaloa);
        instance.addNode(ciudadlerdo);
        instance.addNode(ciudadojocaliente);
        instance.addNode(ciudadvalles);
        instance.addNode(ciudadvictoria);
        instance.addNode(culiacan);
        instance.addNode(fresnillo);
        instance.addNode(gomezpalacio);
        instance.addNode(hermosillo);
        instance.addNode(lapaz);
        instance.addNode(lareto );
        instance.addNode(mazatlan);
        instance.addNode(mexicali);
        instance.addNode(mochis);
        instance.addNode(monclova);
        instance.addNode(monterrey);
        instance.addNode(navojoa);
        instance.addNode(nuevolaredo);
        instance.addNode(nuevoleon);
        instance.addNode(obregon);
        instance.addNode(parral);
        instance.addNode(saltillo);
        instance.addNode(sanblas);
        instance.addNode(santamariaoro);
        instance.addNode(sanvicente);
        instance.addNode(tampico);
        instance.addNode(tecate);
        instance.addNode(tepic);
        instance.addNode(tijuana);
        instance.addNode(torreon);
        instance.addNode(victoriadurango);
        instance.addNode(zaragoza );
        // -----------------------

         instance.addNode(df);
         instance.addNode(toluca);
         instance.addNode(cuernavaca);
         instance.addNode(puebla);
         instance.addNode(cancun);
         instance.addNode(tlaxcala);
         instance.setearH();
        return instance;
    }

    public static Node getNode(String city) {
        List<Node> nodes = instance.getNodes();
        for (Node node : nodes) {
            if (node.getCity().equals(city)) {
                return node;
            }
        }
        return null;
    }

    public static boolean hasPathDfs(String source, String destination) {
        ciudadesRecorridas.clear();
        Node start = getNode(source);
        Node end = getNode(destination);
        if (start != null && end != null) {
            return hasPathDfs(start, end, new HashSet());
        } else {
            return false;
        }
    }

    public static boolean hasPathDfs(Node origen, Node destination, HashSet visited) {
        if (visited.contains(origen.getCity())) {
            return false;
        }
        //System.out.println(origen.getCity());
        visited.add(origen.getCity());
        ciudadesRecorridas.add(origen.getCity());
        if (origen == destination) {
            return true;
        }
        for (Edge edge : origen.getAdjacents()) {
            distancia += edge.getDistance();
            if(visited.contains(edge.getDestination())){
                distancia -= edge.getDistance();
            }
            if (hasPathDfs(edge.getDestination(), destination, visited)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasPathBfsMejorado(String source, String destination){
        ciudadesRecorridas.clear();
        aux = instance;
        //instance.ordenarRutas();

        Node start = getNode(source);
        Node end = getNode(destination);
        boolean band = false ;
        if (start != null && end!= null) {
            band = hasPathBfs(start, end);
        }
        instance = aux ;
        return band ;
    }

    public static boolean hasPathBfs(String source, String destination) {
        ciudadesRecorridas.clear();
        Node start = getNode(source);
        Node end = getNode(destination);

        if (start != null && end!= null) {
            return hasPathBfs(start, end);
        } else {
            return false;
        }
    }

    public static boolean hasPathBfs(Node source, Node destination) {

        LinkedList<Node> nextToVisit = new LinkedList<>();

        HashSet<String> visited = new HashSet<>();
        nextToVisit.add(source);
        //System.out.println(source.getCity());
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
            ciudadesRecorridas.add(node.getCity());
            for (Edge edge : node.getAdjacents()) {
                distancia += edge.getDistance();
                nextToVisit.add(edge.getDestination());
            }
        }
        return false;
    }

    public static List<String> getCiudadesRecorridas(){
        List<String> lista = new ArrayList<>();
        lista.add("Total de Ciudades Visitadas" + (ciudadesRecorridas.size()-1));
        for(String ciudad : ciudadesRecorridas){
            lista.add(ciudad);
        }
        return lista ;
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

    public static List<Node> hasAstartPath(String source, String destination) {
        Node start = getNode(source);
        Node end = getNode(destination);
        AstarSearch(start, end);
        return printPath(end);
    }

    public static List<Node> printPath(Node target){
        List<Node> path = new ArrayList<Node>();

        for(Node node = target; node!=null; node = node.parent){
            path.add(node);
            ciudadesRecorridas.add(node.getCity());
            distancia += node.f_scores;
        }

        Collections.reverse(path);
        Collections.reverse(ciudadesRecorridas);
        return path;
    }
}