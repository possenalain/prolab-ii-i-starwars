package nalain.karakterler;


import nalain.maze.Location;

import java.util.ArrayList;

public class Kyloren extends Karakter {
	public Kyloren() {

		this.stepSize=1;
		this.name="Kyloren";
		this.type="kotu";
		this.color="B";
	}

	public void EnKisaYol() {

		int hedefx, hedefy;

		hedefx = this.hedef.getX();
		hedefy = this.hedef.getY();

		int x, y;
		Location visiting;

		if (visitnext.size() > 0) {
			visiting = visitnext.get(0);

			x = visiting.getX();
			y = visiting.getY();

			if (hedefx == x && hedefy == y) {

				this.enkisayol = (ArrayList<Location>) visiting.getShortpath().clone();

				visiting.getShortpath().clear();
				visitnext.clear();
				visited.clear();

				if (this.enkisayol.size() <= 1) {

					//yakaladik onu

					this.currentlocation.setX(hedefx);
					this.currentlocation.setY(hedefy);

					//System.out.println("------------------>yakaladim seni");

				} else {

					this.currentlocation.setX(this.enkisayol.get(1).getX());
					this.currentlocation.setY(this.enkisayol.get(1).getY());
					this.enkisayol.remove(0);

					for (int i = 0; i < this.enkisayol.size(); i++) {
						System.out.println("-----" + this.enkisayol.get(i).getX() + "  " + this.enkisayol.get(i).getY());
					}
				}


				return;
			}
			else {

				visited.add(visiting);
				visitnext.remove(0);


				//visit top

				if (y - 1 >= 0) {
					if (!nodevisited(locationmatrices[y - 1][x])) {
						Location tempo = locationmatrices[y - 1][x];

						if (tempo.getCost() == 0 || (visiting.getCost() <= tempo.getCost() + 1)) {
							if (!tempo.getDuvar()) {
								tempo.setCost(visiting.getCost() + 1);
								tempo.setShortpath((ArrayList<Location>) visiting.getShortpath().clone());
								tempo.getShortpath().add(tempo);
								updatevisitnext(tempo);
								//System.out.println("top visited");
							}

						}
					}

				}

				//visit right

				if (x + 1 <= 13) {
					if (!nodevisited(locationmatrices[y][x + 1])) {
						Location tempo = locationmatrices[y][x + 1];

						if (tempo.getCost() == 0 || (visiting.getCost() <= tempo.getCost() + 1)) {
							if (!tempo.getDuvar()) {
								tempo.setCost(visiting.getCost() + 1);
								tempo.setShortpath((ArrayList<Location>) visiting.getShortpath().clone());////////////
								tempo.getShortpath().add(tempo);
								updatevisitnext(tempo);
								//System.out.println("right visited");
							}

						}
					}

				}

				//visit bottom

				if (y + 1 <= 10) {
					if (!nodevisited(locationmatrices[y + 1][x])) {
						Location tempo = locationmatrices[y + 1][x];

						if (tempo.getCost() == 0 || (visiting.getCost() <= tempo.getCost() + 1)) {
							if (!tempo.getDuvar()) {
								tempo.setCost(visiting.getCost() + 1);
								tempo.setShortpath((ArrayList<Location>) visiting.getShortpath().clone());////////////
								tempo.getShortpath().add(tempo);
								updatevisitnext(tempo);
								//System.out.println("bottom visited");
							}

						}
					}

				}

				//visit left
				if (x - 1 >= 0) {
					if (!nodevisited(locationmatrices[y][x - 1])) {

						Location tempo = locationmatrices[y][x - 1];

						if (tempo.getCost() == 0 || (visiting.getCost() <= tempo.getCost() + 1)) {
							if (!tempo.getDuvar()) {
								tempo.setCost(visiting.getCost() + 1);
								tempo.setShortpath((ArrayList<Location>) visiting.getShortpath().clone());////////////
								tempo.getShortpath().add(tempo);
								updatevisitnext(tempo);
								//System.out.println("left visited");
							}
						}
					}
				}
				EnKisaYol();
			}
		}


	}

}
