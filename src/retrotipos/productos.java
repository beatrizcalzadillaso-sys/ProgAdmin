package retrotipos;

import java.util.Scanner;

public class productos {

	static Scanner sc = new Scanner(System.in);
	public static productoItem listaProductos[] = new productoItem[50];

	public static void main(String[] args) {

		inicializarListaProductos();

		// loggin de administrador

		while (true) {
			System.out.println("QUE QUIERES HACER");
			System.out.println("1 - Matar");
			System.out.println("2 - Crear");
			System.out.println("3 - Modificar");
			int op = Integer.valueOf(sc.nextLine());
			if (op == 1) {
				/// mostrar productos para ver ID, si lalista esta vacia, notificar, y decir que
				/// hay que agregar productos antes de eliminar alguno, y regresar al menu inicio
				matar(); // cambiar nombre, a "eliminar"
			}
			if (op == 2) {
				// verificar si la lista está llena antes de entrar a "crear", y decir que se puede o eliminar o editar producto y regresar al menu inicio
				crear();
			}
			if (op == 3) {
				/// mostrar productos para ver ID, si lalista esta vacia, notificar, y decir que hay agregar uno para poder modificarlo
				mod();
			}

		}
	}

	

	public static int buscar(int ID) {
		int p = 0;
		for (int i = 0; i < listaProductos.length; i++) {
			if (listaProductos[i].getCodProd() == ID) {
				p = i;
				i = listaProductos.length;
			}
		}
		return p;
	}

	// PLACEHOLDER, CAMBIAR A OTRA CLASE CUANDO EXISTA
	public static void inicializarListaProductos() {

		listaProductos[0] = new productoItem(11234, 1, "Agua natural", 1.26);
		listaProductos[1] = new productoItem(12345, 1, "Agua con gas", 1.26);
		listaProductos[2] = new productoItem(13456, 1, "Zumo de naranja", 1.35);
		listaProductos[3] = new productoItem(14567, 1, "Zumo de tomate", 1.35);
	}

	public static void mostrar() {
		for (productoItem p : listaProductos) {
			if (p != null) {
				System.out.println(p);
			}
		}
	}

	public static void matar() {
		System.out.print("A QUIEN QUIERES MATAR? (id): ");
		int op = Integer.valueOf(sc.nextLine());

		for (int i = 0; i < listaProductos.length; i++) {

			if (listaProductos[i].getCodProd() == op) {
				listaProductos[i] = null;
				i = listaProductos.length;
			}
		}

	}

	public static void crear() {

		int op = buscarNull();

		int id = 0;
		int ti = 0;
		do {
			System.out.print("ID: ");
			id = Integer.valueOf(sc.nextLine());
			do {
				System.out.print("Tipo: ");
				ti = Integer.valueOf(sc.nextLine());
			} while (!validarTipoProd(ti));
		} while (!validarCodProd(id, ti));

		System.out.print("nomber: ");
		String no = sc.nextLine();

		double pr = 0.0;
		do {
			System.out.print("Precio: ");
			pr = Double.valueOf(sc.nextLine());
		} while (!validarPrecio(pr));

		listaProductos[op] = (new productoItem(id, ti, no, pr));
	}

	public static int buscarNull() {
		int p = 0;
		for (int i = 0; i < listaProductos.length; i++) {
			if (listaProductos[i] == null) {
				p = i;
				i = listaProductos.length;
			}
		}
		return p;
	}

	private static boolean validarTipoProd(int ti) {
		boolean jesse = false;

		if (ti > 0 && ti < 5) {
			jesse = true;
		} else {
			System.out.println("Tipo incorrecto, vuelve a intentarlo.");
		}

		return jesse;
	}

	private static boolean validarCodProd(int cod, int ti) {
		boolean walter = false;
		int codbo2 = Integer.parseInt(String.valueOf(cod).substring(0, 1));

		if (String.valueOf(cod).length() == 5) {
			if (codbo2 == ti) {
				walter = true;
			} else {
				System.out.println("El código de producto no se corresponde con los tipos de productos existentes");
			}
		} else {
			System.out.println("El código de producto no se corresponde con la cantidad de cifras");
		}

		return walter;
	}

	private static boolean validarPrecio(double pr) {
		boolean saul = true;

		double pr1 = pr * 100;
		int goodman = String.valueOf(pr1).length();
		int pr2 = Integer.parseInt(String.valueOf(pr).substring(0, 1));

		if (pr2 == 0) {
			saul = false;
		}
		if (goodman > 5) {
			saul = false;
		}
		if (!saul) {
			System.out.println("El precio excede/está por debajo el rango establecido, rectifique el precio");
		}

		return saul;
	}

	public static void mod() {
		System.out.print("A QUIEN QUIERES cambiar? (id): ");
		int op = Integer.valueOf(sc.nextLine());

		int mo = buscar(op);
		int opp = 0;

		do {
			System.out.println("Tipo (previamente " + listaProductos[mo].getTipoNum() + "):");
			opp = Integer.valueOf(sc.nextLine());
		} while (!validarTipoProd(opp));
		listaProductos[mo].setTipoNum(opp);

		System.out.print("nomber (previamente " + listaProductos[mo].getNomProd() + "): ");
		listaProductos[mo].setNomProd(sc.nextLine());

		double oppp = 0;
		do {
			System.out.print("Precio (previamente " + listaProductos[mo].getPrecio() + "): ");
			oppp = Double.valueOf(sc.nextLine());
		} while (!validarPrecio(oppp));
		listaProductos[mo].setPrecio(oppp);
	}

	
}