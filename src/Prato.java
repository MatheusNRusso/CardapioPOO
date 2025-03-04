// Curso de Tecnologia em Sistemas de Computação
// Disciplina: Programação Orientada a Objetos
// Classe para representar um prato do cardápio

public class Prato {
    private String nome;
    private float preco;
    private String categoria;

    // Construtor para inicializar um prato com nome, preço e categoria
    public Prato(String nome, float preco, String categoria) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome do prato não pode ser vazio.");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("O preço do prato deve ser positivo.");
        }
        if (categoria == null || categoria.isEmpty()) {
            throw new IllegalArgumentException("A categoria do prato não pode ser vazia.");
        }
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    // Métodos para obter informações do prato
    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }

    // Método para exibir as informações do prato
    public void exibirInfo() {
        System.out.printf("%s -> R$ %.2f \n", nome, preco);
    }
}
