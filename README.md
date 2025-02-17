## CardápioPOO

        ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white) ![POO](https://img.shields.io/badge/POO-Oriented%20to%20Objects-blue)

        Este projeto foi desenvolvido como parte da disciplina de **Programação Orientada a Objetos** no curso de **Tecnologia em Sistemas de Computação** da UFF. O objetivo é criar um sistema para gerenciar cardápios de diferentes unidades de um restaurante.

        ---

        ## Índice

        1. [Descrição do Projeto](#descrição-do-projeto)
        2. [Estrutura do Projeto](#estrutura-do-projeto)
        3. [Como Executar o Projeto](#como-executar-o-projeto)
        4. [Formato dos Arquivos de Entrada](#formato-dos-arquivos-de-entrada)
        5. [Funcionalidades Principais](#funcionalidades-principais)
        6. [Contribuições](#contribuições)
        7. [Licença](#licença)
        8. [Contato](#contato)

        ---

        ## Descrição do Projeto

        Este sistema permite gerenciar cardápios de diferentes unidades de um restaurante. Ele lê arquivos de texto contendo informações sobre os pratos (nome, preço e categoria), exibe os pratos por categoria, calcula totais de preço e quantidade, e interage com o usuário para fornecer detalhes específicos.

        ---

        ## Estrutura do Projeto

        ```
        .
        ├── cardapiosFiles       -> Arquivos de entrada com os cardápios
        │   ├── cardapio1.txt
        │   ├── cardapio2.txt
        │   └── cardapio3.txt
        ├── src                  -> Código-fonte do projeto
        │   ├── Main.java        -> Classe principal com o método main
        │   ├── Prato.java       -> Classe para representar um prato
        │   └── Cardapio.java    -> Classe para representar um cardápio
        ├── README.md            -> Documentação do projeto
        └── .gitignore           -> Arquivos a serem ignorados pelo Git
        ```

        ---

        ## Como Executar o Projeto

        ### Pré-requisitos

        - **Java JDK**: Certifique-se de ter o Java instalado na sua máquina. Você pode baixá-lo [aqui](https://www.oracle.com/java/technologies/javase-downloads.html).
        - **Git**: Para clonar o repositório, você precisa do Git instalado. Baixe-o [aqui](https://git-scm.com/).

        ### Passos para Executar

        1. **Clone o repositório:**
        ```bash
        git clone https://github.com/seu-usuario/javaPOO_2024.git
        ```

        2. **Navegue até o diretório do projeto:**
        ```bash
        cd javaPOO_2024
        ```

        3. **Certifique-se de que os arquivos de cardápio estão na pasta `cardapiosFiles`.**
        - Exemplo de estrutura:
        ```
        cardapiosFiles/
        ├── cardapio1.txt
        ├── cardapio2.txt
        └── cardapio3.txt
        ```

        4. **Compile o projeto:**
        ```bash
        javac src/*.java
        ```

        5. **Execute o programa:**
        ```bash
        java src.Main
        ```

        6. **Insira o número de unidades e os nomes dos arquivos de cardápio quando solicitado.**
        - Os arquivos serão buscados automaticamente na pasta `cardapiosFiles`.

        ---

        ## Formato dos Arquivos de Entrada

        Os arquivos de cardápio devem seguir este formato:

        ```
        NomeDaCidade
        Prato1;Preço1;Categoria1
        Prato2;Preço2;Categoria2
        Prato3;Preço3;Categoria3
        ```

        ### Exemplo (`cardapio1.txt`):
        ```
        Rio de Janeiro
        Feijoada;25.99;Prato Principal
        Pudim;8.50;Sobremesa
        Caipirinha;12.00;Bebida
        ```

        ---

        ## Funcionalidades Principais

        - **Leitura de Arquivos**: O programa lê arquivos `.txt` contendo informações de cardápios.
        - **Exibição de Pratos por Categoria**: Exibe os pratos de uma determinada categoria.
        - **Cálculo de Totais**: Calcula o total de preço e quantidade de pratos por categoria.
        - **Interação com o Usuário**: Permite ao usuário escolher categorias e exibir detalhes dos pratos.

        ---

        ## Contribuições

        Contribuições são bem-vindas! Se você deseja contribuir para este projeto, siga os passos abaixo:

        1. Faça um fork deste repositório.
        2. Crie uma nova branch (`git checkout -b feature/nova-funcionalidade`).
        3. Commit suas mudanças (`git commit -m 'Adicionando nova funcionalidade'`).
        4. Envie as mudanças para o repositório remoto (`git push origin feature/nova-funcionalidade`).
        5. Abra um Pull Request.

        ---

        ## Licença

        Este projeto está licenciado sob a [MIT License](LICENSE).

        ---

        ## Contato

        Se tiver dúvidas ou sugestões, entre em contato:

        - **Email**: matheusnrs@id.uff.br
        - **GitHub**: [Seu Perfil no GitHub](https://github.com/seu-usuario)

        ---

        ## Agradecimentos

        - **Universidade Federal Fluminense (UFF)**: Pelo suporte acadêmico.
        - **Professores e Colegas**: Pelas discussões e aprendizados durante o curso.

