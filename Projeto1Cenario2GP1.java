public class Projeto1Cenario2GP1 {
    // Define o número de estações (6 neste caso)
    static final int N = 6;
    
    // Define os nomes das estações de metrô
    static String[] estacoes = {"Shopping", "Parque", "Terminal", "Centro", "Praça", "Avenida"};

    // Matriz de adjacência do metrô (0 = sem conexão, 1 = conexão direta)
    static int[][] matrizMetro = {
            {1, 1, 0, 0, 0, 0},  // Shopping
            {0, 1, 1, 1, 0, 0},  // Parque
            {0, 1, 1, 0, 0, 0},  // Terminal
            {1, 0, 0, 1, 1, 0},  // Centro
            {0, 0, 0, 0, 1, 0},  // Praça
            {1, 0, 0, 1, 1, 1}   // Avenida
    };

    // Matriz de adjacência do ônibus
    static int[][] matrizOnibus = {
            {0, 1, 0, 0, 0, 1},  // Shopping
            {1, 0, 0, 1, 0, 0},  // Parque
            {0, 0, 0, 1, 0, 0},  // Terminal
            {0, 1, 1, 0, 0, 1},  // Centro
            {0, 0, 0, 0, 0, 0},  // Praça
            {1, 0, 0, 1, 1, 0}   // Avenida
    };

    // Verifica se a matriz é reflexiva
    public static boolean isReflexiva(int[][] matriz) {
        for (int i = 0; i < N; i++) {
            // Para ser reflexiva, a diagonal principal precisa ser 1
            if (matriz[i][i] != 1) return false;
        }
        return true;
    }

    // Verifica se a matriz é simétrica
    public static boolean isSimetrica(int[][] matriz) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // Para ser simétrica, a[i][j] deve ser igual a a[j][i]
                if (matriz[i][j] != matriz[j][i]) return false;
            }
        }
        return true;
    }

    // Verifica se a matriz é antissimétrica
    public static boolean isAntissimetrica(int[][] matriz) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // Para ser antissimétrica, se a[i][j] == 1, então a[j][i] deve ser 0
                if (i != j && matriz[i][j] == 1 && matriz[j][i] == 1) return false;
            }
        }
        return true;
    }

    // Verifica se a matriz é transitiva
    public static boolean isTransitiva(int[][] matriz) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // Se há uma conexão de i para j (a[i][j] == 1)
                if (matriz[i][j] == 1) {
                    // Verifica se para todo k existe uma conexão de j para k implica uma de i para k
                    for (int k = 0; k < N; k++) {
                        if (matriz[j][k] == 1 && matriz[i][k] == 0) return false;
                    }
                }
            }
        }
        return true;
    }

    // Calcula a composição de duas matrizes de adjacência (A e B)
    public static int[][] composicao(int[][] A, int[][] B) {
        int[][] resultado = new int[N][N];  // Inicializa a matriz de resultado
        // Realiza a composição de A e B
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    // Se existe uma conexão de i para k em A e de k para j em B, então existe uma conexão de i para j
                    if (A[i][k] == 1 && B[k][j] == 1) {
                        resultado[i][j] = 1;
                        break;  // Se encontrou uma conexão, não precisa continuar verificando
                    }
                }
            }
        }
        return resultado;
    }

    // Método para imprimir uma matriz de adjacência de forma legível
    public static void imprimirMatriz(int[][] matriz, String titulo) {
        System.out.println("\n" + titulo);
        // Imprime o cabeçalho com os nomes das estações
        System.out.printf("%-12s", "");
        for (int i = 0; i < N; i++) {
            System.out.printf("%-12s", estacoes[i]);
        }
        System.out.println();
        // Imprime as linhas da matriz com os nomes das estações
        for (int i = 0; i < N; i++) {
            System.out.printf("%-12s", estacoes[i]);
            for (int j = 0; j < N; j++) {
                System.out.printf("%-12d", matriz[i][j]);
            }
            System.out.println();
        }
    }

    // Método principal
    public static void main(String[] args) {
        // Análise das propriedades da matriz de adjacência do metrô
        System.out.println("Análise das propriedades da matriz de adjacência do metrô:");
        System.out.println("- Reflexiva: " + (isReflexiva(matrizMetro) ? "Sim" : "Não"));
        System.out.println("- Simétrica: " + (isSimetrica(matrizMetro) ? "Sim" : "Não"));
        System.out.println("- Antissimétrica: " + (isAntissimetrica(matrizMetro) ? "Sim" : "Não"));
        System.out.println("- Transitiva: " + (isTransitiva(matrizMetro) ? "Sim" : "Não"));

        // Verifica se é uma relação de equivalência ou ordem parcial
        boolean equivalencia = isReflexiva(matrizMetro) && isSimetrica(matrizMetro) && isTransitiva(matrizMetro);
        boolean ordemParcial = isReflexiva(matrizMetro) && isAntissimetrica(matrizMetro) && isTransitiva(matrizMetro);

        // Exibe se a matriz é uma relação de equivalência ou ordem parcial
        System.out.println("- É uma relação de equivalência? " + (equivalencia ? "Sim" : "Não"));
        System.out.println("- É uma relação de ordem parcial? " + (ordemParcial ? "Sim" : "Não"));

        // Calcula a composição entre as matrizes de metrô e ônibus
        int[][] composicao = composicao(matrizMetro, matrizOnibus);
        // Imprime a matriz resultante da composição
        imprimirMatriz(composicao, "Composição entre Metrô e Ônibus:");
    }
}
