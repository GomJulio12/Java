package Clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Gomez Hernandez Julio Manuel <gom_julio12@outlook.com>
 */
public class Regex {

     Pattern[] Patron = new Pattern[15];

    public Regex() {
        Patron[0] = Pattern.compile("(float|int|double|char|String|for|if|while|else|then|println|print)"); //Palabras Reservadas
        Patron[1] = Pattern.compile("([a-zA-Z]|_)([a-zA-Z]|_|[0-9])*");      //Variables ([a-zA-Z]|_)([a-zA-Z]|_|[0-9])*
        Patron[2] = Pattern.compile("[\\+|\\-]?\\d+\\.\\d+");                          //Numero Decimal
        Patron[3] = Pattern.compile("[0-9]+");                               //Numero Entero
        Patron[4] = Pattern.compile(",");                                  //Coma
        Patron[5] = Pattern.compile(";");                                  //Punto y Coma
        Patron[6] = Pattern.compile("\\={1}");                                  //Asignacion
        Patron[7] = Pattern.compile("\\(");                                 //Parentesis Izquierdo
        Patron[8] = Pattern.compile("\\)");                                  //Parentesis Derecho
        Patron[9] = Pattern.compile("\\>|\\<|\\<=|\\>=|\\!=|\\={2}");               //Operadores Relacionales
        Patron[10] = Pattern.compile("\\{");                                   //Llave Izquierda
        Patron[11] = Pattern.compile("\\}");    //Llave Derecha
        Patron[12] = Pattern.compile("\\+{2}");   //Incrementos
        Patron[13] = Pattern.compile("\\+|\\-|\\/|\\*"); //Operadores Aritmeticos
        Patron[14] = Pattern.compile("\"[^\"]*\"");      //Cadenas 
    }
    
    public boolean Reconocer (String Texto, int iniToken, int[] i, int noAuto){
    Matcher m = Patron[noAuto].matcher(Texto);
    if (m.find(iniToken))
        if (m.start()==iniToken){
        i[0] = m.end();
        return true;
        }
        else 
            return false;
    else 
        return false;
    
    }
}
