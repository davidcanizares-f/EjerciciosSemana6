package negocio;

public class AnalizadorTareas {
    private Tarea[] tareas;

    public AnalizadorTareas(Tarea[] tareas){
        this.tareas = tareas;
    }

    public int contarCompletadas(){
        int completadas=0;
        for(int i=0; i< tareas.length ; i++){
            if(tareas[i] != null && tareas[i].isCompletada()){
                completadas++;
            }
        }
        return completadas;
    }
    public int calcularHorasTotales(){
        int horasTotales=0;
        for(int i =0 ; i<tareas.length; i++){
            if(tareas[i]!= null){
                horasTotales += tareas[i].getHorasEstimadas();
            }
        }
        return horasTotales;
    }
    public Tarea buscarPorCodigo(String codigo){
        for(int i =0; i<tareas.length ; i++){
            if(tareas[i] != null && tareas[i].getCodigo().equals(codigo)){
                return tareas[i];
            }
        }
        return null;

    }
    public Tarea obtenerTareaMayorDuracion(){
        Tarea tareaMayorDuracion = null;
        for(int i = 0; i < tareas.length; i++){
            if(tareas[i] != null){
                if(tareaMayorDuracion == null || tareas[i].getHorasEstimadas() > tareaMayorDuracion.getHorasEstimadas()){
                    tareaMayorDuracion = tareas[i];
                }
            }
        }
        return tareaMayorDuracion;
    }
    public double porcentajeTareasCompletadas(){
        int tareasValidas = 0;
        for(int i =0; i< tareas.length; i++){
            if(tareas[i] != null){
                tareasValidas++;
            }
        }
        if(tareasValidas == 0){
            return 0;
        }
        return (contarCompletadas() * 100)/tareasValidas;
    }
    public String listarTareas(){
        String resultado = "";
        for(int i =0; i<tareas.length; i++){
            if(tareas[i]!= null){
                resultado += tareas[i].toString() + "\n";
            }
        }
        return resultado;
    }
}
