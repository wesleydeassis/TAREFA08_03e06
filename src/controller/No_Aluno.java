package controller;

public class No_Aluno {
	public Aluno aluno;
	public No_Aluno prox = null;
	public No_Aluno ant = null;
	
	public No_Aluno (Aluno aluno) {
		this.aluno = aluno;
		prox = null;
		ant = null;
	}

	public No_Aluno() {
		return;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public No_Aluno getProx() {
		return prox;
	}

	public void setProx(No_Aluno prox) {
		this.prox = prox;
	}

	public No_Aluno getAnt() {
		return ant;
	}

	public void setAnt(No_Aluno ant) {
		this.ant = ant;
	}
	
	
}
