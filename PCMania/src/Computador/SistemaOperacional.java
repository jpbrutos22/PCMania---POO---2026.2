package Computador;

public class SistemaOperacional {

    private String nome;
    private int tipo; // arquitetura em bits (Ex: 64)

    public SistemaOperacional(String nome, int tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Sistema Operacional: " + nome + " (" + tipo + " bits)";
    }
}
