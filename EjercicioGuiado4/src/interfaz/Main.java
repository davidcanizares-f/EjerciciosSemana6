package interfaz;

import java.util.Scanner;
import negocio.EquipoRed;
import negocio.AnalizadorRed;

public class Main {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        EquipoRed[] equipos = new EquipoRed[2];

        for (int i = 0; i < equipos.length; i++) {
            System.out.println("Equipo " + (i + 1));
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Direccion IP: ");
            String ip = sc.nextLine();
            System.out.print("Tipo: ");
            String tipo = sc.nextLine();
            System.out.print("Velocidad (Mbps): ");
            double velocidad = sc.nextDouble();
            sc.nextLine();
            System.out.print("Activo (s/n): ");
            boolean activo = sc.nextLine().equalsIgnoreCase("s");
            equipos[i] = new EquipoRed(nombre, ip, tipo, velocidad, activo);
        }

        AnalizadorRed analizador = new AnalizadorRed(equipos);

        System.out.println("==== INVENTARIO DE RED ====");
        System.out.print(analizador.listarEquipos());
        System.out.println("Activos: " + analizador.contarActivos());
        System.out.printf("Velocidad promedio: %.2f Mbps%n", analizador.calcularVelocidadPromedio());

        System.out.print("IP a buscar: ");
        String buscada = sc.nextLine();
        EquipoRed encontrado = analizador.buscarPorIP(buscada);
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.mostrarInformacion());
        } else {
            System.out.println("No existe un equipo con la IP " + buscada);
        }

        EquipoRed masRapido = analizador.obtenerEquipoMasRapido();
        System.out.println("Equipo mas rapido: " + masRapido.mostrarInformacion());

        sc.close();
    }
}