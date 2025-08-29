package ProjPagamento;

public class Contrato implements Pagamento{
    private float salario;

    public Contrato(float sal){
        this.salario = sal;
    }

    public float getSaldo(){
        return this.salario;
    }
}