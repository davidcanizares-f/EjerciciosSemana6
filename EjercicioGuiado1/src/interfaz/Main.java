package interfaz;

import negocio.AnalizadorProyecto;
import negocio.Modulo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Modulo[] modulos = new Modulo[5];

        for (int i = 0; i < modulos.length; i++) {
            System.out.println("Modulo " + (i + 1));
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Lenguaje: ");
            String lenguaje = sc.nextLine();
            int progreso;
            do {
                System.out.print("Progreso (0-100): ");
                progreso = sc.nextInt();
                sc.nextLine();
            } while (progreso < 0 || progreso > 100);
            boolean terminado = progreso == 100;
            modulos[i] = new Modulo(nombre, lenguaje, progreso, terminado);
        }

        AnalizadorProyecto analizador = new AnalizadorProyecto(modulos);

        System.out.println();
        System.out.println("MODULOS DEL PROYECTO");
        System.out.print(analizador.listarModulos());
        System.out.println("Terminados: " + analizador.contarTerminados());
        System.out.printf("Progreso promedio: %.2f%%%n", analizador.calcularProgresoPromedio());

        System.out.print("Nombre del modulo a buscar: ");
        String buscado = sc.nextLine();
        Modulo encontrado = analizador.buscarModulo(buscado);
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.mostrarInformacion());
        } else {
            System.out.println("No existe un modulo con el nombre " + buscado);
        }

        Modulo menor = analizador.obtenerMenorProgreso();
        System.out.println("Menor progreso: " + menor.mostrarInformacion());

        sc.close();
    }
}