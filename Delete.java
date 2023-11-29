import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
public class Delete {
    public static void delete(String targetName) {
        try {
            File file = new File("friendsContact.txt");
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            String line;
            long filePointer = 0;
            boolean contactFound = false;
            while ((line = raf.readLine()) != null) {
                String[] parts = line.split("!");
                String name = parts[0].trim();
                if (name.equals(targetName)) {
                    contactFound = true;
                    break;
                }
                filePointer = raf.getFilePointer();
            }
            if (contactFound) {
                raf.seek(filePointer);
                raf.setLength(file.length() - line.length() - System.lineSeparator().length());
            }
            raf.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}