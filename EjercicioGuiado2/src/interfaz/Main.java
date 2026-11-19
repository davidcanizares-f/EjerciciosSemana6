package interfaz;

import java.util.Scanner;
import negocio.AnalizadorCatalogo;
import negocio.Producto;

public class Main {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        Producto[] productos = new Producto[5];
        for(int i = 0; i < productos.length ; i++){
            System.out.println("Producto " + (i +1));
            System.out.print("Codigo: ");
            String codigo = sc.nextLine();
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Precio: ");
            double precio = sc.nextDouble();
            sc.nextLine();
            System.out.print("Disponible (s/n): ");
            boolean disponible = sc.nextLine().equalsIgnoreCase("s");
            productos[i] = new Producto(codigo, nombre, precio, disponible);
        }
        AnalizadorCatalogo analizador = new AnalizadorCatalogo(productos);
        System.out.println("=== CATALOGO ====");
        System.out.println(analizador.listarProductos());
        System.out.println("Disponibles: " + analizador.contarDisponibles());
        System.out.println("Precio Promedio: $" + analizador.calcularPrecioPromedio());
        System.out.print("Buscar por codigo: ");
        String buscado = sc.nextLine();
        Producto encontrado = analizador.buscarPorCodigo(buscado);
        if(encontrado != null){
            System.out.println(encontrado.mostrarInformacion());
        }else{
            System.out.println("No se encontró el producto.");
        }
        Producto masCaro = analizador.obtenerProductoMasCaro();
        System.out.println("Producto mas Caro: " + masCaro.mostrarInformacion());
        sc.close();




    }
}
