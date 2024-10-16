/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo_crud2;
import java.sql.SQLException;
import java.util.Scanner;


/**
 *
 * @author Nelson
 */
public class Ejemplo_crud2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        int option;

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Eliminar cliente");
            System.out.println("3. Editar cliente"); // Nueva opción para editar
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    agregarcliente(scanner); //agregar
                    break;
                case 2:
                    eliminarcliente(scanner); //elimiar 
                    break;
                case 3:
                    editarcliente(scanner); // editar
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (option != 0);

        scanner.close();
    }

    private static void agregarcliente(Scanner scanner) {
        scanner.nextLine();  // Consumir el salto de línea
        System.out.print("Ingrese la Cedula: ");
        String Cedula = scanner.nextLine();
        System.out.print("Ingrese el Nombre: ");
        String Nombre = scanner.nextLine();
        System.out.print("Ingrese la Direccion: ");
        String Direccion = scanner.nextLine();
        System.out.print("Ingrese la Ciudad: ");
        String Ciudad = scanner.nextLine();
        System.out.print("Ingrese el Pais: ");
        String Pais = scanner.nextLine();

        // Llamar al método de agregar
        agregar ag = new agregar();
        try {
            ag.agregarcliente(Cedula, Nombre, Direccion, Ciudad, Pais);
            System.out.println("cliente agregado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al agregar cliente: " + e.getMessage());
        }
    }

    private static void eliminarcliente(Scanner scanner) {
        System.out.print("Ingrese el ID del cliente a eliminar: ");
        int id = scanner.nextInt();

        // Llamar al método de eliminar
        eliminar el = new eliminar();
        try {
            el.eliminarcliente(id);
            System.out.println("cliente eliminado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar cliente: " + e.getMessage());
        }
    }

    private static void editarcliente(Scanner scanner) {
        System.out.print("Ingrese el ID del cliente a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea

        System.out.print("Ingrese la nueva Cedula (deje en blanco para no cambiar): ");
        String Cedula = scanner.nextLine();
        System.out.print("Ingrese el nuevo Nombre (deje en blanco para no cambiar): ");
        String Nombre = scanner.nextLine();
        System.out.print("Ingrese la nueva Direccion (deje en blanco para no cambiar): ");
        String Direccion = scanner.nextLine();
        System.out.print("Ingrese la nueva Ciudad (deje en blanco para no cambiar): ");
        String Ciudad = scanner.nextLine();
        System.out.print("Ingrese el nuevo Pais (deje en blanco para no cambiar): ");
        String Pais = scanner.nextLine();

        // Llamar al método de editar
        editar ed = new editar();
        try {
            ed.editarcliente(id, Cedula, Nombre, Direccion, Ciudad, Pais);
            System.out.println("cliente editado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al editar persona: " + e.getMessage());
}
}
}
