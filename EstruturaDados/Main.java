public class Main{
    public static void main(String args[]){
    ListaLigada lista = new ListaLigada();
    System.out.println(lista.getTamanho());
    lista.adicionarValor("AC");
    lista.adicionarValor("BA");
    lista.adicionarValor("CE");
    lista.adicionarValor("DFF");
    System.out.println("Tamanho: " + lista.getTamanho());
    System.out.println("Primeiro: " + lista.getPrimeiro().getValor());
    System.out.println("Ultimo: " + lista.getUltimo().getValor());


    }
}