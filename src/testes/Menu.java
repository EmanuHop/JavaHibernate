package testes;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import actions.DeleteAlunoById;
import actions.InsertAluno;
import actions.SearchAlunoById;
import actions.SelectAlunos;
import actions.SelectAlunosByFirstChar;
import actions.UpdateAluno;
import model.Aluno;

public class Menu {
	public static void main(String[] args) {
		System.out.println("Bem vindo ao Menu de Alunos!");
		System.out.println("Para começar, escolha uma opcao");
		String menu;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1- Inserir um novo aluno.");
			System.out.println("2- Listar todos os aluno.");
			System.out.println("3- Filtrar lista por inicial do nome.");
			System.out.println("4- Buscar um aluno.");
			System.out.println("5- Editar um aluno.");
			System.out.println("6- Excluir um aluno");
			System.out.println("S- Sair");
			menu = sc.next().toLowerCase();
			menu = menu.toLowerCase();
			switch(menu) {
				//Inserir aluno
				case "1":{
					Aluno aluno = new Aluno();
					System.out.println("Insira o nome: ");
					aluno.setNome(sc.next());
					System.out.println("Insira o CPF: ");
					aluno.setCPF(sc.next());
					System.out.println("Insira o endereco: ");
					aluno.setEndereco(sc.next());
					
					InsertAluno IA = new InsertAluno();
					IA.action(aluno);
					System.out.println("Aluno salvo com sucesso!\n");

					break;
				}
				
				//listar aluno
				case "2":{
					SelectAlunos SA = new SelectAlunos();
					List<Aluno> alunos = SA.action();
					for (Aluno aluno : alunos) {
						System.out.println("Id: "+ aluno.getId());
						System.out.println("Nome: "+ aluno.getNome());
						System.out.println("Endereco: "+ aluno.getEndereco());
						System.out.println("---------------------------\n");
					}
					System.out.println("Aperte enter para continuar.");
					InputStreamReader espera;
					try {
					       espera = new InputStreamReader(System.in);
					       espera.read();
					} catch (IOException e) {
					       e.printStackTrace();
					}
					break;
				}
				
				//listar alunos pela inicial
				case "3":{
					SelectAlunosByFirstChar SA = new SelectAlunosByFirstChar();
					System.out.println("Informe a inicial do nome: ");
					String letra = sc.next();
					List<Aluno> alunos = SA.action(letra);
					for (Aluno aluno : alunos) {
						System.out.println("Id: "+ aluno.getId());
						System.out.println("Nome: "+ aluno.getNome());
						System.out.println("Email: "+ aluno.getCPF());
						System.out.println("---------------------------\n");
					}
					System.out.println("Aperte enter para continuar.");
					InputStreamReader espera;
					try {
					       espera = new InputStreamReader(System.in);
					       espera.read();
					} catch (IOException e) {
					       e.printStackTrace();
					}
					break;
				}
				
				//buscar aluno
				case "4":{
					System.out.println("Informe o ID: ");
					Long id = Long.parseLong(sc.next());
					SearchAlunoById SA = new SearchAlunoById();
					Aluno aluno = SA.action(id);
					if(aluno != null) {
						System.out.println("Nome: "+ aluno.getNome());
						System.out.println("Email: "+ aluno.getCPF());
						System.out.println("Endereco: "+ aluno.getEndereco());
						System.out.println("---------------------------\n");
					} else {
						System.out.println("Nenhum contato encotrado");
					}
					System.out.println("Aperte enter para continuar.");
					InputStreamReader espera;
					try {
					       espera = new InputStreamReader(System.in);
					       espera.read();
					} catch (IOException e) {
					       e.printStackTrace();
					}
					break;
				}
				
				//editar aluno
				case "5":{
					System.out.println("Informe o ID: ");
					Long id = Long.parseLong(sc.next());
					SearchAlunoById SA = new SearchAlunoById();
					Aluno aluno = SA.action(id);
					System.out.println("\n");
					if(aluno != null) {
						System.out.println("Informacoes do aluno:");
						System.out.println("Nome: "+ aluno.getNome());
						System.out.println("Email: "+ aluno.getCPF());
						System.out.println("Endereco: "+ aluno.getEndereco());
						System.out.println("---------------------------\n");
						String opUpdateContinue = null;
						do{
							System.out.println("O que voce deseja alterar?");
							System.out.println("1- Nome.\n2- CPF.\n3- Endereco\n");
							String opUpdate = sc.next();
							
							switch(opUpdate) {
								case "1":{
									System.out.println("Insira o novo nome: ");
									aluno.setNome(sc.next());
									break;
								}
								
								case "2":{
									System.out.println("Insira o novo CPF: ");
									aluno.setCPF(sc.next());
									break;
								}
								
								case "3":{
									System.out.println("Insira o novo endereco: ");
									aluno.setEndereco(sc.next());
									break;
								}
								
								default:{
									System.out.println("Insira uma opcao valida");
									break;
								}
							}
							
							do {
								System.out.println("Deseja continuar editando?\n1- Sim.\n2- Nao.");
								opUpdateContinue = sc.next().toLowerCase();
								switch(opUpdateContinue) {
									
									case "1":{
										System.out.println("Informacoes do aluno:");
										System.out.println("Nome: "+ aluno.getNome());
										System.out.println("Email: "+ aluno.getCPF());
										System.out.println("Endereco: "+ aluno.getEndereco());
										System.out.println("---------------------------\n");
										break;
									}
								
									case "2":{
										UpdateAluno UA = new UpdateAluno();
										UA.action(aluno);
										break;
									}
									
									default:{
										System.out.println("Informe uma opcao valida");
										break;
									}
								}
							}while(!(opUpdateContinue.equals("1")||opUpdateContinue.equals("2")));
							
						}while(!opUpdateContinue.equals("2"));
						
					} else {
						System.out.println("Nenhum contato encotrado");
					}
					break;
				}
				
				//excluir aluno
				case "6":{
					System.out.println("Informe o ID: ");
					Long id = Long.parseLong(sc.next());
					SearchAlunoById SA = new SearchAlunoById(); 
					Aluno aluno = SA.action(id);
					System.out.println("\n");
					if(aluno != null) {
						System.out.println("O aluno com o "+ id +"id e:");
						System.out.println("Nome: "+ aluno.getNome());
						System.out.println("CPF: "+ aluno.getCPF());
						System.out.println("Endereco: "+ aluno.getEndereco());
						System.out.println("---------------------------\n");
						System.out.println("\nDeseja deletar o Aluno? 1- Sim  2- Nao");
						String opDelete = sc.next();
						if(opDelete.equalsIgnoreCase("1")) {
							DeleteAlunoById DA = new DeleteAlunoById();
							boolean res = DA.action(aluno.getId());
							if(res) {
								System.out.println("Aluno deletado com sucesso!");
							} else {
								System.out.println("Falha ao deletar o aluno.");
							}
						} else {
							System.out.println("Cancelando operacao...");
						}
					} else {
						System.out.println("Nenhum aluno encotrado");
					}
					break;
				}
				
				case "7":{
					System.out.println("Obrigado por utilizar o aplicativo!");
					break;
				}
				
				default:{
					System.out.println("Insira uma opcao valida");
					break;
				}
			}
		}while(!menu.equals("7"));
		sc.close();
	}
}

