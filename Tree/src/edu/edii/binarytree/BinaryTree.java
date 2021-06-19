

public class BinaryTree<E> {
    //raiz da árvore
    private Node<E> root;

    public BinaryTree(){
        this.root = null;
    }

    // hasLeft(n): verifica se existe filho a esquerda.
    public boolean hasLeft(Node<E> n){
        return n.getLeft() != null;
    }
    // hasRight(n): verifica se existe filho a direita.
    public boolean hasRight(Node<E> n){
        return n.getRight() != null;
    }
    // isInternal(n): verifica se um nó é interno.
    public boolean isInternal(Node<E> n){
        return hasLeft(n) || hasRight(n);
    }
    // isExternal(n): verifica se um nó é externo ou folha.
    public boolean isExternal(Node<E> n){
        return !hasLeft(n) && !hasRight(n);
    }
    // isRoot(n): verifica se um nó é raiz.
    public boolean isRoot(Node<E> n){
        return n == this.root;
    }

    // isEmpty(n): verifica se a árvore está vazia.
    public boolean isEmpty(){
        return this.root == null;
    }

    // left(n): retorna o filho da esquerda, ocorre uma condição de erro (InvalidNodeException) se n não tiver filho a esquerda.
    public Node<E> left(Node<E> n) throws InvalidNodeException{
        if(!hasLeft(n)) throw new InvalidNodeException("Não existe filho a esquerta!");
        return n.getLeft();
    }

    // right(n): retorna o filha da direita, ocorre uma condição de erro (InvalidNodeException) se n não tiver filho a direita.
    public Node<E> right(Node<E> n) throws InvalidNodeException{
        if(!hasRight(n)) throw new InvalidNodeException("Não existe filho a direita!");
        return n.getRight();
    }

    // addRoot(e): cria e retorna um nó novo, que armazena o elemento e torna-o raiz da árvore; um erro ocorre se a árvore não estiver vazia.
    public Node<E> addRoot(E element) throws NonEmptyTreeException{
        if(!isEmpty()) throw new NonEmptyTreeException("A árvore já possui raiz!");
        this.root = new Node<E>(element);
        return this.root;
   }

    // parent(n): retorna o nodo pai de n; ocorre um erro se n for raiz.(BoundaryViolationException).
    public Node<E> parent(Node<E> n) throws BoundaryViolationException{
        if(isRoot(n)) throw new BoundaryViolationException("Não possui pai!");
        return n.getParent();
    }

    // root(): retorna a raiz da árvore; um erro ocorre se a árvore está vazia.(EmptyTreeException)
    public Node<E> root() throws EmptyTreeExcepiton{
        if(isEmpty()) throw new EmptyTreeExcepiton("A árvore está vazia!");
        return this.root();
    }

    //insertLeft(n, v): cria e retorna um nodo novo que armazena o valor v, acrescenta o novo nodo como filho a esquerda de n. um condição de erro ocorre caso n já tenha filho a esquerda (InvalidNodeException)
    public Node<E> insertLeftNode(Node<E> n, E v) throws InvalidNodeException{
        if(hasLeft(n)) throw new InvalidNodeException("Já existe nó a esquerda!");
        Node<E> novo = new Node<>(v);
        n.setLeft(novo);
        novo.setParent(n);
        return novo;
    }

     //insertRight(n, v): cria e retorna um nodo novo que armazena o valor v, acrescenta o novo nodo como filho a direita de n. um condição de erro ocorre caso n já tenha filho a direita
     public Node<E> insertRightNode(Node<E> n, E v) throws InvalidNodeException{
        if(hasRight(n)) throw new InvalidNodeException("Já existe nó a direita!");
        Node<E> novo = new Node<>(v);
        n.setRight(novo);
        novo.setParent(n);
        return novo;
    }

     //attach(n, t1, t2): conecta t1 e t2, respectivamente, como nodos a esquerda e a direita de n; uma condição de erro ocorre caso n não seja nodo folha
    public void attach(Node<E> n, Node<E> left, Node<E> right) throws NonExternalException{
        if(!isExternal(n)) throw new NonExternalException("Não é nó folha!");
        //vinculei a esquerda
        n.setLeft(left);
        left.setParent(n);
        //viculei a direita
        n.setRight(right);
        right.setParent(n);
    }

}
