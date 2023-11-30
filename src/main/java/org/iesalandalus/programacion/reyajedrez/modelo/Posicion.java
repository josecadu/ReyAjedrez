package org.iesalandalus.programacion.reyajedrez.modelo;

import java.util.Objects;

public class Posicion {
    private int fila;
    private char columna;

    public char getColumna() {
        return columna;
    }

    public Posicion(int fila, char columna) {
        setFila(fila);
        setColumna(columna);
    }

    public Posicion(Posicion p) {
        if(p == null) {
            throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
        }
        setFila(p.getFila());
        setColumna(p.getColumna());
    }

    private void setColumna(char columna) {
        if (columna != 'a' && columna != 'b' && columna != 'c' && columna != 'd' && columna != 'e' && columna != 'f' && columna != 'g' && columna != 'h') {
            throw new IllegalArgumentException("ERROR: Columna no válida.");
        }
        this.columna = columna;

    }

    public int getFila() {
        return fila;
    }

    private void setFila(int fila) {
        if (fila < 1 || fila > 8) {
            throw new IllegalArgumentException("ERROR: Fila no válida.");
        }
        this.fila = fila;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Posicion posicion)) return false;
        return getFila() == posicion.getFila() && getColumna() == posicion.getColumna();
    }


    public int hashCode() {
        return Objects.hash(getFila(), getColumna());
    }

    @Override
    public String toString() {
        return
                "fila=" + fila +
                        ", columna=" + columna
                ;
    }
}

