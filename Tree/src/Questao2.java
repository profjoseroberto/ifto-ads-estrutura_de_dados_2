import edu.edii.binarysearchtreeavl.*;

public class Questao2 {
    public static void main(String[] args) {
        DiasComemorativos c = new DiasComemorativos();

        c.put(1, new Cliente("Bianca", 'F', true, false));
        c.put(2, new Cliente("Mariana", 'F', false, false));
        c.put(3, new Cliente("Breno", 'M', false, true));
        c.put(4, new Cliente("Pedro", 'M', false, false));
        c.put(5, new Cliente("Nayana", 'F', true, false));

        System.out.println("Clientes para o dia das Mães");
        c.diaDasMaes();
        System.out.println();

        System.out.println("Clientes para o dia da Mulher");
        c.diaDaMulher();
        System.out.println();

        System.out.println("Clientes para o dia dos Pais");
        c.diaDosPais();
        System.out.println();
    }
}
