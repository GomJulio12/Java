package Clases;

/**
 *
 * @author Gomez Hernandez Julio Manuel <gom_julio12@outlook.com>
 */
public class Lexico {

    final int TOKREC = 15; //Minimo de Token
    final int MAXTOKENS = 500; //Maximo de Tokens 
    String[] Lexemas;
    String[] Tokens;
    String Lexema;
    int NoTokens; //Numero de Tokens
    int[] i = {0};
    int IniToken;
    Regex Patron;

    public int NoTokens() {
        return NoTokens;
    }

    public String[] Tokens() {
        return Tokens;
    }

    public String[] Lexemas() {
        return Lexemas;
    }

    public Lexico() {
        Lexemas = new String[MAXTOKENS];
        Tokens = new String[MAXTOKENS];
        Patron = new Regex();
        i[0] = 0;
        IniToken = 0;
        NoTokens = 0;
    }

    public void Inicia() {
        i[0] = 0;
        IniToken = 0;
        NoTokens = 0;
    }

    //Metodo donde analiza el texto de entrada y verifica que patron corresponde
    public void Analiza(String Texto) {
        boolean recAuto;
        int noAuto;
        while (i[0] < Texto.length()) {
            recAuto = false;
            noAuto = 0;
            for (; noAuto < TOKREC && !recAuto;) {
                if (Patron.Reconocer(Texto, IniToken, i, noAuto)) {
                    recAuto = true;
                } else {
                    noAuto++;
                }
            }
            if (recAuto) {
                Lexema = Texto.substring(IniToken, i[0]);
                switch (noAuto) {
                    case 0:
                        Tokens[NoTokens] = "Patron 1 Palabras Reservadas";
                        break;
                    case 1:
                        Tokens[NoTokens] = "Patron 2 Variables";
                        break;
                    case 2:
                        Tokens[NoTokens] = "Patron 3 Decimal";
                        break;
                    case 3:
                        Tokens[NoTokens] = "Patron 4 Entero";
                        break;
                    case 4:
                        Tokens[NoTokens] = "Patron 5 Coma";
                        break;
                    case 5:
                        Tokens[NoTokens] = "Patron 6 Punto y Coma";
                        break;
                    case 6:
                        Tokens[NoTokens] = "Patron 7 Asignacion";
                        break;
                    case 7:
                        Tokens[NoTokens] = "Patron 8 Parentesis Izq";
                        break;
                    case 8:
                        Tokens[NoTokens] = "Patron 9 Parentesis Der";
                        break;
                    case 9:
                        Tokens[NoTokens] = "Patron 10 Oper Rel";
                        break;
                    case 10:
                        Tokens[NoTokens] = "Patron 11 Llave Izquierda";
                        break;
                    case 11:
                        Tokens[NoTokens] = "Patron 12 Llave Derecha";
                        break;
                    case 12:
                        Tokens[NoTokens] = "Patron 13 Incremento";
                        break;
                    case 13:
                        Tokens[NoTokens] = "Patron 14 Oper Aritmetico";
                        break;
                    case 14:
                        Tokens[NoTokens] = "Patron 15 Cadena";
                        break;
                }
                Lexemas[NoTokens++] = Lexema;
            } else {
                i[0]++;
            }
            IniToken = i[0];
        }//While
    }//Cierre Constructor Analizador

}//Cierre de Clase Lexico
