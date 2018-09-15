package Codigos_de_Barras;




import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.String.valueOf;


public class Id_Cod {
    
    Id_Barras setcod =new Id_Barras();
     
   public String cod(){ // Lee archivo y actualiza codigo de barras
     String cadena;
    int cod=0;
    String ncod="";
    try{
    File archivo = new File("cod.txt");
    FileReader fr = new FileReader(archivo);
    BufferedReader br = new BufferedReader(fr);
    while((cadena=br.readLine())!=null){
        cod = Integer.parseInt(cadena);
        cod++;
        ncod=valueOf(cod);
        setcod.Codigo(ncod);// Se llama al metodo de escritura de la clase Id_Barras
    }
    br.close();
    }catch(FileNotFoundException e){
        e.printStackTrace();
    }catch(IOException e){
        e.printStackTrace();
    }
    return ncod;
   }
    
}
