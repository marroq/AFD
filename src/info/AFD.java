package info;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class AFD {
    LinkedList<String> parametros;
    LinkedList<String> alfabeto;
    LinkedList<String> finales;
    String transiciones[][];
    Scanner lector;
    LinkedList<String> commandLine;

    public AFD() {
	parametros = new LinkedList<String>();
	alfabeto = new LinkedList<String>();
	finales = new LinkedList<String>();
        commandLine= new LinkedList<String>();
    }

    void readAdd(String archivo) {
	/*LEO EL ARCHIVO Y LLENO LISTA CON ELEMENTOS DEL AFD*/
        File f = new File(archivo);
	BufferedReader entrada;
	try {
            entrada = new BufferedReader(new FileReader(f));
            String linea;
            while(entrada.ready()){
		linea = entrada.readLine();
		parametros.addLast(linea);
            }
	}catch (IOException e) {
            e.printStackTrace();
	}
        
        /*LLENO LA LISTA DE ALFABETO Y ESTADOS FINALES*/
        for (int i=0; i<2; i++) {
            lector = new Scanner(parametros.get(i));
            switch (i) {
                case 0:
                    lector.useDelimiter(" |\\[|\\]");
                    while (lector.hasNext()) {
                        alfabeto.addLast(lector.next());
                    }
                break;
                case 1:
                    lector.useDelimiter(" |\\[|\\]");
                    while (lector.hasNext()) {
                        finales.addLast(lector.next());
                    }
                break;
            }
        }
        
        /*CREO LA MATRIZ DE TRANSICIONES*/
        transiciones = new String[parametros.size() - 2][alfabeto.size()];
        /*CREO UN ARREGLO CON TODOS LOS ELEMENTOS DE LAS TRANSICIONES*/
        String contenedor[] = new String[transiciones.length*alfabeto.size()];
        
        /*LLENO EL ARREGLO*/
        for (int i=2, j=0; i<transiciones.length+2;i++) {
            lector = new Scanner(parametros.get(i));
            lector.useDelimiter(" ");
            while (lector.hasNext()) {
                contenedor[j] = lector.next();
                j++;
            }
        }
        
        /*LLENO LA MATRIZ*/
        for (int i=0,x=0;i<transiciones.length;i++) {
            for (int j=0;j<alfabeto.size();j++) {
                transiciones[i][j] = contenedor[x];
                x++;
            }
        }
    }

    boolean pasoOne(String cuerda) {
	boolean ans;
	int cont=0;
        /*COMPRUEBO QUE LA CUERDA TENGA LOS CARACTERES DEL ALFABETO*/
	for(int i=0;i<cuerda.length();i++) {
            String elemento=cuerda.substring(i,(i+1));
            for (int j=0;j<alfabeto.size();j++) {
                if (elemento.equals(alfabeto.get(j))) {
                    cont++;
                }
            }
        }
        
        if (cont==cuerda.length()) 
            ans=true;
        else {
            ans=false;
            System.out.println("CUERDA CONTIENE SIMBOLOS INVALIDOS");
        }
            
        /*COMPRUEBO QUE LOS ESTADOS FINALES SEAN VALIDOS*/
        for (int i=0; i<finales.size();i++) {
            if (!(Integer.parseInt(finales.get(i))<transiciones.length)) {
                ans=false;
                System.out.println("ESTADOS FINALES NO VALIDOS");
            }
        }
        
        /*COMPRUEBO QUE EN LA MATRIZ NO HAGA FALTA NINGUN ELEMENTO EN LA TRANSICIÓN*/
        for (int i=0,x=0;i<transiciones.length;i++) {
            for (int j=0;j<alfabeto.size();j++) {
                if (!(transiciones[i][j]!=null)) {
                    ans=false;
                    x++;
                }
            }
            if ((i==transiciones.length-1) && (x>0)) {
                System.out.println("HAY TRANSICIONES INCOMPLETAS");
            }                
        }
        
	return ans;
    }
    
    boolean pasoTwo(String cuerda) {
        boolean ans=false;
        String estado="0";
        
        //VER SI LA CUERDA ES ACEPTADA
        for (int i=0;i<cuerda.length();i++) {
            String elemento=cuerda.substring(i,(i+1));
            //System.out.println("Analizando: "+ elemento);
            for (int j=0; j<alfabeto.size();j++) {
                if ((elemento.equals(alfabeto.get(j)))) {
                    estado = transiciones[Integer.parseInt(estado)][j];
                    //System.out.println("Estado actual: "+estado);
                }
            }
            
            if (i==(cuerda.length()-1)) {
                for (int k=0;k<finales.size();k++) {
                    if (estado.equals(finales.get(k))) {
                        ans = true;
                    } 
                }
            }
        }
        
        return ans;
    }
    
    /*METODO PARA REALIZAR LA PARTE 2 DEL COMMANDLINE*/
    void readArch(String archivo) {
        LinkedList<String> listado = new LinkedList<String>();
        File f = new File(archivo);
	BufferedReader entrada;
	try {
            entrada = new BufferedReader(new FileReader(f));
            String linea;
            while(entrada.ready()){
		linea = entrada.readLine();
		listado.addLast(linea);
            }
	}catch (IOException e) {
            e.printStackTrace();
	}
        
        for (int i=0;i<listado.size();i++) {
            System.out.print(listado.get(i)+" : ");
            if (pasoOne(listado.get(i))) {
                if (pasoTwo(listado.get(i))) {
                    System.out.println("ACEPTADA");
                    commandLine.addLast(listado.get(i)+": ACEPTADA");
                }   
                else {
                    System.out.println("NO ACEPTADA");
                    commandLine.addLast(listado.get(i)+": NO ACEPTADA");
                }
            }
        }
    }
}