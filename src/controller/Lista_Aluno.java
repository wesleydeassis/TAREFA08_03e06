package controller;

import javax.swing.JOptionPane;


public class Lista_Aluno {

	private int IDAluno;
    private String NomeCompleto;
    private String Curso;
    private String Semestre;
    private No_Aluno inicio;
    
    public Lista_Aluno() {
    	inicio = null;
    }
    
    public void MenuAlunos() {
    	
    	int opcao = 0;
		while (opcao != 9) {

			opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu de Aluno: \n " +
																	"\n1- Verificar se a Lista esta vazia" +
																	"\n2- Inserir Aluno no Fim da Lista" +
																	"\n3- Inserir Aluno no Inicio da Lista " +
																	"\n4- Remover Aluno no Final da lista" +
																	"\n5- Remover Aluno no Inicio da lista" +
																	"\n6- Mostar a Lista de Alunos" +
																	"\n7- Ordenar a lista QuickShort"+
																	"\n8- Ordenar a lista MergeSort"+
																	"\n9- Voltar  "));
			
			switch (opcao) {
				case 1:
					if (ListaVazia() == true) {
						System.out.println("Lista de Aluno vazia");
					}
					else {
						System.out.println("Lista de Aluno nao esta vazia");
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
	            	Aluno[] vet1 = null;
					Aluno[] vet = converteNoVetor(vet1);
					quickSort(vet, 0, vet.length - 1);
					JOptionPane.showMessageDialog(null, "A lista sera mostrada no console");
					for (int j = 0; j < vet.length; j++) {
						System.out.println("\n ID Aluno: " + vet[j].getIDAluno() + " - Nome Aluno: " + vet[j].getNomeCompleto()
								+ " - Curso: " + vet[j].getCurso() + " - Semestre: " + vet[j].getSemestre());
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
    	
        Aluno aluno = new Aluno(IDAluno, NomeCompleto, Curso, Semestre);
        
        IDAluno = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Aluno: "));  
        aluno.setIDAluno(IDAluno);

        NomeCompleto = JOptionPane.showInputDialog("Digite o nome do aluno: ");
        aluno.setNomeCompleto(NomeCompleto);

        Curso = JOptionPane.showInputDialog("Digite o curso do aluno: ");
        aluno.setCurso(Curso);
        
        Semestre = JOptionPane.showInputDialog("Digite o semestre do aluno: ");
        aluno.setSemestre(Semestre);   

		No_Aluno noA = new No_Aluno(aluno);
		if (inicio == null){
			inicio = noA;
			noA.ant = null;
			noA.prox = null;
		}
		else{
			No_Aluno aux = inicio;
			while(aux.prox != null){
				aux = aux.prox;
			}
			aux.prox = noA;
			noA.ant = aux;
			noA.prox=null;
		}
		JOptionPane.showMessageDialog(null,"- ID Aluno: " + aluno.getIDAluno() +
											"\n- Nome Compleo: " + aluno.getNomeCompleto() +
											"\n- Curso: " + aluno.getCurso() +
											"\n- Semestre: " +aluno.getSemestre() +
											"\n\n Foi adicionado com sucesso!");
    }  // fim Inserir no final
    
    public void InserirInicio() {
    	Aluno aluno = new Aluno(IDAluno, NomeCompleto, Curso, Semestre);
    	  
        IDAluno = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Aluno: "));  
        aluno.setIDAluno(IDAluno);

        NomeCompleto = JOptionPane.showInputDialog("Digite o nome do aluno: ");
        aluno.setNomeCompleto(NomeCompleto);

        Curso = JOptionPane.showInputDialog("Digite o curso do aluno: ");
        aluno.setCurso(Curso);
        
        Semestre = JOptionPane.showInputDialog("Digite o semestre do aluno: ");
        aluno.setSemestre(Semestre); 

		No_Aluno noA = new No_Aluno(aluno);
		
        if (inicio == null) {							
			inicio = noA;
			noA.ant = null;
			noA.prox = null;
		}  
        noA.prox = inicio;
        inicio.ant = noA;
        inicio = noA;
       
        
		
        JOptionPane.showMessageDialog(null,"\n- ID Aluno: "+aluno.getIDAluno()+
											"\n- Nome Completo: "+aluno.getNomeCompleto()+
											"\n- Curso: "+aluno.getCurso()+
											"\n- Semestre: "+aluno.getSemestre()+
											"\n\n Foi adicionado com sucesso!");
    } // fim inserir no começo
    
    public String RemoverAlunoFinal() {
		String Nome = "", Curso = "", Semestre = "";
        int IDAluno = 0;

        if ( ListaVazia() == true ) {
			JOptionPane.showConfirmDialog(null, "A lista esta vazia!");
		}
		else {
			if (inicio.prox == null) {			
				IDAluno = inicio.aluno.getIDAluno();
                Nome = inicio.aluno.getNomeCompleto();
                Curso = inicio.aluno.getCurso();
                Semestre = inicio.aluno.getSemestre();
				
				inicio = null;					
			} 
			else {
				No_Aluno aux1 = inicio;			
				No_Aluno aux2 = inicio;
				
				while (aux1.prox != null) {
					aux2 = aux1;
					aux1 = aux1.prox;
				}

				No_Aluno aux = LocalizaFim(inicio, inicio);

				IDAluno = aux.aluno.getIDAluno();
			    Nome = aux.aluno.getNomeCompleto();
                Curso = aux.aluno.getCurso();
                Semestre = aux.aluno.getSemestre();
				
				aux1.ant = null;
				aux2.prox = null;			
				
			} 
        }
        return "- ID Aluno: "+ IDAluno + " - Nome: " + Nome + " - Curso: "+Curso+ " - Semestre: "+Semestre +"\n Foi removido com sucesso!";
    } // remover aluno no final
    
    public String RemoverAlunoInicio() {
		String Nome = "", Curso = "", Semestre = "";
        int IDAluno = 0;

        if ( ListaVazia() == true ) {
			JOptionPane.showConfirmDialog(null, "A lista esta vazia!");
		} 
		else {
			IDAluno = inicio.aluno.getIDAluno();
            Nome = inicio.aluno.getNomeCompleto();
            Curso = inicio.aluno.getCurso();
            Semestre = inicio.aluno.getSemestre();

			inicio = inicio.prox;			
			if (inicio != null) {
				inicio.ant = null;
			}
		} 
        return "- ID Aluno: "+ IDAluno +" - Nome: "+ Nome +" - Curso: "+Curso+ " - Semestre: " +Semestre + "\n\n Foi removido com sucesso!";
    } // remove no Inicio
    
    public No_Aluno LocalizaFim(No_Aluno aux1, No_Aluno aux2) {
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
			No_Aluno aux = inicio;	
			
			while (aux != null) {
//				JOptionPane.showMessageDialog(null, "A lista sera mostrada no console");
				System.out.println("\n- ID: "+aux.aluno.getIDAluno()+" - Nome: "+aux.aluno.getNomeCompleto()+" - Curso: "+aux.aluno.getCurso() + " Semestre: " +aux.aluno.getSemestre()); 
				aux = aux.prox;
			} 
		}
    } // fim percorrer a lista
    
    public int Contar() {
    	int count = 1;
    	No_Aluno aux = inicio;
    	while (aux.prox != null) {
    		count++;
    		aux = aux.prox;
    	}
    	System.out.println(count);
    	return count;
    } // fim contar
  
    
    // Ordenacao por MergeSorte
    
    public No_Aluno mergeSort(No_Aluno aluno){
		if (aluno == null || aluno.getProx() == null) {
			return aluno;
		}
		No_Aluno meio = getNoMeio(aluno);
		No_Aluno segundaMetade = meio.getProx();
		meio.setProx(null);
		segundaMetade.setAnt(null);
		
		return merge(mergeSort(aluno),mergeSort(segundaMetade));
		
		}
	
		private No_Aluno getNoMeio(No_Aluno aluno){
			No_Aluno a = aluno;
			No_Aluno b = aluno.getProx();
			
			while (b != null && b.getProx() != null) {
				a = a.getProx();
				b = b.getProx().getProx();
			}
			return a;
		}
		
		private No_Aluno merge(No_Aluno primeiro, No_Aluno segundo){
			No_Aluno aux = new No_Aluno();
			
			No_Aluno lista = aux;
			
			while (primeiro != null && segundo != null) {
				if (primeiro.getAluno().getIDAluno() < (segundo.getAluno().getIDAluno())) {
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
			No_Aluno a = mergeSort(inicio);
			this.inicio = a;
		} // ordenar MergeSort
		
		
		// Metodo QuickSort
		
		// Metodo Obter tamanho da lista
		public int obterTamanho() {
			No_Aluno aux = inicio;
			int contador = 0;
			while (aux != null) {
				contador = contador + 1;
				aux = aux.prox;
			}
			return contador;
		}
		
		// Metodo Converter lista em vetor
		public Aluno[] converteNoVetor(Aluno vet[]) {
			No_Aluno aux = inicio;
			int cont = 0;
			int tamanho = obterTamanho();
			Aluno[] vet1 = new Aluno[tamanho];
			while (aux != null) {
				vet1[cont] = aux.aluno;
				aux = aux.prox;
				cont++;

			}
			return vet1;
		}

		// Metodo Ordenação por quickSort
		public Aluno[] quickSort(Aluno vet[], int ini, int fim) {

			int divisao;
			if (ini < fim) {
				divisao = particao(vet, ini, fim);
				quickSort(vet, ini, divisao - 1);
				quickSort(vet, divisao + 1, fim);
			}
			return vet;
		}

		public int particao(Aluno[] vet, int ini, int fim) {
			Aluno pivo = vet[ini];
			int i = ini + 1, f = fim;
			Aluno aux;
			while (i <= f) {
				while (i <= fim && (vet[i].getNomeCompleto().compareTo(pivo.getNomeCompleto()) <= 0))

				++i;
				while ((pivo.getNomeCompleto().compareTo(vet[f].getNomeCompleto()) < 0))
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
		
		
		
} // fim da classe
