import javax.management.BadAttributeValueExpException;
import java.util.*;

public class Ekonos2022 {

    final static int RONDES = 3;

    static Scanner s = new Scanner(System.in);

    static List<Carta> baralla = new ArrayList<>();
    static LinkedList<Jugador> jugadors = new LinkedList<>();
    static TaulellAfilials taulell = new TaulellAfilials();
    static Map<String, Empresa> empreses = new HashMap();

    public static void main(String[] args) {

        Ekonos2022 joc = new Ekonos2022();

        joc.iniciarPartida();

        joc.jugar();

    }

    public void iniciarPartida() {
        empreses = Empresa.afegirEmpreses();
        obtenirJugadors();
    }

    public void jugar() {
        for (int i = 0; i < RONDES; i++) {
            int numeroCarta;
            baralla = Carta.generarBaralla();
            repartirMa(baralla);

            System.out.println("\n\n RONDA " + (i+1) + "\n\n");
            while (jugadors.getLast().getMa().size() > 0) {
                for (Jugador actual : jugadors) {
                    actual.mostrarMa();
                    do {

                        try {
                            System.out.print("Indica la carta: ");
                            numeroCarta = s.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Ha de ser un numero.");
                            numeroCarta = -1;
                            s.next();
                        }
                    } while (!validarCarta(actual, numeroCarta));

                    actual.getMa().remove(actual.getMa().size()-1);
                }
            }
        }
    }

    private static boolean validarCarta(Jugador actual, int numeroCarta) {
        if (numeroCarta >= 0 && numeroCarta < actual.getMa().size()) {
            return true;
        }
        System.out.println("Carta no valida.");
        return false;
    }

    /*
     * OBTENIR JUGADORS
     *
     */

    public static LinkedList<Jugador> obtenirJugadors() {

        for (int i = 1; i <= 6; i++) {
            jugadors.add(new Jugador(i));

        }

        return jugadors;

    }

    /*
     * CREAR TAULELL
     *
     */

    private void crearTaulell() {
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
    *
    * CREAR EMPRESA
    *
    * */

    public static void crearFilial (Carta.opcions empresa) {

        int numCasella;

        do {
            System.out.print("Indica el numero de casella: ");
            numCasella = s.nextInt();
        } while (numCasella < 1 && numCasella > 36);

        if (taulell.comprovarCasella(numCasella)) {
            System.out.println("Casella ocupada");
        } else {
            taulell.caselles[numCasella].propietariFIlial = empreses.get(empresa.toString());
            taulell.caselles[numCasella].ocupada = true;
        }

    }

    /*
     *
     * CREIXER EMPRESA
     *
     * */

    public static void creixerEmpresa (Carta.opcions empresa) {
        Empresa creixer = empreses.get(empresa.toString());

        if (creixer.estatDesenvolupament == 4) {
            creixer.estatDesenvolupament++;
            //casella especial 1
        } else if (creixer.estatDesenvolupament == 6) {
            creixer.estatDesenvolupament++;
            //casella especial 2
        } else {
            creixer.estatDesenvolupament++;
        }

    }

}
