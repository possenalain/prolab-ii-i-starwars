package nalain;

import nalain.karakterler.Karakter;
import nalain.maze.Labyrinth;

import java.util.ArrayList;

public class PortableGameSetup {

    String BASE_PATH_RESOURCES = "./resources/";
    Karakter iyikarakter;
    ArrayList<Karakter> kotukarakter;
    Labyrinth labyrinth;


    public Karakter getIyikarakter() {
        return iyikarakter;
    }

    public void setIyikarakter(Karakter iyikarakter) {
        this.iyikarakter = iyikarakter;
    }

    public ArrayList<Karakter> getKotukarakter() {
        return kotukarakter;
    }

    public void setKotukarakter(ArrayList<Karakter> kotukarakter) {
        this.kotukarakter = kotukarakter;
    }

    public Labyrinth getLabyrinth() {
        return labyrinth;
    }

    public void setLabyrinth(Labyrinth labyrinth) {
        this.labyrinth = labyrinth;
    }
}
