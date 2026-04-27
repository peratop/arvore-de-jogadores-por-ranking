package tree;
import model.Node;
import model.Player;


public class BinarySearchTree {
    private Node root;

    public BinarySearchTree(){
        this.root = null;
    }

    public void insert(Player p){
        root = insert(root, p);
    }


    private Node insert(Node current, Player p){
        if (current ==null){
            return new Node(p);
        }

        if (p.getRanking() < current.player.getRanking()){
            current.left = insert(current.left, p);
        }
        else{
            current.right = insert(current.right, p);
        }

        return current;

    }

    public boolean search(String name){
        Node result = search(this.root, name);
        return result != null;
    }

    private Node search(Node current, String name){
        if (current == null){
            return null;

        }
        if (current.player.getNickname().equals(name)) {
            return current;
        }
        Node left = search(current.left, name);
        if (left != null){
            return left;
        }

        return search(current.right, name);

    }

    public Player remove(String name){
        Node found = search(root, name);
        if (found == null){
            return null;
        }
        Player jogador = new Player(found.player.getNickname(), found.player.getRanking());
        root = remove(root, found.player.getRanking());
        return jogador;
    }

    private Node remove (Node current, int ranking){
        if (current == null) {
            return null;
        }

        if (ranking < current.player.getRanking()){
            current.left = remove(current.left, ranking);

        }
        else if (ranking > current.player.getRanking()){
            current.right = remove(current.right, ranking);
        }
        else {
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;

            Node successor = findMinimum(current.right);
            current.player = successor.player;
            current.right = remove(current.right, successor.player.getRanking());
        }
        return current;

    }
    private Node findMinimum(Node current) {
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public Node getRoot() {
        return root;
    }

}
