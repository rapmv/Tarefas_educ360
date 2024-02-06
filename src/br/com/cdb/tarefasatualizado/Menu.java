package br.com.cdb.tarefasatualizado;

public class Menu {

	private char [] listaOpcoes = {'0', '1', '2', '3', '4', '5'};
	boolean resultado;
	
	public boolean verificacao(char opcao) {
		
		resultado = false;
		
		for(int i=0; i<listaOpcoes.length; i++) {
			if(listaOpcoes[i] == opcao) {
				resultado = true;
			}
		}
		return resultado;
	}
}
