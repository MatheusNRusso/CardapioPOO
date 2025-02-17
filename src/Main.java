// Curso de Tecnologia em Sistemas de Computação
// Disciplina: Programação Orientada a Objetos
// Aluno: Matheus Nogueira Russo

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seja bem-vindo(a)!");
        // Solicitar o número de unidades a serem cadastradas
        System.out.print("Quantas unidades serão cadastradas? ");
        int numUnidades = scanner.nextInt();
        scanner.nextLine(); // Limpar quebra de linha pendente
        // ArrayList para armazenar os cardápios das unidades
        ArrayList<Cardapio> cardapios = new ArrayList<>();
        for (int i = 0; i < numUnidades; i++) {
            // Solicitar o arquivo do cardápio para cada unidade
            System.out.print("Arquivo da Unidade " + (i + 1) + ": ");
            String arquivo = scanner.nextLine();
            arquivo = "cardapiosFiles/" + arquivo; // Adicionado o diretório padrão
            Cardapio cardapio = null;
            String cidade = "";
            boolean arquivoValido = false;
            while (!arquivoValido) {
                try {
                    // Ler o arquivo do cardápio e criar o cardápio para a unidade
                    Scanner fileScanner = new Scanner(new File(arquivo));
                    if (fileScanner.hasNextLine()) {
                        cidade = fileScanner.nextLine().trim();
                        cardapio = new Cardapio(cidade);
                    }
                    while (fileScanner.hasNextLine()) {
                        // Ler cada linha do arquivo e adicionar os pratos ao cardápio
                        String linha = fileScanner.nextLine().trim();
                        if (linha.isEmpty()) continue; // Ignorar linhas vazias
                        String[] dados = linha.split(";");
                        String nome, categoria;
                        float preco;
                        if (dados.length >= 3) {
                            nome = dados[0].trim();
                            preco = Float.parseFloat(dados[1].trim());
                            categoria = dados[2].trim();
                            Prato prato = new Prato(nome, preco, categoria);
                            cardapio.adicionarPrato(prato);
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
        // Obter todas as categorias disponíveis em todos os cardápios
        Set<String> categoriasDisponiveis = new HashSet<>();
        for (Cardapio cardapio : cardapios) {
            for (Prato prato : cardapio.getPratos()) {
                categoriasDisponiveis.add(prato.getCategoria().toLowerCase());
            }
        }
        // Loop para interagir com o usuário e exibir os resultados
        while (true) {
            System.out.print("Escolha uma categoria, ou digite '0' para encerrar: ");
            String categoria = scanner.nextLine().toLowerCase();
            if (categoria.equals("0")) {
                break;
            }
            if (!categoriasDisponiveis.contains(categoria)) {
                System.out.println("Categoria inválida." + "\n" + "Por favor, escolha uma categoria válida.");
                continue;
            }
            float totalPrecoGeral = 0;
            int totalQuantidadeGeral = 0;
            // Calcular e exibir o total de preço e quantidade por categoria para todas as unidades
            for (int i = 0; i < cardapios.size(); i++) {
                Cardapio cardapio = cardapios.get(i);
                float[] resultado = cardapio.calcularTotalPorCategoria(categoria);
                System.out.printf("(%s): Quantidade = %d, Preço = R$ %.2f\n",
                        cardapio.getCidade(), (int) resultado[1], resultado[0]);
                totalPrecoGeral += resultado[0];
                totalQuantidadeGeral += resultado[1];
            }
            // Exibir o total geral de preço e quantidade por categoria
            System.out.printf("Total: Quantidade = %d, Preço = R$ %.2f\n", totalQuantidadeGeral, totalPrecoGeral);
            // Perguntar se o usuário deseja exibir os detalhes dos pratos
            System.out.print("Exibir Detalhes ('s' ou 'n')? ");
            String detalhes = scanner.nextLine();
            if (detalhes.equalsIgnoreCase("s")) {
                for (Cardapio cardapio : cardapios) {
                    System.out.printf("%s\n", cardapio.getCidade());
                    cardapio.exibirPratosPorCategoria(categoria);
                }
            } else {
                System.out.println("Categoria inválida. Por favor, escolha uma categoria válida.");
            }
        }
        // Fechar o scanner ao final do programa
        scanner.close();
    }
}
