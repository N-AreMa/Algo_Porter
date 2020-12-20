
package regex;

import java.io.*;


public class archivos 
{
    public String leerTXT(String direccion) //Direccion del archivo
    {
        String texto = null;
        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            
            while ((bfRead = bf.readLine()) != null )
            {
                temp = temp + bfRead; //Guardado el texto del archivo
            }
            
            texto = temp;
        }
        catch (Exception e)
        {
            System.err.println("No se encontro archivo");
        }
        
        return texto;
    }
}
