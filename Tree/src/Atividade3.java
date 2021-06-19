import edu.edii.binarysearchtree.BinarySearchTree;
import edu.edii.binarysearchtreeavl.BinarySearchTreeAVL;

class Atividade3{
    public static void main(String[] args) {
        BinarySearchTree<String> b = new BinarySearchTree<>();
        b.put(54, "54");
        b.put(48, "48");
        b.put(66, "66");
        b.put(58, "58");
        b.put(70, "70");
        b.put(67, "67");

        b.posorder();

    }
}