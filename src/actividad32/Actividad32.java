/* Escriban un programa que lea una fecha, ingresando por separado el día, mes
 * y año. El programa debe calcular la fecha del día siguiente. El programa debe
 * tener en cuenta los años bisiestos para el manejo de fechas del último día
 * del mes de febrero.
 */
package actividad32;
import java.util.Scanner;
/**
 *
 * @author Enrique A. Martínez Agudelo
 */
public class Actividad32 {
    /**
     * Esta función detemina si un año es o no bisiesto, para esto debe procesar
     * el año dado mediante divisiones; se dice que un año es bisiesto si este
     * es divisible entre 4, pero también hay que calcular si estos años han de
     * ser seculares (un siglo), ya que estos también son divisibles entre 4,
     * para este caso los años seculares han de ser divisibles entre 400 para
     * ser denominados bisiestos.
     * @param year guada el valor del año a calcular.
     * @return falso si el año no es bisiesto.
     */
    private static boolean leapYear(int year) {
        // Declaración e inicializacion de variable booleana.
        boolean bisi = false;
        // Si el módulo del año entre 100 es cero se está ante un año secular,
        // por ende ha de calcularse el módulo de este entre 400 si da cero se
        // esta ante un año secular bisiesto.
        // Si el módulo del año entre 4 es cero se está ante un año bisiesto.
        if((year % 100 == 0 && year % 400 == 0) || year % 4 == 0){
            // 'bisi' cambia de valor.
            bisi = true;
        }
        // Se retorna el valor de 'bisi'.
        return bisi;
    }
    
    /**
     * Determina el día siguiente a a fecha dada.
     * @param day Corresponde al día.
     * @param month Corresponde al mes.
     * @param year Corresponde al año.
     */
    private static void tomorrow(int day, int month, int year) {
        // ---------------------------------------------------------------------
        // Evalua si 'year' es bisiesto con leapYear(), también si 'month' tiene
        // valor 2 y si el valor de 'day' está en el rango [1, 29].
        if(leapYear(year) && month == 2 && day > 0 && day <=29){
            // Evalua si 'day' tiene valor 29, si es así a 'day' toma valor 1 y
            // 'month' incrementa en 1. Sino 'day' incrementa en 1.
            if(day == 29){
                day = 1;
                month++;
            } else {
                day++;
            }
            // Se imprime la fecha de mañana.
            System.out.println("La fecha del día siguiente es: "
                    +day+"/"+month+"/"+year);
        }
        // ---------------------------------------------------------------------
        // Evalua si 'month' tiene valor en el conjunto [4, 6, 9, 11], y si
        // 'day' está en el rango [1, 30].
        else if ((month == 4 || month == 6 || month == 9 || month == 11)
            && (day > 0 && day <=30)){
            // Evalua si 'day' tiene valor 30, si es así a 'day' toma valor 1 y
            // 'month' incrementa en 1. Sino 'day' incrementa en 1.
            if(day == 30){
                day = 1;
                month ++;
            } else {
                day++;
            }
            // Se imprime la fecha de mañana.
            System.out.println("La fecha del día siguiente es: "
                    +day+"/"+month+"/"+year);
        }
        // ---------------------------------------------------------------------
        // Evalua si 'month' tiene valor en el conjunto [1, 3, 5, 7, 8, 10, 12],
        // y si 'day' está en el rango [1, 31].
        else if ((month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12) &&
                (day > 0 && day <=31)){
            // Evalua si 'day' tiene valor 31 y si 'month' tiene valor distinto
            // a 12, si es así 'day' toma valor 1 y 'month' incrementa en 1.
            // Sino evalua si 'day' tiene valor 31 y 'month' tiene valor 12, si
            // es así 'day' toma valor 1, 'month' toma valor 1 y 'year'
            // incrementa en 1. Sino 'day' incrementa en 1.
            if(day == 31 && month != 12){
                day = 1;
                month++;
            } else if(day == 31 && month == 12){
                day = 1;
                month = 1;
                year++;
            } else {
                day++;
            }
            // Se imprime la fecha de mañana.
            System.out.println("La fecha del día siguiente es: "
                    +day+"/"+month+"/"+year);
        }
        // ---------------------------------------------------------------------
        // Si ninguna evaluación resultó exitosa imprime un mensaje de error.
        else {
            System.out.println("Error 1: La fecha: "+day+"/"+month+"/"+year
                    +" introducida no existe");
        }
        // ---------------------------------------------------------------------
        
    }
    /**
     * 
     * @param args
     */
    public static void main(String args[]) {
        // Definición de objeto Scanner.
        Scanner data = new Scanner(System.in);
        // Muestra mensaje pidiendo la carga del día.
        System.out.println("Digite el día.");
        // Carga de día por teclado.
        int day = data.nextInt();
        // Muestra mensaje pidiendo la carga del mes.
        System.out.println("Digite el mes en valor numérico.");
        // Carga de día por teclado.
        int month = data.nextInt();
        // Muestra mensaje pidiendo la carga del año.
        System.out.println("Digite el año.");
        // Carga de día por teclado.
        int year = data.nextInt();
        // Llamada a la función "tomorrow()".
        tomorrow(day, month, year);
    }
}
