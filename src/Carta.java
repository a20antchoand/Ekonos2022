import java.util.*;

public class Carta {

    enum opcions {ALPHA, BETA, GAMMA, DELTA, EPSILON, OMEGA};

    opcions empresa;
    opcions creix1;
    opcions creix2;
    int idCarta;

    public Carta (int idCarta, opcions empresa, opcions creix1, opcions creix2) {
        this.idCarta = idCarta;
        this.empresa = empresa;
        this.creix1 = creix1;
        this.creix2 = creix2;
    }

    public static List<Carta> generarBaralla () {

        List<Carta> baralla = new ArrayList<>();

        baralla.add(new Carta(1, opcions.ALPHA, opcions.BETA, opcions.EPSILON));
        baralla.add(new Carta(2, opcions.ALPHA, opcions.BETA, opcions.GAMMA));
        baralla.add(new Carta(3, opcions.ALPHA, opcions.BETA, opcions.DELTA));
        baralla.add(new Carta(4, opcions.ALPHA, opcions.DELTA, opcions.EPSILON));
        baralla.add(new Carta(5, opcions.ALPHA, opcions.GAMMA, opcions.EPSILON));
        baralla.add(new Carta(6, opcions.ALPHA, opcions.DELTA, opcions.GAMMA));


        baralla.add(new Carta(7, opcions.DELTA, opcions.GAMMA, opcions.OMEGA));
        baralla.add(new Carta(8, opcions.DELTA, opcions.GAMMA, opcions.ALPHA));
        baralla.add(new Carta(9, opcions.DELTA, opcions.EPSILON, opcions.OMEGA));
        baralla.add(new Carta(10, opcions.DELTA, opcions.OMEGA, opcions.ALPHA));
        baralla.add(new Carta(11, opcions.DELTA, opcions.EPSILON, opcions.ALPHA));
        baralla.add(new Carta(12, opcions.DELTA, opcions.EPSILON, opcions.GAMMA));


        baralla.add(new Carta(13, opcions.BETA, opcions.EPSILON, opcions.OMEGA));
        baralla.add(new Carta(14, opcions.BETA, opcions.DELTA, opcions.GAMMA));
        baralla.add(new Carta(15, opcions.BETA, opcions.EPSILON, opcions.GAMMA));
        baralla.add(new Carta(16, opcions.BETA, opcions.GAMMA, opcions.OMEGA));
        baralla.add(new Carta(17, opcions.BETA, opcions.DELTA, opcions.OMEGA));
        baralla.add(new Carta(18, opcions.BETA, opcions.DELTA, opcions.EPSILON));


        baralla.add(new Carta(19, opcions.GAMMA, opcions.BETA, opcions.DELTA));
        baralla.add(new Carta(20, opcions.GAMMA, opcions.OMEGA, opcions.DELTA));
        baralla.add(new Carta(21, opcions.GAMMA, opcions.ALPHA, opcions.BETA));
        baralla.add(new Carta(22, opcions.GAMMA, opcions.OMEGA, opcions.ALPHA));
        baralla.add(new Carta(23, opcions.GAMMA, opcions.ALPHA, opcions.DELTA));
        baralla.add(new Carta(24, opcions.GAMMA, opcions.BETA, opcions.OMEGA));


        baralla.add(new Carta(25, opcions.OMEGA, opcions.BETA, opcions.DELTA));
        baralla.add(new Carta(26, opcions.OMEGA, opcions.DELTA, opcions.EPSILON));
        baralla.add(new Carta(27, opcions.OMEGA, opcions.ALPHA, opcions.DELTA));
        baralla.add(new Carta(28, opcions.OMEGA, opcions.ALPHA, opcions.EPSILON));
        baralla.add(new Carta(29, opcions.OMEGA, opcions.ALPHA, opcions.BETA));
        baralla.add(new Carta(30, opcions.OMEGA, opcions.BETA, opcions.EPSILON));


        baralla.add(new Carta(31, opcions.EPSILON, opcions.GAMMA, opcions.OMEGA));
        baralla.add(new Carta(32, opcions.EPSILON, opcions.GAMMA, opcions.ALPHA));
        baralla.add(new Carta(33, opcions.EPSILON, opcions.OMEGA, opcions.ALPHA));
        baralla.add(new Carta(34, opcions.EPSILON, opcions.OMEGA, opcions.BETA));
        baralla.add(new Carta(35, opcions.EPSILON, opcions.ALPHA, opcions.BETA));
        baralla.add(new Carta(36, opcions.EPSILON, opcions.GAMMA, opcions.BETA));

        Collections.shuffle(baralla);

        return baralla;

    }


    @Override
    public String toString() {
        return "Carta{" +
                "empresa=" + empresa +
                ", creix1=" + creix1 +
                ", creix2=" + creix2 +
                ", idCarta=" + idCarta +
                '}';
    }
}
