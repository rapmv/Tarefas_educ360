package br.com.cdb.tarefasatualizado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Tarefas {
	
	private String tarefaExecutar;
	private double tarefaHora;
	
	public ArrayList <ObjTarefa> realizarTarefas(char opcao, ArrayList<ObjTarefa> listaTarefas){
		
		Scanner input = new Scanner(System.in);
		
		boolean flag;
		
		switch(opcao) {
			case '1':
				
				flag = true;
				
				System.out.println("Digite qual tarefa sera adicionada: ");
				tarefaExecutar = input.nextLine();
				System.out.println("Digite o horario da tarefa: ");
				tarefaHora = input.nextDouble();
				
				for(int i=0; i<listaTarefas.size(); i++) {
					if(tarefaExecutar.equals(listaTarefas.get(i).getNomeTarefa())) {
						flag=false;
					}
				}
				
				if(flag==true) {
					listaTarefas = tarefaADD(listaTarefas);
					System.out.println("Tarefa adicionada!");
				}
				else {
					System.out.println("Tarefa ja existe!");
				}
				
			break;
			case '2':
				flag = false;
				int posicaoTarefa =0;
				
				System.out.println("Digite qual tarefa sera removida: ");
				tarefaExecutar = input.nextLine();
				
				for(int i=0; i<listaTarefas.size(); i++) {
					if(tarefaExecutar.equals(listaTarefas.get(i).getNomeTarefa())) {
						flag=true;
						posicaoTarefa = i;
					}
				}
				if(flag==true) {
					char op = 'n';
					System.out.println("Tem certeza que deseja remover?(s)");
					op=input.next().charAt(0);
					if(op=='s') {
						tarefaRemover(listaTarefas, posicaoTarefa);
						System.out.println("Tarefa foi removida!");
					}
					else {
						System.out.println("Tarefa não foi removida!");
					}
				}
				
				
			break;
			case '3':
				System.out.println("==========LISTA DE TAREFAS=======");
				tarefaListar(listaTarefas);
			break;
			case '4':
				System.out.println("====LISTA DE TAREFAS ORDENADA====");
				tarefaOrdenar(listaTarefas);
			break;
			case '5':
				System.out.println("===LISTA DE TAREFAS CRONOLOGICA===");
				tarefaCronologica(listaTarefas);
			break;
			default:
				System.out.println("PROGRAMA FINALIZADO");
			break;
		}

		return listaTarefas;
	}
	
	

	private ArrayList<ObjTarefa> tarefaADD(ArrayList listaTarefas){
		
		ObjTarefa objTarefa = new ObjTarefa();
		objTarefa.setNomeTarefa(tarefaExecutar);
		objTarefa.setHora(tarefaHora);
		listaTarefas.add(objTarefa);
		
		return listaTarefas;
	}
	
	private ArrayList<ObjTarefa> tarefaRemover(ArrayList listaTarefas, int posicaoTarefa) {
		
		listaTarefas.remove(listaTarefas.get(posicaoTarefa));
		
		return listaTarefas;
	}
	
	private void tarefaListar(ArrayList<ObjTarefa> listaTarefas){
		
		for(int i=0; i<listaTarefas.size(); i++) {
			System.out.printf("TAREFA: "+ listaTarefas.get(i).getNomeTarefa()+
					" hora: %.2f", listaTarefas.get(i).getHora());
			System.out.println();
		}
	}
	
	private void tarefaOrdenar(ArrayList<ObjTarefa> listaTarefas){
		
		ArrayList<ObjTarefa> copyList = new ArrayList<>(listaTarefas);
	
		Collections.sort(copyList, Comparator.comparing(ObjTarefa::getNomeTarefa));
		
		tarefaListar(copyList);
		
	}
	
	private void tarefaCronologica(ArrayList<ObjTarefa> listaTarefas){
		
		ArrayList<ObjTarefa> copyList = new ArrayList<>(listaTarefas);
	
		Collections.sort(copyList, Comparator.comparing(ObjTarefa::getHora));
		
		tarefaListar(copyList);
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(tarefaExecutar, tarefaHora);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefas other = (Tarefas) obj;
		return Objects.equals(tarefaExecutar, other.tarefaExecutar)
				&& Double.doubleToLongBits(tarefaHora) == Double.doubleToLongBits(other.tarefaHora);
	}

}
