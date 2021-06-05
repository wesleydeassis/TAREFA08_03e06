package controller;

import javax.swing.JOptionPane;

public class Lista_Media {

	private int IDAluno;
	private String Disciplina;
	private double MediaFinal;
	private No_Media inicio;
	
   

    public Lista_Media() {
    	inicio = null ;
	}


	public void ListaMedia() {
    	
    	int opcao = 0;
		while (opcao != 9) {

			opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu de Medias: \n " +
																	"\n1- Verificar se a Lista esta vazia" +
																	"\n2- Inserir medias por aluno no fim da lista" +
																	"\n3- Inserir medias por aluno no inicio da lista " +
																	"\n4- Remover medias por aluno no fim da lista" +
																	"\n5- Remover medias por aluno no inicio da lista" +
																	"\n6- Mostar a Lista de Disciplina" +
																	"\n7- Lista com media acima de 8 _ QuickSort"+
																	"\n8- Lista com media acima de 8 _ MergeSort"+
																	"\n9- Voltar  "));
			
			switch (opcao) {
				case 1:
					if (ListaVazia() == true) {
						System.out.println("Lista de Medias esta vazia");
					}
					else {
						System.out.println("Lista de Medias nao esta vazia");
					}
				break;

				case 2:	
					InserirFinal();
				break;

				case 3:
					InserirInicio();
				break;

				case 4:
					RemoverAlunoFinal();
				break;
				
				case 5:
					RemoverAlunoInicio();
					break;
				
				case 6:
					PercorrerLista();
					break;
					
	            case 7:
	            	ordenarMergeSort();
	        		PercorrerLista();

	            	break;
	            	
	            case 8:
  		          	PercorrerLista2();
	            	break;            	

				case 9:
					JOptionPane.showMessageDialog(null, "Voltando ao menu anterior");
				break;

				default:
				break;
			} // fim switch
		} // fim while
    	
    }
    
    
    public boolean ListaVazia() {
        if (inicio == null) {
			return true;			
		}
		return false;	
    }
    
    public void InserirFinal() {
    	
    	Media media = new Media(IDAluno, Disciplina, MediaFinal);
        
        IDAluno = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID Aluno: "));  
        media.setIDAluno(IDAluno);

        Disciplina = JOptionPane.showInputDialog("Digite o nome da Disciplina: ");
        media.setDisciplina(Disciplina);
        
        MediaFinal = Double.parseDouble(JOptionPane.showInputDialog("Digite o Media Final: "));  
        media.setMediaFinal(MediaFinal);

		No_Media noM = new No_Media(media);
		if (inicio == null){
			inicio = noM;
			noM.ant = null;
			noM.prox = null;
		}
		else{
			No_Media aux = inicio;
			while(aux.prox != null){
				aux = aux.prox;
			}
			aux.prox = noM;
			noM.ant = aux;
			noM.prox=null;
		}
		JOptionPane.showMessageDialog(null,"- ID Aluno: " + media.getIDAluno() +
											"\n- Disciplina: " + media.getDisciplina() +
											"\n- Media Final: " +media.getMediaFinal() +
											"\n\n Foi adicionado com sucesso!");
    }  // fim Inserir no final
    
    public void InserirInicio() {
    	Media media = new Media(IDAluno, Disciplina, MediaFinal);
        
        IDAluno = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Aluno: "));  
        media.setIDAluno(IDAluno);

        Disciplina = JOptionPane.showInputDialog("Digite o nome do disciplina: ");
        media.setDisciplina(Disciplina);
        
        MediaFinal = Double.parseDouble(JOptionPane.showInputDialog("Digite a Media: "));  
        media.setMediaFinal(MediaFinal);
        
        No_Media noM = new No_Media(media);
		
        if (inicio == null) {							
			inicio = noM;
			noM.ant = null;
			noM.prox = null;
		}  
        noM.prox = inicio;
        inicio.ant = noM;
        inicio = noM;
		
        JOptionPane.showMessageDialog(null,"- ID Aluno: " + media.getIDAluno() +
											"\n- Disciplina: " + media.getDisciplina() +
											"\n- Media Final: " +media.getMediaFinal() +
        									"\n\n Foi adicionado com sucesso!");
		
    } // fim inserir no inicio
    
    public String RemoverAlunoFinal() {
		int iDAluno = 0;
    	String disciplina = "";
		double mediaFinal = 0;

        if ( ListaVazia() == true ) {
			JOptionPane.showConfirmDialog(null, "A lista esta vazia!");
		}
		else {
			if (inicio.prox == null) {			
				iDAluno = inicio.media.getIDAluno();
				disciplina = inicio.media.getDisciplina();
				mediaFinal = inicio.media.getMediaFinal();
				
				inicio = null;					
			} 
			else {
				No_Media aux1 = inicio;			
				No_Media aux2 = inicio;
				
				while (aux1.prox != null) {
					aux2 = aux1;
					aux1 = aux1.prox;
				}

				No_Media aux = LocalizaFim(inicio, inicio);

				iDAluno = aux.media.getIDAluno();
				disciplina = aux.media.getDisciplina();
				mediaFinal = aux.media.getMediaFinal();
				
				aux1.ant = null;
				aux2.prox = null;			
				
			} 
        }
        return "- ID Aluno: "+ iDAluno + " - Disciplina: " + disciplina + "Meida Final: " + mediaFinal +"\n Foi removido com sucesso!";
    } // remover aluno no final

    public String RemoverAlunoInicio() {
    	int iDAluno = 0;
    	String disciplina = "";
		double mediaFinal = 0;

        if ( ListaVazia() == true ) {
			JOptionPane.showConfirmDialog(null, "A lista esta vazia!");
		} 
		else {
			iDAluno = inicio.media.getIDAluno();
			disciplina = inicio.media.getDisciplina();
			mediaFinal = inicio.media.getMediaFinal();

			inicio = inicio.prox;			
			if (inicio != null) {
				inicio.ant = null;
			}
		} 
        return "- ID Aluno: "+ iDAluno + " - Disciplina: " + disciplina + "Media Final: " + mediaFinal +"\n Foi removido com sucesso!";
    } // remove no Inicio  
    
    public No_Media LocalizaFim(No_Media aux1, No_Media aux2) {
		if (aux1.prox != null ) {
			return LocalizaFim(aux1.prox, aux1);
		}
		return aux2;
	} // fim localizaFim
    
    public void PercorrerLista() {
        if ( ListaVazia() == true ) {
			JOptionPane.showConfirmDialog(null, "A lista esta vazia!");
		} 
		else {
			No_Media aux = inicio;	
			
			while (aux != null) {
				System.out.println("Lista Ordenada" +"\n- ID Aluno: "+aux.media.getIDAluno()+" - Nome disciplina: "+aux.media.getDisciplina()+ " Media Final: " +aux.media.getMediaFinal()); 
				aux = aux.prox;
			} 
		}
    } // fim percorrer a lista
    
    public void PercorrerLista2() {
        if ( ListaVazia() == true ) {
			JOptionPane.showConfirmDialog(null, "A lista esta vazia!");
		} 
		else {
			No_Media aux = inicio;	
			
			while (aux != null) {
				if(aux.media.getMediaFinal() > 8.0) {
				System.out.println("Media acima de 8.0 "+"\n- Aluno: "+aux.media.getIDAluno()+" - Nome disciplina: "+aux.media.getDisciplina()+ " Media Final: " +aux.media.getMediaFinal()); 
				aux = aux.prox;
				} 
				else {
					aux = aux.prox;
				}
			} 
		}
    } // fim percorrer a lista
    
    public int obterTamanho(){
		No_Media aux=inicio;
		int contador=0;
		while(aux!=null){
			contador = contador+1;
			aux = aux.prox;
		}
		return contador;
	} // fim obter dados
    
    public No_Media mergeSort(No_Media media){
		if (media == null || media.getProx() == null) {
			return media;
		}
		No_Media meio = getNoMeio(media);
		No_Media segundaMetade = meio.getProx();
		meio.setProx(null);
		segundaMetade.setAnt(null);
		
		return merge(mergeSort(media),mergeSort(segundaMetade));
		
		}
	
		private No_Media getNoMeio(No_Media media){
			No_Media a = media;
			No_Media b = media.getProx();
			
			while (b != null && b.getProx() != null) {
				a = a.getProx();
				b = b.getProx().getProx();
			}
			return a;
		}
		
		private No_Media merge(No_Media primeiro, No_Media segundo){
			No_Media aux = new No_Media();
			
			No_Media lista = aux; 
			
			while (primeiro != null && segundo != null) {
				if (primeiro.getMedia().getMediaFinal() < (segundo.getMedia().getMediaFinal())) {
					aux.setProx(primeiro);
					primeiro = primeiro.getProx();
				}
				else {
					aux.setProx(segundo);
					segundo = segundo.getProx();
				}
				aux = aux.getProx();
			}
			if (primeiro == null) aux.setProx(segundo);
			else aux.setProx(primeiro);
			
			return lista.getProx();
		} 
		
		public void ordenarMergeSort() {
			No_Media a = mergeSort(inicio);
			this.inicio = a;
		}
    
    
} // final da classe
