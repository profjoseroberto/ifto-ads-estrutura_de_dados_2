package edu.edii.binarysearchtree;


public class BinarySearchTree<E> {
    // raiz da árvore
    private Node<E> root;

    public BinarySearchTree() {
        this.root = null;
    }

    // hasLeft(n): verifica se existe filho a esquerda.
    public boolean hasLeft(Node<E> n) {
        return n.getLeft() != null;
    }

    // hasRight(n): verifica se existe filho a direita.
    public boolean hasRight(Node<E> n) {
        return n.getRight() != null;
    }

    // isInternal(n): verifica se um nó é interno.
    public boolean isInternal(Node<E> n) {
        return hasLeft(n) || hasRight(n);
    }

    // isExternal(n): verifica se um nó é externo ou folha.
    public boolean isExternal(Node<E> n) {
        return !hasLeft(n) && !hasRight(n);
    }

    // isRoot(n): verifica se um nó é raiz.
    public boolean isRoot(Node<E> n) {
        return n == this.root;
    }

    // isEmpty(n): verifica se a árvore está vazia.
    public boolean isEmpty() {
        return this.root == null;
    }

    // left(n): retorna o filho da esquerda, ocorre uma condição de erro
    // (InvalidNodeException) se n não tiver filho a esquerda.
    public Node<E> left(Node<E> n) throws InvalidNodeException {
        if (!hasLeft(n))
            throw new InvalidNodeException("Não existe filho a esquerta!");
        return n.getLeft();
    }

    // right(n): retorna o filha da direita, ocorre uma condição de erro
    // (InvalidNodeException) se n não tiver filho a direita.
    public Node<E> right(Node<E> n) throws InvalidNodeException {
        if (!hasRight(n))
            throw new InvalidNodeException("Não existe filho a direita!");
        return n.getRight();
    }

    // addRoot(e): cria e retorna um nó novo, que armazena o elemento e torna-o raiz
    // da árvore; um erro ocorre se a árvore não estiver vazia.
    private Node<E> addRoot(int k, E element) throws NonEmptyTreeException {
        if (!isEmpty())
            throw new NonEmptyTreeException("A árvore já possui raiz!");
        this.root = new Node<E>(k, element);
        return this.root;
    }

    // parent(n): retorna o nodo pai de n; ocorre um erro se n for
    // raiz.(BoundaryViolationException).
    public Node<E> parent(Node<E> n) throws BoundaryViolationException {
        if (isRoot(n))
            throw new BoundaryViolationException("Não possui pai!");
        return n.getParent();
    }

    // root(): retorna a raiz da árvore; um erro ocorre se a árvore está
    // vazia.(EmptyTreeException)
    public Node<E> root() throws EmptyTreeExcepiton {
        if (isEmpty())
            throw new EmptyTreeExcepiton("A árvore está vazia!");
        return this.root();
    }

    // insertLeft(n, v): cria e retorna um nodo novo que armazena o valor v,
    // acrescenta o novo nodo como filho a esquerda de n. um condição de erro ocorre
    // caso n já tenha filho a esquerda (InvalidNodeException)
    private Node<E> insertLeftNode(Node<E> n, int k, E v) throws InvalidNodeException {
        if (hasLeft(n))
            throw new InvalidNodeException("Já existe nó a esquerda!");
        Node<E> novo = new Node<>(k, v);
        n.setLeft(novo);
        novo.setParent(n);
        return novo;
    }

    // insertRight(n, v): cria e retorna um nodo novo que armazena o valor v,
    // acrescenta o novo nodo como filho a direita de n. um condição de erro ocorre
    // caso n já tenha filho a direita
    private Node<E> insertRightNode(Node<E> n, int k, E v) throws InvalidNodeException {
        if (hasRight(n))
            throw new InvalidNodeException("Já existe nó a direita!");
        Node<E> novo = new Node<>(k, v);
        n.setRight(novo);
        novo.setParent(n);
        return novo;
    }

    // CAMINHAMENTO

    // inicializando o preorder
    public void preorder() {
        preorder(this.root);
    }

    private void preorder(Node<E> v) {
        // operação a ser realizada com o nodo
        System.out.println(v);
        // percorre cada filho de um nodo
        if (hasLeft(v))
            preorder(v.getLeft());
        if (hasRight(v))
            preorder(v.getRight());
    }

    // inicializando o preorder
    public void posorder() {
        posorder(this.root);
    }

    private void posorder(Node<E> v) {
        // percorre cada filho de um nodo
        if (hasLeft(v))
            posorder(v.getLeft());
        if (hasRight(v))
            posorder(v.getRight());
        // operação a ser realizada com o nodo
        System.out.println(v);

    }

    // inicializando o inorder
    public void inorder() {
        inorder(this.root);
    }

    private void inorder(Node<E> v) {
        // percorre a subarvore esquerda
        if (hasLeft(v))
            inorder(v.getLeft());
        // operação a ser realizada com o nodo
        System.out.println(v);
        // percorre a subarvore direita
        if (hasRight(v))
            inorder(v.getRight());
    }

    // adicionar
    public void put(int k, E v){
       if(isEmpty()) addRoot(k, v);
       else{
           Node<E> temp = this.root;
           boolean inseriu = false;
           while(inseriu == false){
                //procurar a posição de inserção a esquerda
                if(k < temp.getKey()){
                    //verificando se a posição de inserção foi encontrada
                    if(!hasLeft(temp)){
                        insertLeftNode(temp, k, v);
                        inseriu = true;
                    }else{
                        temp = temp.getLeft();  
                    }
               //procurar a posição de inserção a direita
               }else{
                   if(!hasRight(temp)){
                       insertRightNode(temp, k, v);
                       inseriu = true;
                   }else{
                    temp = temp.getRight();
                   }
               }
           }
       }
    }
    // pesquisar
    // remove

}
