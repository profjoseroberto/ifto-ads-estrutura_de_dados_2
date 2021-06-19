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

   //adicionar nodo raiz
   public boolean addRoot(Node<E> n){
        if(isEmpty()){
            this.root = n;
            return true;
        } 
        return false;
   }

   //adicionar um filho em pai
   public void addChildren(Node<E> p, Node<E> child){
        p.getChildren().add(child);
        child.setParent(p);
   }

   //imprimir os filhos de um nodo
   public void getChildrenValues(Node<E> t) {
    for(Node<E> n : t.getChildren()){
        System.out.println(n.getElement());   
        }
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

   //CAMINHAMENTO

   //inicializando o preorder
   public void preorder(){
       preorder(this.root);
   } 

    private void preorder(Node<E> v){
        //operação a ser realizada com o nodo
        System.out.println(v);
        System.out.print("_");
        //percorre cada filho de um nodo
	    for(Node<E> w : v.getChildren()){
            //chamando recursivamente o método preorder passando o filho como argumento
            preorder(w);
        }
    }

     //inicializando o preorder
    public void posorder(){
        posorder(this.root);
    } 

    private void posorder(Node<E> v){
        //percorre cada filho de um nodo
	    for(Node<E> w : v.getChildren()){
            //chamando recursivamente o método preorder passando o filho como argumento
            posorder(w);
        }
        //operação a ser realizada com o nodo
        System.out.println(v);
        
    }

    //PROFUNDIDADE
    public int depth(Node<E> v){
        if(v.getParent() == null) return 0;
        return depth(v.getParent()) + 1;
    }

    //ALTURA
    public int height(Node<E> n){
        if(isExternal(n)) return 0;
        int h = 0;
        for(Node<E> x : n.getChildren()){
            h = Math.max(h, height(x));
        }
        return h + 1;
    }

}
