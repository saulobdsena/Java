package ProjPagamento;

public class Main {
    public static void main(String[] args) {
        Pagamento c1 = new Contrato(1500.0f);
        Pagamento c2 = new Contrato(1500.0f);
        Pagamento e1 = new Estagio(700.0f);
        Pagamento clt1 = new CLT(2000.0f);
        Pagamento clt2 = new CLT(3000.0f);


        Folha f1 = new Folha();

        f1.add(c1);
        f1.add(c2);
        f1.add(clt2);
        f1.add(clt1);
        f1.add(e1);

        f1.calcular();

        System.out.println("Saldo da folha de Pagamento:" + f1.getSaldo());


    }
}

