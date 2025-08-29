package ProjPagamento;

import java.util.ArrayList;
import java.util.List;

public class Folha {

    private float saldo;
    private List<Pagamento> funcionarios;

    public Folha() {
        this.saldo = 0.0f;
        this.funcionarios = new ArrayList<Pagamento>();

    }

    public void calcular() {
        for(Pagamento p : funcionarios){
            this.saldo += p.getSaldo();
        }
    }

    public float getSaldo(){
        return this.saldo;
    }

    public void add(Pagamento pag){
        this.funcionarios.add(pag);
    }
}
