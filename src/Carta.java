import java.util.*;

public class Carta {

    enum opcions {ALPHA, BETA, GAMMA, DELTA, EPSILON, OMEGA};

    opcions empresa;
    opcions creix1;
    opcions creix2;

    public Carta (opcions empresa, opcions creix1, opcions creix2) {
        this.empresa = empresa;
        this.creix1 = creix1;
        this.creix2 = creix2;
    }

    public static List<Carta> generarBaralla () {

        List<Carta> baralla = new ArrayList<>();

        baralla.add(new Carta(opcions.ALPHA, opcions.BETA, opcions.EPSILON));
        baralla.add(new Carta(opcions.ALPHA, opcions.BETA, opcions.GAMMA));
        baralla.add(new Carta(opcions.ALPHA, opcions.BETA, opcions.DELTA));
        baralla.add(new Carta(opcions.ALPHA, opcions.DELTA, opcions.EPSILON));
        baralla.add(new Carta(opcions.ALPHA, opcions.GAMMA, opcions.EPSILON));
        baralla.add(new Carta(opcions.ALPHA, opcions.DELTA, opcions.GAMMA));


        baralla.add(new Carta(opcions.DELTA, opcions.GAMMA, opcions.OMEGA));
        baralla.add(new Carta(opcions.DELTA, opcions.GAMMA, opcions.ALPHA));
        baralla.add(new Carta(opcions.DELTA, opcions.EPSILON, opcions.OMEGA));
        baralla.add(new Carta(opcions.DELTA, opcions.OMEGA, opcions.ALPHA));
        baralla.add(new Carta(opcions.DELTA, opcions.EPSILON, opcions.ALPHA));
        baralla.add(new Carta(opcions.DELTA, opcions.EPSILON, opcions.GAMMA));


        baralla.add(new Carta(opcions.BETA, opcions.EPSILON, opcions.OMEGA));
        baralla.add(new Carta(opcions.BETA, opcions.DELTA, opcions.GAMMA));
        baralla.add(new Carta(opcions.BETA, opcions.EPSILON, opcions.GAMMA));
        baralla.add(new Carta(opcions.BETA, opcions.GAMMA, opcions.OMEGA));
        baralla.add(new Carta(opcions.BETA, opcions.DELTA, opcions.OMEGA));
        baralla.add(new Carta(opcions.BETA, opcions.DELTA, opcions.EPSILON));


        baralla.add(new Carta(opcions.GAMMA, opcions.BETA, opcions.DELTA));
        baralla.add(new Carta(opcions.GAMMA, opcions.OMEGA, opcions.DELTA));
        baralla.add(new Carta(opcions.GAMMA, opcions.ALPHA, opcions.BETA));
        baralla.add(new Carta(opcions.GAMMA, opcions.OMEGA, opcions.ALPHA));
        baralla.add(new Carta(opcions.GAMMA, opcions.ALPHA, opcions.DELTA));
        baralla.add(new Carta(opcions.GAMMA, opcions.BETA, opcions.OMEGA));


        baralla.add(new Carta(opcions.OMEGA, opcions.BETA, opcions.DELTA));
        baralla.add(new Carta(opcions.OMEGA, opcions.DELTA, opcions.EPSILON));
        baralla.add(new Carta(opcions.OMEGA, opcions.ALPHA, opcions.DELTA));
        baralla.add(new Carta(opcions.OMEGA, opcions.ALPHA, opcions.EPSILON));
        baralla.add(new Carta(opcions.OMEGA, opcions.ALPHA, opcions.BETA));
        baralla.add(new Carta(opcions.OMEGA, opcions.BETA, opcions.EPSILON));


        baralla.add(new Carta(opcions.EPSILON, opcions.GAMMA, opcions.OMEGA));
        baralla.add(new Carta(opcions.EPSILON, opcions.GAMMA, opcions.ALPHA));
        baralla.add(new Carta(opcions.EPSILON, opcions.OMEGA, opcions.ALPHA));
        baralla.add(new Carta(opcions.EPSILON, opcions.OMEGA, opcions.BETA));
        baralla.add(new Carta(opcions.EPSILON, opcions.ALPHA, opcions.BETA));
        baralla.add(new Carta(opcions.EPSILON, opcions.GAMMA, opcions.BETA));

        Collections.shuffle(baralla);

        return baralla;

    }


    @Override
    public String toString() {
        return "  ||  Opcio 1) Empresa: " + empresa +
                " ||  Opcio 2) Creix1: " + creix1 +
                " ||  Opcio 3) Creix2: " + creix2 ;
    }
}