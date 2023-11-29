import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Read {
    public static String read (String targetName) {
        try (BufferedReader reader = new BufferedReader(new FileReader("friendsContact.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("!");
                String name = parts[0].trim();
                String number = parts[1].trim();
                if (name.equals(targetName)) {
                    return number;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}