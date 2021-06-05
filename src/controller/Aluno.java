package controller;

public class Aluno {
	
	private int IDAluno;
    private String NomeCompleto;
    private String Curso;
    private String Semestre;
    
    public Aluno (int IDAluno, String NomeCompleto, String Curso, String Semestre) {
    	this.IDAluno = IDAluno;
    	this.NomeCompleto = NomeCompleto;
    	this.Curso = Curso;
    	this.Semestre = Semestre;
    }

	public int getIDAluno() {
		return IDAluno;
	}

	public void setIDAluno(int iDAluno) {
		IDAluno = iDAluno;
	}

	public String getNomeCompleto() {
		return NomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		NomeCompleto = nomeCompleto;
	}

	public String getCurso() {
		return Curso;
	}

	public void setCurso(String curso) {
		Curso = curso;
	}

	public String getSemestre() {
		return Semestre;
	}

	public void setSemestre(String semestre) {
		Semestre = semestre;
	}
    
}
