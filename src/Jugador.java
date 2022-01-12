import java.util.HashSet;
import java.util.List;

public class Jugador {

    /* FINAL */
    final int ACCIONS_INICIALS = 18;

    /* INTEGER */
    int id;
    int accions;
    int unitatsMonetaries;

    /* HASHSET */
    List<Carta> ma;

    /*
    * CONSTRUCTOR
    * */
    public Jugador(int id) {
        this.accions = ACCIONS_INICIALS;
        this.unitatsMonetaries = 0;
        this.id = id;
    }

    /*
    * GETTERS & SETTERS
    * */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccions() {
        return accions;
    }

    public void setAccions(int accions) {
        this.accions = accions;
    }

    public int getUnitatsMonetaries() {
        return unitatsMonetaries;
    }

    public void setUnitatsMonetaries(int unitatsMonetaries) {
        this.unitatsMonetaries = unitatsMonetaries;
    }

    public List<Carta> getMa() {
        return ma;
    }

    public void setMa(List<Carta> ma) {
        this.ma = ma;
    }


    /*
     * MOSTRAR MA JUGADOR
     *
     */

    public void mostrarMa() {

        System.out.println("\nCartes de: " + this.getId());

        for (int i = 0; i < this.getMa().size(); i++) {

            System.out.println( i + ": " + this.getMa().get(i).toString());

        }

    }


}
