package edu.edii.graph.adjMatrix;

import java.util.ArrayList;

/* Grafo não direcionado e não ponderado */

public class Graph<E> {
    /* Matriz de adjacência */
    protected int matAdj[][];
    /* Nº máximo de vertices que a matriz pode receber */
    protected int MAX_VERTICES;
    /*
     * Propriedade que determina o número de vertices inseridos,vai limitar o espaço
     * de busca
     */
    protected int numVertice;

    /* Conjunto de vértices */
    protected ArrayList<Vertice<E>> vertices;

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

    // Verificar se o grafo está vazio
    public boolean isEmpty() {
        return this.numVertice == 0;
    }

    // Inserir vertice
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

    // Inserir aresta
    public void insertEdge(int v1, int v2) throws ArrayIndexOutOfBoundsException {
        if (!isValidEdge(v1, v2)) {
            throw new ArrayIndexOutOfBoundsException("ERRO: Você tentou inserir um vértice inexistente!");
        }
        /* inserindo aresta com peso (weight) */
        this.matAdj[v1][v2] = 1;
        /* Para dígrafo não inclua essa linha */
        this.matAdj[v2][v1] = 1;
    }

    // Verificar se a aresta é válida
    protected boolean isValidEdge(int v1, int v2) {
        return (v1 < numVertice && v1 >= 0 && v2 < numVertice && v2 >= 0);
    }

    // Apresentar a matriz de adjacência
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

    // Verificar se tem aresta
    public boolean hasEdge(int v1, int v2) {
        return (this.matAdj[v1][v2] > 0);
    }

    // Retornar número de vertices
    public int numVertice() {
        return this.numVertice;
    }

    // Retornar os vértices
    public ArrayList<Vertice<E>> vertices() {
        return vertices;
    }

    // retirar arestas
    public void deleteEdge(int v1, int v2) throws UnsupportedOperationException {
        if (this.matAdj[v1][v2] == 0) {
            throw new UnsupportedOperationException("Aresta (" + v1 + "," + v2 + ") não existe");
        } else {
            this.matAdj[v1][v2] = 0;
            this.matAdj[v2][v1] = 0;
        }
    }

    // Retirar vertice
    public void deleteVertice(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= numVertice)
            throw new ArrayIndexOutOfBoundsException("ERRO: Você indicou um índice inexistente");
        else {
            for (int i = 0; i < numVertice; i++) {
                for (int j = 0; j < numVertice; j++) {
                    if (i == index || j == index)
                        matAdj[i][j] = 0;
                }
            }
            vertices.remove(index);
            numVertice--;
        }
    }

}
