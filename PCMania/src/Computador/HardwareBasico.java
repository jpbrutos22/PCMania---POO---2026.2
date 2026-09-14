package Computador;

public class HardwareBasico {

    private String nome;
    private float capacidade;

    public HardwareBasico(String nome, float capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return nome + ": " + capacidade;
    }
}
