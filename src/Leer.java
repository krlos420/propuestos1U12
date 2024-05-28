
import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Leer {
    private final static BufferedReader entradaConsola =
            new BufferedReader(new java.io.InputStreamReader(System.in));

public static String leerTexto(String mensaje) {
    String respuesta = null;
    do {
        try {
            System.out.print(mensaje);
            respuesta = entradaConsola.readLine();
        }
        catch (IOException ex) {
            return "";
        }
    } while (respuesta == null);
    return respuesta;
}

public static int leerEntero(String mensaje) {
    int n = 0;
    boolean aconseguit = false;
    while (!aconseguit) {
        try {
            n = Integer.parseInt(leerTexto(mensaje));
            aconseguit = true;
        }
        catch (NumberFormatException ex) {
            System.out.println("Has d'introduir un nombre correcte");
        }
    }
    return n;
}

public static double leerDouble(String mensaje) {
    double n = 0.0;
    boolean aconseguit = false;
    while (!aconseguit) {
        try {
            n = Double.parseDouble(leerTexto(mensaje));
            aconseguit = true;
        }
        catch (NumberFormatException ex) {
            System.out.println("Has d'introduir un nombre correcte");
        }
    }
    return n;
}
public static boolean leerBoolean(String mensaje){
    boolean n = false;
    n = Boolean.parseBoolean(leerTexto(mensaje));
    return n;
}
public static Date leerFecha(String mensaje){
    Date fecha = new Date();
    DateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
    boolean correcto = false;

    while(!correcto){
        try {
            String entrada = leerTexto("Format DD/MM/YYYY: ");
            fecha = formatar.parse(entrada);
            correcto = true;
        } catch (NumberFormatException | ParseException ex){
            System.out.println("Tienes que introducir una fecha correcta");
        }
    }
    return fecha;
}
}





