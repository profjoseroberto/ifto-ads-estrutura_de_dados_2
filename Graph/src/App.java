import java.io.IOException;
import java.util.Scanner;

import edu.edii.graph.adjMatrix.*;

public class App {
    public static void main(String[] args) throws Exception {
        WeightedGraph<String> g = new WeightedGraph<>(10);
        Scanner input = new Scanner(System.in);
        int opcaoMenu = 0;
        do {
            clear();
            listarMenu();

            opcaoMenu = lerOpcaoMenu(input);
            if (!processarOpcaoMenu(input, opcaoMenu, g)) {
                System.out.println("Opção inválida. Tente novamente...");
                Thread.sleep(2000);
            }

        } while (opcaoMenu != 7);

        input.close();
        clear();
    }

    private static void clear() throws InterruptedException, IOException {
        System.out.println("Nome do SO: " + System.getProperty("os.name").contains("Windows"));
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            new ProcessBuilder("sh", "-c", "clear").inheritIO().start().waitFor();
    }

    private static void listarMenu() {
        System.out.println("MENU");
        System.out.println("1. Inserir cidades");
        System.out.println("2. Inserir distâncias entre cidades");
        System.out.println("3. Listar cidades");
        System.out.println("4. Listar distâncias");
        System.out.println("5. Excluir cidade");
        System.out.println("6. Excluir distâncias entre cidades");
        System.out.println("7. Sair");
    }
    private static int lerOpcaoMenu(Scanner input) {
        System.out.println("Escolha uma opção:");
        int opcaoEscolhida = input.nextInt();
        return opcaoEscolhida;
    }

    private static boolean processarOpcaoMenu(Scanner input, int opcaoMenu, WeightedGraph<String> g)
            throws IOException, InterruptedException {
        switch (opcaoMenu) {
            case 1:
                /* Inserir vertices */
                inserirCidade(input, g);
                return true;
            case 2:
                /* Inserir arestas */
                mapearDistanciaCidades(input, g);
                return true;
            case 3:
                /* listar vertices */
                clear();
                System.out.println("==LISTA DE CIDADES==");
                listarCidades(g);
                System.out.println("Tecle em qualquer número para voltar.");
                input.next();
                return true;
            case 4:
                /* Listar arestas */
                clear();
                System.out.println("==MAPEAMENTO DAS DISTÂNCIAS==");
                g.show();
                System.out.println("Tecle em qualquer número para voltar.");
                input.next();
                return true;
            case 5:
                /* excluir vertice */
                excluirCidade(input, g);
                return true;
            case 6:
                /* excluir aresta */
                excluirMapeamento(input, g);
                return true;
            case 7:
                /* sair do programa */
                quit();
                return true;
            default:
                return false;
        }
    }

    private static void quit() throws InterruptedException {
        System.out.println("Saindo do programa...");
        Thread.sleep(500);
    }

    private static void listarCidades(WeightedGraph<String> g) {
        for (int j = 0; j < g.vertices().size(); j++) {
            System.out.format("%d - %s \n", g.vertices().indexOf(g.vertices().get(j)), g.vertices().get(j));
        }
        System.out.format("Número de cidades: %d \n", g.numVertice());
    }

    private static void inserirCidade(Scanner input, WeightedGraph<String> g) throws InterruptedException, IOException {

        boolean opcaoMenu = true;
        while (opcaoMenu) {
            clear();
            System.out.println("==INSERINDO CIDADES==");
            System.out.println("Cidades cadastradas");
            listarCidades(g);
            System.out.println(">> Nova cidade");
            System.out.println("Escreva o nome da cidade:");
            try {
                String cidade = input.next();
                g.insertVertice(cidade);

                listarCidades(g);
                System.out.println("Deseja inserir mais uma cidade? (0 - NÃO / 1 - SIM)");

                opcaoMenu = processarSimOuNao(input.nextInt());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                Thread.sleep(2000);
            }
        }
    }

    private static void excluirCidade(Scanner input, WeightedGraph<String> g) throws InterruptedException, IOException {
        boolean opcaoMenu = true;
        while (opcaoMenu) {
            clear();
            System.out.println("==EXCLUIR CIDADES==");
            System.out.println("Cidades cadastradas");
            listarCidades(g);
            System.out.println(">> Nova cidade");
            System.out.println("Indique o indice da cidade a ser removida:");
            int indexCidade = input.nextInt();
            try {
                g.deleteVertice(indexCidade);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                Thread.sleep(2000);
            }

            listarCidades(g);
            System.out.println("Deseja excluir mais uma cidade? (0 - NÃO / 1 - SIM)");
            opcaoMenu = processarSimOuNao(input.nextInt());
        }
    }

    private static void mapearDistanciaCidades(Scanner input, WeightedGraph<String> g)
            throws InterruptedException, IOException {

        boolean opcaoMenu = true;
        while (opcaoMenu) {
            clear();
            System.out.println("==MAPEANDO A DISTÂNCIA ENTRE CIDADES==");
            System.out.println("Mapa atual");
            g.show();
            System.out.println("Indice das cidades");
            listarCidades(g);
            System.out.println(">> Novo mapeamento");
            System.out.println("Digite na ordem: indice da cidade 1, indice da cidade 2 e distância");
            System.out.print("Indice da cidade 1: ");
            int v1 = input.nextInt();
            System.out.format("\nIndice da cidade 2: ");
            int v2 = input.nextInt();
            System.out.format("\nDistância: ");
            int weight = input.nextInt();
            try {
                g.insertEdge(v1, v2, weight);
            } catch (Exception e) {
                System.out.println(e.getMessage().toUpperCase());
                Thread.sleep(2000);
            }

            Thread.sleep(500);
            g.show();
            System.out.println("Deseja mapear mais uma distância? (0 - NÃO / 1 - SIM)");
            opcaoMenu = processarSimOuNao(input.nextInt());
        }
    }

    private static void excluirMapeamento(Scanner input, WeightedGraph<String> g)
            throws InterruptedException, IOException {

        boolean opcaoMenu = true;
        while (opcaoMenu) {
            clear();
            System.out.println("==EXCLUINDO A DISTÂNCIA ENTRE CIDADES==");
            System.out.println("Mapa atual");
            g.show();
            System.out.println("Indice das cidades");
            listarCidades(g);
            System.out.println(">> Indices das cidades do mapeamento a ser excluído:");
            System.out.println("Digite na ordem: indice da cidade 1, indice da cidade 2");
            System.out.print("Indice da cidade 1:");
            int v1 = input.nextInt();
            System.out.format("\n Indice da cidade 2: ");
            int v2 = input.nextInt();
            try {
                g.deleteEdge(v1, v2);
            } catch (Exception e) {
                System.out.println(e.getMessage().toUpperCase());
                Thread.sleep(2000);
            }

            Thread.sleep(500);
            g.show();
            System.out.println("Deseja excluir outro mapeamento? (0 - NÃO / 1 - SIM)");
            opcaoMenu = processarSimOuNao(input.nextInt());
        }
    }

    private static boolean processarSimOuNao(int opcao){
        switch (opcao) {
            case 1:
                return true;
            default:
                return false;
        }
    }
    
}
