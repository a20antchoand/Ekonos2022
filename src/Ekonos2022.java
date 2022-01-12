import java.util.*;

public class Ekonos2022 {

    final static int RONDES = 3;

    static Scanner s = new Scanner(System.in);

    static Map<Integer, Carta> baralla = new LinkedHashMap<>();
    static LinkedList<Jugador> jugadors = new LinkedList<>();
    static TaulellAfilials taulell = new TaulellAfilials();
    static Map<String, Empresa> empreses = new HashMap();


    public static void main(String[] args) {

        iniciarPartida();

        jugar();

    }

    public static void iniciarPartida() {
        empreses = Empresa.afegirEmpreses();
        obtenirJugadors();
    }

    public static void jugar() {
        for (int i = 0; i < RONDES; i++) {

            baralla = Carta.generarBaralla();
            repartirMa(baralla);

            System.out.println("\n\n RONDA " + i+1 + "\n\n");
            while (jugadors.getLast().getMa().size() > 0) {
                for (Jugador actual : jugadors) {
                    actual.mostrarMa();
                }
            }
        }
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

    public static void repartirMa(Map<Integer, Carta> baralla) {

        List<Carta> maActual;

        if (jugadors.size() == 5) {

            for (Jugador j : jugadors) {
                maActual = new ArrayList<>();
                for (int i = 0; i <= 5; i++) {

                    maActual.add(baralla.get(i));
                    baralla.remove(baralla.get(i));

                }

                j.setMa(maActual);
            }

        } else {

            for (Jugador j : jugadors) {
                maActual = new ArrayList<>();
                for (int i = 0; i <= 6; i++) {

                    maActual.add(baralla.get(i));
                    baralla.remove(baralla.get(i));

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
