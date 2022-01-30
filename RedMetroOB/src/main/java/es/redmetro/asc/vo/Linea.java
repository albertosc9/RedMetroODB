package es.redmetro.asc.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Entity
@JacksonXmlRootElement(localName = "linea")
public class Linea {

	@Column(name="codigoLinea")
	private int codigoLinea;
	
	
	private String nombreCorto;
	
	
	private String nombreLargo;
	
	 @OneToOne(optional=false)
	    @JoinColumn(
	    	name="cod_color", unique=true, nullable=false, updatable=false)
	private Color color;
	
	private double kilometros;
	
	private byte[] imagenLinea;

	public int getCodigoLinea() {
		return codigoLinea;
	}

	public void setCodigoLinea(int codigoLinea) {
		this.codigoLinea = codigoLinea;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getNombreLargo() {
		return nombreLargo;
	}

	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getKilometros() {
		return kilometros;
	}

	public void setKilometros(double kilometros) {
		this.kilometros = kilometros;
	}

	public byte[] getImagenEmpleado() {
		return imagenLinea;
	}

	public void setImagenEmpleado(byte[] imagenLinea) {
		this.imagenLinea = imagenLinea;
	}

	@Override
	public String toString() {
		return "Linea [codigoLinea=" + codigoLinea + ", nombreCorto=" + nombreCorto + ", nombreLargo=" + nombreLargo
				+ ", color=" + color + ", kilometros=" + kilometros + "]";
	}   
	
	

	 
}
