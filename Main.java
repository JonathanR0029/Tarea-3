import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

   
    static class Empleado {
   
        private String nombre;
        private int edad;
        private double salario;
        private String cargo;

     
        public Empleado(String nombre, int edad, double salario, String cargo) {
            this.nombre = nombre;
            this.edad = edad;
            this.salario = salario;
            this.cargo = cargo;
        }

     
        public String getNombre() {
            return nombre;
        }

        public int getEdad() {
            return edad;
        }

        public double getSalario() {
            return salario;
        }

        public String getCargo() {
            return cargo;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

      
        public void imprimirInformacion() {
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
            System.out.println("Salario: $" + salario);
            System.out.println("Cargo: " + cargo);
        }
    }

   
    static class GestorEmpleados {
  
        private final List<Empleado> empleados;

  
        public GestorEmpleados() {
            empleados = new ArrayList<>();
        }

     
        public void agregarEmpleado(Empleado empleado) {
            empleados.add(empleado);
        }

   
        public void mostrarEmpleados() {
            System.out.println("\nDetalles de los empleados:");
            for (Empleado empleado : empleados) {
                empleado.imprimirInformacion();
                System.out.println("---------------------");
            }
        }

      
        public void eliminarEmpleado(String nombre) {
            empleados.removeIf(empleado -> empleado.getNombre().equalsIgnoreCase(nombre));
            System.out.println("Empleado " + nombre + " eliminado.");
        }

    
        public Empleado buscarEmpleado(String nombre) {
            for (Empleado empleado : empleados) {
                if (empleado.getNombre().equalsIgnoreCase(nombre)) {
                    return empleado;
                }
            }
            return null;
        }

     
        public void actualizarEmpleado(String nombre, String nuevoNombre, Integer nuevaEdad, Double nuevoSalario, String nuevoCargo) {
            Empleado empleado = buscarEmpleado(nombre);
            if (empleado != null) {
                if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
                    empleado.setNombre(nuevoNombre);
                }
                if (nuevaEdad != null) {
                    empleado.setEdad(nuevaEdad);
                }
                if (nuevoSalario != null) {
                    empleado.setSalario(nuevoSalario);
                }
                if (nuevoCargo != null && !nuevoCargo.isEmpty()) {
                    empleado.setCargo(nuevoCargo);
                }
                System.out.println("Información del empleado actualizada.");
            } else {
                System.out.println("Empleado no encontrado.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorEmpleados gestor = new GestorEmpleados();

     
        gestor.agregarEmpleado(new Empleado("Antonia Ventura", 30, 1200.00, "Ingeniera"));
        gestor.agregarEmpleado(new Empleado("Sergio Reyes", 40, 1500.00, "Arquitecto"));
        gestor.agregarEmpleado(new Empleado("Roger Galeas", 35, 1300.00, "Supervisor"));
        gestor.agregarEmpleado(new Empleado("David Kay", 28, 1100.00, "Obrero"));
        gestor.agregarEmpleado(new Empleado("Chris Alonzo", 29, 1150.00, "Diseñadora"));

        while (true) {
            System.out.println("\n=== Menú de Gestión de Empleados ===");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Buscar empleado");
            System.out.println("5. Actualizar información de empleado");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el nombre del empleado: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la edad del empleado: ");
                    int edad = scanner.nextInt();
                    System.out.print("Ingrese el salario del empleado: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine(); 
                    System.out.print("Ingrese el cargo del empleado: ");
                    String cargo = scanner.nextLine();
                    Empleado nuevoEmpleado = new Empleado(nombre, edad, salario, cargo);
                    gestor.agregarEmpleado(nuevoEmpleado);
                    System.out.println("Empleado agregado exitosamente.");
                }

                case 2 -> gestor.mostrarEmpleados();

                case 3 -> {
                    System.out.print("Ingrese el nombre del empleado a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    gestor.eliminarEmpleado(nombreEliminar);
                }

                case 4 -> {
                    System.out.print("Ingrese el nombre del empleado a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    Empleado empleadoEncontrado = gestor.buscarEmpleado(nombreBuscar);
                    if (empleadoEncontrado != null) {
                        System.out.println("Empleado encontrado:");
                        empleadoEncontrado.imprimirInformacion();
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                }

                case 5 -> {
                    System.out.print("Ingrese el nombre del empleado a actualizar: ");
                    String nombreActualizar = scanner.nextLine();

               
                    Empleado empleadoActual = gestor.buscarEmpleado(nombreActualizar);
                    if (empleadoActual != null) {
                        System.out.print("Ingrese el nuevo nombre (presione Enter para no cambiar): ");
                        String nuevoNombre = scanner.nextLine();
                        if (nuevoNombre.isEmpty()) {
                            nuevoNombre = null; 
                        }

                        System.out.print("Ingrese la nueva edad (presione 0 para no cambiar): ");
                        int nuevaEdad = scanner.nextInt();
                        if (nuevaEdad == 0) {
                            nuevaEdad = -1; 
                        }

                        System.out.print("Ingrese el nuevo salario (presione 0 para no cambiar): ");
                        double nuevoSalario = scanner.nextDouble();
                        if (nuevoSalario == 0) {
                            nuevoSalario = -1; 
                        }
                        scanner.nextLine();  

                        System.out.print("Ingrese el nuevo cargo (presione Enter para no cambiar): ");
                        String nuevoCargo = scanner.nextLine();
                        if (nuevoCargo.isEmpty()) {
                            nuevoCargo = null; 
                        }

                        gestor.actualizarEmpleado(nombreActualizar, nuevoNombre, (nuevaEdad == -1 ? null : nuevaEdad), (nuevoSalario == -1 ? null : nuevoSalario), nuevoCargo);
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                }

                case 6 -> {
                    System.out.println("Saliendo del sistema.");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}