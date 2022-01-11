import java.util.*;

public class Ekonos2022 {

    static List<Carta> baralla = new ArrayList<>();
    static LinkedList<Jugador> jugadors = new LinkedList<>();
    static TaulellAfilials taulell = new TaulellAfilials();


    public static void main(String[] args) {

        baralla = Carta.generarBaralla();

        for (Carta c : baralla) {
            System.out.println(c.toString() + "\n");
        }

        obtenirJugadors();

        repartirMa(baralla);

        for (Jugador j : jugadors) {
            mostrarMa(j.getId());
        }

        System.out.println(taulell.toString());

    }


    public static LinkedList<Jugador> obtenirJugadors() {

        for (int i = 1; i <= 6; i++) {
            i--;
            jugadors.add(new Jugador(i));

        }

        return jugadors;

    }



    private static void crearTaulell() {
        while (taulell == null) {
			jugadors = obtenirJugadors();

            try {
                taulell = new TaulellAfilials();
            } catch (IllegalArgumentException e) {
                System.out.println("Error al crear el taulell, numero de jugadors incorrectes.\n");
            }
        }
    }

    /*
     * REPARTIR MA
     *
     */

    public static void repartirMa(List<Carta> baralla) {

        List<Carta> maActual;

        if (jugadors.size() == 5) {

            for (Jugador j : jugadors) {
                maActual = new ArrayList<>();
                for (int i = 0; i < 5; i++) {

                    maActual.add(baralla.get(baralla.size() - 1));
                    baralla.remove(baralla.size() - 1);

                }

                j.setMa(maActual);
            }

        } else {

            for (Jugador j : jugadors) {
                maActual = new ArrayList<>();
                for (int i = 0; i < 6; i++) {

                    maActual.add(baralla.get(baralla.size() - 1));
                    baralla.remove(baralla.size() - 1);

                }

                j.setMa(maActual);

            }

        }
    }

    /*
     * MOSTRAR MA JUGADOR
     *
     */

    public static void mostrarMa(int idJugador) {

        for (Jugador j : jugadors) {

            if (j.getId() == idJugador) {

                System.out.println("\nCartes de: " + j.getId());

                for (int i = 0; i < j.getMa().size(); i++) {

                    System.out.println(j.getMa().get(i).toString());

                }

            }

        }

    }


}
