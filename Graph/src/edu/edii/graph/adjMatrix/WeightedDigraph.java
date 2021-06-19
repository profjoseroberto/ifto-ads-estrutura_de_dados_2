package edu.edii.graph.adjMatrix;

// Digrafo Ponderado 
public class WeightedDigraph<E> extends Digraph<E> {

    public WeightedDigraph(int maxVertices) {
        super(maxVertices);
    }

    public void insertEdge(int v1, int v2, int weight) throws ArrayIndexOutOfBoundsException {
        if (!isValidEdge(v1, v2)) {
            throw new ArrayIndexOutOfBoundsException("ERRO: Você tentou inserir um vértice inexistente!");
        }
        /* inserindo aresta com peso (weight) */
        this.matAdj[v1][v2] = weight;
    }
    
}
