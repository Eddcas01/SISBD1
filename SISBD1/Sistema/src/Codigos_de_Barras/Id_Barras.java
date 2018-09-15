package Codigos_de_Barras;




import Manejadora.PRINCIPAL;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Id_Barras {
    void Codigo (String id) throws IOException{  //Genera Codigo de Barras y Escribe nuevo codigo en 
        try {
            Document doc = new Document();
            PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream(id+".pdf"));
            doc.open();
            //code 128
            Barcode128 code = new Barcode128();
            code.setCode(id);
            Image img = code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);            
            img.scalePercent(200);
            doc.add(img);
            doc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
            File archivo = new File("cod.txt");
        FileWriter fw = new FileWriter(archivo);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(id);
        bw.close();
        }catch (FileNotFoundException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
      
    }
}
