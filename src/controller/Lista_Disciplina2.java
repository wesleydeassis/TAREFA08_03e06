package controller;

import javax.swing.JOptionPane;

public class Lista_Disciplina2 {

	private double IDDisciplina;
	private String NomeDisciplina;
    private No_Disciplina inicio;
    private Disciplina[] dadosDisc;
    private static int tamanho;
    
    public Lista_Disciplina2() {
    	inicio = null;
    }
    
    public void MenuDisciplina2() {
    	
    	int opcao = 0;
		while (opcao != 9) {

			opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu de Disciplina: \n " +
																	"\n1- Verificar se a Lista esta vazia" +
																	"\n2- Inserir Disciplina no Fim da Lista" +
																	"\n3- Inserir Disciplina no Inicio da Lista " +
																	"\n4- Remover Disciplina no Final da lista" +
																	"\n5- Remover Disciplina no Inicio da lista" +
																	"\n6- Mostar a Lista de Disciplina" +
																	"\n7- Ordenar a lista QuickSort"+
																	"\n8- Ordenar a lista MergeSort"+
																	"\n9- Voltar  "));
			
			switch (opcao) {
				case 1:
					if (ListaVazia() == true) {
						System.out.println("Lista de Disciplina vazia");
					}
					else {
						System.out.println("Lista de Disciplina nao esta vazia");
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
	            	Disciplina[] vet1 = null;
					Disciplina[] vet = converteNoVetor(vet1);
					quickSort(vet, 0, vet.length - 1);
					JOptionPane.showMessageDialog(null, "A lista sera mostrada no console");
					for (int j = 0; j < vet.length; j++) {
						System.out.println("\n ID Disciplina: " + vet[j].getIDDisciplina() + " - Nome Disciplina: " + vet[j].getNomeDisciplina());
					}

	            	break;
	            	
	            case 8:
	            	ordenarMergeSort();
	        		PercorrerLista();
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
    	
        Disciplina disc = new Disciplina(IDDisciplina, NomeDisciplina);
        
        IDDisciplina = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da disciplina: "));  
        disc.setIDDisciplina(IDDisciplina);

        NomeDisciplina = JOptionPane.showInputDialog("Digite o nome do disciplina: ");
        disc.setNomeDisciplina(NomeDisciplina);

		No_Disciplina noD = new No_Disciplina(disc);
		if (inicio == null){
			inicio = noD;
			noD.ant = null;
			noD.prox = null;
		}
		else{
			No_Disciplina aux = inicio;
			while(aux.prox != null){
				aux = aux.prox;
			}
			aux.prox = noD;
			noD.ant = aux;
			noD.prox=null;
		}
		JOptionPane.showMessageDialog(null,"- ID disciplina: " + disc.getIDDisciplina() +
											"\n- Nome disciplina: " + disc.getNomeDisciplina() +
											"\n\n Foi adicionado com sucesso!");
    }  // fim Inserir no final
    
    public void InserirInicio() {
        Disciplina disc = new Disciplina(IDDisciplina, NomeDisciplina);
    	  
        IDDisciplina = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da disciplina: "));  
        disc.setIDDisciplina(IDDisciplina);;

        NomeDisciplina = JOptionPane.showInputDialog("Digite o nome do disciplina: ");
        disc.setNomeDisciplina(NomeDisciplina);

		No_Disciplina noD = new No_Disciplina(disc);
		
        if (inicio == null) {							
			inicio = noD;
			noD.ant = null;
			noD.prox = null;
		}  
        noD.prox = inicio;
        inicio.ant = noD;
        inicio = noD;
		
		JOptionPane.showMessageDialog(null,	"- ID disciplina: " + disc.getIDDisciplina() +
											"\n- Nome disciplina: " + disc.getNomeDisciplina() +
											"\n\n Foi adicionado com sucesso!");
		
    } // fim inserir no começo
    
    public String RemoverAlunoFinal() {
		String nomeDisc = "";
        double IDDisc = 0;

        if ( ListaVazia() == true ) {
			JOptionPane.showConfirmDialog(null, "A lista esta vazia!");
		}
		else {
			if (inicio.prox == null) {			
				IDDisc = inicio.disciplina.getIDDisciplina();
				nomeDisc = inicio.disciplina.getNomeDisciplina();
				
				inicio = null;					
			} 
			else {
				No_Disciplina aux1 = inicio;			
				No_Disciplina aux2 = inicio;
				
				while (aux1.prox != null) {
					aux2 = aux1;
					aux1 = aux1.prox;
				}

				No_Disciplina aux = LocalizaFim(inicio, inicio);

				IDDisc = aux.disciplina.getIDDisciplina();
				nomeDisc = aux.disciplina.getNomeDisciplina();
				
				aux1.ant = null;
				aux2.prox = null;			
				
			} 
        }
        return "- ID disciplina: "+ IDDisc + " - Nome disciplina: " + nomeDisc +"\n Foi removido com sucesso!";
    } // remover aluno no final
    
    public String RemoverAlunoInicio() {
		String nomeDisc = "";
        double IDDisc = 0;

        if ( ListaVazia() == true ) {
			JOptionPane.showConfirmDialog(null, "A lista esta vazia!");
		} 
		else {
			IDDisc = inicio.disciplina.getIDDisciplina();
			nomeDisc = inicio.disciplina.getNomeDisciplina();

			inicio = inicio.prox;			
			if (inicio != null) {
				inicio.ant = null;
			}
		} 
        return "- ID disciplina: "+ IDDisc + " - Nome disciplina: " + nomeDisc +"\n Foi removido com sucesso!";
    } // remove no Inicio
    
    public No_Disciplina LocalizaFim(No_Disciplina aux1, No_Disciplina aux2) {
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
			No_Disciplina aux = inicio;	
			
			while (aux != null) {
				System.out.println("\n- ID disciplina: "+aux.disciplina.getIDDisciplina()+" - Nome disciplina: "+aux.disciplina.getNomeDisciplina()); 
				aux = aux.prox;
			} 
		}
    } // fim percorrer a lista
     
//	public int obterTamanho(){
//		No_Disciplina aux=inicio;
//		int contador=0;
//		while(aux!=null){
//			contador = contador+1;
//			aux = aux.prox;
//		}
//		return contador;
//	} // fim obter dados

