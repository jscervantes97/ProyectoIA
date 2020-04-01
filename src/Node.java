import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
    private String city;
    private List<Edge> adjacents = new ArrayList();

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
        return "Node [city=" + city + ", adjacents=" + adjacents + "]";
    }

    public void ordenarMayorMayor(){
        Collections.sort(adjacents, (o1, o2) -> {
            String st1 = String.valueOf(o1.getDistance());
            String st2 = String.valueOf(o2.getDistance());
            return st1.compareTo(st2);
        });
    }

    public void ordenarMenorMayor(){
        Collections.sort(adjacents, (o1, o2) -> {
            String st1 = String.valueOf(o1.getDistance());
            String st2 = String.valueOf(o2.getDistance());
            return st2.compareTo(st1);
        });
    }

}