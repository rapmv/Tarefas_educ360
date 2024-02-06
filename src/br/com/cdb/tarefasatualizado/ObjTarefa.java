package br.com.cdb.tarefasatualizado;

public class ObjTarefa {
	
	private String nomeTarefa;
	private double hora;
	
	
	public ObjTarefa() {
		
	}
	
	public ObjTarefa(String nomeTarefa, double hora) {
		this.nomeTarefa = nomeTarefa;
		this.hora = hora;
	}

	public String getNomeTarefa() {
		return nomeTarefa;
	}

	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}

	public double getHora() {
		return hora;
	}

	public void setHora(double hora) {
		this.hora = hora;
	}
	
}
