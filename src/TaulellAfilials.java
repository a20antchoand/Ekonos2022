import java.util.ArrayList;
import java.util.List;

public class TaulellAfilials {

    CasellaFilials[] caselles = new CasellaFilials[37];

    public TaulellAfilials() {

        for (int i = 1; i < caselles.length; i++) {
            caselles[i] = new CasellaFilials(i);
        }

        indicarVeins();

    }

    public void indicarVeins () {

        caselles[1].setVeins(this, 2, 8);
        caselles[2].setVeins(this, 1,3,8);
        caselles[3].setVeins(this, 2,4,10);
        caselles[4].setVeins(this, 3,5,10);
        caselles[5].setVeins(this, 4,6,11);
        caselles[6].setVeins(this, 5,7,11);
        caselles[7].setVeins(this, 6,11,17);
        caselles[8].setVeins(this, 1,2,12);
        caselles[9].setVeins(this, 10,12,13,14);
        caselles[10].setVeins(this, 3,4,9,15);
        caselles[11].setVeins(this, 5,6,7,16);
        caselles[12].setVeins(this, 8,9,18);
        caselles[13].setVeins(this, 9,14,18,19);
        caselles[14].setVeins(this, 9,13,15,20);
        caselles[15].setVeins(this, 10,14,16,21);
        caselles[16].setVeins(this, 11,15,17,21);
        caselles[17].setVeins(this, 7,16,24);
        caselles[18].setVeins(this, 12,13,26,27);
        caselles[19].setVeins(this, 13,20,27,28);
        caselles[20].setVeins(this, 14,19,21,22);
        caselles[21].setVeins(this, 15,16,20,22);
        caselles[22].setVeins(this, 20,21,23,29);
        caselles[23].setVeins(this, 22,24,30);
        caselles[24].setVeins(this, 17,23,30,31);
        caselles[25].setVeins(this, 26,32,33);
        caselles[26].setVeins(this, 18,25,27,34);
        caselles[27].setVeins(this, 18,19,26,28);
        caselles[28].setVeins(this, 19,27,29,34,35);
        caselles[29].setVeins(this, 22,28,35);
        caselles[30].setVeins(this, 23,24,35,36);
        caselles[31].setVeins(this, 24,36);
        caselles[32].setVeins(this, 25,33);
        caselles[33].setVeins(this, 25,32,34);
        caselles[34].setVeins(this, 26,28,33);
        caselles[35].setVeins(this, 28,29,30,36);
        caselles[36].setVeins(this, 30,31,35);

    }


    public CasellaFilials[] getCaselles() {
        return caselles;
    }

    public void setCaselles(CasellaFilials[] caselles) {
        this.caselles = caselles;
    }



    /*
     * TO STRING
     *
     */

    @Override
    public String toString() {

        StringBuilder resultat = new StringBuilder();
        resultat.append("\n");

        resultat.append("\n---------------------------------------------------------------------------\n");

        for (int i = 1; i < caselles.length; i++) {

            if (i < 10) {
                resultat.append("|  Casella: " + caselles[i].getNumeroCasella() + "   |  Ocupada: " +  caselles[i].isOcupada() + "  |  Caselles veinas: ");

            } else {
                resultat.append("|  Casella: " + caselles[i].getNumeroCasella() + "  |  Ocupada: " +  caselles[i].isOcupada() + "  |  Caselles veinas: ");

            }

            for (int j = 0; j < caselles[i].getVeinas().size(); j++) {
                if (j == 0) {
                    resultat.append(caselles[i].getVeinas().get(j).getNumeroCasella());
                } else {
                    resultat.append(", " + caselles[i].getVeinas().get(j).getNumeroCasella());
                }

            }
            resultat.append("\n---------------------------------------------------------------------------\n");

        }




        return resultat.toString();

    }

}
