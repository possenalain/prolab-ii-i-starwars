import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Lab {


    public static void main(String[] args) {

        String BASE_PATH_RESOURCES = "./resources/";
        int sizes[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 200};
        String names[] = {"l1", "l2", "l3", "l4", "l5", "l6", "l7", "l8", "l9", "l10", "l11"};
        for (int o = 0; o < sizes.length; o++) {
            int size = sizes[o];
            String name = names[o];

            Random random = new Random();

            try {
                FileWriter myWriter = new FileWriter(BASE_PATH_RESOURCES + name + ".txt");
                BufferedWriter bw = new BufferedWriter(myWriter);

                for (int y = 0; y < size; y++) {
                    String line = "";
                    for (int i = 0; i < size; i++) {
                        if (i == y && (y+1 == size / 2)) {
                            line += "1\t";
                        } else
                            line += (random.nextBoolean() ? "1" : "0") + "\t";

                    }
                    bw.append(line);
                    bw.newLine();
                }
                bw.close();
            } catch (IOException e) {
                System.out.println("cant write to file");
            }
        }


    }
}