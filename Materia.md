# SOLID com java: principios da programação orientada a objetos
iniciado em 13/04/2022

terminado em 18/04/2022

[certificate](https://cursos.alura.com.br/certificate/c0b507a8-8ee9-427b-85e1-78f4ab69d73b) 

- - [SOLID com java: principios da programação orientada a objetos](#solid-com-java-principios-da-programação-orientada-a-objetos)
  - [SOLID](#solid)
  - [Principios da orientação a objetos](#principios-da-orientação-a-objetos)
    - [coesão](#coesão)
      - [Classes coesas](#classes-coesas)
    - [Encapsulamento](#encapsulamento)
      - [protegendo o codigo](#protegendo-o-codigo)
    - [acoplamento](#acoplamento)
      - [dependencias no codigo](#dependencias-no-codigo)
  - [o que aprendemos?](#o-que-aprendemos)
  - [melhorando a coesão](#melhorando-a-coesão)
    - [extraindo a logica de reajuste salarial](#extraindo-a-logica-de-reajuste-salarial)
      - [ValidacaoException](#validacaoexception)
      - [Cargo](#cargo)
      - [Funcionario](#funcionario)
      - [ReajusteService](#reajusteservice)
      - [Classe Funcionario](#classe-funcionario)
      - [Classe ReajusteService](#classe-reajusteservice)
    - [Single Responsibility Principle](#single-responsibility-principle)
      - [Definiçao de SRP](#definiçao-de-srp)
    - [o que aprendemos?](#o-que-aprendemos-1)
  - [Reduzindo o acoplamento](#reduzindo-o-acoplamento)
    - [extraindo validaçoes](#extraindo-validaçoes)
      - [ValidacaoPercentualReajuste](#validacaopercentualreajuste)
      - [ValidacaoPeriodicidadeEntreReajustes](#validacaoperiodicidadeentrereajustes)
      - [ValidacaoReajuste](#validacaoreajuste)
      - [ReajusteService](#reajusteservice-1)
      - [ValidacaoReajuste](#validacaoreajuste-1)
      - [ReajusteService](#reajusteservice-2)
      - [ValidacaoPercentualReajuste](#validacaopercentualreajuste-1)
      - [ValidaçaoPeriodicidadeEntreReajustes](#validaçaoperiodicidadeentrereajustes)
      - [muitas validaçoes](#muitas-validaçoes)
    - [Open Closed Principle](#open-closed-principle)
      - [garantindo que o sistema seja extensivel](#garantindo-que-o-sistema-seja-extensivel)
    - [o que aprendemos?](#o-que-aprendemos-2)
  - [Herança indesejada](#herança-indesejada)
    - [implementando uma nova regra de negocio](#implementando-uma-nova-regra-de-negocio)
      - [PromocaoService](#promocaoservice)
      - [Cargo](#cargo-1)
      - [PromocaoService](#promocaoservice-1)
      - [Funcionario](#funcionario-1)
    - [utilizando herança da maneira ERRADA](#utilizando-herança-da-maneira-errada)
      - [Composiçao ao inves de herança](#composiçao-ao-inves-de-herança)
      - [DadosPessoais](#dadospessoais)
      - [Funcionario](#funcionario-2)
      - [Terceirizados](#terceirizados)
      - [Herança](#herança)
    - [Liskov Substituition Principle](#liskov-substituition-principle)
      - [alternativa a herança](#alternativa-a-herança)
    - [o que aprendemos?](#o-que-aprendemos-3)
  - [trabalahando com abstraçoes](#trabalahando-com-abstraçoes)
    - [criando abstraçoes com interfaces e poliformismo](#criando-abstraçoes-com-interfaces-e-poliformismo)
    - [Dependency Inversion Principle](#dependency-inversion-principle)
      - [vantagem ao criar dependencias com interfaces](#vantagem-ao-criar-dependencias-com-interfaces)
    - [Interface Segregation Principle](#interface-segregation-principle)
      - [Reajuste](#reajuste)
      - [ReajusteTributavel](#reajustetributavel)
      - [Anuenio](#anuenio)
      - [Promocao](#promocao)
      - [Definicao do ISP](#definicao-do-isp)
    - [o que aprendemos?](#o-que-aprendemos-4)


## SOLID
Nesse treinamento a proposta é aprendermos essa sigla SOLID, o que significa isso, quais são esses princípios e cada um dos 5 princípios do SOLID e ver como que podemos utilizar isso na prática em um projeto.

Vamos aprender sobre o **princípio da responsabilidade única**, o **princípio aberto e fechado** e o **princípio da substituição de Liskov** e o **princípio da segregação de interface** e o **princípio da inversão de dependências**. 

```diff
+ Então cada um desses princípios formam o SOLID que são princípios focados em boas práticas de programação e de orientação a objetos.
```

São extremamente importantes se você trabalha com uma linguagem orientada a objetos como o Java para você escrever um código que é fácil de manter e principalmente fácil de estender, de adicionar novas características, novos comportamentos, novas funcionalidades com um menor impacto possível. 

Não é muito comum termos projetos que conforme o tempo vai passando mais e mais funcionalidades vão sendo desenvolvidas, começa a ficar difícil de dar manutenção.

Você mexe em uma classe e ela quebra, outras 3, 5, 10 classes e você tem que ficar fazendo esse remendo, procurando onde que vai gerar impacto, procurando toda a mudança em quais classes que eu vou ter que mexer. 

```diff
+ Então esses princípios visam justamente simplificar esse processo de manutenção no seu código.
```

Então aqui vamos ter um projeto que é um projeto bem simples, que é um projeto de um RH onde eu tenho lá os meus funcionários e eu preciso ter algumas funcionalidades como de conceder reajustes salariais, fazer promoção para o profissional subir de cargo. 

E essas funcionalidades vamos implementar e vamos ver alguns problemas no código e ver como podemos aplicar cada um daqueles princípios do SOLID para deixar o código muito mais simples e muito mais fácil de manter e de evoluir.

Então essa é a proposta do curso: podermos utilizar esses princípios em uma aplicação Java para deixar o código mais fácil de manter e de estender. 

Vamos ver como podemos aplicar esses princípios para deixar esse código um pouco mais fácil de manter e que você possa utilizá-los nos seus projetos pessoais e profissionais.

## Principios da orientação a objetos

### coesão
Antes de falar sobre SOLID em si, eu queria fazer algumas discussões com vocês sobre alguns conceitos, alguns pilares importantes da orientação a objetos. 

São pilares que vamos tratar aqui durante o curso de SOLID e aí vamos ter um alinhamento melhor sobre as coisas que vamos discutir durante esse treinamento.

São três princípios que são mega importantes na orientação a objetos quando trabalhamos com uma linguagem orientada a objetos, Java, PHP, Python ou qualquer outra linguagem orientada a objetos. 

```diff
+ É o princípio da coesão, do encapsulamento e do acoplamento. 
```

Então conforme você estudou nos treinamentos de orientação a objetos, já deve estar familiarizado com esses termos.

Mas aqui eu quero fazer uma discussão só para alinharmos um pouco sobre esses conceitos e justamente no caso do SOLID, os princípios do SOLID estão diretamente ligados com esses princípios da orientação a objetos. 

Então quando aplicamos aqueles princípios do SOLID, vamos acabar aplicando também esses princípios da orientação a objetos, favorecendo uma melhor orientação a objetos no nosso código. 

O primeiro deles que eu quero discutir nesse vídeo com vocês é justamente sobre a coesão.

Coesão se formos parar para pesquisar, ler no dicionário o que é coesão provavelmente você vai chegar nesse significado ou algo do gênero, que é "União harmônica entre uma coisa e outra". 

Então coesão é justamente isso, quando você tem uma harmonia entre elementos. 

E aí aqui eu estou pensando de uma maneira genérica. 

Eu peguei do dicionário essa definição, não estou levando para área de software e nem em coisa do gênero. 

Mas se formos levar para software, o que seria essa harmonia?

No caso nós estamos pensando em uma classe. 

Vamos pensar que na orientação a objetos nós modelamos as coisas importantes do domínio da nossa aplicação com classes. 

Então, a união harmônica seria as coisas que tem dentro de uma classe. 

```diff
+ Os atributos e os métodos devem estar em harmonia, devem estar unidos e devem representar coisas em comum. 
```

Então aqui eu trouxe um exemplo de uma classe que vamos ter no nosso projeto, a classe "Funcionario".

Aqui seria um exemplo bom de uma classe que tem harmonia, uma classe que está coesa. 

```
public class Funcionario {

	private String nome;
	private String cpf;
	private Cargo cargo;
	private BigDecimal salario;

  public boolean isGerente() {
    return Cargo.GERENTE == this.cargo;
  }
  ...
```

Então percebe, é uma classe chamada "Funcionario" é a única coisa que tem ali dentro são atributos e métodos que representam o que é um funcionário no sistema.

Então eu tenho lá um atributo "nome", "CPF", "cargo", "salario" e tenho um método para dizer se um determinado "Funcionario" é um gerente. 

Então ele usa o "cargo" do "Funcionario", o atributo "cargo" para saber se é gerente ou não. 

Percebe, isso é um exemplo de uma classe coesa.

As coisas que tem dentro dessa classe estão em harmonia, estão tratando da mesma coisa, que no caso é da representação de um funcionário. 

Então não tenho coisas muito diferentes de funcionário dentro dessa classe, não que iria prejudicar a coesão. 

Aqui por outro lado eu fiz uma pequena modificação nessa classe "Funcionario". 

```diff
- E aí aqui já temos um exemplo de uma classe não coesa.
```

```
public class Funcionario {

	private String nome;
	private String cpf;
	private Cargo cargo;
	private BigDecimal salario;
  private String cep;
  private String logradouro;
  private String bairro;

  public boolean isGerente() {
    return Cargo.GERENTE == this.cargo;
  }

  public void formatarCPF() {
    // logica para formataçao do CPF
  }
  ...
```

Aqui a diferença é que na classe "Funcionario" eu tenho alguns outros atributos e são atributos referentes ao endereço do funcionário. 

Então eu tenho o "CEP", o "logradouro", "bairro", "cidade", "uf", enfim. 

Percebe que a classe começou a crescer e ficar muito grande, ficar com muitos atributos. 

Talvez isso seja um indício de que essa classe não está coesa. 

Aqui no caso, será que não seria melhor eu jogar todos esses atributos para uma classe "Endereco"?

Já que aqui eu não estou mais falando do "Funcionario", eu estou falando do "endereco". 

Óbvio, o funcionário tem o endereço, mas está muito detalhado, tem todos os atributos, todas as informações do endereço dentro, soltas na classe "Funcionario". 

Talvez fosse o seu caso de extrair isso para uma classe externa e deixar isso escondido dentro da classe "Endereco". 

E aí aqui também tem alguns métodos que talvez já estejam fugindo um pouco do objetivo da classe "Funcionario".

Então eu tenho um método para formatar um "CPF". 

Será que essa parte de "formatarCpf", ok, faz parte do funcionário, todo funcionário tem o CPF. 

Mas será que a formatação visual desse CPF deveria estar dentro da classe "Funcionario"? 

Será que não deveria ter uma outra classe que cuida só de formatação? 

E aí eu posso ter algumas variações da formatação com o ponto, sem os pontos, enfim. 

A mesma coisa, o outro método de formatar CEP. 

E o último que talvez seja o pior, "completarEndereco".

Eu coloquei um comentário aqui para não detalhar muito essa questão da lógica do código, mas aqui seria a ideia de consultar um WebService dos Correios para passar o CEP e recuperar os dados endereço, o logradouro, o bairro, enfim. 

Aqui seria um outro exemplo, será que a responsabilidade da classe "Funcionário" de fazer uma consulta, um serviço externo, buscar, fazer essa chamada a uma API externa, fazer um tratamento ou coisas do gênero. 

Então talvez aí já estava fugindo aquela harmonia, já perdeu a harmonia.

A classe está fazendo coisas demais. 

```diff
+ Então a classe deveria ter uma única responsabilidade. 
```

Isso é o que tem a ver com a coesão, você ter classes que fazem apenas uma única coisa, que é algo que vamos discutir bastante quando formos detalhar os princípios do SOLID. 

Então a ideia da coesão é justamente essa. 

Deixei essa frase aqui de resumo. 

```diff
+ "Classes não coesas tendem a crescer indefinidamente, o que as tornam difíceis de manter". 
```

Então provavelmente você já deve ter se esbarrado com isso em algum projeto.

Você pegou aquela classe que tinha 1000, 2000, 3000 linhas de código, tinha dezenas, centenas de atributos e de métodos e é bem provável que essa classe não é coesa porque ela deve estar fazendo coisas demais. 

Então acaba se tornando aquela classe muito maçante, muito difícil de dar manutenção. 

Qualquer coisa você tem que alterar essa classe e ela está fazendo coisas demais.

Você acabe se perdendo ali no meio, você pode ser código duplicado, enfim. 

A manutenção fica prejudicada quando temos classes não coesas. 

Então esse era um dos pilares da orientação a objetos que eu queria discutir com vocês nesse vídeo.

E ele vai ser bastante importante quando formos trabalhar e for entender e detalhar mais sobre os princípios do SOLID. 

#### Classes coesas
aprendemos sobre o conceito de coesão na programação orientada a objetos.

Qual a melhor definição de uma classe coesa?

R: Uma classe que executa bem a sua única tarefa, de forma concisa.

 Cada classe deve ser responsável por apenas uma coisa, e deve executar esta tarefa muito bem

### Encapsulamento
Agora vamos falar sobre o segundo princípio da nossa lista que é o encapsulamento.

Provavelmente você já se esbarrou com esse termo, já está familiarizado com esse termo e talvez você tenha uma visão errada e até incompleta sobre encapsulamento porque esse é um princípio que confunde um pouco.

Então vamos discutir sobre esse princípio aqui. 

O encapsulamento, se você for pesquisar na internet ou no dicionário ou algo do gênero, você vai ver que encapsulamento significa o ato de você incluir e inserir algo em uma cápsula, você proteger alguma coisa independente do que seja essa coisa. 

E a ideia é justamente essa, você blindar. 

Então eu gosto de pensar dessa maneira no encapsulamento.

Agora trazendo para o nosso contexto de desenvolvimento de software e orientação a objetos. 

```diff
+ O encapsulamento nada mais é do que você proteger, blindar uma classe contra influências externas, contra manipulações externas que podem prejudicar a consistência das informações. 
```

Então isso que tem a ver com encapsulamento. 

E no geral temos uma visão errada do encapsulamento.

```diff
- No geral aprendemos ou entendemos errado que encapsulamento é só pegar aquela classe, 

- colocar os atributos como o "private", coloca lá o modificador "private" para deixar como privado e colocar os métodos 

- "getters" e "setters" para fazer acesso a esses atributos de fora da classe. 

- Só que na verdade isso não é que esteja errado, mas está incompleto. 

- Não é só isso, o encapsulamento.
```

Encapsulamento tem outras questões importantes. 

E às vezes o fato de você simplesmente colocar "private" e colocar o geral, os métodos "getters" e "setters" pode ser que você esteja ferindo o encapsulamento, que você esteja criando lá um buraco digamos assim lá naquela cápsula que deveria proteger aquela classe. 

Então vamos ao exemplo de código. 

Aqui de novo a mesma classe "Funcionario". 

Aqui eu tenho um exemplo de como que seria a aplicação do conceito de encapsulamento.

No caso a classe "Funcionario" tem um atributo importante que é o salário.

Inclusive, só para fins didáticos eu coloquei o salário aqui com double, mas no mundo real você colocaria como o big decimal. 

Aqui é só para facilitar. 

E a ideia é justamente essa. 

O salário é um atributo importante, ele tem validações, ele tem regras de negócio. 

Eu não posso alterar o salário de qualquer maneira, existem validações.

```
public class Funcionario {

    private String nome;
    private String cpf;
    private Cargo cargo;

// double apenas para fins didáticos
    private double salario;

    public void reajustarSalario(double aumento) {
        double percentualReajuste = (aumento / salario) * 100;

        if (percentualReajuste > 40) {
            throw new IllegalArgumentException(
                "percentual de reajuste deve ser inferior a 40%";
        }

        this.salario += aumento;
    }
}
```

Então para proteger, para encapsular o atributo "salario", foi criado esse método chamado "reajustar salário". 

Ele recebe o valor do aumento e faz uma validação. 

Aqui no exemplo que eu coloquei nesse código, o reajuste não pode ser maior do que 40% do salário. 

Então eu preciso fazer essa validação.

Toda vez que o método "reajustar salário" é chamado, a primeira coisa que é feita aqui no código é pegar o valor do aumento, comparar com o salário atual e ver qual é o percentual de aumento que está sendo concedido para esse funcionário e ele não pode ser maior do que 40%. 

O funcionário não pode receber mais que 40% de aumento, seria essa a regra. 

E aqui dentro desse método tem essa validação.

Se bateu nesse "if", se foi maior do que 40%, ele joga uma exception. 

Se não, se foi menor do que 40%, aí ele faz o incremento do salário do funcionário com o valor do aumento. 

```Diff
+ Aqui tem um exemplo, um exemplo bom e positivo de encapsulamento. 
```

Eu estou encapsulando o salário que é um atributo da classe "Funcionario". 

A classe "Funcionario" está encapsulada.

Os atributos, quer dizer, pelo menos o atributo "salario" está protegido contra manipulações externas que possam violar essa regra de negócio, possam mexer diretamente no salário sem fazer essas validações. 

E vamos a um exemplo ruim que seria um exemplo clássico de você somente chegar na classe e colocar os atributos como "private" e gerar os métodos "getters" e "setters".

encapsulamento errado:
```
public class Funcionario {
  private String nome;
  private String cpf;
  private Cargo cargo;

  //double apenas para fins didaticos
  private double salario;

  public void setSalario(double salario) {
    this.salario = salario;
  }
}

Funcionario novo = carregarDoBancoDeDados();
novo.setSalario(100000);
```

Aqui estaria um exemplo de violação no encapsulamento. 

Então a classe não estaria encapsulada, por mais que ela tenha os atributos privados. 

```diff
- O método "set" seria o problema, o método "setSalario". 
```
Aqui seria esse exemplo. Eu não tenho mais aquele método "reajustar salário". 

Um exemplo que eu coloquei, finge que eu carreguei um funcionário lá do banco de dados, eu posso simplesmente pegar esse objeto "Funcionario" e chamar o método "setSalario" e passar um valor qualquer, por exemplo, 100 mil reais.

Não tem nenhuma validação, nenhuma regra sendo feita aqui, a não ser que essa regra esteja dentro do método "setter", mas no geral é aquele método "setter" tradicional que nem é você que digita. A IDE é que gera para você o método "getter" e "setter". 

Aqui seria um exemplo de violação do encapsulamento. 

Perceba que eu estou podendo acessar e manipular diretamente o atributo "salario".

Por mais que ele esteja privado, o método "setter" me permite isso. 

Permite que eu mexa diretamente no atributo e com isso eu consigo burlar regras de negócio. 

Eu não estou realizando aquela validação dos 40% de reajuste, eu estou fazendo reajuste de um valor indefinido. 

Percebe, é um exemplo ruim do encapsulamento. 

E esse tipo de coisa é o que tentamos evitar.

E os princípios do SOLID também vão favorecer com essa questão do encapsulamento. 

E aqui o resumo é do encapsulamento. 

```diff
+ Quando temos classes não encapsuladas, isso faz com que tenhamos violações da regra de negócio do projeto. 
```
Podemos ter classes com estados inválidos, com atributos, com valores que não deveriam ter e isso faz com que a classe tenha um aumento no seu acoplamento.

E é um outro que vamos discutir. 

#### protegendo o codigo
Começamos a entender agora que encapsulamento é uma forma de manter os objetos das nossas classes protegidos, fornecendo apenas o que é estritamente necessário para o mundo exterior.

Quais das seguintes alternativas estão corretas?

R:
* Getters e setters por si só não fornecem nenhum tipo de encapsulamento.

O fato de criar getters e setters para tudo, na verdade, quebra o encapsulamento da nossa classe.

* Encapsulamento ajuda no uso correto dos objetos.

Ao encapsular o acesso a determinados dados, liberando acesso apenas ao necessário, os objetos da nossa classe se tornam mais fáceis de serem utilizados.

### acoplamento
Agora vamos falar sobre o último princípio importante da orientação a objetos que eu quero tratar com vocês antes de começarmos a discutir sobre o SOLID, que é o princípio do acoplamento que também é algo importante que gera problemas no nosso código quando não é bem tratado, esse princípio.

Então, acoplamento, a definição é a ação de você acoplar, você fazer um agrupamento aos pares. 

É meio esquisito, muito abstrato isso, mas vamos trazer para o nosso contexto de desenvolvimento de software e orientação a objetos. 

A ideia de você acoplar é quando você tem dois componentes que estão interligados entre si causando uma dependência entre eles. 

Então, por exemplo, quando eu tenho uma classe que faz a utilização de uma outra classe. Uma classe A que chama uma classe B.

O fato da classe A estar utilizando a classe B, isso já gera um acoplamento. 

```diff
+ Só que não necessariamente o acoplamento é algo ruim. 
```

O problema é quando temos um acoplamento muito forte. 

```diff
+ Então não dá para você não ter acoplamento. 
```

Seguindo a orientação a objetos, a ideia é que tenhamos várias classes no nosso projeto. 

E não tem como, uma classe vai ter que conversar com a outra.

```diff
- O problema é quando essa conversa, digamos assim, fica muito íntima. 
```

A classe está conhecendo detalhes demais da outra classe e isso causa uma dependência muito forte e qualquer mudança que você faça na classe B provavelmente vai gerar um impacto na classe A e todas as outras classes que fazem a utilização dessa classe B. 

Aí está o problema. Você cria uma dependência muito forte.

Vamos a um exemplo em código. 

Aquele de novo, aquela nossa classe "Funcionario". 

```
Funcionario funcionario = carregaDadosDoBancoDeDados();
double reajustes = funcionario.getValorTotalRecebidoEmReajustes();
```

```diff
+ Aqui eu teria um exemplo positivo, um exemplo bom onde eu não tenho um acoplamento muito forte. 
```

Então eu tenho aqui, eu estou carregando um funcionário do banco de dados e eu preciso saber o quanto que ele já recebeu de reajustes. 

Fazer o somatório dos reajustes que ele já recebeu.

E aí um exemplo bom, um exemplo que eu mantenho o acoplamento mais baixo possível seria eu pegar esse objeto "Funcionario" e chamar um método que aqui eu chamei de "getValorTotalRecebidoEmReajustes". 

Então dessa outra classe eu não sei qual é a lógica utilizada para fazer o cálculo do total de reajustes. 

Eu não sei se ele fez um "for", se tem uma lista de reajustes, não sei como que foi feito. 

A única coisa que eu preciso é saber o valor dos reajustes.

Então eu chamo esse método, ele faz essa lógica para mim e eu recebo um double que seria o valor total dos reajustes. 

Então se eu mudar futuramente a lógica de calcular os reajustes, aqui eu não vou sofrer impacto nenhum porque eu não sei qual é a regra de pegar lá e calcular o valor total em reajustes. 

Então é um código que está bem encapsulado, por sinal. 

Lembra que eu tinha citado que o encapsulamento influencia no acoplamento.

```diff
- Então geralmente a falta de encapsulamento leva a um acoplamento maior. 
```

Aqui, eu estou com um código encapsulado. 

A consequência é que eu acabo tendo um acoplamento menor. 

E o exemplo ruim seria um exemplo de você fazer isso na mão de fora da classe. 

exemplo ruim de acoplamento:
```
Funcionario funcionario = carregaDoBancoDeDados();

double valorTotalReajustes = 0;
List<Reajuste> reajustes = funcionario.getReajustes();
for (Reajuste r : reajustes) {
  valorTotalReajustes += r.getValor();
}
```

Aqui seria o caso onde eu não tenho aquele método que faz o cálculo para mim e eu vou ter que fazer todo esse trabalho de fora da classe.

Aqui eu tenho o "Funcionario", o "Funcionario" tem um método "getReajustes" que me devolve um "List" de reajuste, eu guardo esse "List" em uma variável, faço um "for", para cada reajuste eu incremento a variável com o valor total pegando o valor do reajuste em si. 

Ou seja, é um código onde de fora da classe eu tenho que manipular as informações dela para fazer esse algoritmo.

Aqui eu tenho um exemplo ruim. 

É um exemplo de quebra de encapsulamento de novo porque eu estou sabendo detalhes demais internos da classe "Funcionario" e isso está me levando a um acoplamento maior. 

Qual é o exemplo do acoplamento aqui? 

Por exemplo, eu faço essa chamada "funcionario.getReajustes" e jogo isso em um "List".

E se futuramente eu precisar trocar dentro da classe "Funcionario" o atributo "reajustesdeList" para "set" ou de "List" para "map" ou de "List" para um "array" ou para qualquer outro tipo. 

Eu mexo dentro da classe "Funcionario" e isso gera um impacto nessa classe externa porque essa classe está muito acoplada a classe "Funcionario". 

Qualquer mudança na classe "Funcionario" pode impactar nessa classe e em outras classes. 

Então percebe, o acoplamento ainda vai existir.

Só que aqui no caso ele está mais forte porque qualquer mudança que eu tenha que fazer dentro da classe "Funcionario" eu vou impactar aqui nessa outra classe porque ela está sabendo detalhes demais da classe "Funcionario", de como é feito o cálculo do somatório dos reajustes.

Então esse é um exemplo ruim e dificulta na manutenção do código. 

E aí perceba que, 

```diff
+ classes acopladas, elas geram uma fragilidade muito grande no código da aplicação. Porque qualquer mudança em um ponto pode gerar impactos em muitos outros pontos.
```

É aquele famoso caso que vocês talvez já tenham passado em algum projeto, você mexe em uma classe e aí um monte de outras classes param de compilar e aí você tem que mexer em mais um monte de outras classes porque elas foram impactadas com essa mudança que você fez.

E aí às vezes você acaba criando uma bola de neve, você mexe na classe A e gera um impacto na classe B, ajusta a classe B e gera um impacto na classe C e aí vai essa bola de neve só crescendo e dificultando a manutenção do seu código. 

E a cada mudança o risco de quebrar alguma coisa que já estava funcionando, que já estava quieta no seu canto. 

E isso tudo dificulta a manutenção.

Então, por isso que é importante termos esses princípios, conhecer cada um desses três princípios: 

* coesão, 
* encapsulamento e 
* acoplamento, 
  
e tentar ao máximo sempre segui-los, tentar seguir esses princípios quando formos modelar as classes da nossa aplicação porque isso favorece uma facilidade na manutenção, deixa o código mais simples de entender e de dar manutenção gerando menor impacto possível.

Esses são os três princípios que eu queria discutir com vocês sobre orientação a objetos e eles são importantes e nós vamos esbarrar nesses princípios quando formos falar do SOLID e de cada uma das letras ali do SOLID.

E vamos ver como essas coisas estão interligadas e que você aplicando os princípios do SOLID, você está aplicando diretamente, favorecendo esses três princípios em especial da orientação a objetos, o que deixa o seu código mais fácil de manter por isso que é extremamente importante você seguir esses princípios e seguir os princípios do SOLID também.

#### dependencias no codigo
Ao falar de acoplamento, vimos que é comum que classes dependam de outras para executar determinadas tarefas.

O que é correto afirmar sobre acoplamento?

R: É impossível criar um bom sistema sem nenhum tipo de acoplamento.
É fato que, se estamos organizando o nosso código, seguindo as recomendações da orientação a objetos, algum acoplamento acontecerá. Algumas classes precisarão de outras, para que não tenham muitas responsabilidades. Cabe a nós medir quando faz sentido adicionar tal acoplamento com as dependências e como depender do que é seguro, ao invés de classes concretas.

## o que aprendemos?
* coesao:
  * uma classe coesa faz bem uma unica coisa
  * classes coesas nao devem ter varias responsabilidades
* encapsulamento:
  * getters e setters nao sao formas eficientes de aplicar encapsulamento
  * é interessante fornecer acesso apenas ao que é necessario em nossas classes
  * o encapsulamento torna o uso das nossas classes mais facil e intuitivo
* acoplamento:
  * acoplamento é a dependencia entre classes
  * acoplamento nem sempre é ruim, e que é impossivel criar um sistema sem nenhum acoplamento
  * devemos controlar o nivel de acoplamento na nossa aplicaçao

## melhorando a coesão
### extraindo a logica de reajuste salarial
É uma aplicação do projeto é bem simples, só tem algumas classes aqui.

O foco não é no desenvolvimento da aplicação em si, não é em bibliotecas, frameworks, banco de dados e nem nada do gênero. 

É apenas na parte de código. 

Então basicamente tem três classes principais aqui no projeto. 

O projeto se chama RH e vai ser um projeto que cuida, tem esse domínio relacionado com RH, com funcionários, reajuste salarial e coisas do gênero. 

Basicamente tem o pacote raiz "br.com.alura.rh". 

#### ValidacaoException
Aqui dentro tem uma classe chamada "ValidacaoException".

É só uma classe para representar uma exception, uma exceção onde é uma exceção, uma validação do sistema quando acontecer algum erro de validação, uma classe de exception simples e um pacote Model com algumas classes de modelo. 

#### Cargo
Tem um "enum" chamado "Cargo" e ele só tem alguns tipos de cargo que os funcionários podem ter aqui que no caso é "ASSISTENTE", "ANALISTA", "ESPECIALISTA" e "GERENTE" e 

#### Funcionario
a classe "Funcionario" que digamos assim é a classe principal aqui do nosso projeto.

É a classe que representa um funcionário. 

```
public class Funcionario {

	private String nome;
	private String cpf;
	private Cargo cargo;
	private BigDecimal salario;
	private LocalDate dataUltimoReajuste;

	public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		this.salario = salario;
	}

	public void reajustarSalario(BigDecimal aumento) {
		BigDecimal percentualReajuste = aumento.divide(salario, RoundingMode.HALF_UP);
		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}
		this.salario = this.salario.add(aumento);
		this.dataUltimoReajuste = LocalDate.now();
	}
  ...
```

Então o "Funcionario" tem alguns atributos. 

Tem o nome, tem o CPF, tem o cargo, tem o salário e tem a data de último reajuste desse salário, um construtor que recebe essas informações exceto a data do último reajuste e o método para realizar o reajuste do salário do funcionário seguindo uma regra de negócio, uma validação do percentual do aumento.

E métodos "getters" e "setters" tradicionais. 

Então é isso. 

Esse é o projeto que vamos trabalhar aqui no curso.

É algo bem simples porque o foco é justamente na parte de código. 

Então para começar vamos dar uma analisada aqui no código da classe "Funcionario" e vamos tentar melhorar algumas coisas embora seja um código pequeno e simples, sempre tem alguma coisa que dá para melhorar.

Se analisarmos, a classe "Funcionario", o objetivo dessa classe é representar o que é o conceito de funcionário do domínio dessa aplicação. 

Então estamos representando, nessa aplicação o "Funcionario" é algo que tem nome, tem CPF, tem cargo, tem salário e tem uma data de último reajuste. 

Isso é a representação de um funcionário.

Porém, aqui tem uma questão, tem um método que realiza uma regra de negócio, uma lógica da nossa aplicação e a lógica de conceder um reajuste salarial. 

Então qualquer ideia, como que funciona esse reajuste salarial? 

Esse método recebe um "BigDecimal" com o valor do aumento, aqui fazemos uma lógica para verificar qual é o percentual desse aumento.

Então se o percentual for maior do que 40% do salário, é lançado uma exception porque isso não é permitido no sistema. 

O "Funcionario" só pode ter um aumento de no máximo 40% do valor do salário atual dele. 

Se estiver tudo ok, ele atribui o novo salário e marca como a data atual sendo a data do último reajuste. 

```
public void reajustarSalario(BigDecimal aumento) {
		BigDecimal percentualReajuste = aumento.divide(salario, RoundingMode.HALF_UP);
		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}
		this.salario = this.salario.add(aumento);
		this.dataUltimoReajuste = LocalDate.now();
	}
```

```diff
- Então aqui tem um problema.
```

A questão que vamos tratar é a questão relacionada com **coesão** que discutimos na aula anterior. 

A ideia é, embora reajuste e salário estejam relacionados com o funcionário, aqui eu tenho algo que já está além disso que é o cálculo do reajuste, a validação de reajuste de salário. 

Então essa validação é um pouco complicada. 

Eu tenho que verificar o percentual.

```diff
+ Pode ser que amanhã mude esse percentual, pode ser que tenham novas regras. 

+ Então esse trecho de código poderia estar isolado em uma outra classe. 
```

Isso daqui poderia estar separado para melhorar a coesão em um local onde fique responsável apenas por fazer essa validação de reajuste. 

Então isso vai ser o objetivo.

Vamos tentar extrair esse trecho de código e melhorar esse código para deixá-lo mais coeso, deixar a classe "Funcionario" mais coesa. 

Vamos lá. 

Então a ideia seria transformar isso em uma classe. 

Eu vou ter uma classe que cuida só dessa parte de reajuste. 

Então como isso é uma validação, é uma regra, é um serviço de reajuste, eu vou criar uma outra classe aqui no projeto.

#### ReajusteService
Vou colocar essa classe em um pacote service já que vai ser um serviço de reajuste e vou chamar essa classe a princípio de "ReajusteService". 

E aqui dentro eu vou ter um método public void reajustarSalarioDoFuncionario. 

E aí esse método precisa receber quem é o funcionário que vai receber esse aumento, vou chamar o atributo de "Funcionario" e um "BigDecimal" que é o valor do aumento.

Então algo parecido com o método que está lá dentro da classe "Funcionario". 

Eu meio que estou extraindo ele para cá. 

E aqui é que eu vou fazer a lógica de validar e conceder o reajuste ao funcionário que basicamente é esse código que está aqui. 

Então vou extrair esse código reajustarSalario, vou dar um "Ctrl + X", vou jogar para cá, só que aqui nós vamos ter que fazer alguns ajustes.

Então aqui eu tenho o percentual do reajuste. 

Não existe a variável salário porque agora eu estou fora da classe "Funcionario".

Eu vou transformar isso em uma variável local e vou chamar de salarioAtual. 

Só que eu preciso pegar esse salário justamente do objeto "Funcionario" que está vindo como parâmetro, ficando salarioAtual = funcionario.getSalario.

Essa vai ser uma mudança que vamos ter que fazer aqui. 

Peguei o "salarioAtual", calculei o "percentualReajuste" baseado no "salarioAtual", fiz a comparação. 

Se tiver errado ele vai jogar exception. 

Se estiver tudo ok, aí eu tenho que conceder esse reajuste.

Aqui o que eu vou fazer é pegar o objeto "funcionario" e eu tenho aqui atualizar o salário dele, funcionario.atualizarSalario().

E aí na hora de atualizar o salário eu já vou passar para o funcionário o novo salário dele para que ele não tenha que fazer esse cálculo. 

Então aqui eu vou criar uma outra variável BigDecimal salarioReajustado = salarioAtual.add o valor do aumento. E é justamente esse "salarioReajustado" que eu vou passar como parâmetro para esse método "atualizarSalario".

Lá na classe "Funcionario" eu vou renomear esse método para "atualizarSalario" e aqui vou renomear esse parâmetro para "novoSalario" e aí eu vou atribuir esse valor ao atributo "salario". 

Então this.salario recebe novoSalario que veio como parâmetro. 

this.salario = novoSalario e this.dataUltimoReajuste = LocalDate.now(). 

Então agora a classe "Funcionario" não sabe qual é a regra de validação do reajuste, como que é feito esse reajuste. 

A única coisa que ela faz é atualizar o salário.

Então uma das responsabilidades do "Funcionario" é essa, eu tenho aqui os meus atributos e uma das coisas que o funcionário, acaba acontecendo eventualmente com ele, é de ele ter uma atualização salarial. 

Eu tenho o método "atualizarSalario", recebo o salário. 

Não sei qual é o novo valor, como que foi feito o cálculo, se tem validação, simplesmente recebo esse novo salário, ele é atribuído ao salário do funcionário e a data de reajuste é atualizada para a data atual. Simples assim.

E aqui na classe "ReajusteService" é que vai ficar a regra de negócio relacionada com o reajuste salarial. 

Então aqui eu recebo quem é o funcionário que vai pegar esse aumento, qual é o valor do aumento e eu faço toda a lógica, toda aquela validação que estava lá na "Funcionario" e trouxemos para cá.

Eu calculo o percentual de reajuste, verifico se ele não está maior do que 40%, se estiver eu jogo um erro e não realizo esse reajuste, se estiver menor do que 40%, até 40% eu realizo a atualização do salário e pronto, morreu o assunto. 

E agora essa classe tem essa responsabilidade, fazer a regra de negócio de reajuste salarial. 

E a classe "Funcionario" ficou mais coesa, ela não cuida mais dessa validação e dessa regra de negócio de reajuste salarial.

Ela só tem a representação de um funcionário. 

Nós extraímos essa lógica para melhorar a coesão dessa classe. 

Então isso que acabamos de fazer pode parecer algo simples, mas é algo que nós às vezes no automático, e sem querer passa batido e acabamos escrevendo classes que vão perdendo a coesão aos poucos.

Nós vamos adicionando coisas, adicionando métodos e aquela classe começa a ficar muito grande e começa a fazer várias coisas distintas que indiretamente estão relacionados com ela, mas que poderiam estar extraídas para classes separadas para diminuir esse código e diminuir a verbosidade e deixá-la mais coesa.

E esse é justamente um princípio do SOLID que acabamos de aplicar aqui e ele está diretamente relacionado com a coesão. 

Então por isso que foi importante nós termos aquele alinhamento dos princípios da orientação a objetos. 

#### Classe Funcionario
```
public class Funcionario {

	private String nome;
	private String cpf;
	private Cargo cargo;
	private BigDecimal salario;
	private LocalDate dataUltimoReajuste;

	public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		this.salario = salario;
	}

	public void atualizarSalario(BigDecimal novoSalario) {
		this.salario = novoSalario;
		this.dataUltimoReajuste = LocalDate.now();
	}
...
```

#### Classe ReajusteService
```
public class ReajusteService {
    
    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento){
        BigDecimal salarioAtual = funcionario.getSalario();

        BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}

        BigDecimal salarioReajustado = salarioAtual.add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
    }
}
```

### Single Responsibility Principle
Então aquele último ajuste, aquela refatoração que fizemos no código foi buscando em melhorar a coesão e com isso acabamos aplicando o primeiro princípio do SOLID que é a letra S que significa **Single Responsibility Principle**, o princípio da responsabilidade única.

"Só porque você pode não significa que você deveria".

Então é a mesma coisa, podemos pensar no nosso código, só porque você pode ter o sistema inteiro escrito em uma única classe não significa que você deveria fazer dessa maneira. 

Então quando temos essa situação acabamos ferindo a coesão, acabamos tendo aquele código gigantesco que é muito difícil de dar manutenção, de encontrar as coisas.

Provavelmente você vai ter código duplicado ali dentro e é um código que tende a mudar toda hora. 

Qualquer coisa que mexe no sistema, qualquer tipo de mudança você vai ter que mexer naquela classe. 

É uma classe muito frágil também. 

Então essa aqui é a ideia. 

E esse termo, essa frase, esse Single Responsibility Principle foi criado e seu nome foi dado pelo Uncle Bob que é uma pessoa bastante proeminente na nossa área de desenvolvimento de software.

```diff
+ "uma classe deveria ter apenas um unico motivo para mudar" (Uncle Bob)
```

E a ideia é justamente essa, ele prega que uma classe deveria ter apenas um único motivo para mudar. 

Só que assim, se formos parar para analisar mais friamente, vamos pensar "Poxa Rodrigo, mas é difícil a classe não ter dois ou mais motivos para mudar, ter apenas um único motivo". 

Mas a ideia não é essa, a ideia é que a classe tem que ter um único motivo que está alinhado, ela tem que mudar sempre que for algo relacionado com ela.

Por exemplo, a classe "Funcionario" só deveria mudar quando tiver alguma alteração na representação de um funcionário. 

Então quando eu for mudar, por exemplo, o jeito de enviar um e-mail no sistema, o jeito de gerar um relatório, o acesso ao banco de dados, isso não deveria impactar na classe "Funcionario".

Então percebe, a classe "Funcionario" pode mudar quando for alterado o atributo "nome", quando for alterado o atributo "salario". 

São dois motivos para mudar, só que esses dois motivos estão relacionados entre si, eles se referem a mesma coisa. 

Então essa é que é a ideia. 

Nós não podemos levar também ao pé da letra. 

E esse princípio, o foco dele é justamente em **coesão**.

Quando aplicamos esse princípio da responsabilidade única, estamos focando em manter uma alta coesão no nosso código, estamos pensando em deixar as classes pequenas, enxutas e deixá-las com bastante coesão para que assim elas tenham realmente um único motivo para mudar. 

Então eu consigo sempre que for fazer uma alteração no meu projeto, mexer em um único ponto do sistema.

Sem o medo de quebrar em um monte de outros lugares ou sem o medo de ter que sair caçando, "Poxa, eu fiz essa mudança na classe A, onde mais eu vou ter que mudar para aplicar essa mudança?" 

Então isso é bem comum nos projetos que não seguem esse princípio e não tem classes coesas. 

No nosso caso fizemos isso na classe "Funcionario". 

Então agora a classe "Funcionario" não tem mais as regras e as validações de reajuste.

Ela apenas representa o funcionário, ela representa lá o "salario" e a data de último reajuste.

Mas ela não sabe quais são as regras, todas as possibilidades de reajuste salarial. 

E por outro lado, aquela classe que extraímos, a classe "ReajusteService" é responsável por fazer as regras e validações de reajuste salarial. 

Então essa classe "ReajusteService" sempre vai mudar quando houver novos funcionalidades, novas regras relacionadas com reajuste salarial.

Tudo que for referente a reajuste salarial vai entrar nessa classe, apenas nessa classe. 

Então quando tiver uma nova regra, por exemplo, o percentual aumentou, agora é 55%. Um funcionário pode receber um aumento de até 55% do seu salário. Então eu vou mudar apenas aqui na classe "ReajusteService". Eu não vou precisar mexer na classe "Funcionario".

Então percebe, eu estou mexendo em um único ponto do meu sistema. 

Isso é uma boa característica, isso é o que deveríamos buscar no nosso projeto. 

Toda mudança deveria mexer em um ou outro ponto, não deveria mexer no sistema inteiro em 5, 10, 20 pontos do projeto. 

Então esse que era o objetivo da aula de hoje, discutirmos sobre o primeiro princípio S da letra do SOLID que é relacionado com coesão, com a responsabilidade única.

E a ideia é essa, mantermos esse sistema coeso que é mais fácil de dar manutenção é isso é o que sempre deveríamos buscar nos nossos códigos. 

```diff
+ Principalmente nos códigos que representamos a camada de domínio da aplicação. 
```

Deveria ser um lugar ali onde deveríamos conseguir aplicar esses conceitos de orientação a objetos e esses princípios do SOLID. 

Então na próxima aula vamos ainda discutir sobre essa classe aqui porque tem algumas questões em relação a ela.

#### Definiçao de SRP
Ao extrair uma nova classe, vimos que agora temos classes com menos responsabilidades, o que facilita na manutenção. Esse é o conceito de Single Responsibility Principle.

Qual é a definição mais formal do princípio de responsabilidade única?

R: Uma classe (ou módulo, função, etc) deve ter um e apenas um motivo para mudar
Esta é uma das definições mais conhecidas do SRP (Single Responsibility Principle).

### o que aprendemos?
* que classes/metodos/funçoes/modulos devem ter uma unica responsabilidade definida
* que, segundo o Principio de Responsabilidade Unica (SRP), uma classe deve ter um e apenas um motivo para ser alterada
* como realizar uma refatoraçao no nosso sistema, para aplicar o SRP
* como extrair uma classe

## Reduzindo o acoplamento
### extraindo validaçoes
na aula de hoje, nesse vídeo nós vamos continuar tratando dessa parte de reajuste. 

E qual é a ideia? 

Vamos imaginar que temos uma nova regra de negócio, um novo requisito que chegou para implementarmos aqui no nosso projeto.

A ideia é relacionada com o reajuste de salário. 

Antes só existia uma única regra, uma única validação que era o percentual do reajuste. 

O funcionário não poderia receber um reajuste que cujo percentual fosse maior do que 40% do salário dele. 

E agora tem uma outra regra de negócio que diz que um funcionário tem que ter uma periodicidade, ele não pode sair recebendo reajuste todos os meses.

Então o pessoal da área de negócios passou para nós que a regra é a seguinte, um funcionário tem que ter um intervalo mínimo de seis meses para receber um novo reajuste. 

Então se ele receber um reajuste, por exemplo, no mês passado ele não pode receber um reajuste nesse mês, tem que esperar pelo menos seis meses.

Então ele só pode receber um reajuste a cada 6 meses para, assim, termos uma melhor periodicidade, para que o funcionário só tenha dois reajustes no máximo dentro de um mesmo ano. 

Então vamos implementar essa regra. 

Como isso tem a ver com o reajuste, é aqui na própria classe "ReajusteService".

Aqui eu tinha aquela regra anterior que é a regra do percentual de 40%, só que antes de efetuar de fato o reajuste, eu preciso implementar a nova regra que é relacionada com a periodicidade. 

Então vou fazer o seguinte, vou criar uma variável local, LocalDate dataUltimoReajuste e aí eu vou perguntar para o funcionário, lembra que o funcionário tem um atributo, getDataUltimoReajuste? 

Fica LocalDate dataUltimoReajuste = funcionário.get.DataUltimoReajuste().

Vou pegar qual foi a data de último reajuste desse funcionário, vou pegar também a data atual LocalDate dataAtual = LocalDate.now(). Então agora eu tenho a "dataAtual" de quanto que está sendo chamado esse código, a data do último reajuste e eu preciso fazer essa comparação para ver quantos meses se passou entre a data do último reajuste e a data atual.

E se for menor do que 6, ainda está muito cedo, eu jogo uma exception parecido com isso que eu fiz aqui. Vou até copiar esse trecho de código para baixo de "dataAtual". Só que aqui é if mesesDesdeUltimoReajuste < 6 for menor do que 6, aí eu lanço uma exception dizendo que ele não pode ter um reajuste e aí eu coloco uma mensagem, ValidaçaoException("Intervalo entre reajustes deve ser de no mínimo 6 meses").

Só que agora eu preciso criar essa variável que tenha essa quantidade de meses desde o último reajuste. 

Vou fazer o seguinte, long, vou copiar aqui, mesesDesdeUltimoReajuste é igual a, tem a classe da API de datas do Java, ChronoUnit.MONTHS.between, vou chamar esse método de "between" e aí eu passo a data de último reajuste, a data atual e ele já vai me devolver quantos meses, vai me devolver um "long" com o número de meses que tem entre essas duas datas.

E aí está pronto. 

Verifique se for menor do que 6, se for lança uma exception, não atualiza o salário do funcionário. 

Se for maior do que 6, ok, já passou o tempo mínimo e ele pode receber um novo reajuste. 

Está implementado. Simples. 

Então percebe, como foi uma regra de reajuste, ela ficou aqui dentro da classe "ReajusteService".

Eu não precisei mexer na classe "Funcionario" para implementar uma nova regra relacionada com validações de reajuste. 

```
public class ReajusteService {
    
    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento){
        BigDecimal salarioAtual = funcionario.getSalario();

        BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}
        
        LocalDate dataUltimoReajuste = funcionário.get.DataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
        if(mesesDesdeUltimoReajuste < 6) {
            throw new ValidacaoException("Intervalo entre reajuste deve ser de no minimo 6 meses");
        }
        BigDecimal salarioReajustado = salarioAtual.add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
    }
}
```


Porém temos um problema em "ReajusteService". 

Embora essa mudança seja relacionada com reajuste e a classe "ReajusteService" ainda esteja coesa, você poderia estar pensando, "Poxa, a classe "ReajusteService" agora não está mais coesa". 

Mas na verdade, ela ainda está coesa porque esse código que eu coloquei ainda tem relação com o reajuste salarial. 

Então ela ainda continua coesa.

```diff
- Porém essa classe tende a ficar grande, ela tende a crescer muito. 
- Para cada nova mudança, para cada nova regra de negócio ou para cada nova validação de reajuste, eu vou ter que mexer nesse código. 
```

Essa classe é uma classe que nunca vai parar de crescer. 

Ela vai sempre aumentar de tamanho conforme novas regras vão surgindo. 

Sempre que uma regra de reajuste mudar, eu vou ter que mexer nessa classe.

Sempre que uma regra deixar de existir, eu vou ter que mexer nessa classe. 

Então toda hora eu vou ter que ficar mexendo nessa classe e aí começa a dificultar a manutenção do código. 

E aí se eu precisar estender essa classe, eu não consigo estendê-la adicionando essas novas regras por fora. 

Eu vou ter que sempre mexer na mesma classe.

E sempre que eu tenho que mexer em uma classe, em um código existente eu corro o risco de estragar alguma coisa que estava funcionando. 

Então aí está o problema dessa classe e nós vamos tentar resolver isso agora. 

Então a ideia seria separar cada regra dessa em uma classe a parte. 

Então vamos começar extraindo esse trecho de código para uma outra classe. 

Vou criar uma outra classe no menu do lado esquerdo. 

Por enquanto vou criar aqui dentro mesmo da classe "Service".

#### ValidacaoPercentualReajuste
Vou criar uma nova classe chamada "ValidacaoPercentualReajuste". 

Vou criar essa classe e dentro dela vou criar um método public void validar, ele recebe o Funcionario". 

Vai ter aquela mesma assinatura. 

Recebe um "Funcionario" e recebe o "BigDecimal" com o valor do aumento. 

Então aqui "aumento". 

Ficou public void validar(Funcionario funcionario, BigDecimal aumento) {. Então eu vou jogar para cá. Aquela regra veio justamente para cá. Copiei, colei. Está compilando tudo certo.

```
public class ValidacaoPercentualReajuste {
    public void validar(Funcionario funcionario, BigDecimal aumento) {
        BigDecimal salarioAtual = funcionario.getSalario();

        BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}
    }
}
```

#### ValidacaoPeriodicidadeEntreReajustes
Aí agora eu vou copiar essa classe, vou colar. Só que aí vou renomear para "ValidacaoPeriodicidadeEntreReajustes". 

Só que aí o código dela ficou igual ao da outra agora. 

E agora eu vou extrair esse "dataUltimoReajuste". 

Vou dar um "Ctrl + X" e vou colar abaixo de "validar". 

Pronto, agora está separado. 

```
public class ValidacaoPercentualReajuste {
    public void validar(Funcionario funcionario, BigDecimal aumento) {
        LocalDate dataUltimoReajuste = funcionário.get.DataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
        if(mesesDesdeUltimoReajuste < 6) {
            throw new ValidacaoException("Intervalo entre reajuste deve ser de no minimo 6 meses");
        }
    }
}
```

Uma classe cuida só da validação de periodicidade, outra classe cuida só da validação de percentual.

E agora o reajuste, aí é que está. 

Como que eu faço agora para chamar as validações se elas estão separadas? 

Repara também o seguinte, repara que são duas classes separadas, mas percebe que as duas têm o mesmo método. 

Não o mesmo método, não a mesma implementação, mas a mesma assinatura de método. 

As duas têm um método "validar" que recebe um "funcionario" e um "BigDecimal".

Talvez você já tenha visto isso no Java. 

Quando eu tenho várias classes que tenham a mesma assinatura ou o mesmo contrato, mas cada uma implementa de um jeito, tem um conceito lá que é aquela ideia justamente de interface. 

Então poderia criar uma interface, definir uma interface e a interface comum de validação, de reajuste. 

Então vou fazer isso aqui, vou colocar um "implements ValidacaoReajuste", ficando ValidacaoPercentualReajuste implements ValidacaoReajuste {.

#### ValidacaoReajuste
Não existe essa interface, vou dar um "Ctrl + N", "Create interface 'ValidacaoReajuste'", vou criar essa interface e eu vou jogar para cá a assinatura desse método aqui. 

Então esse método vai ficar na minha interface. 

O "public" não precisa. 

Todo método em uma interface já é público. Então "void validar". Pronto. Essa classe já está implementando a interface.

Vou colocar a outra classe para implementar a interface. Pronto. 

Então agora só para padronizar. 

Eu tenho duas classes que implementam a mesma interface, só que cada uma vai implementar um método de uma maneira distinta. 

E com isso agora eu posso usar aquele recurso do Java. 

Eu posso ter essa interface que ela me dá essa abstração das validações. 

Eu não preciso conhecer cada uma das validações.

#### ReajusteService
Eu posso fazer o seguinte, voltando para o "ReajusteService" eu posso declarar um atributo. 

Como são várias validações, eu vou declarar um atributo do tipo "list", Java útil. E aí para eu não ficar amarrado com uma validação especifica, o tipo da minha lista vai ser de "ValidacaoReajuste" que é a interface. 

Eu vou chamar aqui de "validacoes". 

O meu "ReajusteService" tem uma lista de validações.

Não sei quantas validações são, quais são elas. 

Simplesmente eu tenho uma lista de validações. 

Para essa classe não ter que criar cada uma das validações, eu vou fazer o seguinte, eu vou gerar um construtor e já recebendo esse construtor, atalhos "Source", "Generate Constructor Using Fields".

Já no construtor eu recebo essa lista. 

Então é classe não precisa saber quais são as validações, quantas são e o que cada uma faz e como que elas trabalham. 

Eu simplesmente recebo elas no construtor. 

E aqui o que eu faço? 

Agora preciso chamar cada uma dessas validações. 

Então como que eu faço aqui?

This.validacoes.forEach, vou percorrer cada uma dessas validações e aí dentro de cada validação dessa, dado uma validação V, "v.validar" passando o "funcionario" e passando o "aumento". 

```
public class ReajusteService {

    public ReajusteService (List<ValidacaoReajuste> validacoes) {
        this.validacoes = validacoes;
    }

    private List<ValidacaoReajuste> validacoes;
    
    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento){
        this.validacoes.forEach(v -> v.validar(funcionario, aumento));

        BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
    }
}
```

Então pronto. Aqui eu só preciso do salário atual.

Então é "funcionario.getSalario" que é o salário atual do funcionário.

Pronto. 

Olha só que legal, agora a minha classe até diminuiu. 

Ela já estava coesa, mas estava ficando muito grande. 

Agora ela está pequena. 

Então agora a minha classe "Reajuste" recebe uma lista de validações e aí o que significa reajustar o salário do funcionário?

Significa executar cada uma das validações. 

Então aqui nesse código eu faço justamente isso. 

Pego cada uma das validações, estou me referenciando a interface que é um conceito, uma abstração de validação e não a cada uma das implementações e chamo o método "validar". 

Se alguma delas constar que está inválida, ela vai jogar exception, esse código vai ser interrompido.

Se todas elas passaram e não lançaram nenhuma exception, ele vai cair nessa linha de baixo, vai pegar o salário do funcionário, adicionar o aumento e incrementar, fazer a atualização do salário do funcionário. 

E cada validação implementa a interface. 

Cada classe agora tem a sua regra específica de validação do reajuste, uma não conhece a outra e a classe "Service" não conhece nenhuma delas. 

Então agora o código continua coeso.

Eu ainda continuo fazendo a validação de reajuste, porém agora ele está extensível. 

Esse código aqui eu consigo estendê-lo. 

Se surgir uma nova validação de reajuste salarial, eu não preciso mexer mais nessa classe. 

Eu simplesmente vou criar uma classe, vou implementar a interface validação do reajuste, vou ser obrigado a ter um método "validar" e vou implementar o algoritmo de validação. Simples assim.

Não vou precisar mexer nas outras validações que existem e não vou precisar mexer nessa classe "Service". Ela continua recebendo uma lista de validações. 

A classe que está chamando a "Service" é que vai passar essa nova validação. 

Mas a classe "Service" em si não conhece as validações. 

Então a classe agora está extensível. 

Agora perceba que é muito mais fácil de dar manutenção.

Se uma regra de negócio precisar ser alterada, por exemplo, o percentual do reajuste agora não é mais 40, é 50%, eu mexo apenas nessa classe. 

Não preciso mexer nos outros validadores, não preciso mexer na classe "ReajusteService". 

Se não existir mais essa regra da periodicidade, agora ele pode receber quantos reajustes quiser independente do período, simplesmente eu apago essa classe.

Não vou precisar mexer nas outras validações, não vou precisar mexer na classe "ReajusteService". 

Percebe que está muito mais fácil de dar manutenção aqui no código, está muito mais fácil de adicionar, alterar e remover validações relacionadas com reajuste. 

Essa classe se tornou muito mais extensível para novas funcionalidades.

Obviamente você já sabe, nós acabamos de aplicar mais um princípio do SOLID, mas na próxima aula discutimos sobre esse princípio e como que ele foi aplicado aqui. 

#### ValidacaoReajuste
```
public interface ValidacaoReajuste {
    void validar(Funcionario funcionario, BigDecimal aumento);
}
```

#### ReajusteService
```
public class ReajusteService {

    public ReajusteService (List<ValidacaoReajuste> validacoes) {
        this.validacoes = validacoes;
    }

    private List<ValidacaoReajuste> validacoes;
    
    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento){
        this.validacoes.forEach(v -> v.validar(funcionario, aumento));

        BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
    }
}
```

#### ValidacaoPercentualReajuste
```
public class ValidacaoPercentualReajuste implements ValidacaoReajuste{
    public void validar(Funcionario funcionario, BigDecimal aumento) {
        BigDecimal salarioAtual = funcionario.getSalario();

        BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}
    }
}
```

#### ValidaçaoPeriodicidadeEntreReajustes
```
public class ValidacaoPercentualReajuste implements ValidacaoReajuste{
    public void validar(Funcionario funcionario, BigDecimal aumento) {
        LocalDate dataUltimoReajuste = funcionário.get.DataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
        if(mesesDesdeUltimoReajuste < 6) {
            throw new ValidacaoException("Intervalo entre reajuste deve ser de no minimo 6 meses");
        }
    }
}
```

#### muitas validaçoes
Encontramos nesta aula um problema na classe ReajusteSalarial.

O que pudemos identificar sobre o problema desta classe?

R: Esta classe poderia crescer para sempre

Enquanto novas validações de reajuste fossem criadas, novas condições deveriam ser adicionadas a esta classe, fazendo-a crescer interminavelmente.

### Open Closed Principle
No último item nós aprendemos como extrair aquelas validações relacionadas com reajuste para tornar aquela classe mais extensível. 

```diff
+ Na programação orientada a objeto, o princípio do aberto/fechado estabelece que
+ "entidades de software (classes, módulos, funções, etc.) devem ser abertas para extensão, 
+ mas fechadas para modificação";
+ isto é, a entidade pode permitir que o seu comportamento seja estendido sem modificar seu código-fonte.
```

Nós conseguimos adicionar novas características, novos comportamentos sem ter que ficar alterando o código daquela classe.

E aí esse é justamente o conceito por trás do princípio Open Closed que é o princípio do aberto fechado. 

Então em vez de toda nova regra de negócio ou toda nova validação, nós adicionarmos um novo código ali e mexer na mesma classe, nós conseguimos extrair utilizando **interface** e **polimorfismo**. 

Então aqui é outro conceito da orientação a objetos para tornar aquela classe um pouco mais extensível e com isso deixamos o código muito mais flexível e paramos de sempre ficar mexendo e alterando o código de uma classe existente porque é sempre perigoso mexer em um código existente.

Nós podemos quebrar alguma coisa que estava funcionando. 

Então a ideia do princípio aberto fechado é que entidades de software, entidades entendam como classes, módulos, funções ou coisas do gênero, elas deveriam estar sempre abertas para a extensão para você adicionar coisas novas, novos comportamentos, porém fechadas para modificação.

Então quanto menos mexermos, modificarmos uma classe, melhor, porque mais estável ela vai ficar, menos bugs corremos o risco de introduzir no software. 

Porém vamos precisar alterar o software, nós vamos precisar adicionar novas funcionalidades, novas validações, novos algoritmos, regras, enfim. 

Então precisamos escrever o código de uma maneira que nós também não deixamos o deixe engessado, que não possamos mexer e não possamos adicionar mais nada, ele esteja fechado, uma caixa-preta.

Não, nós temos que implementar, fazer o design do código de uma maneira que ele consiga ser extensível, que consigamos estendê-lo. 

Sempre adicionando novos comportamentos e nunca, evitando ao máximo mexer em nenhum código existente para adicionar algo novo. 

Nós temos que mexer no código quando é uma mudança de uma regra já existente. 

Aí não tem para onde correr.

Agora, quando é para adicionar uma nova característica, uma nova regra, o ideal seria que evitássemos de mexer em código e sim adicionasse de uma maneira extensível conforme fizemos com o uso de interfaces e o grande polimorfismo da orientação a objetos que é um conceito até um pouco difícil de entender para quando você está caindo de paraquedas na orientação a objetos.

Você vê esse nome esquisito polimorfismo e às vezes não fica muito claro o que diabos é esse tal do polimorfismo e acabamos de ver uma utilização do polimorfismo com o uso da interface e daquelas classes implementando a interface e lá na classe "ReajusteService" recebemos um "List" da interface.

Então nós não conhecemos as implementações, então isso daqui é uma abstração, é a validação de reajuste, é um conceito. 

Para fazer um reajuste tem uma validação.

Aqui eu tenho vários tipos de validações. 

Aqui eu tenho só esse conceito, só essa abstração de uma validação de reajuste. 

Agora cada implementação, aí sim é o código concreto da implementação desse conceito. 

Então nós tornando concreto esse conceito de validação e com isso conseguimos deixar o código extensível. 

Então essa que foi a ideia do princípio aberto fechado.

#### garantindo que o sistema seja extensivel
O Open Closed Principle, embora complexo em sua definição, é muito útil e pertinente.

O que podemos fazer para garantir que nosso sistema seja extensível da forma correta?

R: Garantir que cada ação/responsabilidade esteja na classe correta

 Esta é uma das formas de garantir que o sistema seja extensível.

### o que aprendemos?
* que cada classe deve conhecer e ser responsavel por suas proprias regras de negocio
* que o principio Aberto/Fechado (OCP) diz que um sistema deve ser aberto para extensao mas fechado para modificaçao
  * isso significa que devemos poder criar novas funcionaliudades e estender o sistema sem precisar modificar muitas classes ja existentes
* uma classe que tende a crescer "para sempre" é uma forte candidata a sofrer alguma especie de refatoraçao

## Herança indesejada
### implementando uma nova regra de negocio
Na última aula implementamos o Open Close Principle extraindo da classe "ReajusteService" aquelas validações. 

Então cada validação agora está dentro de uma classe separada e o código ficou mais simples, mais organizado e mais fácil de estender. 

E aí na aula de hoje vamos implementar uma nova regra de negócio na nossa aplicação.

Então já tratamos de reajuste. 

Mas uma outra funcionalidade importante que precisamos ter no sistema é a de promover um funcionário. 

Então se um funcionário bateu a meta do semestre, por exemplo, ele vai ser promovido. 

E o que significa ser promovido? Ele vai subir de cargo. 

Não sei se vocês lembram, mas no nosso projeto tínhamos um enum chamado "cargo" e nós temos esses quatro cargos aqui, "ASSISTENTE", "ANALISTA", "ESPECIALISTA" e "GERENTE".

Então se um assistente bateu a meta, ele vai virar analista.

Se um analista bateu a meta vai virar especialista e o especialista vai virar gerente e só o gerente que não vai poder ser promovido porque ele já, no exemplo que estamos usando no curso, seria o último cargo na hierarquia. 

Então vamos implementar essa funcionalidade. 

Como vai ter uma lógica, vai ter uma validação do gerente, da meta, o ideal é criarmos uma classe separada para cuidar dessa regra de negócio.

#### PromocaoService
Estou no pacote "Service", eu vou criar uma nova classe e o nome dessa classe vai ser "PromocaoService". 

Então vai ser uma classe de serviço que vai cuidar da lógica de promoção. 

E aqui nessa classe o que vamos fazer? 

Vamos criar um método public void promover. 

Então esse método é que vai fazer a lógica de promoção do funcionário.

Então eu preciso receber como parâmetro quem é o funcionário que vai ser promovido e um booleano dizendo se a meta foi batida ou não. 

Então só para ter o controle se ele bateu a meta do semestre ou do ano, enfim. 

Então a lógica era, uma das validações, o gerente não pode ser promovido porque o gerente já é o último cargo.

Então eu vou fazer um "if" só para verificar se o funcionário que foi passado como parâmetro não é um gerente. 

Então if (Cargo.GERENTE == funcionario.getCargo()). 

Se por acaso o funcionário que foi passado como parâmetro, o cargo dele já for gerente, vamos lançar uma exception porque o gerente não pode ser promovido. 

Então throw new ValidacaoException. Lembra que temos uma classe de exceção aqui no projeto.

Vou colocar uma mensagem genérica aqui, ("Gerentes nao podem ser promovidos"). 

Só para ter essa validação. 

Então se caiu nesse "if" eu quero um gerente e vai interromper o fluxo, se não caiu no "if" vai continuar aqui. 

Então o próximo passo é verificar se esse funcionário, se essa pessoa bateu a meta. 

Então vou ter que ter mais um "if" aqui, if (metaBatida) {. Se bateu a meta aí eu vou fazer a promoção.

Então eu preciso saber qual é o cargo atual do funcionário. 

Vou extrair essa linha do "funcionario.getCargo" para uma variável local. 

Vou extrair para uma variável chamada "cargoAtual" porque vou precisar reutilizá-la aqui e agora eu vou ter que saber qual é o cargo atual, voltando para o "enum Cargo" e vou ter que pegar a próxima constante. 

Para não ter que fazer um monte de "if" e "else" no código, "if assistente promove para analista", "else if analista promove para especialista".

Em vez de fazer isso, vamos fazer de um jeito mais elegante. 

Vou fazer o seguinte, Cargo novoCargo, vou criar uma variável para guardar um novo cargo e ela vai receber = cargoAtual.. 

Então eu vou pegar variável "cargoAtual.", vou criar um método chamado getProximoCargo e o próprio cargo vai me devolver qual é o próximo cargo. 

Vou mandar ele criar e ele criou o método no "enum Cargo", porém eu vou fazer uma mudança aqui. 

Esse método vou transformar em abstrato. 

Então abstract Cargo getProximoCargo(), vou excluir essa implementação, vou salvar e aí como é um método abstrato, o Eclipse já reclamou porque todas as constantes vão precisar implementar esse método".

Então vou vir aqui na primeira constante "assistente", "Add unimplemented methods" e aí a constante "assistente" vai ter que devolver qual é o próximo cargo, return ANALISTA. 

O próximo cargo, se for assistente, é analista. E aí eu faço a mesma coisa para as outras constantes.

O "gerente" vou retornar "gerente". 

Ele não pode ser promovido, então ele continua no próprio cargo. 

O especialista, o próximo cargo é "gerente" e o analista o próximo cargo é "especialista". 

Então agora o "enum" tem cada constante. 

Só que cada constante tem que implementar um método abstrato. 

Então é uma maneira interessante de você criar um método abstrato e forçar cada constante em implementar esse método de uma maneira distinta.

Agora voltando lá para a classe "PromocaoService", eu já tenho um novo cargo do funcionário baseado no cargo atual. 

Agora eu preciso pegar o funcionário e promovê-lo. 

Vou chamar o método "promover" passando como parâmetro o novo cargo. 

Então vou colocar aqui funcionario.promover passando como parâmetro novoCargo. 

Ele está reclamando porque não existe esse método "promover" na classe "funcionario". Vou mandar ele gerar esse método.

E aqui basicamente eu tenho que substituir o "cargoAtual", this.cargo recebe = novoCargo. 

Então a própria classe "funcionario" recebe o "novoCargo" e ela atribui ao "cargoAtual". 

E na classe "PromocaoService" está aqui a nossa regra de negócio implementada. 

Então eu tenho a classe "PromocaoService", tenho o método "promover" e aqui vai estar a lógica de promoção do funcionário. Qual é essa lógica?

Eu recebo um funcionário, recebo um booleano indicando se ele bateu ou não a meta, vejo qual é o "cargoAtual" do funcionário, se for o gerente eu jogo uma exception, jogo um erro de validação porque gerente não pode ser promovido, se não for verifico se bateu a meta, se bateu a meta eu atribuo o novo cargo do funcionário, "else".

Se não bateu a meta, esse método não poderia ter sido chamado. 

Então vou lançar uma exception aqui, "("Funcionario não bateu a meta")". 

Então ele não pode ser promovido se ele não tiver batido a meta. 

E está aí implementado a nossa nova regra de negócio. 

Percebe que foi simples implementar essa nova regra de negócio.

Eu só criei uma classe ou um método, fiz as validações, utilizei esse esquema do "enum". 

Talvez você nunca tivesse visto esse esquema. Mas o "enum" não precisa ser somente um conjunto de constantes, você pode ter métodos aqui também para dar um pouco de lógica para um "enum".

Então aqui um método abstrato para forçar que cada constante implemente um determinado método e sua implementação provavelmente vai ser diferente uma da outra. 

Está implementado aqui. 

Porém vamos ter uma mudança que vai gerar um efeito colateral. 

#### Cargo
```
public enum Cargo {

	ASSISTENTE {
		@Override
		public Cargo getProximoCargo() {
			return ANALISTA;
		}
	},
	ANALISTA{
		@Override
		public Cargo getProximoCargo() {
			return ESPECIALISTA;
		}
	},
	ESPECIALISTA{
		@Override
		public Cargo getProximoCargo() {
			return GERENTE;
		}
	},
	GERENTE{
		@Override
		public Cargo getProximoCargo() {
			return GERENTE;
		}
	};

	public abstract Cargo getProximoCargo();

}
```

#### PromocaoService
```
public class PromocaoService {
    public void promover(Funcionario funcionario, boolean metaBatida) {
        Cargo cargoAtual = funcionario.getCargo();

        if(Cargo.GERENTE == cargoAtual) {
            throw new ValidacaoException("Gerentes nao podem ser promovidos");
        }
        if(metaBatida) {
            Cargo novoCargo = cargoAtual.getProximoCargo();
            funcionario.promover(novoCargo);
        }
    }
}
```

#### Funcionario
```
public class Funcionario {

	private String nome;
	private String cpf;
	private Cargo cargo;
	private BigDecimal salario;
	private LocalDate dataUltimoReajuste;

	public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		this.salario = salario;
	}

	public void atualizarSalario(BigDecimal novoSalario) {
		this.salario = novoSalario;
		this.dataUltimoReajuste = LocalDate.now();
	}

	public void promover(Cargo novoCargo) {
		this.cargo = novoCargo;
	}

  ...
```

### utilizando herança da maneira ERRADA
No último item nós implementamos essa funcionalidade de promoção para promover um funcionário e aí terminamos com esse código aqui da classe "PromocaoService" e todas as regras, as validações relacionadas com a promoção foram implementadas.

Agora vamos ter uma nova mudança aqui no projeto porque além de funcionário essa empresa, o RH dessa empresa precisa também gerenciar os terceirizados. 

Então a empresa tem os próprios funcionários contratados, mas ela também contrata terceirizados. 

Faz um contrato com uma outra empresa que envia funcionários para trabalhar temporariamente na empresa.

E aí nós não temos essa implementação desse modelo de terceirizado. 

Então aqui no pacote de modelo eu vou criar uma nova classe chamada "Terceirizado". 

Então tudo que for relacionado a um funcionário terceirizado vai ficar aqui dentro. 

Então terceirizado na teoria é um funcionário. 

Então eu preciso saber qual é o nome, qual é o e-mail, qual é o CPF.

É exatamente as informações que eu tenho aqui na classe "funcionario". 

Então vamos utilizar aquele conceito da orientação a objetos de herança para poder ter um reaproveitamento. 

Então "Terceirizado", vou dar um "extends" na classe "Funcionario". 

um terceirizado nada mais é do que um funcionário. 

Ele está reclamando aqui porque lá na classe "funcionario" tem um construtor e eu preciso também gerar o construtor aqui.

Vou pedir para o Eclipse gerar o construtor. 

Está aqui o construtor que recebe um nome, um CPF, o cargo e o salário. 

E aí ele simplesmente delegou isso para o construtor da classe mãe, da classe pai que, no caso, é a classe "Funcionario". 

Pronto, está implementado. 

E aí aqui eu posso ter coisas específicas de um terceirizado. 

Por exemplo, private String empresa.

Qual é o nome da empresa terceirizada? 

E tudo que for relacionado com o terceirizado vai ficar aqui dentro da classe "Terceirizado". 

Vou gerar os "getters" e "setters" desse atributo "empresa". 

Pronto. Está implementado, tudo certo. 

Por enquanto eu não tenho mais nada para fazer com o "Terceirizado", apenas a representação do objeto terceirizado e depois vai ter persistência com banco de dados, ele vai ser exibido em alguma tela. Enfim, está aqui implementado.

Porém acabamos de utilizar herança com o "extends" do "Funcionario" que é um recurso bem interessante de orientação a objetos, um recurso que te permite ter reaproveitamento de código. 

Em vez de virmos na classe "Funcionario" e dar um "Ctrl + C" em todos os atributos, métodos e colar na classe "Terceirizado", ficar com código meio duplicado, nós utilizamos a herança para reaproveitar.

Então isso evita código duplicado. 

É um excelente recurso da orientação a objetos. 

```diff
- Porém, a herança, temos que tomar cuidado quando utilizamos a herança em um projeto porque às vezes ao utilizar a herança nós podemos estar gerando um efeito colateral. 

- Então temos que pensar muito bem nesse indicativo de herança. Pensar naquela premissa.
```

**Estou dizendo que terceirizado é "extends Funcionario", então estou dizendo "Terceirizado" é um funcionário**. 

E será que realmente essa premissa é válida para esse projeto? 

Um terceirizado é um funcionário? 

Pode até fazer sentido, "Poxa, ele é um funcionário. 

Ele vai trabalhar na empresa, ele tem um cargo, tem um salário, tem um nome, tem um CPF". Enfim, ele é um funcionário.

Porém precisamos pensar na classe que estamos herdando, na classe "Funcionario". 

Lembra que quando usamos herança, nós herdamos tudo. 

Então tudo que está na classe "Funcionario", o "Terceirizado" herdou. 

E aí temos que pensar, tudo que está aqui na classe "Funcionario" faz sentido na classe "Terceirizado"? 

E aí que está o problema. 

Às vezes usamos herança e aí acaba caindo nesse problema. 

Nem tudo que estamos herdando faz sentido.

**Às vezes podemos estar herdando coisas demais, coisas que não deveria e que pode gerar um efeito colateral.** 

E aqui um exemplo é a questão da promoção e do reajuste também. 

Tanto a parte da promoção quando a parte de atualizar salário, vamos imaginar nesse projeto como que funciona a regra. 

O terceirizado não pode ser promovido e ele não pode ter reajuste salarial porque quem cuida do cargo e do salário do terceirizado é a empresa desse terceirizado, não é a nossa empresa.

Nós só contratamos a outra empresa e ela é que vai administrar os seus funcionários. 

A única coisa que precisamos ter aqui é um controle de quem são os terceirizados que estão trabalhando para nós. 

Então ao utilizar a herança aqui na classe "Funcionario" acabamos ganhando um método "atualizarSalario" e um método "promover" que não deveria ser válido para um terceirizado.

```diff
- O terceirizado não pode ter esses métodos. 
```

Inclusive, lembra da nossa classe "PromocaoService"? 

O método "promover" recebe como parâmetro um funcionário. 

Eu posso passar um objeto do tipo "Terceirizado". 

Compila e funciona porque "Terceirizado" "extends Funcionario". 

Então todas as classes que herdarem de funcionários, vão poder ser passados como parâmetros objetos do tipo delas aqui para esse método "promover". E aí está o efeito colateral.

Eu vou estar permitindo a promoção de funcionários e de terceirizados que não deveria acontecer, apenas para funcionários que deveria acontecer. 

E aí está o problema. 

É um problema bem difícil de detectar porque compila tudo. 

Não vai dar um erro de compilação. 

É mais de você ter essa sacada de bater o olho, de lembrar da regra de negócio e ver que isso vai ferir essa regra de negócio.

E aí o que poderíamos fazer para resolver esse problema? 

Tem algumas soluções que o pessoal utiliza. 

Então uma solução seria, na classe "Terceirizado" reescrever aqueles métodos. 

O método "promover" e o método "atualizarSalario". 

Nós reescrevemos esses dois métodos. Só que por padrão aqui ele chama o "super". E aí o que fazemos? Deixa vazio? Se chamar o "promover" não faz nada.

Só que daí fica meio esquisito isso. 

Eu tenho um método que não faz nada. 

Para que tem esse método então se ele não faz nada? 

Só por causa da herança? 

Ou tem gente que joga uma exception aqui. 

Se esse método for jogado lança uma exception. 

Só que aí também fica esquisito. 

Eu tenho um método que sempre lança exception. 

Exception é para quando tem alguma situação inesperada, algum caso alternativo. Não sempre que for chamado.

E aí fica com esse problema, fica esse negócio meio esquisito no código. 

Então isso pode ser um indício de que: 

**"Opa, não estou usando a herança da maneira correta, estou herdando coisas que eu não deveria herdar"**. 

#### Composiçao ao inves de herança
Então uma solução mais elegante seria utilizar composição em vez de herança. 

Seria aqui na classe "Terceirizado", não dar um "extends" na classe "Funcionario".

"Poxa Rodrigo, se eu não der um "extends" eu vou ter que copiar todos esses atributos?" 

Não. 

Nós podemos extrair esses atributos de "Funcionarios" que são comuns, menos a data do último reajuste no caso para uma classe. 

Poderia extrair para uma classe "DadosPessoais" e aqui fazer isso private DadosPessoais dadosPessoais. 

Pronto. 

E aí "DadosPessoais" também é comum lá para o "Terceirizado"?

Então eu também declaro aqui um atributo "DadosPessoais", private DadosPessoais. 

Então todo mundo que tiver "DadosPessoais" vai ter um atributo "DadosPessoais". Vai ser uma composição. Então o "Terceirizado" não é mais um funcionário, ele tem dados pessoais. Apenas os dados que são compartilhados. E aí com isso você evitaria o código duplicado. Percebe?

Então essa é até uma dica, uma boa prática de orientação a objetos, favorecer a composição em vez de a herança. Se a herança não está fazendo sentido, veja se a composição pode ser utilizada para você não usar herança, mas mesmo assim evitar códigos duplicados.

Então toma cuidado quando for utilizar a herança porque às vezes a herança gera esse efeito colateral.

#### DadosPessoais
```
public class DadosPessoais {
    private String nome;
	private String cpf;
	

    // Getters e setters
}

```
#### Funcionario
```
public class Funcionario extends DadosPessoais{

	private DadosPessoais dadosPessoais;
	private Cargo cargo;
	private BigDecimal salario;
	private LocalDate dataUltimoReajuste;

	public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		this.salario = salario;
	}

	public void atualizarSalario(BigDecimal novoSalario) {
		this.salario = novoSalario;
		this.dataUltimoReajuste = LocalDate.now();
	}

	public void promover(Cargo novoCargo) {
		this.cargo = novoCargo;
	}
  ...

  //getters e setters
```
#### Terceirizados
```
public class Terceirizado extends DadosPessoais{
    private String empresa;
    private DadosPessoais dadosPessoais;

    //getters e setters
}

```

#### Herança
Sabemos que, ao estender uma classe através da herança, devemos sempre respeitar os contratos (interfaces) de seus métodos.

Por que nossa classe Terceirizado estava estendendo de forma indesejada um comportamento?

R: Porque estava herdando métodos que não faziam sentido para ela

 Alguns métodos herdados não deveriam existir nessa classe.

### Liskov Substituition Principle
Então o que discutimos e implementamos no último vídeo foi relacionado ao princípio e a letra L do SOLID que é o Liskov Substitution Principle, princípio da substituição de Liskov. 

E foi a Barbara Liskov a engenheira de software que trabalhava com computação e pensou nesse princípio e a ideia é quando você utiliza herança que você tem que tomar cuidado para você não ferir esse princípio.

```diff
+ "Se parece com pato, se faz 'quack' igual um pato, mas precisa de baterias, então não é um pato, você está usando uma abstração errada". 
```

Então é justamente um pato de borracha, ele não é um pato de verdade, ele precisa de pilha ou algo do gênero para funcionar.

Ele até é parecido, a forma, o jeito, mas ele não é um pato de verdade. 

Então é aquela questão da herança que vimos. 

Quando usamos herança de maneira errada, acabamos tendo um comportamento inesperado, algo que é parecido com o outro, a classe era parecida com a outra e usamos herança para reaproveitar, às vezes por preguiça e aí geramos um efeito colateral que nem recebeu.

Então o princípio de Liskov tenta resolver essa questão quando você trabalha com herança. 

E aí esse que é o princípio. 

Tem esse texto aqui que é um pouco complicado, mas vamos lá. 

"Se q(x) ' – , a função q(x) – ' é uma propriedade demonstrável dos objetos x do tipo T, então q(y) ' - que é um outro objeto – ' deve ser verdadeiro para objetos Y do tipo S, se S for um subtipo de T".

Então essa é a frase da Barbara Liskov para descrever esse princípio e é bem confusa, meio complicada de entender, Mas a ideia é justamente aquela que vimos na classe "PromocaoService". 

Eu tenho aqui o q(x), uma função. 

No caso a função se chama a "promover" e ela recebe um objeto do tipo "funcionario". 

E se eu passar um objeto "funcionario" ela vai ter um comportamento.

Se eu passar um objeto que herda de funcionário, eu não deveria gerar um efeito colateral. 

Já que ele está herdando de "funcionario", então tudo deveria funcionar normalmente. 

Só que aí que estava o problema. 

O terceirizado, quando estávamos usando a herança que eu tinha proposto, ele não era bem um funcionário, ele estava herdando só que não era para ser promovido, não era para eu passar um terceirizado como parâmetro para o método "promover". 

Então ferimos o princípio de Liskov.

Nós usamos a herança de maneira errada só para reaproveitar alguns atributos e acabou tendo comportamentos inesperados, tendo funções que não deveriam receber aquele tipo de objeto. 

E tendo métodos, aquele método "promover" e o "atualizarSalario" na classe terceirizada que eram métodos que não faziam sentido.

Então eram métodos que iam ficar vazios ou iam jogar exception, métodos que não faziam o menor sentido de existir nessa classe específica. 

Então era um exemplo de como ferir o princípio de Liskov. E a ideia é que você evite ferir esse princípio quando for trabalhar com herança porque isso gera efeitos colaterais na sua aplicação. 

Vai ter comportamentos inesperados quando você substituir uma classe pela outra.

Você tem uma classe base, a classe mãe e se você a substituir pela classe filha quando for chamar um método, isso pode gerar um efeito colateral. 

```diff
- Então se gerou esse efeito colateral, o princípio de Liskov não foi seguido e aí você vai ter uma inconsistência na sua aplicação e isso vai gerar problemas de manutenção. 
```

Talvez você também pudesse ter "if" e "else" no código.

"If", classe e a instância do tipo tal faz assim e aí já começa a complicar o seu código. 

Então esse é o princípio, essa que era a discussão dessa aula sobre esse princípio e ele aparece mais quando trabalhamos com herança.

Ele é um pouco confuso de entender quando você ler essa frase, mas a ideia é essa, tome cuidado quando for usar herança e se possível, aqui o exemplo eu tinha proposto, use composição.

E é até uma recomendação do livro "Effective Java", Java Efetivo, do Joshua Bloch, um dos engenheiros que trabalhou na "Sun", no desenvolvimento do Java que ele recomenda favorecermos e priorizar a composição. 

Não é que a herança seja ruim e você sempre tem que evitá-la, é só para tomar cuidado porque às vezes a herança vai gerar um efeito colateral.

Então às vezes a composição poderia fazer mais sentido. 

E aqui eu tinha feito aquela proposta de criar uma classe "DadosPessoais" com os atributos nome, CPF, cargo e salário que são atributos comuns tanto para funcionário quanto para terceirizado. 

E agora a classe "funcionario" tem um atributo "DadosPessoais" e a terceirizado também tem um atributo "DadosPessoais".

Ela não herda mais de funcionário, terceirizado não é um funcionário. 

Parece funcionário, tem gosto de funcionário, mas não é um funcionário. 

#### alternativa a herança
Qual seria uma alternativa quando a herança não fizer sentido?

R: Utilizar composição.
 Essa é uma das maneiras de evitar a herança sem duplicação de código.

### o que aprendemos?
* que, embora a herança favoreça o reaproveitamento de codigo, ela pode trazer efeitos colaterais quando nao utilizada da maneira correta
* que o Principio de Substituiçao de Liskov (LSP) diz que devemos poder substituir classes base por suas classes derivadas em qualquer lugar, sem problema.

## trabalahando com abstraçoes
### criando abstraçoes com interfaces e poliformismo
Na última aula discutimos sobre o princípio da letra L, o princípio de substituição de Liskov com a utilização de herança e vimos como tomar certos cuidados na hora de utilizar a herança para não criar efeitos colaterais na aplicação e a composição como uma alternativa.

E na aula de hoje vamos discutir sobre um outro princípio e vamos voltar aqui para aquela classe "ReajusteService". 

Não sei se vocês lembram, aqui tínhamos implementado esse método "ReajustarSalario" do funcionário que recebe o funcionário, qual foi o aumento concedido a ele e nós executávamos aquelas validações, aquelas regras de negócio que no caso foram duas validações que acabamos separando para classes distintas.

Então tem a validação do percentual de aumento que o funcionário não pode receber um aumento cujo valor seja maior do que 40% do salário atual e a validação da periodicidade que o funcionário só pode receber um reajuste a cada 6 meses. 

Então acabamos extraindo para classes separadas. 

E aqui na classe "ReajusteService" nós só fazemos essa chamada para aquelas duas classes.

Porém quando implementamos essa classe, acabamos implementando de uma outra maneira que ficou até bem mais interessante porque na realidade esse código do "ReajustarSalario", deixa eu só descer ele aqui, ele era para ficar da seguinte maneira. 

Eu ia precisar ter um objeto do tipo ValidacaoPercentualReajuste = new ValidacaoPercentualReajuste().

Eu deveria instanciar a classe que faz a validação. 

E eu também tenho aquela outra validação, ValidacaoPeriodicidadeEntreReajustes, vou instanciar essa classe, new ValidacaoPeriodicidadeEntreReajustes(). 

E com os dois objetos instanciados, aí sim eu pego cada uma das validações, validacaoPercentualReajuste.validar, passo o "funcionario" e passo o "aumento", pego a outra validação da periodicidade ".validar", passo o "funcionario", passo o "aumento".

Então era para ficar assim na realidade o código. 

Então nós extraímos as duas validações e aqui precisamos chamá-las, precisamos instanciar a classe, chamar um método, passar os parâmetros. Então o código deveria ter ficado assim. 

Porém se tivéssemos deixado esse código dessa maneira, nós íamos estar seguindo o S do SOLID, o *Single Responsibility Principle" porque íamos ter separado cada validação em uma classe.

Então cada classe cuida da sua única validação, só tem um único motivo para mudar. 

```diff
- Não está com aquele monte de validações misturadas e nós não íamos estar seguindo da maneira correta, 
- da maneira ideal o princípio O que era o foco da aula onde implementamos esse código que era o Open-Closed.
```

Porque toda vez que surgisse uma nova validação, além de ter que criar a classe com a validação, nós íamos ter que mexer na classe "ReajusteService" e teríamos que instanciar um novo objeto e chamar o método "validar". 

Então nós íamos estar tendo que mexer em vários pontos da aplicação. 

Só que fomos um pouco mais espertos. 

Nós percebemos o seguinte, essas duas classes de validação, elas meio que seguem um mesmo contrato.

Ela só tem um único método que faz a validação de um funcionário e um aumento. 

Então colocamos o mesmo método, a mesma assinatura do método. 

E aí lembramos que quando eu tenho isso no Java, eu tenho uma ou mais classes que estão implementando o mesmo método só que cada uma faz de um jeito, mas é o mesmo método, temos aquele conceito de interface. 

E criamos a interface "ValidacaoReajuste".

E o método "validar" está aqui definido na interface e as duas classes implementam essa interface. 

E assim seria a regra, toda nova validação nós íamos criar uma nova classe que implementa automaticamente essa interface para ter aqui o mesmo método, a mesma assinatura. 

E com isso, na classe "ReajusteService" não precisamos instanciar cada uma das validações, nós podemos referenciar a interface que foi exatamente o que fizemos aqui.

No construtor do "ReajusteService" nós recebemos um "List" de "ValidacaoReajuste" que é a interface. 

Então na classe "ReajusteService" nós não sabemos qual é a classe de validação que vai ser chamada, quais são as classes. 

Se é uma, se são duas, três, dez. 

Não sei quais são as classes, não sei qual é a implementação de cada uma. 

Então a nossa classe "ReajusteService" não está dependendo de classes concretas diretamente e isso é uma coisa muito boa porque classe é algo que é mais instável.

**Classe é um tipo de código que mexemos o tempo inteiro**. 

Nós precisamos dar manutenção, precisamos alterar. 

Essa classe aqui mesmo do percentual, pode ser que esse percentual mude, pode ser que tenha uma outra regra relacionada com o percentual. 

Então vamos estar constantemente mexendo na classe.

**Agora, uma interface costuma ser mais estável, costuma mudar menos porque a interface está só definindo um contrato.** 

Então pensa nas interfaces do Java, a interface "List", por exemplo, ela muda com muito menos frequência do que o "array List", do que é uma classe concreta.

```diff
+ Então isso é algo importante, procurarmos sempre depender de coisas mais estáveis como interfaces, por exemplo, aqui no Java porque elas dão mais segurança, elas são mais estáveis. 
```

Então acabamos com isso automaticamente diminuindo o acoplamento que foi um dos princípios que discutimos na primeira aula aqui do curso.

Um dos princípios importantes, um dos pilares da orientação a objetos do acoplamento que tínhamos até discutido que não tem como eliminarmos o acoplamento, mas a ideia é que você reduza esse acoplamento ou se possível se acople com coisas que são mais estáveis, como interfaces.

E quando nós implementamos o Open-Closed Principle nós já seguimos esse princípio, nós já nos acoplamos com uma interface que no caso foi a interface de "Validacao". 

E nós implementamos essas validações seguindo essa interface. 

Favoreceu o princípio do Open-Closed. 

Se eu quiser criar uma nova validação, é só criar uma nova classe implementando a interface.

Eu não preciso mexer na classe "ReajusteService", eu não preciso mexer nesse método "ReajustarSalario". 

Automaticamente eu posso passar para cá uma nova lista contendo esse terceiro objeto do tipo "ValidacaoReajuste". 

Então percebe que o código está flexível, está extensível e ele é muito mais estável. 

Essa classe aqui é muito estável porque ela depende apenas de coisas estáveis que são interfaces.

E sem querer querendo, quando implementamos o Open-Closed Principle, nós acabamos implementando desse jeito aqui, acabamos automaticamente meio que sem querer implementando o outro princípio do SOLID. 


### Dependency Inversion Principle
Princípio da Inversão de Dependência — Dependa de abstrações e não de implementações.
De acordo com Uncle Bob, esse princípio pode ser definido da seguinte forma:
1. Módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender da abstração.
2. Abstrações não devem depender de detalhes. Detalhes devem depender de abstrações.
   
```diff
- No contexto da programação orientada a objetos, é comum que as pessoas confundam a INVERSÃO DE DEPENDÊNCIA com a INJEÇÃO DE DEPENDÊNCIA, porém são coisas distintas, mas que relacionam entre si com um proposito em comum, deixar o código desacoplado.
```
Importante: **Inversão de Dependência não é igual a Injeção de Dependência**, fique ciente disso! 

A Inversão de Dependência é um princípio (Conceito) e a Injeção de Dependência é um padrão de projeto (Design Pattern).



Na última aula discutimos sobre aquela implementação da classe "ReajusteService" quando implementamos o Open-Closed Principle e aí de brinde **acabamos implementando também com aquele uso de interfaces e do polimorfismo um outro princípio do SOLID que é a letra D, que é o Dependency Inversion Principle**, princípio da inversão de dependências.

Então a ideia é o seguinte: 
```diff
+ se você quer ligar uma lâmpada na sua casa, quer colocar lá uma lâmpada no quarto você não pega um fio e solda diretamente na tomada. voce usa um bocal, e esse bocal é a abstraçao.

+ ficamos dependentes da abstraçao (bocal) e nao da implementaçao (lampada)
```

Não é dessa maneira que você faz. 

Até daria para fazer desse jeito, mas aí seria algo muito estranho e até perigoso.

Então você simplesmente coloca um bocal no teto e pluga a lâmpada no bocal. 

O bocal já abstrai essa complexidade, essa questão do fio que está soldado e que está interligado de maneira elétrica com a tomada. 

Então o bocal é uma abstração. 

E aí nós simplesmente plugamos a lâmpada nessa abstração e não precisa ir lá manualmente soldar um fio na tomada. 

Então essa que é a ideia do Dependency Inversion.

Então a ideia é que 
```diff
+ abstrações não devem depender de implementações. 
+ A abstração deve ser totalmente abstrata. 
+ Ela não depende de nenhuma implementação específica. 
+ A implementação sim é que deveria depender de uma abstração. 
```

E foi exatamente o que fizemos aqui na implementação.

Nós temos essas implementações de validações, "ValidacaoPeriodicidade", "ValidacaoPercentualReajuste" e elas dependem de uma abstração que é o conceito de validação de reajuste que é justamente essa interface. 

Então são as implementações que estão dependendo da abstração, que é a interface, que é o conceito de validar um reajuste e não o contrário. 

Não é essa abstração que está dependendo de uma implementação específica.

Até porque eu posso ter mais de uma implementação, posso querer trocar essa implementação com o menor impacto possível no meu código. 

Então foi justamente isso que fizemos aqui quando utilizamos o Open-Closed Principle. 

Nós acabamos implementando junto o Dependency Inversion Principle. 

E a letra O do SOLID é o meu princípio favorito.

Eu gosto muito desse princípio porque no geral quando implementamos aquela letra O, acabamos implementando três princípios em uma tacada só. 

Nós acabamos implementando o **SO** e o **D**, o SOD que eu chamo. 

Você implementa o **Open-Closed Principle** e provavelmente você vai separar as implementações em classes distintas, então "Opa, já implementei o S, o **Single Responsibility Principle** porque cada implementação está em uma classe separada.

E se você for esperto, utilizar uma abstração, uma interface, o polimorfismo da orientação a objetos, você de quebra também implementa a letra D que é o **princípio da inversão de dependência**. 

Então eu gosto muito do O do SOLID porque quando implementamos ele, não é automático mas já somos induzidos a implementar o S e o D juntos.

Então implementamos os três em uma tacada só e o nosso código fica muito mais fácil de dar manutenção e muito mais fácil de estender, de adicionar novas características. 

Nós ficarmos dependendo de coisas estáveis, de interfaces. E nós adicionamos coisas no projeto criando classes novas.

Nós não precisamos mexer em código existente que é sempre um risco de quebrar alguma coisa que já estava funcionando. 

Então a letra O é a minha favorita do SOLID. 

Espero que vocês tenham gostado dessa sacada e que sempre levem isso em consideração quando for implementar esse padrão e veja se, de quebra, já não consegue implementar os outros dois juntos.

#### vantagem ao criar dependencias com interfaces
aprendemos o conceito de Dependency Inversion Principle.

Que vantagem temos ao depender de interfaces e não de implementações?

R: Caso uma determinada implementação mude, não seremos afetados, pois dependemos apenas de sua interface.

  Se um método muda a forma como realiza sua tarefa, desde que a interface se mantenha, não vamos precisar nos preocupar nem em editar o nosso código.

### Interface Segregation Principle
```diff
+ Princípio da Segregação da Interface — Uma classe não deve ser forçada a implementar interfaces e métodos que não irão utilizar.
```
Esse princípio basicamente diz que é melhor criar interfaces mais específicas ao invés de termos uma única interface genérica.


Então agora nessa aula vamos discutir sobre o último princípio que ficou faltando. 

Vamos imaginar que por algum motivo você precisou transformar o "Reajuste". 

Em vez de ser uma informação você transformou ele em uma interface. Então você quer utilizar polimorfismo, você vai ter vários tipos de reajustes. 

E aí você vai ter um tratamento para cada tipo de reajuste. 

Então você criou uma interface chamada "Reajuste".

E na interface tem dois métodos, "valor" e "data". Então de todos os reajustes você precisa saber qual é o valor do reajuste e qual foi a data daquele reajuste. 

E vamos considerar que nós temos dois tipos de reajuste aqui no projeto. 

Nós temos o "Anuenio". 

Toda vez que a pessoa completa um ano na empresa ela recebe esse reajuste. 

Então Anuenio implements Reajuste {.

E aí ele tem um atributo "valor" e "data", recebe aqui no construtor e está implementado aqueles dois métodos, "valor" e "data" devolvendo os atributos. 

E nós também temos um outro tipo de reajuste que é a promoção, quando um funcionário é promovido que também é um reajuste, também tem lá um valor e uma data. 

Bem parecido com a classe "Anuenio".

Então você implementou dessa maneira e provavelmente você vai ter uma outra classe que recebe como parâmetro a interface "Reajuste" para poder utilizar o polimorfismo e aí você pode passar tanto o "Anuenio" quanto "Promocao" como parâmetros que já eles estão implementando essa interface. 

Porém surgiu uma nova necessidade na aplicação, você precisa também dentro de todo o reajuste saber qual que foi o cálculo do imposto, o valor do imposto.

Então vamos criar um outro método aqui que devolve um BigDecimal valorImposto().

Então todo o reajuste, além de ter um valor que é o valor do reajuste em si e tem o valor do imposto, imposto de renda, por exemplo. 

Vamos colocar valorImpostoDeRenda() só para simplificar. 

E aí automaticamente criei um novo método nessa interface. 

As duas classes pararam de compilar porque eu preciso dizer qual é o valor do imposto de renda.

Então vamos considerar, vamos implementar aqui na classe "Promocao". 

O valor do imposto de renda para promoção é sempre, vamos pensar aqui e simular, que é sempre 10% do valor do reajuste. 

Então return valor que é o valor do reajuste .multiply (new BigDecimal) e aí vamos passar aqui como parâmetro. BigDecimal com "B" maiúsculo.

Então vai ser o BigDecimal("0.1") que é 10%. 

Então esse que é o valor do imposto de renda. 

Eu pego o valor do reajuste e multiplico por 0.1 e dá 10%. 

No "Anuenio" o que acontece? 

Vamos pensar o seguinte, "Promocao" ou sempre que o funcionário sobe de cargo ele tem que pagar 10% de imposto de renda. 

Mas "Anuenio" vamos considerar que é isento de imposto de renda. 

Então não tem cobrança de imposto de renda para "Anuenio".

Só que como o "Anuenio" está implementando aquela interface, nós precisamos ter um método "valorImpostoDeRenda". 

Só que o que devolvemos aqui? 

Devolvemos 0? 

Nós poderíamos devolver aqui BigDecimal.ZERO. 

Só que aí é que está, será que faz sentido mesmo eu devolver zero? 

Zero é o imposto para "Anuenio"? 

E se mudar isso aqui depois? E não for zero, receber um valor de restituição, por exemplo, enfim.

Então fica meio estranho isso, "valorImpostoDeRenda". 

Nós fomos obrigados a ter esse método por conta da interface. 

Só que pode acontecer essa situação.

Nem todas as classes vão fazer sentido ter esse método. 

Só que você é obrigado a ter esse método porque você está implementando uma interface e sempre que você implementa uma interface você é obrigado a sobrescrever e implementar todos os métodos. 

E aí está o problema.

Então o último princípio que vamos lidar aqui no caso do SOLID é o princípio chamado de **segregação de interface**. 

Esse princípio diz que às vezes nós vamos ser obrigados a implementar uma interface que não faz sentido para nós. 

Nem sempre todas as interfaces fazem sentido. 

Então a ideia é justamente essa. 

```diff
+ Uma classe não deveria ser forçada a implementar de métodos que não utilizará.
```

E aí o Uncle Bob novamente com esse princípio. Então ali caímos nesse problema.

Nós temos uma classe, no caso o "Anuenio" e ela está sendo obrigada a implementar um método que não faz sentido. 

Então aqui poderíamos devolver nulo, devolver zero. 

Então percebe, é comum, às vezes acontecer isso. 

Nós estamos implementando uma interface e precisa adicionar um novo método nessa interface, só que esse método não faz sentido para todas as classes que estão implementando.

Parecido com o que íamos fazer com aquela classe "Terceirizado". 

Nós íamos herdar de "Funcionario" e íamos ter um método "promover" e um método "atualizarSalario" que não fazem sentido para o "Terceirizado". 

Então percebe, nós temos que sempre tomar esse cuidado. 

Como que resolveríamos aqui nesse caso?

Poderíamos fazer o seguinte, já que nem toda classe faz sentido esse método aqui, então poderíamos fazer o seguinte, **criar uma outra interface**. 

Vou criar uma outra interface aqui chamada "ReajusteTributavel", por exemplo.

Então eu tenho o "Reajuste" e eu tenho o "ReajusteTributavel". 

Esse método do imposto de renda eu tiro ele e jogo para o "ReajusteTributavel".

Então no "ReajusteTributavel" a única diferença é que eu tenho esse método a mais. 

E aí o que eu poderia fazer? Eu poderia na classe "Promocao" implementar a interface "Reajuste". 

Só que na classe "Anuenio" eu implemento o "Reajuste". 

Então eu não tenho o método "ImpostoDeRenda", eu só tenho o método "valor" e "data".

Mas na classe "Promocao" eu implemento o "Reajuste" e implemento o "ReajusteTributavel", por exemplo. 

Então aqui sim eu implemento o método "valorImpostoDeRenda". 

Para não esquecer, para não ter problema, o que nós poderíamos fazer? Implementar "ReajusteTributavel" e "ReajusteTributavel" herdar de "Reajuste". 

Então pronto, "ReajusteTributavel" é um tipo de reajuste.

A diferença é que ele tem um método a mais. 

E na classe Promocao implements ReajusteTributavel. 

Então implementando "ReajusteTributavel" que herda de "Reajuste", automaticamente eu também estou implementando "Reajuste". 

Então percebe, as novas classes, os novos tipos de reajuste, se eles precisarem ser tributáveis é só herdar a interface "ReajusteTributavel".

Se não tem tributação de imposto de renda ele vai implementar a interface "Reajuste". 

Percebe, ficou muito mais flexível aqui. 

Então eu não forço uma classe a ter métodos que ela não vai precisar e essa é a ideia do princípio da segregação de interfaces. 

Esse era o último princípio que ficou faltando para fecharmos a nossa aula.

#### Reajuste
```
public interface Reajuste {

    BigDecimal valor();
    LocalDate data();
}
```

#### ReajusteTributavel
```
public interface ReajusteTributavel extends Reajuste{
    BigDecimal valorImpostoDeRenda();
}

```

#### Anuenio
```
public class Anuenio implements Reajuste{
    
    private BigDecimal valor;
    private LocalDate data;

    public Anuenio(BigDecimal valor) {
        this.valor = valor;
        this.data = LocalDate.now();
    }
    //getters e setters
}
```

#### Promocao
```
public class Promocao implements ReajusteTributavel {
    private BigDecimal valor;
    private LocalDate data;

    public Promocao (BigDecimal valor) {
        this.valor = valor;
        this.data = LocalDate.now();
    }

    @Override
    public BigDecimal valorImpostoRenda() {
        return valor.multiply(new BigDecimal("0.1"));
    }

    //getters e setters
}
```

#### Definicao do ISP
 ao separar as interfaces, implementamos o Interface Segregation Principle.

Qual a definição formal deste princípio?

R:Classes não devem ser obrigadas a implementar métodos que não irão precisar.
  Uma classe não deve ser obrigada a implementar um método de determinada interface, se ele não será útil. Para isso, uma interface deverá ser extraída apenas com os métodos necessários.

### o que aprendemos?
* que é mais interessante e mais seguro para o nosso codigo depender de interfaces (classes abstratas, assinaturas de metodos e interfaces em si) do que das implementaçoes de uma classe
* que as interfaces sao menos propensas a sofrer mudanças enquanto implementaçoes podem mudar a qualquer momento
* que o Principio de Inversao de Dependencia (DIP) diz que implementaçoes devem depender de abstraçoes e abstraçoes nao devem depender de implementaçoes
* que as interfaces devem definir apenas os metodos que fazem sentido para seu contexto
* que o Principio de Segregaçao de Interfaces (ISP) diz que uma classe nao dese ser obrigada a implementar um metodo que ela nao precisa
* os conceitos aprendidos neste treinamento formam o acronimo SOLID
  * Single Resposibility Principle
  * Open Closed Principle
  * Liskov Substituition Principle
  * Interface Segregation Principle
  * Dependency Inversion Principle


