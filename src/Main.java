import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import model.Player;
import tree.BinarySearchTree;
import ui.TreeVisualizer;
import util.CsvReader;
import util.MinhaFila;
import java.util.Scanner;

public class Main extends Application {
    private static BinarySearchTree tree = new BinarySearchTree();

    public static void main(String[] args) {
        MinhaFila<Player> fila = CsvReader.lerCsv("src/players.csv");
        while (!fila.vazia()) {
            tree.insert(fila.desenfileirar());
        }
        menuTerminal();
        launch(args);
    }

    private static void menuTerminal() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n1 - Inserir jogador");
            System.out.println("2 - Buscar jogador");
            System.out.println("3 - Remover jogador");
            System.out.println("0 - Abrir visualizacao");
            System.out.print("Opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Nickname: ");
                String nickname = scanner.nextLine();
                System.out.print("Ranking: ");
                int ranking = scanner.nextInt();
                scanner.nextLine();
                tree.insert(new Player(nickname, ranking));
                System.out.println("Jogador inserido!");

            } else if (opcao == 2) {
                System.out.print("Nickname: ");
                String nickname = scanner.nextLine();
                boolean encontrado = tree.search(nickname);
                if (encontrado) {
                    System.out.println("Jogador encontrado!");
                } else {
                    System.out.println("Jogador nao encontrado.");
                }

            } else if (opcao == 3) {
                System.out.print("Nickname: ");
                String nickname = scanner.nextLine();
                Player removido = tree.remove(nickname);
                if (removido != null) {
                    System.out.println("Removido: " + removido);
                } else {
                    System.out.println("Jogador nao encontrado.");
                }

            } else if (opcao != 0) {
                System.out.println("Opcao invalida.");
            }
        }
        scanner.close();
    }

    @Override
    public void start(Stage stage) {
        TreeVisualizer treeView = new TreeVisualizer();
        treeView.drawTree(tree.getRoot(), 600, 50, 350);

        ScrollPane scroll = new ScrollPane(treeView);
        scroll.setPannable(true);
        Scene scene = new Scene(scroll, 1200, 700);
        stage.setTitle("Ranking ABB");
        stage.setScene(scene);
        stage.show();
    }
}