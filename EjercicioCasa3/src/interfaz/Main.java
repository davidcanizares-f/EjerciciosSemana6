package interfaz;

import negocio.AnalizadorVersiones;
import negocio.VersionSoftware;
import negocio.AnalizadorVersiones;

import java.util.Scanner;

public class Main {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        final int CANTIDAD = 5;
        VersionSoftware[] versiones = new VersionSoftware[CANTIDAD];
        System.out.println("Ingrese los datos de " + CANTIDAD + " versiones.");
        for (int i = 0; i < CANTIDAD; i++) {
            System.out.println("\n- Version " + (i + 1));
            System.out.print("Numero (ejemplo: 1.0.2): ");
            String numero = sc.nextLine();
            System.out.print("Fecha (dd/mm/aaaa): ");
            String fecha = sc.nextLine();
            System.out.print("Estable? (s/n): ");
            boolean estable = sc.nextLine().equalsIgnoreCase("s");
            System.out.print("Cantidad de cambios: ");
            int cambios = Integer.parseInt(sc.nextLine());
            versiones[i] = new VersionSoftware(numero, fecha, estable, cambios);
        }
        AnalizadorVersiones analizador = new AnalizadorVersiones(versiones);
        System.out.println("\n=== HISTORIAL DE VERSIONES ===");
        System.out.print(analizador.listarVersiones());

        System.out.println("\n=== PRUEBAS ===");
        System.out.println("Versiones estables: " + analizador.contarEstables());
        System.out.println("Total de cambios: " + analizador.sumarCambios());
        System.out.print("\nNumero de version a buscar (existente): ");
        String num1 = sc.nextLine();
        VersionSoftware v1 = analizador.buscarVersion(num1);
        if (v1 != null) {
            System.out.println("Encontrada: " + v1);
        } else {
            System.out.println("No existe la version " + num1);
        }
        System.out.print("Numero de version a buscar (inexistente): ");
        String num2 = sc.nextLine();
        VersionSoftware v2 = analizador.buscarVersion(num2);
        if (v2 != null) {
            System.out.println("Encontrada: " + v2);
        } else {
            System.out.println("No existe la version " + num2);
        }
        VersionSoftware mayor = analizador.obtenerVersionMasCambios();
        if (mayor != null) {
            System.out.println("\nVersion con mas cambios: " + mayor);
        } else {
            System.out.println("\nNo hay versiones registradas.");
        }
        System.out.println("Promedio de cambios por version: " + analizador.calcularPromedioCambios());

        sc.close();
    }

}
