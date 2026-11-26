package interfaz;
import negocio.AnalizadorErrores;
import negocio.ErrorSoftware;

import java.util.Scanner;
public class Main {
    private static String leerSeveridad(Scanner sc) {
        String s;
        do {
            System.out.print("Severidad (ALTA/MEDIA/BAJA): ");
            s = sc.nextLine().trim().toUpperCase();
        } while (!s.equals("ALTA") && !s.equals("MEDIA") && !s.equals("BAJA"));
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int CANTIDAD = 7;
        ErrorSoftware[] errores = new ErrorSoftware[CANTIDAD];
        System.out.println("Ingrese los datos de " + CANTIDAD + " errores (usar ALTA, MEDIA y BAJA).");

        for (int i = 0; i < CANTIDAD; i++) {
            System.out.println("\n- Error " + (i + 1));
            System.out.print(">Codigo: ");
            String codigo = sc.nextLine();
            System.out.print(">Descripcion: ");
            String descripcion = sc.nextLine();
            String severidad = leerSeveridad(sc);
            System.out.print(">Resuelto? (s/n): ");
            boolean resuelto = sc.nextLine().equalsIgnoreCase("s");

            errores[i] = new ErrorSoftware(codigo, descripcion, severidad, resuelto);
        }

        AnalizadorErrores analizador = new AnalizadorErrores(errores);

        System.out.println("\n=== LISTADO DE ERRORES ===");
        System.out.print(analizador.listarErrores());

        System.out.println("\n=== PRUEBAS ===");
        System.out.println("Errores pendientes: " + analizador.contarPendientes());

        System.out.println("\nConteo por severidad:");
        System.out.println(" >ALTA : " + analizador.contarPorSeveridad("ALTA"));
        System.out.println(" >MEDIA: " + analizador.contarPorSeveridad("MEDIA"));
        System.out.println(" >BAJA : " + analizador.contarPorSeveridad("BAJA"));

        System.out.print("\nSeveridad a listar (ALTA/MEDIA/BAJA): ");
        String sev = sc.nextLine().trim().toUpperCase();
        String listado = analizador.listarPorSeveridad(sev);
        if (listado.equals("")) {
            System.out.println("No hay errores con severidad " + sev);
        } else {
            System.out.println("Errores con severidad " + sev + ":");
            System.out.print(listado);
        }
        System.out.print("\nCodigo a buscar (existente): ");
        String codigo1 = sc.nextLine();
        ErrorSoftware e1 = analizador.buscarPorCodigo(codigo1);
        if (e1 != null) {
            System.out.println("Encontrado: " + e1);
        } else {
            System.out.println("No se encontro el error con codigo " + codigo1);
        }
        System.out.print("Codigo a buscar (inexistente): ");
        String codigo2 = sc.nextLine();
        ErrorSoftware e2 = analizador.buscarPorCodigo(codigo2);
        if (e2 != null) {
            System.out.println("Encontrado: " + e2);
        } else {
            System.out.println("No se encontro el error con codigo " + codigo2);
        }
        ErrorSoftware critico = analizador.obtenerPrimerPendienteAlta();
        if (critico != null) {
            System.out.println("\nPrimer error pendiente de severidad ALTA: " + critico);
        } else {
            System.out.println("\nNo hay errores pendientes de severidad ALTA.");
        }

        sc.close();
    }
}
