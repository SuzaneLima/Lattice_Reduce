import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.naming.CommunicationException;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class ArquivoXML {
	
	private static String[][] contextoFormal;
	
	
	public void teste() throws IOException{
						
		int numObjetos = 5;
		int numConjuntos = 6;
		
		contextoFormal = new String[numObjetos][numConjuntos];
		
		File path = new File("C:/Users/suzane Carol/Documents/Mestrado/Projeto Mestrado-Ontologia/FFCA/teste2.txt");
		File path2 = new File("C:/Users/suzane Carol/Documents/Mestrado/Projeto Mestrado-Ontologia/FFCA/objTeste.txt");
		File path3 = new File("C:/Users/suzane Carol/Documents/Mestrado/Projeto Mestrado-Ontologia/FFCA/atriTeste.txt");
  		                    
          FileReader fr = new FileReader(path);
          BufferedReader lerArq = new BufferedReader(fr);
          
          String data = null;
          
          String[] colunas = null;
          int linhas = 0;
          while((data = lerArq.readLine()) != null){
        	  //System.out.println(data);     
        	    colunas = data.split("\t");
        	    for (int i = 0; i < colunas.length; i++)
        	    {
        	    	contextoFormal[linhas][i] = colunas[i];
        	    }
        	    linhas++;
              //System.out.println("Leu o arquivo");
          }
          //System.out.println(contextoFormal);
          
          fr = new FileReader(path2);
          lerArq = new BufferedReader(fr);
          
          String[] objetos = new String[5];
          data = null;
          int aux = 0;
          while((data = lerArq.readLine()) != null){
        	  //System.out.println(data);     
        	    objetos[aux] = data;
        	    aux++;
              //System.out.println("Leu o arquivo");
          }
          
          fr = new FileReader(path3);
          lerArq = new BufferedReader(fr);
          
          String[] atributos = new String[6];
          data = null;
          aux = 0;
          while((data = lerArq.readLine()) != null){
        	  //System.out.println(data);     
        	    atributos[aux] = data;
        	    aux++;
              //System.out.println("Leu o arquivo");
          }
          
          for(int i = 0; i < numObjetos; i++){
    			for(int j = 0; j < numConjuntos; j++){
    					
				System.out.print(contextoFormal[i][j] + "\t"); 
												
    			}
    			System.out.print("\n");
         }
          
          System.out.println("leu arquivo");
          
          
    			//try {
					//lerArq.close();
				//} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				//}
    	  		
    			//fr.close();
    	  		
    	
          
          Element context = new Element("context");
          for(int i = 0; i < numObjetos; i++){
        	  	Element object = new Element("object");
        	  	object.setAttribute(new Attribute("name",objetos[i]));
        	  	for(int j = 0; j < numConjuntos; j++){
        	  		Element attribute = new Element("attribute");
        	  		attribute.setAttribute(new Attribute("name", atributos[j]));
        	  		Element membership = new Element("membership");
        	  		membership.setText(contextoFormal[i][j]);
        	  		attribute.addContent(membership);
        	  		object.addContent(attribute);
        	  	}
        	  	context.addContent(object);
          }
    
          Document doc = new Document();
          doc.setRootElement(context);
    
          Writer out = new OutputStreamWriter(new FileOutputStream("C:/Users/suzane Carol/Documents/Mestrado/Projeto Mestrado-Ontologia/Gera XML/grupoIa.xml"));
          XMLOutputter xout = new XMLOutputter();
          xout.setFormat(Format.getCompactFormat().setEncoding("ISO-8859-1"));
          xout.output(doc, out);
          System.out.println("XML criado com sucesso!");
    
	
	}
          
	}

