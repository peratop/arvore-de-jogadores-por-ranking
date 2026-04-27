package util;

public class MinhaFila<T> {
    private Nodo<T> inicio;
    private Nodo<T> fim;

    public void enfileirar(T dado) {
        Nodo<T> novoNodo = new Nodo<>(dado);
        if (vazia()) {
            inicio = novoNodo;
        } else {
            fim.proximo = novoNodo;
        }
        fim = novoNodo;
    }

    public T desenfileirar() {
        if (vazia()) return null;
        T dado = inicio.dado;
        inicio = inicio.proximo;
        if (inicio == null) fim = null;
        return dado;
    }

    public boolean vazia() {
        return inicio == null;
    }
}