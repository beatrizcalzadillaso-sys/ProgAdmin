package retrotipos;

public class productoItem {
	private int codProd;
    private int tipoNum;
    private String nomProd;
    private double precio;

    public int getCodProd() {
		return codProd;
	}


	public void setCodProd(int codProd) {
		this.codProd = codProd;
	}


	public int getTipoNum() {
		return tipoNum;
	}


	public void setTipoNum(int tipoNum) {
		this.tipoNum = tipoNum;
	}


	public String getNomProd() {
		return nomProd;
	}


	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public productoItem(int codProd, int tipoNum, String nomProd, double precio) {
        this.codProd = codProd;
        this.tipoNum = tipoNum;
        this.nomProd = nomProd;
        this.precio = precio;
    }

    
    public String toString() {
        return codProd + " | " + tipoNum + " | " + nomProd + " | " + precio;
    }
}
