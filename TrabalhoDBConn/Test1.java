package TrabalhoDBConn;

public class Test1 {

    DBConn db = DBConn.getInstance();

    public void Escreverlog(){
        db.conectar("Test 1 tudo certo!");
    }
}
