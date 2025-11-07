package TrabalhoDBConn;

public class Test2 {
    DBConn db = DBConn.getInstance();

    public void Escreverlog(){
        db.conectar("Test 2 tudo certo!");
    }
}
