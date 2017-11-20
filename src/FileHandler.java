package src;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class FileHandler {

        private static String filePath = "snake_save.ser";

        public static void saveFile(Entities ent) {
        	try {
                FileOutputStream fileOut =
                new FileOutputStream(filePath);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(ent);
                out.close();
                fileOut.close();
                System.out.printf("Data saved to \"" + filePath + "\"");
             } catch (IOException i) {
                i.printStackTrace();
             }
        }

        public static Entities loadFile() {
        	Entities e = null;
            try {
            	FileInputStream fileIn = new FileInputStream(filePath);
            	ObjectInputStream in = new ObjectInputStream(fileIn);
            	e = (Entities) in.readObject();
            	in.close();
            	fileIn.close();
            } catch (FileNotFoundException f) {
            	System.err.println("File not found. Starting new game.");
            	return null;
            } catch (IOException i) {
            	System.err.println(i.getMessage());
            	return null;
            } catch (ClassNotFoundException c) {
            	System.out.println("Entities Class not found.");
            	c.printStackTrace();
            	return null;
            }
            return e;
        }

		public static void delSave() {
			File f = new File(filePath);
			f.delete();
		}
}
