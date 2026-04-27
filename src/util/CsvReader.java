package util;

import model.Player;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {

    public static MinhaFila<Player> lerCsv(String caminho) {
        MinhaFila<Player> fila = new MinhaFila<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(caminho));
            br.readLine();
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                String nickname = partes[0].trim();
                int ranking = Integer.parseInt(partes[1].trim());
                fila.enfileirar(new Player(nickname, ranking));
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return fila;
    }
}