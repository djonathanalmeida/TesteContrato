package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departamento;
import entities.HoraContrato;
import entities.Trabalho;
import enums.NivelTrabalho;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Informe o nome do departamento ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Insira os dados do trabalhador:");
		System.out.print("Nome: ");
		String nomeTrabalho = sc.nextLine();
		System.out.print("Nivel: ");
		String nivelTrabalho = sc.nextLine();
		System.out.print("Salário Base: ");
		double salarioBase = sc.nextDouble();
		Trabalho trabalho = new Trabalho(nomeTrabalho, NivelTrabalho.valueOf(nivelTrabalho), salarioBase, new Departamento(nomeDepartamento));

		System.out.print("Quantos contratos para este trabalhador? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Insira o contrato #" + i + " data:");
			System.out.print("Data (DD/MM/YYYY): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorporHora = sc.nextDouble();
			System.out.print("Duração (hora): ");
			int horas = sc.nextInt();
			HoraContrato contrato = new HoraContrato(dataContrato, valorporHora, horas);
			trabalho.addContrato(contrato);
		}

		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String mesEAno = sc.next();
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		System.out.println("Name: " + trabalho.getNome());
		System.out.println("Department: " + trabalho.getDepartmento().getNomeLocal());
		System.out.println("Income for " + mesEAno + ": " + String.format("%.2f", trabalho.renda(ano, mes)));

		sc.close();

	}

}
