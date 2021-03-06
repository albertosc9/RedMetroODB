package es.redmetro.asc.app;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import es.redmetro.asc.clasesApoyo.LineaXml;
import es.redmetro.asc.dao.IRedMetro;
import es.redmetro.asc.dao.jpa.ColorJpa;
import es.redmetro.asc.dao.jpa.LineaJpa;
import es.redmetro.asc.procesamiento.Deseralitation;
import es.redmetro.asc.vo.Color;
import es.redmetro.asc.vo.Linea;

public class Aplicativo {

	
    public static void main(String[] args) {
    
    
    	 	
    	IRedMetro<Color> accionesColor = new ColorJpa();
       	IRedMetro<Linea> accionesLinea = new LineaJpa();
    	Aplicativo aplicativo = new Aplicativo();
      	   	
    	/*insercion de los datos en objectDB
    	aplicativo.procesarColores();
    	aplicativo.procesarLineas();
    	*/
    
    	
    	//lista de colores
    	
    	List<Color>colores = accionesColor.getLista();
    	for (Color color : colores) {
    		System.out.println(color);
    	}
    	
    	//lista de lineas
    	
    	List<Linea>lineas = accionesLinea.getLista();
    	
    	for (Linea linea : lineas) {
    		System.out.println(linea);
    	}
    	
//    System.out.println(accionesLinea.buscar(1));
 

    }	
  
    

    public  void procesarColores() {
    	
    	List<Color> colores = Deseralitation.getDeseratitation();
    	
    	IRedMetro<Color> acciones  = new ColorJpa();
    	
    	
    	
     	for (Color col : colores) {
     		
     		acciones.crear(col);
    		System.out.println(col);
    	}
    	
    	
    	
    	
    }
    public void procesarLineas() {
    	List<LineaXml> lineas = Deseralitation.getDeseratitationLineas();
    	IRedMetro<Color> accionesColor = new ColorJpa();
       	IRedMetro<Linea> accionesLinea = new LineaJpa();
        
        for (LineaXml li : lineas) {
        	
        	Linea linea = new Linea();
        	
        	
        	Color color1 = accionesColor.buscar(li.getCod_color());
        	
        	System.out.println(color1);
        	
        
        		linea.setColor(color1);
            	linea.setCodigoLinea(li.getCod_linea());
    			linea.setKilometros(li.getKilometros());
    			linea.setNombreCorto(li.getNombre_corto());
    			linea.setNombreLargo(li.getNombre_largo());
    			linea.setImagenEmpleado(getBytesFromUrl(li.getUrl_img_tmp()));
    			
    			
    			accionesLinea.crear(linea);
    			System.out.println(li);
    			
    		
        }
    }
    
	private static byte[] getBytesFromUrl(String TextoUrl) {
		byte [] bytesImage = null;
		
		URL url = null;
		
		try {
			url = new URL(TextoUrl);
			
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			
			urlConnection.addRequestProperty("User-Agent","Mozilla");
			
			
			InputStream input = urlConnection.getInputStream();
			
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			byte [] buffer = new byte[1024];
			
			int len = 0;
			
			while((len = input.read(buffer))!= -1) {
				
				outStream.write(buffer,0,len);
			}
			input.close();
			bytesImage = outStream.toByteArray();
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bytesImage;
		
		
	}
	
 }
    	
//    	ObjectMapper mapper = new XmlMapper();
//    	
//    	String xmlStr = null;
//    	
//    	ListaColores listaColores = new ListaColores();
//    	
//    	List<Color>colores = new ArrayList();
//    	
//    	
//    	
//    	Linea linea = new Linea();
//    	
//    	linea.setCodigoLinea(1);
//    	linea.setNombreCorto("arg???elles");
//    	linea.setNombreLargo("arguelles-manoteras");
//    	linea.setColor(new Color(1,"rojo","#777"));
//    	linea.setKilometros(7);
//    	
//    	Color color= new Color();
//    	Color color1 = new Color();
//    	Color color3 = new Color();
//    	
//    	
//    	color.setCodigoColor(1);
//    	color.setNombre("rojo");
//    	color.setCodigoHexadecimal("#56545");
//    	
//    	color1.setCodigoColor(2);
//    	color1.setNombre("azul");
//    	color1.setCodigoHexadecimal("#43434");
//    	
//    	colores.add(color);
//    	colores.add(color1);
//    	listaColores.setColores(colores);
//    	try {
//    		
//    		//pasar a xml un solo  color
//    		xmlStr = mapper.writeValueAsString(color1);
//    		System.out.println(xmlStr);
//    		
//    		
//    		xmlStr = mapper.writeValueAsString(listaColores);
//    		
//    		
//    		System.out.println(xmlStr);
//    	
//    		color3 = mapper.readValue(xmlStr,Color.class);
//    		
//    		
////    	
////    		Linea linea2= new Linea();
////    		linea2 = mapper.readValue(xmlStr, Linea.class);
////    		System.out.println(linea2);
////    	
//    	
//    	}catch(Exception e) {
//    		
//    	}
//    	
//    
//    
//    }
//    
    

  

