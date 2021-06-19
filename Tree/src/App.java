import java.util.ArrayList;

import edu.edii.treegeneric.*;

public class App {
    public static void main(String[] args) throws Exception {
       //Nó raiz
        Node<String> r = new Node<>("RAIZ");

        //Instanciamos a árvore e inserimos a raiz
        Tree<String> t = new Tree<>(r);

        //Criando os filhos de r
        Node<String> f1_r = new Node<>("Filho 1 da Raiz", r);
        Node<String> f2_r = new Node<>("Filho 2 da Raiz", r);
        Node<String> f3_r = new Node<>("Filho 3 da Raiz", r);

        //Criando a arrayList para guardar os filhosDeR
        ArrayList<Node<String>> filhosDeR = new ArrayList<>();
        //Adicionando os filhosDeR ao arrayList
        filhosDeR.add(f1_r);
        filhosDeR.add(f2_r);
        filhosDeR.add(f3_r);

        //filhosDeR.add(new Node<>("Filho 1 da Raiz", r));


        //passando a arrayList com os filhos de filhosDeR
        r.setChildren(filhosDeR);
        // r.getChildren().get(0);

        System.out.println(t.root().getElement());
        System.out.println("A árvore está vazia? " + t.isEmpty());
        System.out.println("Se r é folha " + t.isExternal(r));
        System.out.println("O filho 1 de R é folha?" + t.isExternal(f1_r));
        System.out.println("Se filho 2 de R é nó interno?" + t.isInternal(f2_r));

        System.out.println("Quem é o pai de filho 3 de R?" + t.parent(f3_r).getElement());

        System.out.println("Filhos de R:");
        for(Node<String> n : t.children(r)){
            System.out.println(n.getElement());
        }
    }
}
