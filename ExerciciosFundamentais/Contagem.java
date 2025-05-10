package ExerciciosFundamentais;
import java.util.Scanner;

public class Contagem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe a quantidade de alunos ");
        int quantidade = sc.nextInt();
        int contador = 0;
        int i = 0;

        while (i < quantidade){
            int nota = sc.nextInt();
            if(nota >= 50){
                contador+=1;
            }
            i++;
        }

        System.out.println("O numero de alunos aprovados é de: " + contador);

        sc.close();
    }
}
