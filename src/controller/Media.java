package controller;

public class Media {

	private int IDAluno;
	private String Disciplina;
	private double MediaFinal;
	
	public Media(int IDAAluno,String IDDisciplina, double MediaFinal) {
		this.IDAluno = IDAluno;
		this.Disciplina = IDDisciplina;
		this.MediaFinal = MediaFinal;
	}

	public int getIDAluno() {
		return IDAluno;
	}

	public void setIDAluno(int iDAluno) {
		IDAluno = iDAluno;
	}

	public String getDisciplina() {
		return Disciplina;
	}

	public void setDisciplina(String disciplina) {
		Disciplina = disciplina;
	}

	public double getMediaFinal() {
		return MediaFinal;
	}

	public void setMediaFinal(double mediaFinal) {
		MediaFinal = mediaFinal;
	}

	
}
