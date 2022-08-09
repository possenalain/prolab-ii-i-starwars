package nalain.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Random;

public class LabyrinthGenerator {
    public static void main(String[] args) {

        System.out.printf("labyrinth will be generated");
        int sizes[] = {10, 15};

        for (int size : sizes) {
            String fileName = "labyrinth_" + size + ".txt";
            int[][] labyrinth = generateLabyrinth(size);
            writeLabyrinthToFile(labyrinth, fileName);
            System.out.println(labyrinth);
        }

        System.out.println("labyrinth was generated");
    }

    private static int[][] generateLabyrinth(int size) {

        System.out.println("labyrinth will be generated");

        Random random = new Random();

        int[][] labyrinth = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                labyrinth[i][j] = 0;
            }
        }


        int startRow = random.nextInt(size);
        int startCol = random.nextInt(size);

        labyrinth[startRow][startCol] = 1;

        return labyrinth;
    }
    private static void writeLabyrinthToFile(int[][] labyrinth, String fileName) {

        System.out.println("labyrinth will be written to file");
        String BASE_PATH_RESOURCES = "./resources/labyrinths/";
        fileName = BASE_PATH_RESOURCES + fileName;

        try {
            FileWriter myWriter = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(myWriter);

            for (int[] row : labyrinth) {
                for (int col : row) {
                    bw.write(col + " ");
                }
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("cant write to file");
        }
    }
}
