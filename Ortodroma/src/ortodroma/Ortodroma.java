/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortodroma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.Math.acos;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;


/**
 *
 * @author Blizius
 */
public class Ortodroma {

    /**
     * @param args the command line arguments
     * Vytvoření pole pro souřadnice bodů, načtení pomocí funkce, načtení poloměru
     * a jeho jednotek, volání funkce výpočtu vzdálenosti na kouli (ortodroma).
     */
    public static void main(String[] args) {        
        double [][] coord = new double [2][2];
        coordIn(coord);
        
        System.out.println("Napište poloměr, potvrďte a napište jeho jednotky.");        
        double r = readDouble();
        if (r <= 0){
            System.out.println("Poloměr koule nemůže být nula nebo záporný.");
            System.exit(1);
        }
        String units = null;
        try{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        units = reader.readLine();
        }
        catch (IOException ex){
            System.err.print("Chyba při načítání vstupu, zkuste to znovu.");
            System.exit(1);
        }
        
        double dist = orthodrome(coord, r);
        System.out.format("Vzdálenost bodů na kouli je %.3f %s.\n", dist, units );
    }
    /**
     * Funkce pro zapsání souřadnic uživatelem s chybovou podmínkou pro chybné úhly
     * @param coord vstupní definované pole pro zapsání souřadnic
     */
    public static void coordIn(double [][] coord){
        System.out.println("Napište zeměpisnou šířku prvního bodu (desetiné stupně). Záporná pro jižní polokouli.");
        coord[0][0] = toRadians(readDouble());
        System.out.println("Napište zeměpisnou délku prvního bodu (desetiné stupně). Záporná pro západní polokouli.");
        coord [0][1] = toRadians(readDouble());
        System.out.println("Napište zeměpisnou šířku druhého bodu (desetiné stupně). Záporná pro jižní polokouli.");
        coord [1][0] = toRadians(readDouble());
        System.out.println("Napište zeměpisnou délku druhého bodu (desetiné stupně). Záporná pro západní polokouli.");
        coord [1][1] = toRadians(readDouble());
        if (abs(coord[0][0]) > PI/2 || abs(coord[0][1]) > PI || abs(coord[1][0]) > PI/2 || abs(coord[1][1]) > PI){
            System.err.print("Chybné souřadnice. Zem. šířka musí být od -90°do 90° a zem. délka od -180° do 180°.");
            System.exit(1);
        }
    }
    /**
     * Výpočet vzdáleností bodů na kouli pomocí vzorce pro ortodromu
     * @param coord vstupní pole souřadnic dvou bodů
     * @param r poloměr koule
     * @return vzdálenost dvou bodů na kouli (v jednotkách zadaných uživatelem)
     */
    public static double orthodrome(double [][] coord, double r){
        return r * acos(sin(coord[0][0]) * sin(coord[1][0]) + cos(coord[0][0]) * cos(coord[1][0]) * cos(coord[1][1] - coord[0][1]));
    }
    /**
     * Čtení doublu, použití pro načtení souřadnic a poloměru
     * @return desetinné číslo
     */
    public static double readDouble() {
        BufferedReader reader;
        double a = 0;
        try {            
            reader = new BufferedReader(new InputStreamReader(System.in));
            a = Double.parseDouble(reader.readLine());
        }
        catch (IOException ex){
            System.err.print("Chyba při načítání vstupu, zkuste to znovu.");
            System.exit(1);
        }
        catch (NumberFormatException ex){
            System.err.print("Špatný formát vstupu. Zadejte číslo");
            System.exit(1);
        }
        return a;
    }                   
}
