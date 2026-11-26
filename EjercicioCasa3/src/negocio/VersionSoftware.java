package negocio;

public class VersionSoftware {
    private String numero;
    private String fecha;
    private boolean estable;
    private int cantidadCambios;

    public VersionSoftware(String numero, String fecha, boolean estable, int cantidadCambios) {
        this.numero = numero;
        this.fecha = fecha;
        this.estable = estable;
        this.cantidadCambios = cantidadCambios;
    }

    public String getNumero() {
        return numero;
    }

    public String getFecha() {
        return fecha;
    }

    public boolean isEstable() {
        return estable;
    }

    public int getCantidadCambios() {
        return cantidadCambios;
    }

    @Override
    public String toString() {
        return "Version [numero:" + numero + ", Fecha:" + fecha
                + ", Estable:" + (estable ? "SI" : "NO")
                + ", Cantidad Cambios:" + cantidadCambios + "]";
    }
}
