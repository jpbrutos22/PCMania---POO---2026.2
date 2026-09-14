package Computador;

public class Computador {

    private String marca;
    private float preco;

    private HardwareBasico[] hardwares;
    private SistemaOperacional sistemaOperacional;
    private MemoriaUSB memoriaUSB;

    public Computador(String marca, float preco, HardwareBasico[] hardwares, SistemaOperacional sistemaOperacional) {
        this.marca = marca;
        this.preco = preco;
        this.hardwares = hardwares;
        this.sistemaOperacional = sistemaOperacional;
        this.memoriaUSB = null;
    }

    public void addMemoriaUSB(MemoriaUSB musb) {
        this.memoriaUSB = musb;
    }

    public float getPreco() {
        return preco;
    }

    public void mostraPCConfigs() {
        System.out.println("Marca: " + marca);
        System.out.println("Preço: R$" + preco);

        for (HardwareBasico hb : hardwares) {
            System.out.println(hb);
        }

        System.out.println(sistemaOperacional);

        if (memoriaUSB != null) {
            System.out.println("Acompanha: " + memoriaUSB);
        }
    }
}
