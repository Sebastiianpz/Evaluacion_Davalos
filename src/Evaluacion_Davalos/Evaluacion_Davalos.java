package Evaluacion_Davalos;

import java.util.Scanner;

public class Evaluacion_Davalos {

	public static void main(String[] args) {

		Scanner data = new Scanner(System.in);

		String[] apellidos = {"Messi", "Davalos", "Gonzalez", "Giovinazzo", "Martinez"};
		int[] camisetas = {10, 5, 11, 9, 23};
		int contraseña = 2008, contraseña_ingresada, numerobusqueda;
		char opcion;
		boolean encontrado = false;

		System.out.println("Ingrese la contraseña: ");
		contraseña_ingresada = data.nextInt();

		while (contraseña != contraseña_ingresada) {

			System.err.print("Contraseña incorrecta.");
			System.out.print(" Ingresar nuevamente: ");
			contraseña_ingresada = data.nextInt();
		}

		for (int i = 0; i < camisetas.length - 1; i++) {

			for (int j = 0; j < camisetas.length - i - 1; j++) {

				if (camisetas[j] < camisetas[j + 1]) {

					int temporalCamisetas = camisetas[j + 1];

					camisetas[j + 1] = camisetas[j];

					camisetas[j] = temporalCamisetas;

					String temporalApellidos = apellidos[j + 1];

					apellidos[j + 1] = apellidos[j];

					apellidos[j] = temporalApellidos;
				}
			}
		}

		System.out.println("\nLos numeros de camisetas ordenadas junto con sus apellidos son: \n");

		for (int i = 0; i < camisetas.length; i++) {

			System.out.println(camisetas[i] + " " + apellidos[i]);
		}

		System.out.println("\nIngrese un numero de camiseta a buscar: ");
		numerobusqueda = data.nextInt();

		for (int i = 0; i < camisetas.length; i++) {

			if (numerobusqueda == camisetas[i]) {

				encontrado = true;

				System.out.println("\n" + camisetas[i] + " " + apellidos[i]);

				System.out.println("\n¿Desea modificar el apellido? (S/N): ");
				opcion = data.next().charAt(0);

				if (opcion == 's' || opcion == 'S') {

					System.out.println("\nIngrese un nuevo apellido: ");
					apellidos[i] = data.next();

					System.out.println("\nEl nuevo apellido junto a su camiseta es: \n");
					System.out.println(camisetas[i] + " " + apellidos[i]);

					System.out.println("\nPrograma finalizado.");
				}

				else if (opcion == 'n' || opcion == 'N') {

					System.out.println("\nPrograma finalizado.");
				}

				else {

					System.err.println("\nOpcion incorrecta.");
				}
			}
		}

		if (encontrado == false) {

			System.out.println("Numero de camiseta no encontrado.");
		}
	}
}
