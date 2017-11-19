import java.io.*;

class FileHandler {

        private static File player;
        private static FileOutputStream fileOut;
        private static ObjectOutputStream out;
        private static String player;
        private static FileInputStream fileIn;
        private static ObjectInputStream in;

        public void saveFile() {
                try {
                        player = new file(System.getProperty("user.home"));
                        fileOut = new FileOutputStream(player + "/desktop/JSnake.ser");
                        out = new ObjectOutputStream(fileOut);
                        out.writeObject(ent);
                        out.close();
                        fileOut.close();
                } catch (IOException i) {
                        i.printStackTrace();
                }
        }

        public void loadFile() {
                try {
                        player = System.getProperty("user.home");
                        fileIn = new FileInputStream(player + "/desktop/JSnake.ser");
                        in = new ObjectInputStream(fileIn);
                        ent = (ent)in.readObject();
                        in.close()
                        fileIn.close();
                } catch (IOException) {
                        i.printStackTrace();
                        return;
                } catch (ClassNotFoundException c) {
                        // System.out.print("not found!");
                        c.printStackTrace();
                        return;
                }
        }
}
