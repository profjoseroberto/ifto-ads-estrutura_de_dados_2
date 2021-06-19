package edu.edii.graph.adjList;

/**
 *
 * @author joseroberto
 */
public class Edge<T> {

    // private Vertice<T> v1;
    private Vertice<T> d;
    private int weight;

    public Edge(Vertice<T> d, int weight) {
        // this.v1 = o;
        this.d = d;
        this.weight = weight;
    }

    // public Vertice<T> getV1() {
    //     return v1;
    // }

    // public void setV1(Vertice<T> v1) {
    //     this.v1 = v1;
    // }

    public Vertice<T> getD() {
        return d;
    }

    public void setD(Vertice<T> d) {
        this.d = d;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(, " + d.getElement() + ") -> weight=" + weight;
    }

}
