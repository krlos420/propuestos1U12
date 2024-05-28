public class GestionLibros {
    public static boolean menuLibros(){
        System.out.println("");
        System.out.println("Menu principal");
        System.out.println("1. Listar libros");
        System.out.println("2. Nuevo libro");
        System.out.println("3. Modificar libro");
        System.out.println("4. Eliminar libro");
        System.out.println("5. Salir");

        int opcion = Leer.leerEntero("Elige una opción: ");

        switch(opcion){
            case 1:
                opcionMostrarLibros();
                break;
            case 2:
                opcionNuevoLibro();
                break;
            case 3:
                opcionModificarLibro();
                break;
            case 4:
                opcionEliminarLibro();
                break;
            case 5:
                return true;
            default:
                System.out.println("Opcion no valida");
        }
        return false;
    }
    public static void opcionMostrarLibros(){
        System.out.println("\nListado de libros:");
        System.out.println("------------------");
        DBManager.mostrarLibros();
    }
    public static void opcionNuevoLibro(){
        System.out.println("\nIntroduce los datos del nuevo libro:");
        System.out.println("------------------------------------");
        String nombre = Leer.leerTexto("Nombre: ");
        Double precio = Leer.leerDouble("Precio: ");

        boolean res = DBManager.nuevoLibro(nombre, precio);
        if(res){
            System.out.println("Libro registrado correctamente");
        } else {
            System.out.println("Libro no registrado");
        }
    }
    public static void opcionModificarLibro(){
        int id = Leer.leerEntero("Indica el ID del libro a modificar: ");

        if(!DBManager.existsLibro(id)){
            System.out.println("El libro "+id+" no existe");
            return;
        }
        DBManager.printLibro(id);

        String nuevoNombre = Leer.leerTexto("Nuevo nombre: ");
        Double nuevoPrecio = Leer.leerDouble("Nuevo nuevoPrecio: ");

        boolean res = DBManager.modificarLibro(id, nuevoNombre, nuevoPrecio);
        if(res){
            System.out.println("Libro modificado correctamente");
        }else {
            System.out.println("Error");
        }
    }
    public static void opcionEliminarLibro(){
        int id = Leer.leerEntero("Indica el id del libro a eliminar: ");

        if (!DBManager.existsLibro(id)) {
            System.out.println("El libro " + id + " no existe.");
            return;
        }
        boolean res = DBManager.eliminarLibro(id);
        if(res){
            System.out.println("Libro eliminado correctamente");
        } else {
            System.out.println("Error");
        }

    }
}
