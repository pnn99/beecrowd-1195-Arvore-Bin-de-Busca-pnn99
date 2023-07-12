import java.util.Scanner;

public class Main {
    class Node {
        private int chave;
        Node leftNode;
        Node rightNode;

        public Node(int chave) {
            this.chave = chave;
            this.leftNode = null;
            this.rightNode = null;
        }

        public int getChave() {
            return chave;
        }

        public void setChave(int chave) {
            this.chave = chave;
        }
    }

    class Tree {
        Node raiz;

        public Tree() {
            raiz = null;
        }

        public void add(int valor) {
            raiz = insert(raiz, valor);
        }

        private Node insert(Node node, int valor) {
            if (node == null)
                return new Node(valor);

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
                infixo(node.leftNode);
                System.out.print(node.getChave() + " ");
                infixo(node.rightNode);
            }
        }

        private void posfixo(Node node) {
            if (node != null) {
                posfixo(node.leftNode);
                posfixo(node.rightNode);
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

        public void clear() {
            raiz = null;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int casos = scanner.nextInt();

        Main main = new Main();
        Tree tree = main.new Tree();

        // Laço para processar os casos testes
        for (int i = 1; i <= casos; i++) {
            int size = scanner.nextInt();
            int[] num = new int[size];

            // Leitura dos Casos testes
            for (int j = 0; j < size; j++) {
                num[j] = scanner.nextInt();
            }

            // Construção da arvore com os inputs
            for (int k = 0; k < size; k++) {
                tree.add(num[k]);
            }

            // Print dos Resultados
            System.out.println("Case " + i + ":");
            tree.printPrefixo();
            tree.printInfixo();
            tree.printPosfixo();
            System.out.println();

            tree.clear();
        }

        scanner.close();
    }
}
