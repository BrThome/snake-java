import java.io.*;

class FileHandler {

        private static FileOutputStream fileOut;
        private static ObjectOutputStream out;
        private static String playerL;
        private static FileInputStream fileIn;
        private static ObjectInputStream in;

        public static void saveFile(Entities ent) {
                try {
                        fileOut = new FileOutputStream("JSnake.res");
                        out = new ObjectOutputStream(fileOut);
                        out.writeObject(ent);
                        out.close();
                        fileOut.close();
                } catch (IOException i) {
                        i.printStackTrace();
                }
        }

        public static void loadFile(Entities ent) {
                try {
                        fileIn = new FileInputStream("JSnake.res");
                        in = new ObjectInputStream(fileIn);
                        ent = (Entities)in.readObject();
                        in.close();
                        fileIn.close();
                } catch (IOException i) {
                        i.printStackTrace();
                        return;
                } catch (ClassNotFoundException c) {
                        // System.out.print("not found!");
                        c.printStackTrace();
                        return;
                }
        }
}
