package productos;

public class productos {      

	public productoItem listaProiductos[] = new productoItem[50];


	public void inicializarListaProductos() {
		
		listaProiductos[0] = new productoItem(11234, "Bebidas varias", 1, "Agua natural", 1.26);
		listaProiductos[1] = new productoItem(12345, "Bebidas varias", 1, "Agua con gas", 1.26);
		listaProiductos[2] = new productoItem(13456, "Bebidas varias", 1, "Zumo de naranja", 1.35);
		listaProiductos[3] = new productoItem(14567, "Bebidas varias", 1, "Zumo de tomate", 1.35);
		listaProiductos[4] = new productoItem(11234, "Bebidas varias", 1, "Agua natural", 1.26);
		listaProiductos[5] = new productoItem(11234, "Bebidas varias", 1, "Agua natural", 1.26);
		
		
	}
  
    public static void main(String[] args) {


        productos.add(new productoItem(15678, "Bebidas varias", 1, "Zumo de piña", 1.35));

        productos.add(new productoItem(21789, "Bebidas Energéticas", 2, "Kombucha", 2.07));
        productos.add(new productoItem(22456, "Bebidas Energéticas", 2, "Kombucha", 2.07));
        productos.add(new productoItem(23456, "Bebidas Energéticas", 2, "Kombucha", 2.07));
        productos.add(new productoItem(24678, "Bebidas Energéticas", 2, "Kombucha", 2.07));

                for (productosItem p : productos) {
            System.out.println(p);
        }
    }
}