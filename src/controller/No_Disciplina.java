package controller;

public class No_Disciplina {

	public Disciplina disciplina;
	public No_Disciplina prox = null;
	public No_Disciplina ant = null;
	
	public No_Disciplina (Disciplina disciplina) {
		this.disciplina = disciplina;
		prox = null;
		ant = null;
	}

	public No_Disciplina() {
		// TODO Auto-generated constructor stub
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public No_Disciplina getProx() {
		return prox;
	}

	public void setProx(No_Disciplina prox) {
		this.prox = prox;
	}

	public No_Disciplina getAnt() {
		return ant;
	}

	public void setAnt(No_Disciplina ant) {
		this.ant = ant;
	}

	


}
