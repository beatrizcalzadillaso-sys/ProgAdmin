package retrotipos;

import java.util.Scanner;

public class Admin {

	static Scanner sc = new Scanner(System.in);
	public static ProductoItem listaProductos[] = new ProductoItem[50];

	public static void main(String[] args) {

		inicializarListaProductos();

		// login de administrador.

		int select = 0;
		do {
			System.out.println("¿Que quieres hacer?");
			System.out.println("1 - Eliminar");
			System.out.println("2 - Crear");
			System.out.println("3 - Modificar");
			System.out.println("4 - Salir");
			select = Integer.valueOf(sc.nextLine());
			if (select == 1) {
				eliminar();
			}
			if (select == 2) {
				crear();
			}
			if (select == 3) {
				mod();
			}

		} while (select!=4);
	}

	/**
	 * PLACEHOLDER, CAMBIAR A OTRA CLASE CUANDO EXISTA
	 */
	public static void inicializarListaProductos() {

		listaProductos[0] = new ProductoItem(112, 1, "Agua natural", 1.26);
		listaProductos[1] = new ProductoItem(123, 1, "Agua con gas", 1.26);
		listaProductos[2] = new ProductoItem(134, 1, "Zumo de naranja", 1.35);
		listaProductos[3] = new ProductoItem(145, 1, "Zumo de tomate", 1.35);
	}
	
	/**
	 * Muestra la lista de objetos.
	 */
	public static void mostrar() {
		int error = 0;
		for (ProductoItem p : listaProductos) {
			if (p != null) {
				System.out.println(p.aTextoDeCatalogo());
			}
			else {
				error++;
			}
		}
		if(error==listaProductos.length) {
			System.out.println("ERROR: No se ha encontrado nada.");
		}
	}
	
	/**
	 * Elimina el objeto (usando el ID) que el usuario quiera.
	 */
	public static void eliminar() {
		System.out.print("¿A quien quieres eliminar? (id): \n");
		mostrar();
		// op significa opcion.
		int op = Integer.valueOf(sc.nextLine());
		boolean existe = false;

		for (int i = 0; i < listaProductos.length; i++) {
			
			// asegurate que no sea Null, que si no crashea.
			if (listaProductos[i] != null && listaProductos[i].getCodProd() == op) {
				listaProductos[i] = null;
				existe = true;
				// salta directamente hasta el final, un poco rudimentario, pero funciona de lujo.
				i = listaProductos.length;
			}
		}
		if(!existe) {
			System.out.println("ERROR: no se encuentra ese producto.");
		}
	}

	/**
	 * Crea el objeto que el usuario quiera, realizando todas las verificaciones necesarias.
	 */
	public static void crear() {
		int sal = 0;
		
		System.out.println("¿Quieres salir? (1/0)");
		sal = Integer.valueOf(sc.nextLine());
		
		if(sal!=1) {
			int op = 0;
			// busca el primer null, y crea ahi.
			for (int i = 0; i < listaProductos.length; i++) {
				if (listaProductos[i] == null) {
					op = i;
					i = listaProductos.length;
				}
			}
			int id = 0;
			int ti = 0;
			
			// todas las verificaciones.
			do {
				System.out.print("ID: ");
				id = Integer.valueOf(sc.nextLine());
				do {
					System.out.print("Tipo: ");
					ti = Integer.valueOf(sc.nextLine());
				} while (!validarTipoProd(ti));
			} while (!validarCodProd(id, ti));
			
			System.out.print("nombre: ");
			String no = sc.nextLine();
			
			double pr = 0.0;
			do {
				System.out.print("Precio: ");
				pr = Double.valueOf(sc.nextLine());
			} while (!validarPrecio(pr));
			
			//crea el objeto
			listaProductos[op] = (new ProductoItem(id, ti, no, pr));
		}
	}

