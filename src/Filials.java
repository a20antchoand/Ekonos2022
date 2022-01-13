import java.util.ArrayList;
import java.util.List;

public class Filials {

    int numeroCasella;
    boolean ocupada;
    Empresa propietariFIlial;
    List<Filials> veinas = new ArrayList<>();

    public Filials(int numeroCasella) {
        this.numeroCasella = numeroCasella;
        this.ocupada = false;
        this.propietariFIlial = null;
    }

    public int getNumeroCasella() {
        return numeroCasella;
    }

    public void setNumeroCasella(int numeroCasella) {
        this.numeroCasella = numeroCasella;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public List<Filials> getVeinas() {
        return veinas;
    }

    public void setVeins(TaulellFilials taulell, int ...idVeins) {

        Filials[] caselles = taulell.getCaselles();

        for (int i : idVeins) {
            veinas.add(caselles[i]);
        }


        this.veinas = veinas;
    }

    @Override
    public String toString() {
        return "CasellaFilials{" +
                "numeroCasella=" + numeroCasella +
                ", ocupada=" + ocupada +
                ", Propietari=" + propietariFIlial.nomEmpresa +
                ", veinas=" + veinas +
                '}';
    }
}
