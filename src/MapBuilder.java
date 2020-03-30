import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author raidentrance
 *
 */
public class MapBuilder {
    private static final Graph instance = new Graph();

    public static double distancia = 0 ;
    public static List<String> ciudadesRecorridas = new ArrayList<>();

    private MapBuilder() {
    }

    public static Graph getGraph() {
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
        Node	lapaz	= new Node("Lapaz");
        Node	lareto 	= new Node("Lareto");
        Node	mazatlan	= new Node("Mazatlan");
        Node	mexicali	= new Node("Mexicali");
        Node	mochis	= new Node("Los Mochis");
        Node	monclova	= new Node("Monclova");
        Node	monterrey	= new Node("Monterrey");
        Node	nogales	= new Node("Nogales");
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

        cabos.addEdge(new Edge(cabos,lapaz,146));
        cabos.addEdge(new Edge(cabos,tijuana,279));

        ciudaddelicias.addEdge(new Edge(ciudaddelicias,torreon,442));
        ciudaddelicias.addEdge(new Edge(ciudaddelicias,monclova,506));

        ciudadjaloa.addEdge(new Edge(ciudadjaloa,sanvicente	,416));

        ciudadlerdo.addEdge(new Edge(ciudadlerdo,torreon,199));

        ciudadojocaliente.addEdge(new Edge(	ciudadojocaliente,sanluispotosi	,270));

        ciudadvalles.addEdge(new Edge(ciudadvalles,sanluispotosi,419));

        ciudadvictoria.addEdge(new Edge(ciudadvictoria,ciudadvalles,134));

        culiacan.addEdge(new Edge(culiacan,mazatlan,204));

        fresnillo.addEdge(new Edge(fresnillo,ciudadojocaliente,52));

        gomezpalacio.addEdge(new Edge(gomezpalacio,fresnillo,205));

        hermosillo.addEdge(new Edge(hermosillo,obregon,358));
        hermosillo.addEdge(new Edge(hermosillo,	ciudadjuarez	,481));
        hermosillo.addEdge(new Edge(hermosillo,ciudaddelicias,470));

        lapaz.addEdge(new Edge(lapaz,lareto,270));
        lapaz.addEdge(new Edge(lapaz,tecate,1120));

        lareto .addEdge(new Edge(lareto,mexicali,838));

        mazatlan.addEdge(new Edge(mazatlan,victoriadurango,200));

        mexicali.addEdge(new Edge(mexicali,hermosillo,585));

        mochis.addEdge(new Edge(mochis,culiacan,194));

        monclova.addEdge(new Edge(monclova,nuevoleon,187));
        monclova.addEdge(new Edge(monclova,saltillo,169));

        monterrey.addEdge(new Edge(monterrey,zaragoza,71));

        nogales.addEdge(new Edge(nogales,mochis,644));
        nogales.addEdge(new Edge(nogales,parral,551));
        nogales.addEdge(new Edge(nogales,ciudaddelicias,546));

        nuevolaredo.addEdge(new Edge(nuevolaredo,tampico,605));

        nuevoleon.addEdge(new Edge(nuevoleon,monterrey,15));
        nuevoleon.addEdge(new Edge(nuevoleon,nuevolaredo	,214));

        obregon.addEdge(new Edge(obregon,nogales,188));

        parral.addEdge(new Edge(parral,ciudadlerdo,533));

        saltillo.addEdge(new Edge(saltillo,monterrey,74));

        sanblas.addEdge(new Edge(sanblas,santamariaoro,75));

        santamariaoro.addEdge(new Edge(santamariaoro,ciudadojocaliente,262));

        sanvicente.addEdge(new Edge(sanvicente,ciudadojocaliente,426));
        sanvicente.addEdge(new Edge(sanvicente,zaragoza,406));

        tampico.addEdge(new Edge(tampico,ciudadvictoria,3));

        tecate.addEdge(new Edge(tecate,mexicali,108));

        tepic.addEdge(new Edge(tepic,sanblas,40));

        tijuana.addEdge(new Edge(tijuana,tecate,39));

        torreon.addEdge(new Edge(torreon,monclova,253));
        torreon.addEdge(new Edge(torreon,gomezpalacio,213));
        torreon.addEdge(new Edge(torreon,ciudadjaloa,328));

        victoriadurango.addEdge(new Edge(victoriadurango,fresnillo,206));
        victoriadurango.addEdge(new Edge(victoriadurango,tepic,280));

        zaragoza.addEdge(new Edge(zaragoza,ciudadvictoria,386));

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
        instance.addNode(nogales);
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
}