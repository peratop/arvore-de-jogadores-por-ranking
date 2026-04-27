package util;

class Nodo<T> {
    T dado;
    Nodo<T> proximo;

    public Nodo(T dado) {
        this.dado = dado;
    }
}