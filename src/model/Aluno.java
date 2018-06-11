package model;

import java.util.ArrayList;
import json.JSONArray;
import json.JSONObject;
import util.Arquivo;

/**
 * @author LUCASFERNANDODEASSIS
 */
public class Aluno {

    public String Matricula;
    public String Nome;

    public Aluno() {
    }

    public Aluno(String Matricula, String Nome) {
        this.Matricula = Matricula;
        this.Nome = Nome;
    }

    public Aluno(JSONObject json) {
        this.Matricula = json.getString("Matricula");
        this.Nome = json.getString("Nome");
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Nome", this.Nome);
        json.put("Matricula", this.Matricula);

        return json;
    }

    public boolean Persistir() {
        JSONArray ja = new JSONArray();
        String base = Arquivo.Read();

        if (!base.isEmpty() && base.length() > 5) {
            ja = new JSONArray(base);
        }

        ja.put(this.toJson());

        Arquivo.Write(ja.toString());

        return true;
    }

    public static ArrayList<Aluno> getAlunos() {
        ArrayList<Aluno> Alunos = new ArrayList();
        String base = Arquivo.Read();

        if (base.isEmpty() || base.length() < 5) {
            return null;
        }

        JSONArray ja = new JSONArray(base);

        for (int i = 0; i < ja.length(); i++) {
            Alunos.add(new Aluno(ja.getJSONObject(i)));
        }

        return Alunos;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
}
