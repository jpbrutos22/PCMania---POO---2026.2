# João Paulo de Moura Brandão - GEC - 2288
Repositório para a atividade de Programação Orientada à Objetos em java - PCMANIA

# Uso de IA:

Tive algumas dificuldades em relação a getters, setters e arrays. Então, pedi para a IA me explicar melhor e como usar de maneira efetiva no codigo.
Além disso, tirei algumas dúvidas sobre recursos diferentes que conheci no IntelliJay.

# Prompt Inteiro Com o Claude AI:

# //Fala Claudão, estou fazendo uma atividade de Programação Orientada a Objetos em java, estou com duvida em getters e setters, tem como me ajudar? Preciso que explique de maneira simples e fácil como eles funcionam e como seriam uteis para uma programação. // 

E aí! Claro, bora destrinchar isso de um jeito simples.

O problema que eles resolvem
Em Java, você costuma deixar os atributos de uma classe como private. Isso significa que ninguém de fora da classe pode acessar ou alterar esses atributos diretamente. Isso é proposital — é o conceito de encapsulamento, um dos pilares da POO.

Só que aí surge um problema: se está tudo private, como outras partes do programa vão ler ou mudar esses valores? É aí que entram os getters e setters.

Como funcionam
Getter: um método que retorna o valor de um atributo (serve pra "pegar" o valor).
Setter: um método que define/altera o valor de um atributo (serve pra "definir" o valor).
Exemplo prático com uma classe Pessoa:

java
public class Pessoa {
    private String nome;
    private int idade;

    // Getter do nome
    public String getNome() {
        return nome;
    }

    // Setter do nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter da idade
    public int getIdade() {
        return idade;
    }

    // Setter da idade
    public void setIdade(int idade) {
        if (idade >= 0) {
            this.idade = idade;
        } else {
            System.out.println("Idade inválida!");
        }
    }
}

E usando isso em outra classe:

java
Pessoa p = new Pessoa();
p.setNome("Maria");   // define o nome
p.setIdade(25);       // define a idade

System.out.println(p.getNome());  // pega e mostra o nome
System.out.println(p.getIdade()); // pega e mostra a idade
Por que isso é útil?

Controle: repare no setIdade — dá pra validar o valor antes de aceitar (nesse caso, não deixa idade negativa). Se o atributo fosse público, qualquer código poderia colocar idade = -50 sem ninguém impedir.
Flexibilidade: se um dia você precisar mudar a lógica interna (por exemplo, guardar a idade calculada a partir da data de nascimento), você só mexe dentro do getter/setter. Quem usa a classe nem percebe a mudança, porque continua chamando getIdade() normalmente.
Segurança dos dados: você decide o que pode ser lido e o que pode ser alterado. Dá pra criar só o getter (sem setter) pra um atributo que não deve ser mudado depois de criado, por exemplo.
Boas práticas de mercado: é o padrão esperado em Java — frameworks, bibliotecas e outros programadores esperam que suas classes sigam esse padrão de getX() / setX().
Dica sobre o this
Repara que dentro do setter eu uso this.nome = nome;. O this serve pra diferenciar o atributo da classe (this.nome) do parâmetro do método (nome), que têm o mesmo nome.

Quer que eu monte um exercício pra você praticar, ou tem algum código específico da sua atividade que você quer que eu revise?

# O que significa "String toString"? é util?

Boa pergunta! Vamos por partes.

O que é toString()

Todo objeto em Java, por padrão, herda um método chamado toString() (ele vem lá da classe Object, que é a "mãe" de todas as classes). Esse método serve pra retornar uma representação em texto (String) do objeto.

Quando você faz isso:

java
Pessoa p = new Pessoa();
p.setNome("Maria");
p.setIdade(25);

System.out.println(p);

Java automaticamente chama o toString() do objeto por trás dos panos. Só que, se você não criou o seu próprio toString(), o padrão do Java vai imprimir algo tipo:

Pessoa@1b6d3586

Ou seja: o nome da classe + um código de hash (endereço meio aleatório em memória). Isso não serve pra nada útil na prática — não te diz o que tem dentro do objeto.

