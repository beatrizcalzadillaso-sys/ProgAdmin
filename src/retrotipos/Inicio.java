package retrotipos;

import java.util.Scanner;

public class Inicio {
	
	static Scanner sc = new Scanner(System.in);
	public static ProductoItem listaProductos[] = new ProductoItem[50];

	public static void main(String[] args) throws InterruptedException {
		// Creamos los objetos default
		inicializarListaProductos();
		int op1 = 0;
		
		do {
			// Cambiar esto por algo relacionado con las maquinas.
			System.out.println("Welcome to the underground");
			
			System.out.print("Iniciar admin? (1/0): ");
			int op = Integer.parseInt(sc.nextLine());
			if(op==1) {
				
				System.out.print("name: ");
				String opS = sc.nextLine();
				
				if(opS.contentEquals("admin")) {
					
					System.out.print("password: ");
					int opP = Integer.parseInt(sc.nextLine());
					
					if(opP==12345) {
						// Aqui se llama al Admin
						Admin.main(args);
					}
				}
				else {
					System.out.println("ERROR: Acceso no autorizado.");
				}
			}
			else {
				System.out.print("¿Salir? (1/0):");
				op1 = Integer.parseInt(sc.nextLine());
				
				if(op1==0) {
					// Aqui es donde habria que llamar al Cliente.
					System.out.println("Cliente va aqui");
				}
				//Ajustar la espera a lo que pedia el enunciado.
				Thread.sleep(5000);
			}
		} while(op1!=1);
	}
	
	/**
	 * Esta funcion crea los objetos default del programa, para que el usuario y el admin tengan algo desde el principio.
	 */
	public static void inicializarListaProductos() {

		listaProductos[0] = new ProductoItem(112, 1, "Agua natural", 1.26);
		listaProductos[1] = new ProductoItem(123, 1, "Agua con gas", 1.26);
		listaProductos[2] = new ProductoItem(134, 2, "Zumo de naranja", 1.35);
		listaProductos[3] = new ProductoItem(145, 2, "Zumo de tomate", 1.35);
	}

}
