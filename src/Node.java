import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
    private String city;
    private List<Edge> adjacents = new ArrayList();
    public Node parent;
    public double g_scores;
    public double h_scores;  //es la distancia que hay de una ciudad a otra
    public double f_scores = 0;
    public double pathLength;



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