Por que sobrescrever (fazer o seu próprio)

Você pode sobrescrever (override) o toString() pra ele mostrar as informações que você quer:

java
public class Pessoa {
    private String nome;
    private int idade;

    // getters e setters aqui...

    @Override
    public String toString() {
        return "Pessoa{nome='" + nome + "', idade=" + idade + "}";
    }
}

Agora, se você fizer:

java
System.out.println(p);

Vai imprimir:

Pessoa{nome='Maria', idade=25}

Muito mais útil, né?

Por que isso é útil na prática
Debug: quando você está testando o código e quer ver rapidinho o que tem dentro de um objeto, um toString() bom economiza um monte de tempo (em vez de ficar fazendo System.out.println(p.getNome()), System.out.println(p.getIdade())... um por um).
Legibilidade: se você imprime uma lista de objetos (List<Pessoa>), cada item vai usar o toString() automaticamente pra se representar.
Concatenação de Strings: se você fizer String texto = "Cadastrei: " + p;, o Java também chama o toString() do objeto pra transformar ele em texto.
Convenção do Java: assim como getters e setters, é esperado que suas classes tenham um toString() decente — muitas IDEs (Eclipse, IntelliJ) até geram esse método automaticamente pra você, com um clique.
Resumindo a relação com o que vimos antes
Getters/setters → controlam o acesso a cada atributo individual.
toString() → junta tudo isso numa representação completa do objeto em forma de texto.

Quer que eu te mostre um exemplo completo juntando getters, setters e toString() numa classe só, pra você ver como tudo se encaixa?

# Me explica melhor em quais casos eu tenho que usar o @override.

Show, vamos entender isso direitinho.

O que é @Override
@Override é uma anotação (não é obrigatória tecnicamente, mas é fortemente recomendada) que você coloca em cima de um método pra avisar: "esse método está substituindo um método que já existe na superclasse (ou implementando um método de uma interface)".

java
@Override
public String toString() {
    return "Pessoa{nome='" + nome + "'}";
}
Quando você usa
Você usa @Override sempre que estiver reescrevendo um método que já existe em:

1. Uma superclasse (herança)
Toda classe em Java herda de Object, então métodos como toString(), equals() e hashCode() já existem por padrão. Quando você os reescreve, é override:

java
public class Animal {
    public void fazerSom() {
        System.out.println("Som genérico");
    }
}

public class Cachorro extends Animal {
    @Override
    public void fazerSom() {
        System.out.println("Au au!");
    }
}
2. Uma interface
Quando uma classe implementa uma interface, ela é obrigada a implementar os métodos declarados nela — e isso também é considerado override:

java
public interface Forma {
    double calcularArea();
}

public class Quadrado implements Forma {
    private double lado;

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}
Por que usar, já que não é obrigatório?
Essa é a parte mais importante: o compilador te ajuda a pegar erros.

Imagina que você quer sobrescrever o toString(), mas por engano escreve errado:

java
// Sem @Override
public String toSTring() {  // "S" maiúsculo por engano!
    return "Pessoa: " + nome;
}
Sem o @Override, o Java não vai reclamar de nada. Ele simplesmente vai achar que você criou um método novo chamado toSTring() — que nunca vai ser chamado automaticamente, e você vai ficar sem entender por que o System.out.println(p) não está mostrando o que você espera.

Agora, com @Override:

java
@Override
public String toSTring() {  // erro de digitação
    return "Pessoa: " + nome;
}
O compilador vai dar erro na hora, dizendo algo como "método não sobrescreve nenhum método da superclasse". Você descobre o problema imediatamente, em vez de ficar horas debugando.

Resumindo quando usar
Situação	Usa @Override?
Reescrevendo toString(), equals(), hashCode()	✅ Sim
Implementando método de uma interface	✅ Sim
Sobrescrevendo método de uma superclasse	✅ Sim
Criando um método novo, que não existe em lugar nenhum	❌ Não (nem faz sentido usar)
Sobrecarregando um método (overloading, com parâmetros diferentes)	❌ Não — isso é outra coisa, não é override
Um ponto que costuma confundir: overload não é override. Se você cria um método com o mesmo nome mas parâmetros diferentes, isso é sobrecarga (overload), e @Override não se aplica ali.

