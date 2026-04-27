package ui;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import model.Node;

public class TreeVisualizer extends Pane {

    private static final int RADIUS = 30;
    private static final int VERTICAL_GAP = 80;

    public void drawTree(Node root, double x, double y, double offset) {
        if (root == null) return;

        if (root.left != null) {
            Line line = new Line(x, y, x - offset, y + VERTICAL_GAP);
            line.setStroke(Color.BLACK);
            getChildren().add(line);
            drawTree(root.left, x - offset, y + VERTICAL_GAP, offset / 2);
        }

        if (root.right != null) {
            Line line = new Line(x, y, x + offset, y + VERTICAL_GAP);
            line.setStroke(Color.BLACK);
            getChildren().add(line);
            drawTree(root.right, x + offset, y + VERTICAL_GAP, offset / 2);
        }

        Circle circle = new Circle(x, y, RADIUS, Color.DARKGREEN);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(2);

        String nome = root.player.getNickname();
        Text text = new Text(nome);
        text.setFill(Color.WHITE);
        text.setStyle("-fx-font-size: 10px;");
        text.setX(x - text.getLayoutBounds().getWidth() / 2);
        text.setY(y + 4);

        getChildren().addAll(circle, text);
    }
}