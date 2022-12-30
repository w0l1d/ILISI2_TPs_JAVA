import com.drew.imaging.ImageProcessingException;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static java.nio.file.Files.getAttribute;

public class AbstractTest {
    private static void windowsGetAllFileTags(File file) {
    }

    public static void main(String[] args) throws IOException, ImageProcessingException {
        File dirc = new File("P:\\محاضرات\\siisila");
        for (File fl : Objects.requireNonNull(dirc.listFiles())) {
            System.out.println(fl);

            System.out.println(getAttribute(fl.toPath(), "basic:title"));
        }
    }
}
