package view;

import javax.swing.JOptionPane;

import controller.Lista_Aluno;
import controller.Lista_Disciplina2;
import controller.Lista_Media;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Lista_Aluno aluno = new Lista_Aluno();
		Lista_Disciplina2 disc2 = new Lista_Disciplina2();
		Lista_Media media = new Lista_Media();
		
		
	        int opcao = 0;
	        
	        while (opcao != 9) {
	            opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu Principal: \n\n"+
	                                                                "\n1 - Criar uma lista de Alunos " +                                                              
	                                                                "\n2 - Criar uma lista de Disciplinas " +
	                                                                "\n3 - Criar uma lista de Medias "+
	                                                                "\n9 - Sair do programa \n"));
	        

	        switch (opcao) {
	            case 1:
	            	 aluno.MenuAlunos();
	            	break;

	            case 2:
	            	disc2.MenuDisciplina2();
	            	break;

	            case 3:
	            	media.ListaMedia();
	            	break;

	            case 9:
	                JOptionPane.showMessageDialog(null, "Saindo do programa");
	            break;

	            default:
				break;
	        } // fim do Switch
	     } //fim while
		
		
		
	} // main

} // classe
