# CardápioPOO

## Sobre o Projeto
O **CardápioPOO** é um sistema em Java desenvolvido como parte da avaliação do primeiro semestre de 2024 da disciplina de **Programação Orientada a Objetos** do curso de **Tecnologia em Sistemas de Computação** na UFF. O sistema permite gerenciar cardápios de diferentes unidades de um restaurante, permitindo a consulta de pratos por categoria e a visualização das categorias disponíveis antes da seleção.

## Funcionalidades
- Cadastro de múltiplas unidades do restaurante a partir de arquivos de texto.
- Consulta de pratos por categoria, com exibição de quantidade e preço total.
- Opção para exibir os detalhes dos pratos.
- **Nova funcionalidade:** Visualização das categorias disponíveis antes da seleção.

## Como Executar o Projeto

### 1. Clonar o Repositório
```bash
git clone https://github.com/MatheusNRusso/CardapioPOO.git
cd CardapioPOO
```

### 2. Compilar o Projeto
```bash
javac src/*.java
```

### 3. Executar o Programa
```bash
java src.Main
```

## Formato dos Arquivos de Cardápio
Cada unidade deve possuir um arquivo de texto com o seguinte formato:
```
<NOME DA CIDADE>
<NOME DO PRATO>;<PREÇO>;<CATEGORIA>
<NOME DO PRATO>;<PREÇO>;<CATEGORIA>
...
```

**Exemplo (`cardapio1.txt`):**
```
Niterói
Filé Mignon;59.90;Prato Principal
Risoto de Camarão;45.00;Prato Principal
Tiramisu;12.00;Sobremesa
```

## Exemplo de Execução
```
Seja bem-vindo(a)!
Quantas unidades serão cadastradas? 3
Arquivo da Unidade 1: cardapio1.txt
Arquivo da Unidade 2: cardapio2.txt
Arquivo da Unidade 3: cardapio3.txt

Menu:
1 - Visualizar categorias disponíveis
2 - Escolher uma categoria para visualizar pratos
0 - Sair
Escolha uma opção: 1
Categorias disponíveis:
- sobremesa
- prato principal
- prato
- entrada
- drink
- bebida

Menu:
1 - Visualizar categorias disponíveis
2 - Escolher uma categoria para visualizar pratos
0 - Sair
Escolha uma opção: 2
Digite a categoria desejada: sobremesa
(Unidade Niterói): Quantidade = 1, Preço = R$ 12,00
(Unidade São Gonçalo): Quantidade = 1, Preço = R$ 15,00
(Unidade Maricá): Quantidade = 1, Preço = R$ 10,00
Total: Quantidade = 3, Preço = R$ 37,00
Exibir Detalhes ('s' ou 'n')? s

Unidade Niterói
Tiramisu -> R$ 12,00

Unidade São Gonçalo
Brownie de Chocolate -> R$ 15,00

Unidade Maricá
Banana Split -> R$ 10,00

Menu:
1 - Visualizar categorias disponíveis
2 - Escolher uma categoria para visualizar pratos
0 - Sair
Escolha uma opção: 0
Programa encerrado.
```

## Licença
Este projeto é de uso acadêmico e pode ser modificado conforme a necessidade. Caso queira utilizar para fins comerciais, consulte o autor.

---
Desenvolvido por **Matheus Nogueira Russo**


