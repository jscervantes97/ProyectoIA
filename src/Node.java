import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
    private String city;
    public Node parent;
    private List<Edge> adjacents = new ArrayList();
    public double g_scores;
    public double h_scores;  //es la distancia que hay de una ciudad a otra
    public double f_scores = 0;



    public Node(String city) {
        this.city = city;
    }

    public void addEdge(Edge edge) {
        adjacents.add(edge);
    }

    public List<Edge> getAdjacents() {
        return adjacents;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Node [city=" + city + ", h = "+ h_scores +" , adjacents=" + adjacents + "]";
    }



    public void ordenarMenorMayor(){
        /*
        Collections.sort(adjacents, (o1, o2) -> {
            String st1 = String.valueOf(o1.getDistance());
            String st2 = String.valueOf(o2.getDistance());
            return st2.compareTo(st1);
        });*/
        Collections.sort(adjacents);
    }

    public void setH(){
        double sum = 0 ;
        for(Edge vertice : adjacents){
            sum += vertice.getDistance();
        }
        h_scores = sum/adjacents.size() ;
    }

}