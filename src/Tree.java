public class Tree {
    Node raiz;

    public Tree() {
        raiz = null;
    }

    public void add(int valor) {
        raiz = insert(raiz, valor);
    }

    private Node insert(Node node, int valor) {
        if (node == null)
            return new Node(valor, node, node);

        if (valor < node.getChave()) {
            node.leftNode = insert(node.leftNode, valor);
        } else if (valor > node.getChave()) {
            node.rightNode = insert(node.rightNode, valor);
        }

        return node;
    }

    private void prefixo(Node node) {
        if (node != null) {
            System.out.print(node.getChave() + " ");
            prefixo(node.leftNode);
            prefixo(node.rightNode);
        }
    }

    private void infixo(Node node) {
        if (node != null) {
            prefixo(node.leftNode);
            System.out.print(node.getChave() + " ");
            prefixo(node.rightNode);
        }
    }

    private void posfixo(Node node) {
        if (node != null) {
            prefixo(node.leftNode);
            prefixo(node.rightNode);
            System.out.print(node.getChave() + " ");
        }

    }

    public void printPrefixo() {
        System.out.print("Pre.: ");
        prefixo(raiz);
        System.out.println();
    }

    public void printInfixo() {
        System.out.print("In.: ");
        infixo(raiz);
        System.out.println();
    }

    public void printPosfixo() {
        System.out.print("Post.: ");
        posfixo(raiz);
        System.out.println();
    }
}
