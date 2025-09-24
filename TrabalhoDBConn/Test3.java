package TrabalhoDBConn;

public class Test3 {
    DBConn db = DBConn.getInstance();

    public void Escreverlog(){
        db.conectar("Test 3 tudo certo!");
    }
}
