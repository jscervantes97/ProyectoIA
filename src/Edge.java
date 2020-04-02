public class Edge implements Comparable<Edge> {
    private Node origin;
    private Node destination;
    private Double distance;
    private Integer distancia ;
    public Edge(Node origin, Node destination, double distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        distancia = (int) distance ;
    }

    public Node getOrigin() {
        return origin;
    }

    public void setOrigin(Node origin) {
        this.origin = origin;
    }

    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Vertice [origin=" + origin.getCity() + ", destination=" + destination.getCity() + ", distance=" + distance
                + "]";
    }

    public String obtenerDistancias(){
        return "Destino " + destination.getCity() + " Distancia " + distance;
    }

    @Override
    public int compareTo(Edge edge) {
       return Integer.compare(distancia, edge.distancia);
    }
}