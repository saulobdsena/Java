package ProjPagamento;

public class Estagio implements Pagamento{

    private float bolsa;


    public Estagio(float bolsa) {
        this.bolsa = bolsa;
    }

    @Override
    public float getSaldo() {
        return this.bolsa;
    }


}