package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Direccion;
import org.iesalandalus.programacion.reyajedrez.modelo.Rey;

import javax.naming.OperationNotSupportedException;

public class MainApp {
    private static Rey rey;
    public static void main(String[] args) {
        int seleccion = 0;
        boolean fin = false;
        while (!fin){
            Consola.mostrarMenu();
            seleccion=Consola.elegirOpcionMenu();

                try {
                    ejecutarOpcion(seleccion);
                } catch (OperationNotSupportedException e) {
                    System.out.println(e.getMessage());
                }
                if (seleccion==4){
                    fin=true;
                }
                else {
                    try {
                        mostrarRey();
                    }
                    catch (NullPointerException e){
                        System.out.println(e.getMessage());
                    }
                }
            }

        }


        private static void ejecutarOpcion(int opcion) throws OperationNotSupportedException {
        switch (opcion){
            case 1:
                crearReyDefecto();
                break;
            case 2:
                crearReyColor();
                break;
            case 3:
                try{
                    mover();
                }
                catch (NullPointerException | OperationNotSupportedException p){
                    System.out.println(p.getMessage());
                }
                break;
            case 4:
                Consola.despedirse();
                break;
        }
        }
        private static void crearReyDefecto() {
            rey = new Rey();

        }
        private static void crearReyColor(){
           rey = new Rey(Consola.elegirColor());
        }
        private static void mover() throws OperationNotSupportedException {
           if(rey == null){
               throw new NullPointerException("ERROR: El rey debe ser creado primero.");
           }
           else {
               Direccion direccion=null;
               Consola.mostrarMenuDirecciones();
               direccion=Consola.elegirDireccion();
               rey.mover(direccion);
           }
        }
        private static void mostrarRey(){
            if(rey == null){
                throw new NullPointerException("ERROR: El rey debe ser creado primero.");
            }
            else
                System.out.println(rey.toString());
        }



}
