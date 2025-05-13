package ExerciciosFundamentais;
import java.util.Scanner;

public class Fatorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o numero ");
        int n =  sc.nextInt();
        int fatorial = 1;
        int i = n;

        while(i >= 1){
            fatorial *=i;
            i = i - 1;
        }

        System.out.println("O fatorial de " + n + " é " + fatorial);

        sc.close();
    }
}
