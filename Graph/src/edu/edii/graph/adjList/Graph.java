package edu.edii.graph.adjList;

import java.util.ArrayList;

/**
 *
 * @author joseroberto
 */
public class Graph<T> {

    private ArrayList<Vertice<T>> vertices;
    private ArrayList<Edge<T>> edges;

    public Graph() {
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public Vertice<T> insertVertice(T e) {
        Vertice<T> v = new Vertice<>(e);
        // adicionando o vertice criado na lista de vertices do grafo
        this.vertices.add(v);
        return v;
    }

    public void deleteVertice(int index) {
        Vertice<T> v = vertices.get(index);
        /* Excluindo as arestas da lista de incidência do vértice a ser removido */
        for (Edge<T> edge : v.getIncidentList()) {
            edges.remove(edge);
        }

        /* Percorrrer todos os vértices */
        for (Vertice<T> vertice : vertices) {
            for (Edge<T> edge : vertice.getIncidentList()) {
                if (edge.getD().equals(v)) {
                    vertice.removeIncidentList(edge);
                }
            }
        }

        vertices.remove(v);
    }

    public Edge<T> insertEdge(Vertice<T> o, Vertice<T> d, int weight) {
        /* Criando a Aresta */
        Edge<T> e = new Edge<>(d, weight);
        o.addInIncidentList(e);
        this.edges.add(e);
        return e;
    }

    public void deleteEdge(int index) {
        /*Recupero a aresta a ser removida*/
        Edge<T> er = edges.get(index);
        
        for (Vertice<T> vertice : vertices) {
            for (Edge<T> edge : vertice.getIncidentList()) {
                if (edge.equals(er)) {
                    vertice.removeIncidentList(edge);
                }
            }
        }
        edges.remove(er);
    }

    public void showEdges() {
        for (Vertice<T> v : vertices) {
            for (Edge<T> edge : v.getIncidentList()) {
                System.out.format("%d - (%s, %s) \n", edges.indexOf(edge), v.getElement(), edge.getD().getElement());
            }
        }
    }

    public void showVertices() {
        for (Vertice<T> v : this.vertices) {
            System.out.format("%d - %s \n", vertices.indexOf(v), v.getElement());
        }
    }

    public String toString() {
        String r = "";
        for (Vertice<T> v : vertices) {
            r += v.getElement() + " -> ";
            for (Edge<T> a : v.getIncidentList()) {
                v = a.getD();
                r += v.getElement() + ", ";
            }
            r += "\n";
        }
        return r;
    }

}