	/**
	 * Valida el tipo de producto mirando si es mayor que 0, y menor que 5.
	 * @param ti, el tipo de producto que le da el cliente
	 * @return valido, para saber si el tipo es valido o no.
	 */
	private static boolean validarTipoProd(int ti) {
		// valido, previamente conocido como Jesse.
		boolean valido = false;

		if (ti > 0 && ti < 5) {
			valido = true;
		} else {
			System.out.println("Tipo incorrecto, vuelve a intentarlo.");
		}

		return valido;
	}

	/**
	 * Valida el codigo de producto viendo que el primer numero es igual al tipo, y que sea 3 numeros de largo.
	 * @param cod, el codigo que ha introducido el usuario.
	 * @param ti, el tipo, supuestamente valido, que ha introducido el usuario.
	 * @return
	 */
	private static boolean validarCodProd(int cod, int ti) {
		// valido y primNum, previamente walter y codbo2.
		boolean valido = false;
		// De aqui sacamos el primer numero del codigo.
		int primNum = Integer.parseInt(String.valueOf(cod).substring(0, 1));

		if (String.valueOf(cod).length() == 3) {
			if (primNum == ti) {
				valido = true;
			} else {
				System.out.println("El código de producto no se corresponde con los tipos de productos existentes");
			}
		} else {
			System.out.println("El código de producto no se corresponde con la cantidad de cifras");
		}

		return valido;
	}

	/**
	 * Valida que el precio no sea mayor de 9.99€, ni menos que 1€.
	 * @param pr, el precio que ha puesto el usuario.
	 * @return valido, el bool que dicta si es valido o no.
	 */
	private static boolean validarPrecio(double pr) {
		boolean valido = true;

		// Un poco confuso, pero aqui cogemos los dos primeros decimales junto al entero.
		double preInt = pr * 100;
		// longitud del precio.
		int longPre = String.valueOf(preInt).length();
		// El primer numero, que deberia ser mayor de cero, Y NO PUEDEN HABER DOS (chequea el if con longPre).
		int primNumPre = Integer.parseInt(String.valueOf(pr).substring(0, 1));

		if (primNumPre == 0) {
			valido = false;
		}
		if (longPre > 5) {
			valido = false;
		}
		if (!valido) {
			System.out.println("El precio excede/está por debajo el rango establecido, rectifique el precio");
		}

		return valido;
	}

	/**
	 * Modifica el producto que el usuario quiera.
	 */
	public static void mod() {
		int sal = 0;
		
		if(sal!=1) {
			
			int idx = 999;
			boolean idxVal = false;
			
			do {
				System.out.println("¿Quieres salir? (1/0)");
				sal = Integer.valueOf(sc.nextLine());
				if(sal==1) {
					idxVal = true;
				}
				else {
					System.out.println("¿A quien quieres cambiar? (id): ");
					mostrar();
					int op = Integer.valueOf(sc.nextLine());
					
					for (int i = 0; i < listaProductos.length; i++) {
						if (listaProductos[i] != null && listaProductos[i].getCodProd() == op) {
							idx = i;
							idxVal = true;
							// Salta hasta el final
							i = listaProductos.length;
						}
					}
					if (!idxVal) {
						System.out.println("ERROR: No se ha encontrado ese producto.");
					}
				}
				
			} while(!idxVal);
			
			if(sal!=1) {
				int tipo = 0;
				
				do {
					System.out.println("Tipo (previamente " + listaProductos[idx].getTipoNum() + "):");
					tipo = Integer.valueOf(sc.nextLine());
				} while (!validarTipoProd(tipo));
				listaProductos[idx].setTipoNum(tipo);
				
				System.out.print("nombre (previamente " + listaProductos[idx].getNomProd() + "): ");
				listaProductos[idx].setNomProd(sc.nextLine());
				
				double precio = 0;
				do {
					System.out.print("Precio (previamente " + listaProductos[idx].getPrecioEnEuros() + "): ");
					precio = Double.valueOf(sc.nextLine());
				} while (!validarPrecio(precio));
				listaProductos[idx].setPrecioDesdeEuros(precio);
			}
		}
	}
}
