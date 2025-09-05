package ProjAluno;

import java.util.List;
import java.util.ArrayList;

public class TurmaDao {

    List<Aluno> listaDao = new ArrayList<>();
    public List<Aluno> load(){

        listaDao.add(new Aluno("Paulo","241122"));
        listaDao.add(new Aluno("Lucas","233344"));
        listaDao.add(new Aluno("Andre","433555"));

        return listaDao;
    }

    public void save(Aluno a){
        listaDao.add(a);
    }

    public void update(int index, Aluno a) {
        if (index >= 0 && index < listaDao.size()) {
            listaDao.set(index, a);

        }
    }
        public void delete () {
            List<Aluno> listDao = new ArrayList<>();
            listDao.remove(new Aluno("Andre", "433555"));
        }

    }
