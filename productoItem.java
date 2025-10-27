package productos;

public class productoItem {
	private int codProd;
    private String tipoProd;
    private int tipoNum;
    private String nomProd;
    private double precio;

    public int getCodProd() {
		return codProd;
	}


	public void setCodProd(int codProd) {
		this.codProd = codProd;
	}


	public String getTipoProd() {
		return tipoProd;
	}


	public void setTipoProd(String tipoProd) {
		this.tipoProd = tipoProd;
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


	public productoItem(int codProd, String tipoProd, int tipoNum, String nomProd, double precio) {
        this.codProd = codProd;
        this.tipoProd = tipoProd;
        this.tipoNum = tipoNum;
        this.nomProd = nomProd;
        this.precio = precio;
    }

    
    public String toString() {
        return codProd + " | " + tipoProd + " | " + tipoNum + " | " + nomProd + " | " + precio;
    }
}
