import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Node {
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
    }

    static class Tree {
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
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input =  new BufferedReader(new InputStreamReader(System.in));
        int casos = Integer.parseInt(input.readLine());

        // Laço para processar os casos de teste
        for (int i = 1; i <= casos; i++) {
            int size = Integer.parseInt(input.readLine());

            // Verificar tamanho da árvore
            if (size < 1 || size > 500) {
                throw new IllegalArgumentException("Tamanho inválido para a árvore.");
            }

            // Ler valores da árvore
            String[] values = input.readLine().split(" ");

            // Verificar quantidade de valores fornecidos
            if (values.length != size) {
                throw new IllegalArgumentException("Quantidade inválida de valores para a árvore.");
            }

            int[] num = new int[size];

            // Leitura dos valores e verificação se são não negativos
            for (int j = 0; j < size; j++) {
                num[j] = Integer.parseInt(values[j]);
                if (num[j] < 0) {
                    throw new IllegalArgumentException("Valor inválido para a árvore.");
                }
            }

            Tree tree = new Tree();
            // Construção da árvore com os valores
            for (int k = 0; k < size; k++) {
                tree.add(num[k]);
            }

            // Print dos Resultados
            System.out.println("Case " + i + ":");
            tree.printPrefixo();
            tree.printInfixo();
            tree.printPosfixo();
            System.out.println();

        }

        input.close();
    }
}
