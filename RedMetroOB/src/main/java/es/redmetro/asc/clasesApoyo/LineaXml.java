package es.redmetro.asc.clasesApoyo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "linea")
public class LineaXml {

	
		@JacksonXmlProperty(localName = "cod_linea")
		private int cod_linea;
		
		@JacksonXmlProperty(localName = "nombre_corto")
		private String nombre_corto;
		
		@JacksonXmlProperty(localName = "nombre_largo")
		private String nombre_largo;
		
		@JacksonXmlProperty(localName = "cod_color")
		private int cod_color;
		
		@JacksonXmlProperty(localName = "url_img_tmp")
		private String url_img_tmp;
		
		@JacksonXmlProperty(localName = "kilometros" )
		private float kilometros;

	
		
		
		
		@Override
		public String toString() {
			return "LineaXml [cod_linea=" + cod_linea + ", nombre_corto=" + nombre_corto + ", nombre_largo="
					+ nombre_largo + ", cod_color=" + cod_color + ", url_img_tmp=" + url_img_tmp + ", kilometros="
					+ kilometros + "]";
		}

		public int getCod_linea() {
			return cod_linea;
		}

		public void setCod_linea(int cod_linea) {
			this.cod_linea = cod_linea;
		}

		public String getNombre_corto() {
			return nombre_corto;
		}

		public void setNombre_corto(String nombre_corto) {
			this.nombre_corto = nombre_corto;
		}

		public String getNombre_largo() {
			return nombre_largo;
		}

		public void setNombre_largo(String nombre_largo) {
			this.nombre_largo = nombre_largo;
		}

		public int getCod_color() {
			return cod_color;
		}

		public void setCod_color(int cod_color) {
			this.cod_color = cod_color;
		}

		public String getUrl_img_tmp() {
			return url_img_tmp;
		}

		public void setUrl_img_tmp(String url_img_tmp) {
			this.url_img_tmp = url_img_tmp;
		}

		public float getKilometros() {
			// TODO Auto-generated method stub
			return kilometros;
		}

//		public String getKilometros() {
//			return kilometros;
//		}
//
//		public void setKilometros(String kilometros) {
//			this.kilometros = kilometros;
//		}
		
		
		


}
