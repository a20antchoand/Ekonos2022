import java.util.ArrayList;
import java.util.List;

public class TaulellFilials {

    List<Filials> caselles = new ArrayList<>();

    public TaulellFilials() {

        for (int i = 0; i < 36; i++) {
            caselles.add(new Filials(i));
        }

        indicarVeins();

    }

    public void indicarVeins () {

        caselles.get(0).setVeins(this, 2, 8);
        caselles.get(1).setVeins(this, 1,3,8);
        caselles.get(2).setVeins(this, 2,4,10);
        caselles.get(3).setVeins(this, 3,5,10);
        caselles.get(4).setVeins(this, 4,6,11);
        caselles.get(5).setVeins(this, 5,7,11);
        caselles.get(6).setVeins(this, 6,11,17);
        caselles.get(7).setVeins(this, 1,2,12);
        caselles.get(8).setVeins(this, 10,12,13,14);
        caselles.get(9).setVeins(this, 3,4,9,15);
        caselles.get(10).setVeins(this, 5,6,7,16);
        caselles.get(11).setVeins(this, 8,9,18);
        caselles.get(12).setVeins(this, 9,14,18,19);
        caselles.get(13).setVeins(this, 9,13,15,20);
        caselles.get(14).setVeins(this, 10,14,16,21);
        caselles.get(15).setVeins(this, 11,15,17,21);
        caselles.get(16).setVeins(this, 7,16,24);
        caselles.get(17).setVeins(this, 12,13,26,27);
        caselles.get(18).setVeins(this, 13,20,27,28);
        caselles.get(19).setVeins(this, 14,19,21,22);
        caselles.get(20).setVeins(this, 15,16,20,22);
        caselles.get(21).setVeins(this, 20,21,23,29);
        caselles.get(22).setVeins(this, 22,24,30);
        caselles.get(23).setVeins(this, 17,23,30,31);
        caselles.get(24).setVeins(this, 26,32,33);
        caselles.get(25).setVeins(this, 18,25,27,34);
        caselles.get(26).setVeins(this, 18,19,26,28);
        caselles.get(27).setVeins(this, 19,27,29,34,35);
        caselles.get(28).setVeins(this, 22,28,35);
        caselles.get(29).setVeins(this, 23,24,35,35);
        caselles.get(30).setVeins(this, 24,35);
        caselles.get(31).setVeins(this, 25,33);
        caselles.get(32).setVeins(this, 25,32,34);
        caselles.get(33).setVeins(this, 26,28,33);
        caselles.get(34).setVeins(this, 28,29,30,35);
        caselles.get(35).setVeins(this, 30,31,35);

    }


    public List<Filials> getCaselles() {
        return caselles;
    }

    public void setCaselles(List<Filials> caselles) {
        this.caselles = caselles;
    }

    public boolean comprovarCasella(int numCasella) {
        return caselles.get(numCasella).ocupada;
    }

    /*
     * TO STRING
     *
     */

    @Override
    public String toString() {

        StringBuilder resultat = new StringBuilder();
        String nom;
        resultat.append("\n");

        resultat.append("\n-------------------------------------------------------------------------------------------------------\n");

        for (int i = 0; i < caselles.size(); i++) {

            if (caselles.get(i).propietariFIlial == null) {
                nom = "Sense propietari";
            } else {
                nom = caselles.get(i).propietariFIlial.nomEmpresa;
            }

            if (i < 10) {
                resultat.append("|  Casella: " + caselles.get(i).getNumeroCasella() +
                            "   |  Ocupada: " +  caselles.get(i).isOcupada() +
                            "  |  Empresa: " +  nom +
                            " | Caselles veinas: ");

            } else {
                resultat.append("|  Casella: " + caselles.get(i).getNumeroCasella() +
                        "  |  Ocupada: " + caselles.get(i).isOcupada() +
                        "  |  Empresa: " +  nom +
                        " | Caselles veinas: ");

            }

            for (int j = 0; j < caselles.get(i).getVeinas().size(); j++) {
                if (j == 0) {
                    resultat.append(caselles.get(i).getVeinas().get(j).getNumeroCasella());
                } else {
                    resultat.append(", " + caselles.get(i).getVeinas().get(j).getNumeroCasella());
                }

            }
            resultat.append("\n-------------------------------------------------------------------------------------------------------\n");

        }




        return resultat.toString();

    }

}
