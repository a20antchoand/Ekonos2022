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

    public static Map<Integer,Carta> generarBaralla () {

        Map<Integer,Carta> baralla = new TreeMap<>();

        baralla.put(1,new Carta(1, opcions.ALPHA, opcions.BETA, opcions.EPSILON));
        baralla.put(2,new Carta(2, opcions.ALPHA, opcions.BETA, opcions.GAMMA));
        baralla.put(3,new Carta(3, opcions.ALPHA, opcions.BETA, opcions.DELTA));
        baralla.put(4,new Carta(4, opcions.ALPHA, opcions.DELTA, opcions.EPSILON));
        baralla.put(5,new Carta(5, opcions.ALPHA, opcions.GAMMA, opcions.EPSILON));
        baralla.put(6,new Carta(6, opcions.ALPHA, opcions.DELTA, opcions.GAMMA));


        baralla.put(7,new Carta(7, opcions.DELTA, opcions.GAMMA, opcions.OMEGA));
        baralla.put(8,new Carta(8, opcions.DELTA, opcions.GAMMA, opcions.ALPHA));
        baralla.put(9,new Carta(9, opcions.DELTA, opcions.EPSILON, opcions.OMEGA));
        baralla.put(10,new Carta(10, opcions.DELTA, opcions.OMEGA, opcions.ALPHA));
        baralla.put(11,new Carta(11, opcions.DELTA, opcions.EPSILON, opcions.ALPHA));
        baralla.put(12,new Carta(12, opcions.DELTA, opcions.EPSILON, opcions.GAMMA));


        baralla.put(13,new Carta(13, opcions.BETA, opcions.EPSILON, opcions.OMEGA));
        baralla.put(14,new Carta(14, opcions.BETA, opcions.DELTA, opcions.GAMMA));
        baralla.put(15,new Carta(15, opcions.BETA, opcions.EPSILON, opcions.GAMMA));
        baralla.put(16,new Carta(16, opcions.BETA, opcions.GAMMA, opcions.OMEGA));
        baralla.put(17,new Carta(17, opcions.BETA, opcions.DELTA, opcions.OMEGA));
        baralla.put(18,new Carta(18, opcions.BETA, opcions.DELTA, opcions.EPSILON));


        baralla.put(19,new Carta(19, opcions.GAMMA, opcions.BETA, opcions.DELTA));
        baralla.put(20,new Carta(20, opcions.GAMMA, opcions.OMEGA, opcions.DELTA));
        baralla.put(21,new Carta(21, opcions.GAMMA, opcions.ALPHA, opcions.BETA));
        baralla.put(22,new Carta(22, opcions.GAMMA, opcions.OMEGA, opcions.ALPHA));
        baralla.put(23,new Carta(23, opcions.GAMMA, opcions.ALPHA, opcions.DELTA));
        baralla.put(24,new Carta(24, opcions.GAMMA, opcions.BETA, opcions.OMEGA));


        baralla.put(25,new Carta(25, opcions.OMEGA, opcions.BETA, opcions.DELTA));
        baralla.put(26,new Carta(26, opcions.OMEGA, opcions.DELTA, opcions.EPSILON));
        baralla.put(27,new Carta(27, opcions.OMEGA, opcions.ALPHA, opcions.DELTA));
        baralla.put(28,new Carta(28, opcions.OMEGA, opcions.ALPHA, opcions.EPSILON));
        baralla.put(29,new Carta(29, opcions.OMEGA, opcions.ALPHA, opcions.BETA));
        baralla.put(30,new Carta(30, opcions.OMEGA, opcions.BETA, opcions.EPSILON));


        baralla.put(31,new Carta(31, opcions.EPSILON, opcions.GAMMA, opcions.OMEGA));
        baralla.put(32,new Carta(32, opcions.EPSILON, opcions.GAMMA, opcions.ALPHA));
        baralla.put(33,new Carta(33, opcions.EPSILON, opcions.OMEGA, opcions.ALPHA));
        baralla.put(34,new Carta(34, opcions.EPSILON, opcions.OMEGA, opcions.BETA));
        baralla.put(35,new Carta(35, opcions.EPSILON, opcions.ALPHA, opcions.BETA));
        baralla.put(36,new Carta(36, opcions.EPSILON, opcions.GAMMA, opcions.BETA));

        List<Map.Entry<Integer, Carta>> valors = new ArrayList<>(baralla.entrySet());

        Collections.shuffle(valors);

        Map<Integer, Carta> barallaFinal = new LinkedHashMap<>();

        for (Map.Entry<Integer, Carta> entry : valors) {
            barallaFinal.put(entry.getKey(), entry.getValue());
        }

        return barallaFinal;

    }


    @Override
    public String toString() {
        return "Numero: " + idCarta +
                ", Empresa: " + empresa +
                ", Creix1: " + creix1 +
                ", Creix2: " + creix2 ;
    }
}