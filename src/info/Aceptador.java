package info;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Aceptador {
    public static void main(String[] args) throws IOException {
        /*BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("Ingrese: ");
        String archT = lectura.readLine();
	AFD grafo = new AFD();
	grafo.readAdd(archT);
        System.out.print("Cuerda: ");
        String cuerda = lectura.readLine();
        
        if (grafo.pasoOne(cuerda)) {
            if (grafo.pasoTwo(cuerda))
                System.out.println("CUERDA ACEPTADA");
            else
                System.out.println("CUERDA no ACEPTADA");
        }
        
        System.out.print("Ingrese: ");
        String newArch = lectura.readLine();
        grafo.readArch(newArch);*/
        
        Menu consola = new Menu();
        consola.setVisible(true);
    }    
}