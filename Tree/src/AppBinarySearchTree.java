import edu.edii.binarysearchtree.BinarySearchTree;

public class AppBinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree<String> bt = new BinarySearchTree<>();
        bt.put(50, "A");
        bt.put(40, "B");
        bt.put(30, "C");
        bt.put(45, "D");
        bt.put(60, "E");
        bt.remove(40);
        // bt.inorder();

        System.out.println(bt.get(10));

    }
}
