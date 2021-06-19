package edu.edii.treegeneric;

import java.util.ArrayList;

public class Tree<E> {
    private Node<E> root;

    public Tree() {
        this.root = null;
    }

   public Tree(Node<E> root) {
        this.root = root;
   }

    // verifica se um nó é interno (nó que possui filhos)
    public boolean isInternal(Node<E> n){
        return !n.getChildren().isEmpty();
    }

    //verifica se um nó é externo ou folha (nó que não possui filhos) 
    public boolean isExternal(Node<E> n){
        return n.getChildren().isEmpty();
    }

    // verifica se um nó é raiz.
    public boolean isRoot(Node<E> n){
        return n.getParent() == null;
    }

    //verifica se a árvore está vazia.
    public boolean isEmpty(){
        return this.root == null;
    }
    
    /* Retorna a raiz da árvore; um erro ocorre se a árvore está vazia. (EmptyTreeException)*/
    public Node<E> root(){
        if(isEmpty()) throw new EmptyTreeException("Árvora vazia!");
        return this.root;
    }

    /*parent(v): Retorna o nodo pai de v; ocorre um erro se v for raiz. (BoundaryViolationException)*/
    public Node<E> parent(Node<E> n){
        if(isRoot(n)) throw new BoundaryViolationException("O nó é raiz");
        return n.getParent();
    }


    /*children(v): Retorna uma coleção iterável contendo os filhos do nodo v.
    */
   public ArrayList<Node<E>> children(Node<E> n){
       return n.getChildren();
   }
}
