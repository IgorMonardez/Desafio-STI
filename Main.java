import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.lang.Integer;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.lang.NumberFormatException;


public class Main {
    public static void main(String args[]) throws IOException {
        ArrayList<Materia> m = new ArrayList();
        ArrayList<Alunos> conjuntoAlunos = new ArrayList();
        String arq = lerArquivoCSV("notas.csv");
        String s[] = arq.split("\n");
        for(int i = 1;i<s.length;i++) {
            String a[] =  s[i].split(",");
            m.add(new Materia(Integer.valueOf(a[0],10),a[1],Integer.valueOf(a[2],10),Integer.valueOf(a[3],10),Integer.valueOf(a[4],10),Integer.valueOf(a[5],10)));
        }
        int j = 0;
        for(int i = 0;i<m.size();i++) {
            if(conjuntoAlunos.size() == 0) {
                conjuntoAlunos.add(j,new Alunos(m.get(i).getMatricula(),0));
            }
            else {
                if(conjuntoAlunos.get(j).getMatricula() != m.get(i).getMatricula()) { // Com problema
                    conjuntoAlunos.add(j,new Alunos(m.get(i).getMatricula(),0));
                }
            }
        }
        for(int i = 0;i<conjuntoAlunos.size();i++)
            conjuntoAlunos.get(i).cr(m);

        System.out.println("-------------- O CR dos alunos é: -------------");
        System.out.println("      Matrícula        |           CR");

        for(int i = 0;i<conjuntoAlunos.size();i++)
            System.out.println("         " + conjuntoAlunos.get(i).getMatricula() + "           |           " + conjuntoAlunos.get(i).getNota() + "       ");


        j = 0;
        ArrayList<Curso> c = new ArrayList();
        for(int i = 0;i<m.size();i++) {
            int busca = search(c,m.get(i).getCod_curso());
            if(busca == -1)
                c.add(new Curso(m.get(i).getCod_curso(),0));
        }

        for(int i = 0;i<c.size();i++)
            c.get(i).cr(m);


        System.out.println("-------------- O CR dos cursos são: -------------");
        System.out.println("      COD_CURSO        |           CR");

        for(int i = 0;i<c.size();i++) {
            if(c.get(i).getCod_curso() < 10)
                System.out.println("         " + c.get(i).getCod_curso() + "             |           " + c.get(i).getNota());
            else
                if(c.get(i).getCod_curso() > 100)
                    System.out.println("         " + c.get(i).getCod_curso() + "           |           " + c.get(i).getNota());
                else
                    System.out.println("         " + c.get(i).getCod_curso() + "            |           " + c.get(i).getNota());
        }

    }
    static String lerArquivoCSV(String n) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(n));
        String arq = "";
        while(br.ready()) {
            arq += br.readLine() + "\n";
        }
        br.close();
        return arq;
    }

    static int search(@NotNull ArrayList<Curso> c, int cod_curso) {
        for(int i = 0;i<c.size();i++) {
            if(c.get(i).getCod_curso() == cod_curso)
                return i;
        }
        return -1;
    }
}