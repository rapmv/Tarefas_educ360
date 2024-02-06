package br.com.cdb.tarefasatualizado;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Menu verificarOpcao = new Menu();
		
		Tarefas tarefa = new Tarefas();
		
		//Objteos para povoar a lista
		ObjTarefa objTarefa4 = new ObjTarefa("varrer", 23.50);
		ObjTarefa objTarefa1 = new ObjTarefa("passar", 12.01);
		ObjTarefa objTarefa2 = new ObjTarefa("correr", 1.50);
		ObjTarefa objTarefa3 = new ObjTarefa("lavar", 1.40);
		
		//Criando a Lista de objetos
		ArrayList<ObjTarefa> listaTarefas = new ArrayList<>();
		
		//povoando a lista
		listaTarefas.add(objTarefa1);
		listaTarefas.add(objTarefa2);
		listaTarefas.add(objTarefa3);
		listaTarefas.add(objTarefa4);
		
		boolean opcaoResultado = true;
		char opcao;
		int loop =1;
		
		while(loop !=0) {
			opcaoResultado=true;
			System.out.println("===============MENU==============");
			System.out.println("Digite a opção que deseja!");
			System.out.println("1-Adicionar tarefa");
			System.out.println("2-Remover tarefa");
			System.out.println("3-Listar tarefa");
			System.out.println("4-Listar em ordem alfabética as tarefa");
			System.out.println("5-Listar em ordem cronológica as tarefa");
			System.out.println("0-SAIR");
			opcao = input.next().charAt(0);
			
			opcaoResultado = verificarOpcao.verificacao(opcao);
			if(opcao=='0') {
				loop=0;
			}
			if (opcaoResultado == true) {
				listaTarefas = tarefa.realizarTarefas(opcao, listaTarefas);				
			}
			else {
				System.out.println("OPÇÃO NÃO REGISTRADA");
			}
			System.out.println("");
		}
		input.close();
	}

}
