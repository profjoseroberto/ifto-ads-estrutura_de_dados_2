public class Node<E> {
    // Informação guardada na estrutura
    private E element;
    // Node pai
    private Node<E> parent;
    // Filho da esquerda
    private Node<E> left;
    // Filho da direita
    private Node<E> right;

    // construtor no primeiro caso - O nó é raiz
    public Node(E element) {
        this.element = element;
        this.parent = null;
        this.left = null;
        this.right = null;
    }
    // construtor no primeiro caso - O nó não é raiz
    public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
        this.element = element;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
    @Override
    public String toString() {
        return "Node [element=" + element + "]";
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getParent() {
        return parent;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

}