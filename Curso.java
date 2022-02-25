import java.util.ArrayList;

public class Curso {
    int cod_curso;
    int nota;

    public Curso(int cc,int n){
        this.cod_curso = cc;
        this.nota = n;
    }

    public int getNota() {
        return nota;
    }

    public int getCod_curso() {
        return cod_curso;
    }

    public int cr(ArrayList<Materia> m) {
        int notaParcial = 0;
        int cargaHorariaTotal = 0;
        for(int i = 0;i<m.size();i++) {
            if(m.get(i).getCod_curso() == getCod_curso())
                cargaHorariaTotal += m.get(i).getCarga_horaria();
        }
        for(int i = 0;i<m.size();i++) {
            if(m.get(i).getCod_curso() == getCod_curso())
                notaParcial += (m.get(i).getNota()*m.get(i).getCarga_horaria())/cargaHorariaTotal;
        }
        this.nota = notaParcial;
        return notaParcial;
    }
}
