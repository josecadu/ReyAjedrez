package org.iesalandalus.programacion.reyajedrez.modelo;

import java.util.Objects;

public class Posicion {
    private int fila;
    private char columna;

    public char getColumna() {
        return columna;
    }
    public Posicion(int fila, char columna){
        setFila(fila);
        setColumna(columna);
    }
    public Posicion(Posicion p){
        setFila(p.getFila());
        setColumna(p.getColumna());
    }
    private void setColumna(char columna) {
        if (columna != 'a' && columna != 'b' && columna != 'c' && columna != 'd' && columna != 'e' && columna != 'f' && columna != 'g' && columna != 'h') {
            throw new IllegalArgumentException("ERROR: la columna tiene que estar comprendida entre a y h");
        }
            this.columna = columna;

        }

        public int getFila() {
            return fila;
        }

        private void setFila ( int fila){
            if (fila < 1 || fila > 8) {
                throw new IllegalArgumentException("ERROR: la fila no puede ser menor que 1 o mayor que 8.");
            }
            this.fila = fila;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Posicion posicion)) return false;
        return getFila() == posicion.getFila() && getColumna() == posicion.getColumna();
    }

    @Override
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

