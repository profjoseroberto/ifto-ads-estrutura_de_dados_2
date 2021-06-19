package edu.edii.treegeneric;

import java.util.ArrayList;

public class Node<E>{
    private E element;
    private Node<E> parent;
    private ArrayList<Node<E>> children;

    //construtor no primeiro caso - O nó é raiz
    public Node(E element){
        this.element = element;
        this.parent = null;
        this.children = new ArrayList<>();
    }

     //construtor no primeiro caso - O nó não é raiz
     public Node(E element, Node<E> parent){
        this.element = element;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getParent() {
        return parent;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    public ArrayList<Node<E>> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node<E>> children) {
        this.children = children;
    }

    
}