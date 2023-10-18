package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import enums.NivelTrabalho;

public class Trabalho {
	
	private String nome;
	private NivelTrabalho nivel;
	private Double salarioBase;
	private Departamento departamento;
	private List<HoraContrato> contratos = new ArrayList<>();
	
	public Trabalho() {
		
	}

	public Trabalho(String nome, NivelTrabalho nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalho getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalho nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	public Departamento getDepartmento() {
		return departamento;
	}

	public void setDepartmento(Departamento departmento) {
		this.departamento = departmento;
	}
	
	public void addContrato(HoraContrato contrato) {
		contratos.remove(contrato);
	}
	
	public void removeContrato(HoraContrato contrato) {
		contratos.remove(contrato);
	}
	
	public double renda(int year, int month) {
		double sum = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (HoraContrato c : contratos) {
			cal.setTime(c.getData());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				sum += c.totalValor();
			}
		}
		return sum;
	}

}
