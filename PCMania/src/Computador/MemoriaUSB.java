package Computador;

public class MemoriaUSB {

    private String nome;
    private int capacidade;

    public MemoriaUSB(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return nome + " de " + capacidade + "Gb";
    }
}
