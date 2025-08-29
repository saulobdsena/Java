package ProjAluno;
import java.util.List;

public class Turma {

    private List<Aluno> listaAlunos;
    private TurmaDao turmaDao;

    public Turma() {
        turmaDao = new TurmaDao();
        listaAlunos = turmaDao.load();

    }

    public float calcMedia(){
        return 0.0F;
    }

    public List getAlunos(){
        return listaAlunos;
    }

    public int getTotalAlunos() {
        int tamanho = this.listaAlunos.size();
        return tamanho;
    }

    public Aluno add(Aluno a){
        listaAlunos.add(a);
        return a;
    }

    public void delete(Aluno a){
        listaAlunos.remove(a);

    }
}