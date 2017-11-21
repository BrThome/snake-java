package src;

import java.io.*;

class FileHandler {

        private static String filePath = "snake_save.ser";

        public static void saveFile(Entities ent) { // Salva o Arquivo
        	try {
                FileOutputStream fileOut = new FileOutputStream(filePath); // abre uma stream direcionada ao arquivo especifico em filePath acima
                
                ObjectOutputStream out = new ObjectOutputStream(fileOut); // abre uma stream de objeto, para serializar, o objeto e colocar neste arquivo
                out.writeObject(ent); // escreve o objeto no arquivo alvo atrav�s do stream de objetos acima (ObjectOutputStream)
                
                out.close(); // fecha a stream de objeto
                fileOut.close(); // fecha a stream de arquivo.
                // � importante sempre fechar as streams ap�s usa-las para evitar que dados sejam corrompidos
                
                //System.out.printf("Data saved to \"" + filePath + "\"");
                
             } catch (IOException i) {  // Caso d� algum outro erro referente aos streams de grava��o em arquivo
            	 System.err.println(i.getMessage());
             }
        }

        public static Entities loadFile() {
        	Entities e = null; // inicializa entidades como nulo.
            try {
            	FileInputStream fileIn = new FileInputStream(filePath); // cria e abre uma stream direcionada ao arquivo especifico em filePath acima
            	
            	ObjectInputStream in = new ObjectInputStream(fileIn); // abre uma stream de objeto, para serializar, o objeto e colocar neste arquivo
            	
            	e = (Entities) in.readObject(); // tentar ler uma entidade de dentro do arquivo sendo lido pelo in (ObjectInputStream)
            	
            	if(e != null) { // se n�o for nulo, a de inicio da cobra s�o alteradas no gamehandler, para evitar que ela morra logo que spawne
            		GameHandler.dx = e.getHead().getDx();
        			GameHandler.dy = e.getHead().getDy();
            	}
            	
            	in.close();
            	fileIn.close();
            	// De novo, � importante refor�ar que � importante sempre fechar as streams ap�s usa-las para evitar que dados sejam corrompidos
            	
            } catch (FileNotFoundException f) { // Caso o arquivo n�o seja encontrado, � retornado null para que GameHandler lide com o resto.
            	System.err.println("Save file not found.");
            	return null;
            	
            } catch (IOException i) { // Caso d� algum outro erro referente aos streams de leitura de arquivo
            	System.err.println(i.getMessage());
            	return null;
            	
            } catch (ClassNotFoundException c) { // Caso n�o exista a classe Entities. O que por sinal � um problem�o sabe...
            	System.err.println("Entities Class not found.");
            	c.printStackTrace();
            	return null;
            }
            return e;
        }
}
