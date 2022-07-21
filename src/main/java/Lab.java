
import java.io.File;

public class Lab {

    public static void main(String[] args) {
        File folder = new File("./resources");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles)
            if (file.isFile())
                System.out.println("File " + file.getName());
            else if (file.isDirectory())
                System.out.println("Directory " + file.getName());

    }
}
