package es.redmetro.asc.procesamiento;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class Imagen {

	public static byte[] getBytesFromUrl(String TextoUrl) {
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
