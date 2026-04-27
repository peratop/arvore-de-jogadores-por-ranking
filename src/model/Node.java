package model;

public class Node {
    public Player player;
    public Node left;
    public Node right;

    public Node(Player player){
        this.player = player;
        this.left = null;
        this.right = null;
    }
}

