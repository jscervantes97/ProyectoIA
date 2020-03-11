import java.util.ArrayList;
import java.util.List;

/**
 * @author raidentrance
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
}