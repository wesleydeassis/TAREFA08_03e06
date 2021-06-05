package controller;

public class No_Media {

	public Media media;
	public No_Media prox = null;
	public No_Media ant = null;
	
	public No_Media (Media media) {
		this.media = media;
		prox = null;
		ant = null;
	}

	public No_Media() {
		// TODO Auto-generated constructor stub
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public No_Media getProx() {
		return prox;
	}

	public void setProx(No_Media prox) {
		this.prox = prox;
	}

	public No_Media getAnt() {
		return ant;
	}

	public void setAnt(No_Media ant) {
		this.ant = ant;
	}
	
}
