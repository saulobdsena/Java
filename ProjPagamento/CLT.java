package ProjPagamento;

public class CLT implements Pagamento{

    private float salario;

    public CLT(float salario) {
        this.salario = salario;
    }

    @Override
    public float getSaldo() {
        return this.salario;
    }
}
