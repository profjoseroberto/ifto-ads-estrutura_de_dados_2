import java.util.ArrayList;

import edu.edii.treegeneric.*;

public class App {
    public static void main(String[] args) throws Exception {
       //Nó raiz
        Node<String> r = new Node<>("RAIZ");

        //Instanciamos a árvore e inserimos a raiz
        Tree<String> t = new Tree<>();

        // try {
        //     System.out.println(t.root());
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }

        t.addRoot(r);

        // try {
        //     System.out.println(t.root());
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }

        //Criando os filhos de r
        Node<String> f1_r = new Node<>("Filho 1 da Raiz", r);
        Node<String> f2_r = new Node<>("Filho 2 da Raiz", r);
        Node<String> f3_r = new Node<>("Filho 3 da Raiz", r);

        //vinculando uma pai ao seu filho
        t.addChildren(r, f1_r);
        t.addChildren(r, f2_r);
        t.addChildren(r, f3_r);

        Node<String> f1_f1 = new Node<>("Filho 1 do Filho 1", r);
        Node<String> f2_f1 = new Node<>("Filho 2 do Filho 1", r);
        Node<String> f1_f3 = new Node<>("Filho 1 do Filho 3", r);
        
        t.addChildren(f1_r, f1_f1);
        t.addChildren(f1_r, f2_f1);
        t.addChildren(f3_r, f1_f3);
        // r.getChildren().get(0);

        // System.out.println(t.root().getElement());
        // System.out.println("A árvore está vazia? " + t.isEmpty());
        // System.out.println("Se r é folha " + t.isExternal(r));
        // System.out.println("O filho 1 de R é folha?" + t.isExternal(f1_r));
        // System.out.println("Se filho 2 de R é nó interno?" + t.isInternal(f2_r));

        // System.out.println("Quem é o pai de filho 3 de R?" + t.parent(f3_r).getElement());

        // System.out.println("Filhos de R:");
        // t.getChildrenValues(r);    
        System.out.println("Pré:");
        t.preorder();
        System.out.println("Pós:");
        t.posorder();

        System.out.println("A profundidade do f1 do f1:" + t.depth(f1_f1));
        System.out.println("A altura do f1 do f1:" + t.height(r));
    }
}
