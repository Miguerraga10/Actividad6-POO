import java.io.FileWriter;
import java.io.IOException;
public class Create {
    public static void create(String newName, String newNumber) {
        try (FileWriter writer = new FileWriter("friendsContact.txt", true)) {
            String contactString = newName + "!" + newNumber + System.lineSeparator();
            writer.write(contactString);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}