
/**
 * @author raidentrance
 *
 */
public class MapBuilder {
    private static final Graph instance = new Graph();

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
        Node	cabos	= new Node("cabos");
        Node	ciudaddelicias	= new Node("ciudaddelicias");
        Node	ciudadjaloa	= new Node("ciudadjaloa");
        Node	ciudadlerdo	= new Node("ciudadlerdo");
        Node	ciudadojocaliente	= new Node("ciudadojocaliente");
        Node	ciudadjuarez	= new Node("ciudadjuarez");
        Node	ciudadvalles	= new Node("ciudadvalles");
        Node	ciudadvictoria	= new Node("ciudadvictoria");
        Node	culiacan	= new Node("culiacan");
        Node	fresnillo	= new Node("fresnillo");
        Node	gomezpalacio	= new Node("gomezpalacio");
        Node	hermosillo	= new Node("hermosillo");
        Node	lapaz	= new Node("lapaz");
        Node	lareto 	= new Node("lareto");
        Node	loreto 	= new Node("loreto");
        Node	mazatlan	= new Node("mazatlan");
        Node	mexicali	= new Node("mexicali");
        Node	mochis	= new Node("mochis");
        Node	monclova	= new Node("monclova");
        Node	monterrey	= new Node("monterrey");
        Node	nogales	= new Node("nogales");
        Node	nuevolaredo	= new Node("nuevolaredo");
        Node	nuevoleon	= new Node("nuevoleon");
        Node	obregon	= new Node("obregon");
        Node	parral	= new Node("parral");
        Node	saltillo	= new Node("saltillo");
        Node	sanblas	= new Node("sanblas");
        Node	sanluispotosi	= new Node("sanluispotosi");
        Node	santamariaoro	= new Node("santamariaoro");
        Node	sanvicente	= new Node("sanvicente");
        Node	tampico	= new Node("tampico");
        Node	tecate	= new Node("tecate");
        Node	tepic	= new Node("tepic");
        Node	tijuana	= new Node("tijuana");
        Node	torreon	= new Node("torreon");
        Node	victoriadurango	= new Node("	victoriadurango	");
        Node	zaragoza 	= new Node("	zaragoza 	");



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
}