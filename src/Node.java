public class Node {
    private int chave;
    Node leftNode;
    Node rightNode;

    public Node(int chave, Node leftNode, Node rigNode) {
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
