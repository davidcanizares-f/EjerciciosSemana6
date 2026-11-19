package negocio;

public class PanelMonitoreo {
    private Sensor[] sensores;

    public PanelMonitoreo(Sensor[] sensores){
        this.sensores = sensores;
    }

    public String listarSensores(){
        String resultado = "";
        for(int i = 0; i< sensores.length; i++){
            if(sensores[i] != null){
                resultado += sensores[i].mostrarInformacion() + '\n';
            }
        }
        return resultado;
    }

    public int contarActivos(){
        int contador = 0;
        for(int i= 0; i < sensores.length; i++){
            if(sensores[i] != null && sensores[i].isActivo()){
                contador++;
            }
        }
        return contador;
    }

    public double calcularPromedioLecturas(){
        double suma = 0;
        int validos = 0;
        for(int i = 0; i<sensores.length; i++){
            if(sensores[i] != null){
                suma += sensores[i].getLectura();
                validos++;

            }
        }
        if(validos == 0){
            return 0;
        }
        return suma/validos;
    }
    public Sensor buscarSensor(String codigo){
        for(int i = 0; i<sensores.length; i++){
            if(sensores[i] != null && sensores[i].getCodigo().equals(codigo)){
                return sensores[i];
            }
        }
        return null;

    }

    public Sensor obtenerMayorLectura(){
        Sensor mayor = null;
        for(int i = 0; i< sensores.length; i++){
            if(sensores[i] != null){
                if(mayor == null || sensores[i].getLectura() > mayor.getLectura()){
                    mayor = sensores[i];
                }
            }

        }
        return mayor;
    }

}
