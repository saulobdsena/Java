package TrabalhoDBConn;

public class Main {
    public static void main(String[] args) {

        DBConn db = DBConn.getInstance();

        db.conectar("Minha primeira instancia na main");

        Test1 t1 = new Test1();
        Test2 t2 = new Test2();
        Test3 t3 = new Test3();

        t1.Escreverlog();
        t2.Escreverlog();
        t3.Escreverlog();
    }
}