    public No_Disciplina mergeSort(No_Disciplina disciplina){
		if (disciplina == null || disciplina.getProx() == null) {
			return disciplina;
		}
		No_Disciplina meio = getNoMeio(disciplina);
		No_Disciplina segundaMetade = meio.getProx();
		meio.setProx(null);
		segundaMetade.setAnt(null);
		
		return merge(mergeSort(disciplina),mergeSort(segundaMetade));
		
		}
	
		private No_Disciplina getNoMeio(No_Disciplina disciplina){
			No_Disciplina a = disciplina;
			No_Disciplina b = disciplina.getProx();
			
			while (b != null && b.getProx() != null) {
				a = a.getProx();
				b = b.getProx().getProx();
			}
			return a;
		}
		
		private No_Disciplina merge(No_Disciplina primeiro, No_Disciplina segundo){
			No_Disciplina aux = new No_Disciplina();
			
			No_Disciplina lista = aux;
			
			while (primeiro != null && segundo != null) {
				if (primeiro.getDisciplina().getIDDisciplina() < (segundo.getDisciplina().getIDDisciplina())) {
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
			No_Disciplina a = mergeSort(inicio);
			this.inicio = a;
		}

		// Metodo QuickSort
		
		// Metodo Obter tamanho da lista
		public int obterTamanho() {
			No_Disciplina aux = inicio;
			int contador = 0;
			while (aux != null) {
				contador = contador + 1;
				aux = aux.prox;
			}
			return contador;
		}
		
		// Metodo Converter lista em vetor
		public Disciplina[] converteNoVetor(Disciplina vet[]) {
			No_Disciplina aux = inicio;
			int cont = 0;
			int tamanho = obterTamanho();
			Disciplina[] vet1 = new Disciplina[tamanho];
			while (aux != null) {
				vet1[cont] = aux.disciplina;
				aux = aux.prox;
				cont++;

			}
			return vet1;
		}

		// Metodo Ordenação por quickSort
		public Disciplina[] quickSort(Disciplina vet[], int ini, int fim) {

			int divisao;
			if (ini < fim) {
				divisao = particao(vet, ini, fim);
				quickSort(vet, ini, divisao - 1);
				quickSort(vet, divisao + 1, fim);
			}
			return vet;
		}

		public int particao(Disciplina[] vet, int ini, int fim) {
			Disciplina pivo = vet[ini];
			int i = ini + 1, f = fim;
			Disciplina aux;
			while (i <= f) {
				while (i <= fim && (vet[i].getNomeDisciplina().compareTo(pivo.getNomeDisciplina()) <= 0))

				++i;
				while ((pivo.getNomeDisciplina().compareTo(vet[f].getNomeDisciplina()) < 0))
					--f;
				if (i < f) {
					aux = vet[i];
					vet[i] = vet[f];
					vet[f] = aux;
					++i;
					--f;
				}
			}
			if (ini != f) {
				vet[ini] = vet[f];
				vet[f] = pivo;
			}
			return f;
		}// Fim quickSort
		
		
	
} // final da Classe
