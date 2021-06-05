package controller;

public class Disciplina {

	private double IDDisciplina;
	private String NomeDisciplina;
	
	public Disciplina (double IDDisciplina, String NomeDisciplina) {
		this.IDDisciplina = IDDisciplina;
		this.NomeDisciplina = NomeDisciplina;
	}

	public double getIDDisciplina() {
		return IDDisciplina;
	}

	public void setIDDisciplina(double iDDisciplina) {
		IDDisciplina = iDDisciplina;
	}

	public String getNomeDisciplina() {
		return NomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		NomeDisciplina = nomeDisciplina;
	}
	
}
