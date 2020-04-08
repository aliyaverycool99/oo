package icmit.oodb.Lab2;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWriter {
    public static void appendUsingFileWriter(String filePath, String text) {
        try {
            Files.write(Paths.get(filePath), text.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
