import java.util.ArrayList;
import java.util.List;

public class CasellaFilials {

    int numeroCasella;
    boolean ocupada;
    Empresa propietariFIlial;
    List<CasellaFilials> veinas = new ArrayList<>();

    public CasellaFilials(int numeroCasella) {
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

    public List<CasellaFilials> getVeinas() {
        return veinas;
    }

    public void setVeins(TaulellAfilials taulell, int ...idVeins) {

        CasellaFilials[] caselles = taulell.getCaselles();

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
