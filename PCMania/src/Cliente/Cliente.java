package Cliente;


import Computador.Computador;

public class Cliente {

    private String nome;
    private String cpf;

    private Computador[] compras;
    private int qtdCompras;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.compras = new Computador[2];
        this.qtdCompras = 0;
    }

    public void addComputador(Computador computador) {
        if (qtdCompras == compras.length) {
            Computador[] novoArray = new Computador[compras.length * 2];
            for (int i = 0; i < compras.length; i++) {
                novoArray[i] = compras[i];
            }
            compras = novoArray;
        }
        compras[qtdCompras] = computador;
        qtdCompras++;
    }

    public float calculaTotalCompra() {
        float total = 0f;
        for (int i = 0; i < qtdCompras; i++) {
            total += compras[i].getPreco();
        }
        return total;
    }

    public void mostraCompras() {
        for (int i = 0; i < qtdCompras; i++) {
            compras[i].mostraPCConfigs();
        }
    }
    
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getQtdCompras() {
        return qtdCompras;
    }

    public Computador[] getComputadoresComprados() {
        Computador[] resultado = new Computador[qtdCompras];
        for (int i = 0; i < qtdCompras; i++) {
            resultado[i] = compras[i];
        }
        return resultado;
    }
}
