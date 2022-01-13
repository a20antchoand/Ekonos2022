import java.util.*;

public class Ekonos2022 {

    final static int RONDES = 3;

    static Scanner s = new Scanner(System.in);

    static List<Carta> baralla = new ArrayList<>();
    static LinkedList<Jugador> jugadors = new LinkedList<>();
    static TaulellAfilials taulell = new TaulellAfilials();
    static Map<String, Empresa> empreses = new HashMap();
    static Jugador actual;

    public static void main(String[] args) throws Exception {

        Ekonos2022 joc = new Ekonos2022();

        joc.iniciarPartida();

        joc.jugar();

    }

    public void iniciarPartida() {
        empreses = Empresa.afegirEmpreses();
        obtenirJugadors();
    }

    public void jugar() throws Exception {

        Carta cartaJugar;
        Carta.opcions opcioJugar;


        for (int i = 0; i < RONDES; i++) {
            int numeroCarta;
            baralla = Carta.generarBaralla();
            repartirMa(baralla);

            System.out.println("\n\n RONDA " + (i+1) + "\n\n");
            while (jugadors.getLast().getMa().size() > 0) {
                for (Jugador j : jugadors) {

                    actual = j;

                    demanarCartaOpcio();

                    System.out.println(taulell.toString());
                }
            }
        }
    }

    public static void demanarCartaOpcio () throws Exception {

        Carta cartaJugar;

        cartaJugar = agafarCarta();
        agafarOpcio(cartaJugar);

        actual.getMa().remove(cartaJugar);

    }

    private static Carta agafarCarta () {

        Carta agafar;
        int numeroCarta;

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

            numeroCarta--;

        } while ((agafar = validarCarta(actual.getMa(), numeroCarta)) == null);

        return agafar;

    }

    private static Carta validarCarta(List<Carta> maActual, int numeroCarta) {
        if (numeroCarta >= 0 && numeroCarta < maActual.size()) {
            return maActual.get(numeroCarta);
        }
        System.out.println("Carta no valida.");
        return null;
    }

    private static void agafarOpcio (Carta cartaJugar) throws Exception {

        Carta.opcions agafar;
        int numeroOpcio;

        System.out.println(cartaJugar.toString());

        do {
            try {
                System.out.print("Indica la opcio: ");
                numeroOpcio = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ha de ser un numero.");
                numeroOpcio = -1;
                s.next();
            }

            numeroOpcio--;

        } while ((agafar = validarOpcio(cartaJugar, numeroOpcio)) == null);

    }

    private static Carta.opcions validarOpcio(Carta cartaJugar, int numeroOpcio) throws Exception {
            switch (numeroOpcio) {
                case 0:
                    crearFilial(cartaJugar.empresa);
                    return cartaJugar.empresa;
                case 1:
                    desenvolupaEmpresa(cartaJugar.creix1);
                    return cartaJugar.creix1;
                case 2:
                    desenvolupaEmpresa(cartaJugar.creix2);
                    return cartaJugar.creix2;
                default:
                    return null;
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

    public static void crearFilial (Carta.opcions empresa) throws Exception{

        int numCasella;
        char opcio = ' ';
        boolean casellaOcupada = false;

        do {
            do {
                System.out.print("Indica el numero de casella: ");
                numCasella = s.nextInt();

                if (numCasella < 1 || numCasella > 36) {
                    System.out.println("Numero d ecasella invalid.");
                }
            } while (numCasella < 1 || numCasella > 36);

            try {
                casellaOcupada = taulell.comprovarCasella(numCasella);
            } catch (IllegalArgumentException e) {
                System.out.println("Vols cambiar d'opcio? (s/n): ");
                opcio = s.next().charAt(0);

                if (opcio == 's') {
                    demanarCartaOpcio();
                    break;
                }   
            }

            

        } while (casellaOcupada || (numCasella < 1 || numCasella > 36) || opcio == 's');

        taulell.caselles[numCasella].propietariFIlial = empreses.get(empresa.toString());
        taulell.caselles[numCasella].ocupada = true;
        System.out.println("S'ha creat la filial: " + empresa.toString() + " a la casella: " + numCasella);


    }

    /*
     *
     * CREIXER EMPRESA
     *
     * */

    public static void desenvolupaEmpresa (Carta.opcions empresa) {
        Empresa companyia = empreses.get(empresa.toString());

        if (companyia.estatDesenvolupament == 4) {
            companyia.estatDesenvolupament++;
            //casella especial 1
        } else if (companyia.estatDesenvolupament == 6) {
            companyia.estatDesenvolupament++;
            //casella especial 2
        } else {
            companyia.estatDesenvolupament++;
        }
        System.out.println("Estat de " + companyia.nomEmpresa + ": " + companyia.estatDesenvolupament);
    }

}
