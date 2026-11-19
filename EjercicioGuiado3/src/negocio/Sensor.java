package negocio;

public class Sensor {
    private String codigo;
    private String tipo;
    private String unidad;
    private double lectura;
    private boolean activo;

    public Sensor(String codigo, String tipo, String unidad, double lectura, boolean activo){
        this.codigo = codigo;
        this.tipo = tipo;
        this.unidad = unidad;
        this.lectura = lectura;
        this.activo = activo;
    }

    public String getCodigo(){
        return codigo;
    }
    public String getTipo(){
        return tipo;
    }

    public String getUnidad() {
        return unidad;
    }

    public double getLectura() {
        return lectura;
    }

    public boolean isActivo() {
        return activo;
    }

    public String mostrarInformacion() {
        String estado = activo ? "Activo" : "Inactivo";
        return "> " + codigo + " - " + tipo + " - " + lectura + " " + unidad + " - " + estado;
    }
}
