import java.util.*;

public class Ekonos2022 {

    final static int RONDES = 3;

    static Scanner s = new Scanner(System.in);

    static List<Carta> baralla = new ArrayList<>();
    static LinkedList<Jugador> jugadors = new LinkedList<>();
    static TaulellFilials taulell = new TaulellFilials();
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
        char veureTaulell = ' ';

        for (int i = 0; i < RONDES; i++) {
            int numeroCarta;
            baralla = Carta.generarBaralla();
            repartirMa(baralla);

            System.out.println("\n\n RONDA " + (i+1) + "\n\n");
            while (jugadors.getLast().getMa().size() > 0) {
                for (Jugador j : jugadors) {

                    actual = j;

                    System.out.println(empreses.toString());

                    System.out.print("Vols veure el taulell: ");
                    veureTaulell = s.next().charAt(0);
                    if (veureTaulell == 's') {
                        System.out.println(taulell.toString());
                    }

                    demanarCartaOpcio();

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
                    crearFilial(cartaJugar.empresa.toString());
                    return cartaJugar.empresa;
                case 1:
                    desenvolupaEmpresa(cartaJugar.creix1.toString());
                    return cartaJugar.creix1;
                case 2:
                    desenvolupaEmpresa(cartaJugar.creix2.toString());
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
                taulell = new TaulellFilials();
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

    public static void crearFilial (String empresa) throws Exception{

        int numCasella;
        boolean casellaOcupada = false;



            do {
                System.out.print("Indica el numero de casella: ");
                numCasella = s.nextInt();

                if (numCasella < 1 || numCasella > 36) {
                    System.out.println("Numero d ecasella invalid.");
                } else {
                    casellaOcupada = taulell.comprovarCasella(numCasella);
                }


            } while (casellaOcupada || (numCasella < 1 || numCasella > 36));



        taulell.caselles.get(numCasella).propietariFIlial = empreses.get(empresa.toString());
        taulell.caselles.get(numCasella).ocupada = true;
        System.out.println("S'ha creat la filial: " + empresa.toString() + " a la casella: " + numCasella);


    }

    /*
     *
     * CREIXER EMPRESA
     *
     * */

    public static void desenvolupaEmpresa (String empresa) throws Exception {

        Empresa companyia = empreses.get(empresa.toString());
        char opcio = ' ';

        companyia.estatDesenvolupament++;

        if (companyia.estatDesenvolupament == 4) {
            System.out.println("Vols utilitzar la acció especial?");
            opcio = s.next().charAt(0);
            if (opcio == 's') {
                accioEspecil(companyia);
                companyia.estatDesenvolupament = 0;
            }
        } else if (companyia.estatDesenvolupament == 6) {
            accioEspecil(companyia);
            companyia.estatDesenvolupament = 0;
        }

        System.out.println("Estat de " + companyia.nomEmpresa + ": " + companyia.estatDesenvolupament);
    }

    private static void accioEspecil(Empresa companyia) throws Exception {

        int accio = 0;
        int voltes = 0;


            System.out.print("Que vols fer? \n1) Crear filials \n2) Menjar filials \nOpccio: ");
            accio = s.nextInt();

            if (accio == 1) {

                if (companyia.estatDesenvolupament == 4) {
                    voltes = 2;
                } else if (companyia.estatDesenvolupament == 6) {
                    voltes = 3;
                }

                for (int i = 0; i < voltes; i++) {
                    crearFilial(companyia.nomEmpresa);
                }

            } else if (accio == 2) {

                if (companyia.estatDesenvolupament == 4) {
                    voltes = 1;
                } else if (companyia.estatDesenvolupament == 6) {
                    voltes = 2;
                }


                for (int i = 0; i < voltes; i++) {
                    //menjarVeina(companyia.nomEmpresa);
                }

            }


    }

//    private static void menjarVeina(Empresa companyia) {
//
//
//
//    }

}
