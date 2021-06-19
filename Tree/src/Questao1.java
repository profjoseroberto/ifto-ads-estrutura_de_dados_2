import edu.edii.binarysearchtree.BinarySearchTree;
import edu.edii.binarysearchtreeavl.BinarySearchTreeAVL;

class Questao1 {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bt = new BinarySearchTree<>();
        BinarySearchTreeAVL<Integer> avl = new BinarySearchTreeAVL<>();
        
        long inicio = System.currentTimeMillis();
        for (int i = 10000; i > 0; i--) {
            bt.put(i, i);
        }
        System.out.println("Tempo inserção BT: " + (System.currentTimeMillis() - inicio));

        inicio = System.currentTimeMillis();
        for (int i = 10000; i > 0; i--) {
            avl.put(i, i);
        }
        System.out.println("Tempo inserção AVL: " + (System.currentTimeMillis() - inicio));

        inicio = System.currentTimeMillis();
        System.out.println(bt.get(1));
        System.out.println("Tempo PESQUISA BT: " + (System.currentTimeMillis() - inicio));

        inicio = System.currentTimeMillis();
        System.out.println(avl.get(1));
        System.out.println("Tempo PESQUISA AVL: " + (System.currentTimeMillis() - inicio));
    }
}