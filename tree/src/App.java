import java.io.IOException;
import java.util.*;

public class App {
    public static void clear() throws IOException, InterruptedException {
        new ProcessBuilder("clear").inheritIO().start().waitFor();
    }

public static void main(String[] args) throws IOException, InterruptedException {  
    clear();

    ArrayList<Integer> lista = new ArrayList<>();
    lista.add(10);
    lista.add(20);
    lista.add(30);

    System.out.println(lista.size());
    }
}
