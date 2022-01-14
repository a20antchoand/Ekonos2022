import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Empresa {

    Jugador president;
    String nomEmpresa;
    int numeroAccions;
    int estatDesenvolupament;

    public Empresa(String nomEmpresa) {
        this.president = null;
        this.nomEmpresa = nomEmpresa;
        this.numeroAccions = 0;
        this.estatDesenvolupament = 0;
    }

    public static Map<String, Empresa> afegirEmpreses() {

        Map empreses = new HashMap();

        empreses.put("ALPHA", new Empresa("ALPHA"));
        empreses.put("BETA", new Empresa("BETA"));
        empreses.put("GAMMA", new Empresa("GAMMA"));
        empreses.put("DELTA", new Empresa("DELTA"));
        empreses.put("EPSILON", new Empresa("EPSILON"));
        empreses.put("OMEGA", new Empresa("OMEGA"));

        return empreses;
    }

    @Override
    public String toString() {
        return  "\n President=" + president +
                "\n Nom Empresa=" + nomEmpresa  +
                "\n Numero Accions=" + numeroAccions +
                "\n Estat Desenvolupament=" + estatDesenvolupament + "\n\n";
    }
}
