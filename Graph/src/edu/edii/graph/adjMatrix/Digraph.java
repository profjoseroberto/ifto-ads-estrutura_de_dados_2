package edu.edii.graph.adjMatrix;

public class Digraph<E> extends Graph<E>{

    public Digraph(int maxVertices) {
        super(maxVertices);
    }

    @Override
    public void insertEdge(int v1, int v2) throws ArrayIndexOutOfBoundsException {
        if (!isValidEdge(v1, v2)) {
            throw new ArrayIndexOutOfBoundsException("ERRO: Você tentou inserir um vértice inexistente!");
        }
        /* inserindo aresta com peso (weight) */
        this.matAdj[v1][v2] = 1;
    }

     // retirar arestas

     @Override
     public void deleteEdge(int v1, int v2) throws UnsupportedOperationException {
        if (this.matAdj[v1][v2] == 0) {
            throw new UnsupportedOperationException("Aresta (" + v1 + "," + v2 + ") não existe");
        } else {
            this.matAdj[v1][v2] = 0;
        }
    }
}
