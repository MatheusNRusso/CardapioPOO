// Curso de Tecnologia em Sistemas de Computação
// Disciplina: Programação Orientada a Objetos
// Classe para representar um cardápio de uma unidade

import java.util.ArrayList;

public class Cardapio {
    private String cidade;
    private ArrayList<Prato> pratos;

    // Construtor para inicializar o cardápio com o nome da cidade
    public Cardapio(String cidade) {
        this.cidade = cidade;
        pratos = new ArrayList<>();
    }

    // Método para obter o nome da cidade
    public String getCidade() {
        return cidade;
    }

    // Método para adicionar um prato ao cardápio
    public void adicionarPrato(Prato prato) {
        pratos.add(prato);
    }

    // Método para exibir os pratos de uma determinada categoria
    public void exibirPratosPorCategoria(String categoria) {
        for (Prato prato : pratos) {
            if (prato.getCategoria().equalsIgnoreCase(categoria)) {
                prato.exibirInfo();
            }
        }
    }

    // Método para calcular o total de preço e quantidade de pratos de uma categoria
    public float[] calcularTotalPorCategoria(String categoria) {
        float totalPreco = 0;
        int totalQuantidade = 0;
        for (Prato prato : pratos) {
            if (prato.getCategoria().equalsIgnoreCase(categoria)) {
                totalPreco += prato.getPreco();
                totalQuantidade++;
            }
        }
        return new float[]{totalPreco, totalQuantidade};
    }

    // Método para obter todos os pratos do cardápio
    public ArrayList<Prato> getPratos() {
        return pratos;
    }
}
