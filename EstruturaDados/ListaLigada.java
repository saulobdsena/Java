package EstruturaDados;
public class ListaLigada {
        private Elemento ultimo;
        private Elemento primeiro;
        private int tamanho;
    

        public ListaLigada() {
            this.tamanho = 0;
        }


        public Elemento getUltimo() {
            return ultimo;
        }
        public void setUltimo(Elemento ultimo) {
            this.ultimo = ultimo;
        }
        public Elemento getPrimeiro() {
            return primeiro;
        }
        public void setPrimeiro(Elemento primeiro) {
            this.primeiro = primeiro;
        }
        public int getTamanho() {
            return tamanho;
        }
        public void setTamanho(int tamanho) {
            this.tamanho = tamanho;
        }

    public void adicionarValor(String novoValor){
        Elemento novoElemento = new Elemento(novoValor);
        if(this.primeiro == null && this.ultimo == null){
            this.primeiro = novoElemento;   
            this.ultimo = novoElemento;
        }
        else{
            this.ultimo.setProximo(novoElemento);
            this.ultimo = novoElemento;
        }
        tamanho++;
    }

    public void removerValor(String novoValor){

    }

    public Elemento get(int posicao){
        Elemento atual = this.primeiro;
        for(int i = 0; i <= posicao; i++){
            if(atual.getProximo() != null){
                atual = atual.getProximo();
            }
        }
        return atual;
    }
    
}
