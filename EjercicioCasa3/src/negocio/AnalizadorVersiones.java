package negocio;

public class AnalizadorVersiones {
    private VersionSoftware[] versiones;

    public AnalizadorVersiones(VersionSoftware[] versiones) {
        this.versiones = versiones;
    }

    public int contarEstables() {
        int contador = 0;
        for (int i = 0; i < versiones.length; i++) {
            if (versiones[i] != null && versiones[i].isEstable()) {
                contador++;
            }
        }
        return contador;
    }
    public VersionSoftware buscarVersion(String numero) {
        for (int i = 0; i < versiones.length; i++) {
            if (versiones[i] != null && versiones[i].getNumero().equals(numero)) {
                return versiones[i];
            }
        }
        return null;
    }


    public VersionSoftware obtenerVersionMasCambios() {
        VersionSoftware mayor = null;
        for (int i = 0; i < versiones.length; i++) {
            if (versiones[i] != null) {
                if (mayor == null || versiones[i].getCantidadCambios() > mayor.getCantidadCambios()) {
                    mayor = versiones[i];
                }
            }
        }
        return mayor;
    }

    public int sumarCambios() {
        int total = 0;
        for (int i= 0; i < versiones.length; i++) {
            if (versiones[i] != null) {
                total += versiones[i].getCantidadCambios();
            }
        }
        return total;
    }

    public double calcularPromedioCambios() {
        int validas = 0;
        for (int i = 0; i < versiones.length; i++) {
            if (versiones[i] != null) {
                validas++;
            }
        }
        if (validas == 0) {
            return 0;
        }
        return (double) sumarCambios() /validas;
    }

    public String listarVersiones() {
        String resultado = "";
        for (int i = 0; i < versiones.length; i++) {
            if (versiones[i] != null) {
                resultado += versiones[i].toString() + "\n";
            }
        }
        return resultado;
    }
}
