import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Object> ListaEmpregado = new ArrayList<>();
        
        System.out.println("Quantos empregados deseja cadastrar? ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){

            System.out.println("Qual seria o ID? ");
            int id = sc.nextInt();

            System.out.println("Qual seria um nome");
            sc.nextLine();
            String nome = sc.nextLine();

            System.out.println("Qual o salario? ");
            double salario = sc.nextDouble();
            Empregado e = new Empregado(id, nome, salario);

            ListaEmpregado.add(e);
        }

        for(Object obj : ListaEmpregado){
            System.out.println(obj);
        }


    }
} 
