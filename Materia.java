import java.lang.Integer;

public class Materia {
    int matricula;
    String cod_disciplina;
    int cod_curso;
    int nota;
    int carga_horaria;
    int ano_semestre;

    public Materia(String m, String cd, String cc, String n, String ch, String as) {
        this.matricula = Integer.parseInt(m,10);
        this.cod_disciplina = cd;
        this.cod_curso = Integer.parseInt(cc,10);
        this.nota = Integer.parseInt(n,10);
        this.carga_horaria = Integer.parseInt(ch,10);
        this.ano_semestre = Integer.parseInt(as,10);
    }

    public Materia(int m,String cd, int cc, int n, int ch, int as) {
        this.matricula = m;
        this.cod_disciplina = cd;
        this.cod_curso = cc;
        this.nota = n;
        this.carga_horaria = ch;
        this.ano_semestre = as;
    }

    public String getCod_disciplina() {
        return cod_disciplina;
    }

    public int getCod_curso() {
        return cod_curso;
    }

    public int getNota() {
        return nota;
    }

    public int getMatricula() {
        return matricula;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public int getAno_semestre() {
        return ano_semestre;
    }
}
