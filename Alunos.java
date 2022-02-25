import java.util.ArrayList;

public class Alunos {
    int matricula;
    int nota;

    public Alunos(int m,int n) {
        this.matricula = m;
        this.nota = n;
    }

    public int getMatricula() {
        return matricula;
    }

    public int getNota() {
        return nota;
    }

    public int cr(ArrayList<Materia> m) {
        int notaParcial = 0;
        int notaTotal = 0;
        int cargaHorariaTotal = 0;
        for(int i = 0;i<m.size();i++) {
            if(m.get(i).getMatricula() == getMatricula())
                cargaHorariaTotal += m.get(i).getCarga_horaria();
        }
        for(int i = 0;i<m.size();i++) {
            if(m.get(i).getMatricula() == getMatricula())
                notaParcial += (m.get(i).getNota()*m.get(i).getCarga_horaria())/cargaHorariaTotal;
        }
        this.nota = notaParcial;
        return getNota();
    }
}
