// Curso de Tecnologia em Sistemas de Computação
// Disciplina: Programação Orientada a Objetos
// Aluno: Matheus Nogueira Russo

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seja bem-vindo(a)!");

        // Solicitar o número de unidades a serem cadastradas
        System.out.print("Quantas unidades serão cadastradas? ");
        int numUnidades = scanner.nextInt();
        scanner.nextLine(); // Limpar quebra de linha pendente

        // Lista para armazenar os cardápios das unidades
        ArrayList<Cardapio> cardapios = new ArrayList<>();

        for (int i = 0; i < numUnidades; i++) {
            System.out.print("Arquivo da Unidade " + (i + 1) + ": ");
            String arquivo = scanner.nextLine();
            arquivo = "cardapiosFiles/" + arquivo; // Adicionar o diretório padrão

            boolean arquivoValido = false;
            while (!arquivoValido) {
                try {
                    Scanner fileScanner = new Scanner(new File(arquivo));
                    String cidade = fileScanner.hasNextLine() ? fileScanner.nextLine().trim() : "";
                    Cardapio cardapio = new Cardapio(cidade);

                    while (fileScanner.hasNextLine()) {
                        String linha = fileScanner.nextLine().trim();
                        if (linha.isEmpty()) continue;

                        String[] dados = linha.split(";");
                        if (dados.length >= 3) {
                            String nome = dados[0].trim();
                            float preco = Float.parseFloat(dados[1].trim());
                            String categoria = dados[2].trim();
                            cardapio.adicionarPrato(new Prato(nome, preco, categoria));
                        } else {
                            System.out.println("Formato inválido para linha: " + linha);
                        }
                    }
                    fileScanner.close();
                    cardapios.add(cardapio);
                    arquivoValido = true;
                } catch (FileNotFoundException e) {
                    System.out.println("Arquivo não encontrado: " + arquivo);
                    System.out.print("Por favor, insira o nome do arquivo novamente: ");
                    arquivo = scanner.nextLine();
                } catch (NumberFormatException e) {
                    System.out.println("Formato de preço inválido no arquivo: " + arquivo);
                    System.out.print("Por favor, insira o nome do arquivo novamente: ");
                    arquivo = scanner.nextLine();
                }
            }
        }

        // Obter todas as categorias disponíveis
        Set<String> categoriasDisponiveis = new HashSet<>();
        for (Cardapio cardapio : cardapios) {
            for (Prato prato : cardapio.getPratos()) {
                categoriasDisponiveis.add(prato.getCategoria().toLowerCase());
            }
        }

        // Menu principal
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Visualizar categorias disponíveis");
            System.out.println("2 - Escolher uma categoria para visualizar pratos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            if (opcao.equals("0")) {
                break;
            } else if (opcao.equals("1")) {
                System.out.println("Categorias disponíveis:");
                for (String categoria : categoriasDisponiveis) {
                    System.out.println("- " + categoria);
                }
            } else if (opcao.equals("2")) {
                System.out.print("Digite a categoria desejada: ");
                String categoriaEscolhida = scanner.nextLine().toLowerCase();

                if (!categoriasDisponiveis.contains(categoriaEscolhida)) {
                    System.out.println("Categoria inválida. Por favor, escolha uma categoria válida.");
                    continue;
                }

                float totalPrecoGeral = 0;
                int totalQuantidadeGeral = 0;

                for (Cardapio cardapio : cardapios) {
                    float[] resultado = cardapio.calcularTotalPorCategoria(categoriaEscolhida);
                    System.out.printf("(%s): Quantidade = %d, Preço = R$ %.2f\n",
                            cardapio.getCidade(), (int) resultado[1], resultado[0]);
                    totalPrecoGeral += resultado[0];
                    totalQuantidadeGeral += resultado[1];
                }

                System.out.printf("Total: Quantidade = %d, Preço = R$ %.2f\n", totalQuantidadeGeral, totalPrecoGeral);

                System.out.print("Exibir Detalhes ('s' ou 'n')? ");
                String detalhes = scanner.nextLine();

                if (detalhes.equalsIgnoreCase("s")) {
                    for (Cardapio cardapio : cardapios) {
                        System.out.printf("\n%s\n", cardapio.getCidade());
                        cardapio.exibirPratosPorCategoria(categoriaEscolhida);
                    }
                }
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }
}
