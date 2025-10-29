package reto1prototipos;

import java.util.Scanner;

public class PrototipoNoSeLmao {
	
	static String [] anp = new String [100];
	static int [] aidp = new int [100];
	static double [] app = new double [100];
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		anp[1] = "Zumo"; anp[2] = "Agua"; anp[3] = "snack1"; anp[4] = "snack2";
		aidp[1] = 1; aidp[2] = 2; aidp[3] = 3; aidp[4] = 3;
		app[1] = 1.5; app[2] = 0.25; app[3] = 5; app[4] = 0.99;
		
		System.out.println("1 - Bebidas");
		System.out.println("2 - Agua");
		System.out.println("3 - Snacks");
		System.out.println("4 - Dulce");
		
		while(true) {
			int rs = Integer.parseInt(sc.nextLine());
			añadirCarrito(rs);
		}
	}
	
	private static boolean añadirCarrito(int ars) {
		
		Boolean skip = false;

		for (int i=0; i<aidp.length; i++) {
			if(ars==1&&aidp[i]==1) {
				System.out.println(anp[i]+" - "+app[i]);
			}
			else if(ars==2&&aidp[i]==2) {
				System.out.println(anp[i]+" - "+app[i]);
			}
			else if(ars==3&&aidp[i]==3) {
				System.out.println(anp[i]+" - "+app[i]);
			}
			else if(ars==4&&aidp[i]==4) {
				System.out.println(anp[i]+" - "+app[i]);
			}
		}
		System.out.println("Done");
		System.out.println("Volver? (1/0)");
		int rs = Integer.parseInt(sc.nextLine());
		if(rs==0) {
			System.out.print("Selecciona un producto: ");
			rs = Integer.parseInt(sc.nextLine());
			for(int i=0; i<aidp.length; i++) {
				if(aidp[i]==rs) {
					
				}
			}
		}
		
		return skip;
	}

}

