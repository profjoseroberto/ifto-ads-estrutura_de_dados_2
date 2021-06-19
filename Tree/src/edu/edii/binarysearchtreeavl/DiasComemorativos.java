package edu.edii.binarysearchtreeavl;

import edu.edii.binarysearchtree.Node;

public class DiasComemorativos extends BinarySearchTreeAVL<Cliente> {

    public void diaDasMaes() {
        diaDasMaes(this.root);
    }

    private void diaDasMaes(Node<Cliente> v) {
        if (v.getElement().isMae()) {
            System.out.println(v.getElement());
        }
        if (hasLeft(v))
            diaDasMaes(v.getLeft());
        if (hasRight(v))
            diaDasMaes(v.getRight());
    }

    public void diaDaMulher() {
        diaDaMulher(this.root);
    }

    private void diaDaMulher(Node<Cliente> v) {
        if (v.getElement().getSexo() == 'F') {
            System.out.println(v.getElement());
        }
        if (hasLeft(v))
            diaDaMulher(v.getLeft());
        if (hasRight(v))
            diaDaMulher(v.getRight());
    }

    public void diaDosPais() {
        diaDosPais(this.root);
    }

    private void diaDosPais(Node<Cliente> v) {
        if (v.getElement().isPai()) {
            System.out.println(v.getElement());
        }
        if (hasLeft(v))
            diaDosPais(v.getLeft());
        if (hasRight(v))
            diaDosPais(v.getRight());
    }
}