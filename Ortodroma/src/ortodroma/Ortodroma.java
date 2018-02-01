/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortodroma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author Blizius
 */
public class Ortodroma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double [][] coord = new double [2][2];
        coordIn(coord);
        
        System.out.println("Napište poloměr, potvrďte a napište jednotky.");        
        double r = readDouble();
        String units = null;
        try{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        units = reader.readLine();
        }
        catch (IOException ex){
            System.err.print("Chyba při načítání vstupu, zkuste to znovu.");
            System.exit(1);
        }
        
        double dist = ortodr(coord, r);
        System.out.println("Vzdálenost bodů na kouli je " +dist+ " " +units);
    }
    
    public static void coordIn(double [][] coord){
        System.out.println("Napište zeměpisnou šířku prvního bodu. Záporná pro jižní polokouli.");
        coord[0][0] = readDouble();
        System.out.println("Napište zeměpisnou délku prvního bodu. Záporná pro západní polokouli.");
        coord [0][1] = readDouble();
        System.out.println("Napište zeměpisnou šířku druhého bodu. Záporná pro jižní polokouli.");
        coord [1][0] = readDouble();
        System.out.println("Napište zeměpisnou délku druhého bodu. Záporná pro západní polokouli.");
        coord [1][1] = readDouble();        
    }
    
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
    public static int readUnits() {
        BufferedReader reader;
        String input = null;
        int units = 0;
        while (units == 0){
            try {            
                reader = new BufferedReader(new InputStreamReader(System.in));
                input = reader.readLine();
            }
            catch (IOException ex){
                System.err.print("Chyba při načítání vstupu, zkuste to znovu.");
                System.exit(1);
            }
            if (input.equals("mm")){
                units = 1;
            }
            else if (input.equals("cm")){
                units = 2;
            }
            else if (input.equals("dm")){
                units = 3;
            }
            else if (input.equals("m")){
                units = 4;
            }
            else if (input.equals("km")){
                units = 5;
            }
            else{
                System.out.println("Chybně zadané jednotky, opakujte znovu dle instrukcí výše.");                
            }
        }
        return units;
    } 
            
    
}
