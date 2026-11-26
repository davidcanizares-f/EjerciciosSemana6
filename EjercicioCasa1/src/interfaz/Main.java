package interfaz;

import negocio.AnalizadorTareas;
import negocio.Tarea;

import java.util.Scanner;

public class Main {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        final int CANTIDAD = 2;
        Tarea[] tareas = new Tarea[CANTIDAD];
        System.out.println("Ingrese los datos de " + CANTIDAD + " tareas del sprint.");

        for (int i = 0; i < CANTIDAD; i++) {
            System.out.println("\n> Tarea " + (i + 1));
            System.out.print(">Codigo: ");
            String codigo = sc.nextLine();
            System.out.print("> Titulo: ");
            String titulo = sc.nextLine();
            System.out.print(">Horas estimadas: ");
            int horas = Integer.parseInt(sc.nextLine());
            System.out.print(">Completada? (s/n): ");
            boolean completada = sc.nextLine().equalsIgnoreCase("s");

            tareas[i] = new Tarea(codigo, titulo, horas, completada);
        }
        AnalizadorTareas analizador = new AnalizadorTareas(tareas);

        System.out.println("\n=== LISTADO DE TAREAS ===");
        System.out.print(analizador.listarTareas());

        System.out.println("\n=== PRUEBAS ===");
        System.out.println("Tareas completadas: " + analizador.contarCompletadas());
        System.out.println("Horas totales: " + analizador.calcularHorasTotales());
        System.out.print("\nCodigo a buscar (existente): ");
        String codigo1 = sc.nextLine();
        Tarea t1 = analizador.buscarPorCodigo(codigo1);
        if (t1 != null) {
            System.out.println("Encontrada: " + t1);
        } else {
            System.out.println("No se encontro la tarea con codigo " + codigo1);
        }
        System.out.print("Codigo a buscar (inexistente): ");
        String codigo2 = sc.nextLine();
        Tarea t2 = analizador.buscarPorCodigo(codigo2);
        if (t2 != null) {
            System.out.println("Encontrada: " + t2);
        } else {
            System.out.println("No se encontro la tarea con codigo " + codigo2);
        }
        Tarea mayor = analizador.obtenerTareaMayorDuracion();
        if (mayor != null) {
            System.out.println("\nTarea de mayor duracion: " + mayor);
        } else {
            System.out.println("\nNo hay tareas registradas.");
        }
        System.out.println("Porcentaje de tareas completadas: " + analizador.porcentajeTareasCompletadas() + "%");

        sc.close();

    }

}
