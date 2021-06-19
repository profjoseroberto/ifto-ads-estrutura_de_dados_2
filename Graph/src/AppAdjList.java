import java.io.IOException;

import edu.edii.graph.adjList.Graph;
import edu.edii.graph.adjList.Vertice;

/**
 *
 * @author joseroberto
 */
public class AppAdjList {

    /**
     * @param args the command line arguments
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        Graph<String> g = new Graph<>();
        Vertice<String> a = g.insertVertice("Araguaína");
        Vertice<String> p = g.insertVertice("Palmas");
        Vertice<String> c = g.insertVertice("Colinas");
        g.insertEdge(a, p,384);
        g.insertEdge(a, c, 100);
        g.insertEdge(c, a, 100);
        g.insertEdge(p, c, 284);
        g.deleteEdge(0);
        g.deleteVertice(0);
        clear();   
        
        System.out.printf("##Vertices##\n");
        g.showVertices();
        System.out.printf("\n##Arestas##\n");
        g.showEdges();
        System.out.printf("\n##Lista de adjacência##\n");        
        System.out.println(g);
    }
    private static void clear() throws InterruptedException, IOException {
        System.out.println("Nome do SO: " + System.getProperty("os.name").contains("Windows"));
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            new ProcessBuilder("sh", "-c", "clear").inheritIO().start().waitFor();
    }
    
}
