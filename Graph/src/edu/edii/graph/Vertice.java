package edu.edii.graph;

public class Vertice<E> {
    private E element;
    public Vertice(E element) {
        this.element = element;
    }
    public E getElement() {
        return this.element;
    }
    public void setElement(E element) {
        this.element = element;
    }
    @Override
    public String toString() {
        return (String) element;
    }   

    
}
