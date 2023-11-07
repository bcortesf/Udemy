/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk7.b6_PatternRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author BryanCFz
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk7.b6_PatternRegex".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        /**
         * https://es.wikipedia.org/wiki/Expresi%C3%B3n_regular#El_punto_%22.%22
         * https://www.youtube.com/watch?v=_uNtV-BaU0g&list=PLvimn1Ins-43qPXR3gBcxwe7tydxZtsON&index=22
         * https://www.youtube.com/watch?v=_uNtV-BaU0g&list=PLvimn1Ins-43qPXR3gBcxwe7tydxZtsON&t=316s
         * 
         * https://www.youtube.com/watch?v=7zOuL1kt3Zs&list=PLvimn1Ins-43qPXR3gBcxwe7tydxZtsON&index=23
         */
        System.out.println(     esMatch(".", "XYZ") );      //false  :"." evalua cualquier caracter, de maximo 1.length()
        System.out.println(     esMatch(".", "X"  ) );      //true   :"." evalua cualquier caracter, de maximo 1.length()
        
        System.out.println("\n" + esMatch(".m", "amb"  ) );   //false  :".m" cualquier valor, "m" debe terminar en <m>
        System.out.println(     esMatch(".m", "am"  ) );    //true   :".m" evalua cualquier caracter, de maximo 1.length()
        
        System.out.println("\n" + esMatch("..m", "amb"  ) );  //false  :"..m" debe tener 3 valores, "m" el ultimo caracter debe ser <m>
        System.out.println(     esMatch("..m", "ambm"  ) ); //false  :"..m" debe tener 3 valores, "m" el ultimo caracter debe ser <m>
        System.out.println(     esMatch("..m", "amm"  ) );  //true   :"..m" debe tener 3 valores, "m" el ultimo caracter debe ser <m>
        
        System.out.println("\n" + esMatch("[abc]", "a"  ) );  //true  :"[abc]" en este este rango, el texto MATCHER contenga todas las palabras
        System.out.println(     esMatch("[abc]", "az"  ) ); //false :"[abc]" en este este rango, el texto MATCHER contenga todas las palabras
        
        System.out.println("\n" + esMatch("[^abc]", "w"  ) );  //true  :"[^abc]" en este este rango, el texto MATCHER no contenga ningun caracter
    }

    private static boolean esMatch(String patternStr, String matcherStr) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(matcherStr);
        return matcher.matches();
    }

}
