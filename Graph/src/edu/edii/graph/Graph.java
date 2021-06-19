package edu.edii.graph;

import java.util.ArrayList;

public class Graph<E> {
    /* Matriz de adjacência */
    private int matAdj[][];
    /* Nº máximo de vertices que a matriz pode receber */
    private int MAX_VERTICES;
    /*
     * Propriedade que determina o número de vertices inseridos,vai limitar o espaço
     * de busca
     */
    private int numVertice;
    /* Conjunto de vértices */
    private ArrayList<Vertice<E>> vertices;

    public Graph(int maxVertices) {
        this.MAX_VERTICES = maxVertices;
        this.numVertice = 0;
        this.vertices = new ArrayList<>();
        this.matAdj = new int[MAX_VERTICES][MAX_VERTICES];
        /* O valor 0 representa que não há adjacência entre dois vértices */
        /*
         * Preenchendo todos os campos com 0, já que a matriz ainda não tem adjacências
         */
        for (int i = 0; i < this.MAX_VERTICES; i++) {
            for (int j = 0; j < this.MAX_VERTICES; j++) {
                this.matAdj[i][j] = 0;
            }
        }
    }

    public boolean isEmpty() {
        return this.numVertice == 0;
    }

    public int insertVertice(E e) throws UnsupportedOperationException {
        /*
         * Verificando se o número de inserções de vértices já chegou ao limite da
         * matriz
         */
        if (numVertice == MAX_VERTICES) {
            throw new UnsupportedOperationException("Não é possível mais inserir vértices");
        }
        Vertice<E> v = new Vertice<>(e);
        vertices.add(v);
        numVertice++;
        return vertices.indexOf(v);
    }

    public void insertEdge(int v1, int v2, int weight) throws ArrayIndexOutOfBoundsException {
        if (v1 >= numVertice || v2 >= numVertice) {
            throw new ArrayIndexOutOfBoundsException("ERRO: Você tentou inserir um vértice inexistente!");
        }
        /* inserindo aresta com peso (weight) */
        this.matAdj[v1][v2] = weight;
        /*Para dígrafo não inclua essa linha*/
        this.matAdj[v2][v1] = weight;
    }

    public void show() {
        System.out.format("%12s", "|");
        for (int i = 0; i < this.numVertice; i++) {
            System.out.format("%-10s |", this.vertices.get(i).getElement());
        }
        System.out.println();
        for (int i = 0; i < this.numVertice; i++) {
            System.out.format("%-10s |", this.vertices.get(i).getElement());
            for (int j = 0; j < this.numVertice; j++) {
                System.out.format("%-10s |", this.matAdj[i][j]);
            }
            System.out.println();
        }
    }

    public boolean hasEdge(int v1, int v2) {
        return (this.matAdj[v1][v2] > 0);
    }

    public int numVertice() {
        return this.numVertice;
    }

    public ArrayList<Vertice<E>> vertices() {
        return vertices;
    }

    // retirar arestas
    public void deleteEdge(int v1, int v2) {
        if (this.matAdj[v1][v2] == 0) {
            throw new UnsupportedOperationException("Aresta (" + v1 + "," + v2 + ") não existe");
        } else {
            this.matAdj[v1][v2] = 0;
        }
    }

}
