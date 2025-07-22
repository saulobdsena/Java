public class Projeto1Cenario2GP1Ajustado {
    static final int N = 6;
    static String[] estacoes = {"Shopping", "Parque", "Terminal", "Centro", "Praça", "Avenida"};

    static int[][] matrizMetro = {
            {1, 1, 0, 0, 0, 0},
            {0, 1, 1, 1, 0, 0},
            {0, 1, 1, 0, 0, 0},
            {1, 0, 0, 1, 1, 0},
            {0, 0, 0, 0, 1, 0},
            {1, 0, 0, 1, 1, 1}
    };

    // Fecho Reflexivo
    public static int[][] fechoReflexivo(int[][] matriz) {
        for (int i = 0; i < N; i++) {
            matriz[i][i] = 1; // Adiciona laços reflexivos
        }
        return matriz;
    }

    // Fecho Simétrico
    public static int[][] fechoSimetrico(int[][] matriz) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matriz[i][j] == 1) {
                    matriz[j][i] = 1; // Adiciona simetria
                }
            }
        }
        return matriz;
    }

    // Fecho Transitivo (Algoritmo de Warshall)
    public static int[][] fechoTransitivo(int[][] matriz) {
        int[][] fecho = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fecho[i][j] = matriz[i][j];
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    fecho[i][j] = fecho[i][j] | (fecho[i][k] & fecho[k][j]);
                }
            }
        }

        return fecho;
    }

    // Verifica se a matriz é reflexiva
    public static boolean isReflexiva(int[][] matriz) {
        for (int i = 0; i < N; i++) {
            if (matriz[i][i] != 1) return false;
        }
        return true;
    }

    // Verifica se a matriz é simétrica
    public static boolean isSimetrica(int[][] matriz) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matriz[i][j] != matriz[j][i]) return false;
            }
        }
        return true;
    }

    // Verifica se a matriz é antissimétrica
    public static boolean isAntissimetrica(int[][] matriz) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && matriz[i][j] == 1 && matriz[j][i] == 1) return false;
            }
        }
        return true;
    }

    // Verifica se a matriz é transitiva
    public static boolean isTransitiva(int[][] matriz) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matriz[i][j] == 1) {
                    for (int k = 0; k < N; k++) {
                        if (matriz[j][k] == 1 && matriz[i][k] == 0) return false;
                    }
                }
            }
        }
        return true;
    }

    // Verifica se a matriz é assimétrica
    public static boolean isAssimetrica(int[][] matriz) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // Para ser assimétrica, a matriz não deve ser simétrica
                // e a[i][j] != a[j][i] para todos os i != j
                if (i != j && matriz[i][j] == 1 && matriz[j][i] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // Método para imprimir uma matriz de adjacência de forma legível
    public static void imprimirMatriz(int[][] matriz, String titulo) {
        System.out.println("\n" + titulo);
        System.out.printf("%-12s", "");
        for (int i = 0; i < N; i++) {
            System.out.printf("%-12s", estacoes[i]);
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.printf("%-12s", estacoes[i]);
            for (int j = 0; j < N; j++) {
                System.out.printf("%-12d", matriz[i][j]);
            }
            System.out.println();
        }
    }

    // Identifica a Relação de Equivalência ou Ordem
    public static void verificarRelacao(int[][] matriz) {
        boolean equivalencia = isReflexiva(matriz) && isSimetrica(matriz) && isTransitiva(matriz);
        boolean ordemParcial = isReflexiva(matriz) && isAntissimetrica(matriz) && isTransitiva(matriz);

        System.out.println("- A relação é de equivalência? " + (equivalencia ? "Sim" : "Não"));
        System.out.println("- A relação é de ordem parcial? " + (ordemParcial ? "Sim" : "Não"));
    }

    // Identifica os elementos Maximais e Minimais
    public static void identificarMaxMin(int[][] matriz) {
        System.out.print("- Elementos maximais: ");
        for (int i = 0; i < N; i++) {
            boolean maximal = true;
            for (int j = 0; j < N; j++) {
                if (matriz[i][j] == 1 && i != j) {
                    maximal = false;
                    break;
                }
            }
            if (maximal) System.out.print(estacoes[i] + " ");
        }

        System.out.print("\n- Elementos minimais: ");
        for (int i = 0; i < N; i++) {
            boolean minimal = true;
            for (int j = 0; j < N; j++) {
                if (matriz[j][i] == 1 && i != j) {
                    minimal = false;
                    break;
                }
            }
            if (minimal) System.out.print(estacoes[i] + " ");
        }

        System.out.println();
    }

    // Identifica o maior e menor elemento da relação
    public static void identificarMaiorMenor(int[][] matriz) {
        int maiorElemento = -1, menorElemento = -1;

        for (int i = 0; i < N; i++) {
            boolean maior = true, menor = true;
            for (int j = 0; j < N; j++) {
                if (matriz[i][j] == 1 && i != j) menor = false; // Não é o menor
                if (matriz[j][i] == 1 && i != j) maior = false; // Não é o maior
            }
            if (maiorElemento == -1 && maior) maiorElemento = i;
            if (menorElemento == -1 && menor) menorElemento = i;
        }

        System.out.println("- Maior elemento: " + (maiorElemento != -1 ? estacoes[maiorElemento] : "Nenhum"));
        System.out.println("- Menor elemento: " + (menorElemento != -1 ? estacoes[menorElemento] : "Nenhum"));
    }

    public static void main(String[] args) {
        // Gerando fechos para a matriz do metrô
        System.out.println("Análise das propriedades da matriz de adjacência do metrô:");

        System.out.println("- Reflexiva: " + (isReflexiva(matrizMetro) ? "Sim" : "Não"));
        System.out.println("- Simétrica: " + (isSimetrica(matrizMetro) ? "Sim" : "Não"));
        System.out.println("- Assimétrica: " + (isAssimetrica(matrizMetro) ? "Sim" : "Não"));
        System.out.println("- Antissimétrica: " + (isAntissimetrica(matrizMetro) ? "Sim" : "Não"));
        System.out.println("- Transitiva: " + (isTransitiva(matrizMetro) ? "Sim" : "Não"));

        // Gerando fechos, caso as propriedades não sejam atendidas
        if (!isReflexiva(matrizMetro)) {
            matrizMetro = fechoReflexivo(matrizMetro);
            imprimirMatriz(matrizMetro, "Fecho Reflexivo do Metrô:");
        }

        if (!isSimetrica(matrizMetro)) {
            matrizMetro = fechoSimetrico(matrizMetro);
            imprimirMatriz(matrizMetro, "Fecho Simétrico do Metrô:");
        }

        if (!isTransitiva(matrizMetro)) {
            matrizMetro = fechoTransitivo(matrizMetro);
            imprimirMatriz(matrizMetro, "Fecho Transitivo do Metrô:");
        }

        // Verificando a relação (Equivalência ou Ordem)
        verificarRelacao(matrizMetro);

        // Identificando os elementos maximais e minimais
        identificarMaxMin(matrizMetro);

        // Identificando o maior e menor elemento
        identificarMaiorMenor(matrizMetro);
    }
}
