package edu.edii.binarysearchtree;

public class BinarySearchTree<E> {
    // raiz da árvore
    protected Node<E> root;

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
    protected Node<E> addRoot(int k, E element) throws NonEmptyTreeException {
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
    protected Node<E> insertLeftNode(Node<E> n, int k, E v) throws InvalidNodeException {
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
    protected Node<E> insertRightNode(Node<E> n, int k, E v) throws InvalidNodeException {
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

    protected void preorder(Node<E> v) {
        // operação a ser realizada com o nodo
        System.out.println(v + " Pai:" + v.getParent() + " Esquerda:" + v.getLeft() + " Direita:" + v.getRight());
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

    protected void posorder(Node<E> v) {
        // percorre cada filho de um nodo
        if (hasLeft(v))
            posorder(v.getLeft());
        if (hasRight(v))
            posorder(v.getRight());
        // operação a ser realizada com o nodo
        System.out.println(v + " Pai:" + v.getParent() + " Esquerda:" + v.getLeft() + " Direita:" + v.getRight());

    }

    // inicializando o inorder
    public void inorder() {
        inorder(this.root);
    }

    protected void inorder(Node<E> v) {
        // percorre a subarvore esquerda
        if (hasLeft(v))
            inorder(v.getLeft());
        // operação a ser realizada com o nodo
        System.out.println(v + " Pai:" + v.getParent() + " Esquerda:" + v.getLeft() + " Direita:" + v.getRight());
        // percorre a subarvore direita
        if (hasRight(v))
            inorder(v.getRight());
    }

    // adicionar
    public void putNoRecursivo(int k, E v) {
        if (isEmpty())
            addRoot(k, v);
        else {
            Node<E> temp = this.root;
            boolean inseriu = false;
            while (inseriu == false) {
                // procurar a posição de inserção a esquerda
                if (k < temp.getKey()) {
                    // verificando se a posição de inserção foi encontrada
                    if (!hasLeft(temp)) {
                        insertLeftNode(temp, k, v);
                        inseriu = true;
                    } else {
                        temp = temp.getLeft();
                    }
                    // procurar a posição de inserção a direita
                } else {
                    if (!hasRight(temp)) {
                        insertRightNode(temp, k, v);
                        inseriu = true;
                    } else {
                        temp = temp.getRight();
                    }
                }
            }
        }
    }

    /* Adicionar recursivo */
    public void put(int key, E v) {
        //Chamando o método para adicionar o novo nó e atualizar a árvore com a nova configuração
        this.root = put(this.root, null, key, v);
    }

    protected Node<E> put(Node<E> n, Node<E> a, int k, E v) {
        /* Encontramos uma posição em que o novo nó possa ser inserido */
        if (n == null) {
            Node<E> t = new Node<>(k, v);
            t.setParent(a);
            return t;
        } else {
            // Verificamos se o valor é menor com o nó atual verificado
            if (k < n.getKey()) {
                // Chamamos de forma recursiva o método put passando o próximo nó a esquerda. As alterações devem refletir na subárvore a esquerda do nó atual
                n.setLeft(put(n.getLeft(), n, k, v));
            // Verificamos se o valor é menor com o nó atual verificado
            } else {
                // Chamamos de forma recursiva o método put passando o próximo nó a direita. As alterações devem refletir na subárvore a direita do nó atual
                n.setRight(put(n.getRight(), n, k, v));
            }
        }
        return n;
    }

    /**
     * ************* FIM DOS MÉTODOS DE ADICIONAR
     */

    // pesquisar
    public Node<E> get(int k){
        //retornar o valor encontrado
        return get(this.root, k);
    }

    protected Node<E> get(Node<E> n, int key){
        //Ponto de parada da busca, pois o elemento não foi encontrado
        if(n == null) return null;
        //Elemento foi encontrado foi encontrado e retornado
        else if(key == n.getKey()) return n;
        else{
        // if(n != null && key != n.getKey()){
            // executa o método get de forma recursiva passando o filho a esquerda do nó atualh, pois a chave passada é menor do que o nó atual
            if(key < n.getKey()) return get(n.getLeft(), key);
            // executa o método get de forma recursiva passando o filho a direita do nó atual, pois a chave passada é marior do que o nó atual
            else if(key > n.getKey()) return get(n.getRight(), key);
        }
        return n;
    }

    /* MÉTODO DE REMOVER */
    public void remove(int key) {
        //inicializa o método de remover pela raiz, que receberá as atualizações da árvore
        this.root = remove(this.root, key);
    }

    protected Node<E> remove(Node<E> n, int k) {
        /* BUSCANDO VALOR */
        if (n != null) {
            if (k < n.getKey()) {
                n.setLeft(remove(n.getLeft(), k));
            } else if (k > n.getKey()) {
                n.setRight(remove(n.getRight(), k));
            }
            /* ENCONTROU */
           //O nó a ser removido é folha. Então o seu pai vai receber uma atualização null para sua subárvore esquerda ou direita
            else if(isExternal(n)) return null;
            /* Não existe valor a esquerda */ /* compiamos a subarvore a direita para o lugar do pai */
            else if (n.getLeft() == null) {
                if(!isRoot(n)) n.getRight().setParent(n.getParent());
                n = n.getRight();
            }
            /* Não existe valor a direita */ /* compiamos a subarvore a esquerda para o lugar do pai */
            else if (n.getRight() == null) {
                if(!isRoot(n)) n.getLeft().setParent(n.getParent());
                n = n.getLeft();
            } /*
               * Buscamos a direita, o menor valor, que irá ocupar o lugar do nó a ser
               * removido
               */
            else {
                n.setRight(menorDir(n, n.getRight()));
            }
        }
        return n;
    }

    protected Node<E> menorDir(Node<E> aRemover, Node<E> menor) {
        /*
         * Saberemos que encontramos o elemento de menor chave, quando o próximo nó a
         * esquerda for nulo
         */
        if (menor.getLeft() == null) {
            /*
             * O valor do elemento de menor valor da subárvore a direita é copiado para o nó
             * a ser removido
             */
            aRemover.setElement(menor.getElement());
            aRemover.setKey(menor.getKey());
            if(hasRight(menor)) menor.getRight().setParent(menor.getParent());
            /*
             * retornamos a subárvore direita do menor valor para que ela possa ocupar o
             * lugar do nó de menor valor
             */
            return menor.getRight();
            /*
             * Se o valor de menor valor não foi encontrado, contiamos a buscar a esquerda
             * da subárvore a direita
             */
        } else {
            /*
             * Se o valor for encontrado no próximo passo, a subárvore a direita do menor
             * valor ocupará o seu lugar
             */
            menor.setLeft(menorDir(aRemover, menor.getLeft()));
        }

        return menor;
    }
    /**
     * ************** FIM DO MÉTODO DE REMOVER
     */
}