Faz sentido? Quer que eu monte um exercício rapidinho pra você testar se identifica quando é override e quando não é?

C06_EX1_PCMania.pdf
pdf

# Aqui está minha atividade, quero utilizar arrays com a classe computador, ja que serão 3. Porém estou com um pouco de dificuldade de entender, consegue me ajudar?

Montando um exemplo genérico de array de objetos para adaptar.
Beleza! Vou focar exatamente no que você perguntou: como usar arrays de objetos com a classe Computador, já que você vai ter as 3 promoções e o cliente pode comprar várias delas.

A ideia central
Um array de objetos funciona igual um array de int ou String, só que em vez de guardar valores "puros", ele guarda referências para objetos. Relembrando o básico:

java
Computador[] computadores = new Computador[3]; // array com espaço pra 3 Computadores
Nesse momento, todas as posições estão como null (vazias) — você ainda não criou nenhum objeto Computador, só reservou o espaço.

No seu caso específico, você provavelmente vai precisar de DOIS arrays diferentes
1º array: o "catálogo" das 3 promoções (dados fixos)
Como o enunciado diz que essas informações já são conhecidas (marca, preço, etc.), você pode montar esse array de forma estática, sem input do usuário:

java
Computador[] promocoes = new Computador[3];

promocoes[0] = new Computador("Apple", matricula);
promocoes[1] = new Computador("Samsung", matricula + 1);
promocoes[2] = new Computador("Dell", matricula + 2);

// aqui você também chamaria os métodos pra adicionar
// os HardwareBasico, SistemaOperacional e MemoriaUSB de cada um
Repare: promocoes[0] corresponde ao código 1 do enunciado, promocoes[1] ao código 2, e assim por diante. Ou seja, código do usuário = índice + 1.

2º array: os computadores que o cliente efetivamente comprou
Aqui é mais interessante, porque você não sabe de antemão quantos o cliente vai comprar (só sabe que não é mais que 3, já que só existem 3 promoções). Como vocês não podem usar ArrayList, a solução é: criar um array do tamanho máximo possível e usar uma variável contadora pra controlar quantas posições já foram preenchidas.

java
Computador[] comprados = new Computador[3]; // tamanho máximo = 3 promoções
int qtdComprados = 0; // contador de quantos já foram comprados

int codigo;
do {
    // aqui você lê o código digitado pelo usuário (Scanner)
    codigo = /* leitura do Scanner */;

    if (codigo >= 1 && codigo <= 3) {
        comprados[qtdComprados] = promocoes[codigo - 1]; // guarda a referência
        qtdComprados++; // avança o contador
    }

} while (codigo != 0);
Note o pulo do gato:

comprados[qtdComprados] = promocoes[codigo - 1] — não estamos criando um Computador novo, estamos só copiando a referência do computador da promoção escolhida pro array de comprados.
qtdComprados funciona como o "tamanho real usado" do array, já que comprados.length sempre vai ser 3, não importa quantos o cliente realmente comprou.
Por que isso importa na hora de percorrer o array depois
Quando for mostrar os computadores comprados ou calcular o total, você não pode usar comprados.length no loop, porque isso ia tentar acessar posições que ainda estão null (nunca preenchidas) e te dar um erro (NullPointerException). Você usa o contador:

java
for (int i = 0; i < qtdComprados; i++) {
    comprados[i].mostraPCConfigs();
}
Isso é diferente de:

java
for (int i = 0; i < comprados.length; i++) { // ERRADO se nem tudo foi preenchido
Resumindo o padrão
Situação	O que usar
Você sabe exatamente quantos elementos vai ter	Array com esse tamanho fixo
Você não sabe quantos, mas sabe o máximo possível	Array do tamanho máximo + contador auxiliar
Percorrer só o que foi preenchido	Loop usando o contador, não .length
