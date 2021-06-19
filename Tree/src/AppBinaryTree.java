public class AppBinaryTree {
    public static void main(String[] args) {
        BinaryTree<String> t = new BinaryTree<>();
        Node<String> a = t.addRoot("A");
        Node<String> b = t.insertLeftNode(a, "B");
        Node<String> c = t.insertRightNode(a, "C");
        t.insertLeftNode(b, "D");
        t.insertRightNode(b, "E");
        t.insertLeftNode(c, "F");
        t.insertRightNode(c, "G");

        System.out.println("Caminhmento em pré-ordem:");
        t.preorder();
        System.out.println("Caminhmento em pós-ordem:");
        t.posorder();
        System.out.println("Caminhmento em em-ordem:");
        t.inorder();
    }
}
