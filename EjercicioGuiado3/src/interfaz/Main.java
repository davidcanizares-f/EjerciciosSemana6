package interfaz;

import negocio.PanelMonitoreo;
import negocio.Sensor;
import negocio.PanelMonitoreo;

import java.util.Scanner;
public class Main {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        Sensor[] sensores = new Sensor[5];
        for(int i = 0; i < sensores.length; i++){
            System.out.println("Sensor " + (i+1));
            System.out.print("Codigo: ");
            String codigo = sc.nextLine();
            System.out.print("Tipo: ");
            String tipo = sc.nextLine();
            System.out.print("Unidad: ");
            String unidad = sc.nextLine();
            System.out.print("Lectura: ");
            double lectura = sc.nextDouble();
            sc.nextLine();
            System.out.println("Activo (s/n): ");
            boolean activo = sc.nextLine().equalsIgnoreCase("s");

            sensores[i] = new Sensor(codigo, tipo, unidad, lectura, activo);

        }
        PanelMonitoreo panel = new PanelMonitoreo(sensores);
        System.out.println("==== PANEL DE MONITOREO ====");
        System.out.println(panel.listarSensores());
        System.out.println("Activos: " + panel.contarActivos());
        System.out.println("Promedio Lecturas: " + panel.calcularPromedioLecturas());
        System.out.print("Buscar por Codigo: ");
        String codigoBuscado = sc.nextLine();
        Sensor encontrado = panel.buscarSensor(codigoBuscado);
        if(encontrado != null){
            System.out.println("Encontrado: " + encontrado.mostrarInformacion());
        }else{
            System.out.println("No se encontró el sensor");
        }
        Sensor mayorLectura = panel.obtenerMayorLectura();
        System.out.println("Sensor con Mayor Lectura: " + mayorLectura.mostrarInformacion());

        sc.close();


    }
}
