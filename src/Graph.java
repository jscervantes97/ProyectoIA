import java.util.ArrayList;
import java.util.List;

/**
 * @author Chuy 7u7
 *
 */
public class Graph {

    private List<Node> nodes = new ArrayList();

    public void addNode(Node node) {
        nodes.add(node);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        return "Graph [nodes=" + nodes + "]";
    }

    public void imprimirNodos(){
        for(Node nodo : nodes){
            System.out.println("Ciudad: " + nodo.getCity());
        }
    }
}