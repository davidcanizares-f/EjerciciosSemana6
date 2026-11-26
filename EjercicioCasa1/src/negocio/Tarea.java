package negocio;

public class Tarea {
    private String codigo;
    private String titulo;
    private int horasEstimadas;
    private boolean completada;

    public Tarea(String codigo, String titulo, int horasEstimadas, boolean completada) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.completada = completada;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public boolean isCompletada() {
        return completada;
    }
    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
    @Override
    public String toString(){
        return "Tarea [Codigo:" + codigo + ", Título=" + titulo
                + ", HorasEstimadas:" + horasEstimadas
                + ", Completada:" + (completada ? "SI" : "NO") + "]";
    }
}
