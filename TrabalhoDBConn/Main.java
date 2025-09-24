package TrabalhoDBConn;

public class Main {
    public static void main(String[] args) {

        DBConn db = DBConn.getInstance();

        db.conectar("Minha primeira instancia na main");

        Teste1 t1 = new Teste1();
        Test2 t2 = new Test2();
        Test3 t3 = new Test3();

        t1.EscreveLog();
        t2.EscreveLog();
        t3.EscreveLog();
    }
}
