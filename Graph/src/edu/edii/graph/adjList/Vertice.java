package edu.edii.graph.adjList;

import java.util.LinkedList;

/**
 *
 * @author joseroberto
 */
public class Vertice<E> {

    private E element;
    /* Lista de arestas que incidem do Vertice*/
    private LinkedList<Edge<E>> incidentList;

    public Vertice(E element) {
        this.element = element;
        this.incidentList = new LinkedList<Edge<E>>();
    }

    public void addInIncidentList(Edge<E> e) {
        incidentList.addLast(e);
    }

    public void removeIncidentList(Edge<E> e){
        incidentList.remove(e);
    }

    public LinkedList<Edge<E>> getIncidentList() {
        return incidentList;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

}
