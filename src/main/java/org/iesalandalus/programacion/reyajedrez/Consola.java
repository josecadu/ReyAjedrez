package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;
import org.iesalandalus.programacion.reyajedrez.modelo.Direccion;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
    private Consola() {
    }

    public static void mostrarMenu() {
        System.out.println("--------MENU DE OPCIONES--------");
        System.out.println("--------------------------------");
        System.out.println("1 ----Crear rey  por defecto----");
        System.out.println("2 -Crear un rey eligiendo color-");
        System.out.println("3 ------------Mover-------------");
        System.out.println("4 ------------Salir-------------");
        System.out.println("--------------------------------");
    }

    public static int elegirOpcionMenu() {
        int seleccion = 0;
        while (seleccion < 1 || seleccion > 4) {
            System.out.println("ELIGE LA OPCION QUE DESEA REALIZAR");
            seleccion = Entrada.entero();

        }
        return seleccion;
    }

    public static Color elegirColor() {
        Color color = null;
        int seleccion = 0;
        do {
            System.out.println("Elige el color del rey blanco/negro.");
            System.out.println("------------------------------------");
            System.out.println("1 ---------Blanco-------------------");
            System.out.println("2----------Negro--------------------");
            System.out.println("------------------------------------");
            seleccion = Entrada.entero();

        } while (seleccion != 1 && seleccion != 2);
        switch (seleccion) {
            case 1:
                color = Color.BLANCO;
                System.out.println("Ha elegido el rey blanco.");
                break;
            case 2:
                color = Color.NEGRO;
                System.out.println("Ha elegido el rey negro.");
                break;
        }
        return color;
    }

    public static void mostrarMenuDirecciones() {
        System.out.println("-----MENU DE DIRECCIONES---");
        System.out.println("--------------------------");
        System.out.println("0 ---------NORTE----------");
        System.out.println("1 --------NOROESTE--------");
        System.out.println("2 ---------OESTE----------");
        System.out.println("3 --------SUROESTE--------");
        System.out.println("4 ----------SUR-----------");
        System.out.println("5 --------SURESTE---------");
        System.out.println("6 ---------ESTE-----------");
        System.out.println("7 --------NORESTE---------");
        System.out.println("8 -----ENROQUE CORTO------");
        System.out.println("9 -----ENROQUE LARGO------");
        System.out.println("--------------------------");


    }

    public static Direccion elegirDireccion() {
        Direccion direccion = null;
        int seleccion = 0;
        do {
            System.out.println("Introduzca un numero entre 0 y 9");
            seleccion = Entrada.entero();
        } while (seleccion < 0 || seleccion > 9);
        switch (seleccion) {
            case 0:
                direccion=Direccion.NORTE;
                System.out.println("Ha elegido mover al norte.");
                break;
            case 1:
                direccion=Direccion.NOROESTE;
                System.out.println("Ha elegido mover al noroeste.");
                break;
            case 2:
                direccion=Direccion.OESTE;
                System.out.println("Ha elegido mover al oeste.");
                break;
            case 3:
                direccion=Direccion.SUROESTE;
                System.out.println("Ha elegido mover al suroeste.");
                break;
            case 4:
                direccion=Direccion.SUR;
                System.out.println("Ha elegido mover al sur.");
                break;
            case 5:
                direccion=Direccion.SURESTE;
                System.out.println("Ha elegido mover al sureste.");
                break;
            case 6:
                direccion=Direccion.ESTE;
                System.out.println("Ha elegido mover al este.");
                break;
            case 7:
                direccion=Direccion.NORESTE;
                System.out.println("Ha elegido mover al noreste.");
                break;
            case 8:
                direccion=Direccion.ENROQUE_CORTO;
                System.out.println("Ha elegido hacer enroque corto.");
                break;
            case 9:
                direccion=Direccion.ENROQUE_LARGO;
                System.out.println("Ha elegido hacer enroque largo.");
                break;
        }
        return direccion;
    }

    public static void despedirse() {
        System.out.println("Gracias por jugar. Saludos");
    }

}
