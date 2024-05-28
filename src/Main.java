
public class Main {
    public static void main(String[] args) {
        DBManager.loadDriver();
        DBManager.connect();
        boolean salir = false;
        do{
            salir = menuPrincipal();
        }while (!salir);
        DBManager.close();
    }
    private static boolean menuPrincipal() {
        System.out.println("");
        System.out.println("MENU PRINCIPAL");
        System.out.println("1. Gestión de libros");
        System.out.println("0. Salir");

        int opcion = Leer.leerEntero("Elige una opción: ");

        switch (opcion) {
            case 1:
                GestionLibros.menuLibros();
                break;
            case 0:
                System.out.println("Saliendo...");
                return true;
            default:
                System.out.println("Opción no válida");
        }
        return false;
    }
}