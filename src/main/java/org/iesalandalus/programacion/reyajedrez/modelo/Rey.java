package org.iesalandalus.programacion.reyajedrez.modelo;

import javax.naming.OperationNotSupportedException;

public class Rey {
    private Color color;
    private Posicion posicion;
    private boolean enroqueCorrecto = false;
    private int totalMovimientos=0;

    public Rey() {
        Posicion posicionReyBlanco = new Posicion(1, 'e');
        setColor(Color.BLANCO);
        setPosicion(posicionReyBlanco);
    }

    public Rey(Color color) {
        Posicion posicionReyBlanco = new Posicion(1, 'e');
        setColor(color);
        if (color == Color.BLANCO) {
            setPosicion(new Posicion(posicionReyBlanco));
        } else setPosicion(new Posicion(8, 'e'));
    }

    public void mover(Direccion direccion) throws OperationNotSupportedException {
        if (direccion == null) {
            throw new NullPointerException("ERROR: La dirección no puede ser nula.");
        }

        switch (direccion) {
            case SUR:
                try {
                    setPosicion(new Posicion(posicion.getFila() - 1, posicion.getColumna()));
                } catch (IllegalArgumentException p) {
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                }
                break;
            case ESTE:
                try {
                    setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() + 1)));
                } catch (IllegalArgumentException p) {
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                }
                break;
            case NORTE:
                try {
                    setPosicion(new Posicion(posicion.getFila() +1,  posicion.getColumna()));
                } catch (IllegalArgumentException p) {
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                }
                break;
            case OESTE:
                try {
                    setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() - 1)));
                } catch (IllegalArgumentException p) {
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                }
                break;
            case NORESTE:
                try {
                    setPosicion(new Posicion(posicion.getFila() + 1, (char) (posicion.getColumna() + 1)));
                } catch (IllegalArgumentException p) {
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                }
                break;
            case SURESTE:
                try {
                    setPosicion(new Posicion(posicion.getFila() - 1, (char) (posicion.getColumna() + 1)));
                } catch (IllegalArgumentException p) {
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                }
                break;
            case NOROESTE:
                try {
                    setPosicion(new Posicion(posicion.getFila() + 1, (char) (posicion.getColumna() - 1)));
                } catch (IllegalArgumentException p) {
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                }
                break;
            case SUROESTE:
                try {
                    setPosicion(new Posicion(posicion.getFila() - 1, (char) (posicion.getColumna() - 1)));
                } catch (IllegalArgumentException p) {
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                }break;
            case ENROQUE_CORTO:

                if (comprobarEnroque()) {
                    try {

                        setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() + 2)));
                    } catch (IllegalArgumentException p) {
                        throw new OperationNotSupportedException("ERROR: Movimiento no válido (ya ha movido el rey).");
                    }
                }
                break;
            case ENROQUE_LARGO:
                if (comprobarEnroque())
                    try {
                        setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() - 2)));
                    } catch (IllegalArgumentException p) {
                        throw new OperationNotSupportedException("ERROR: Movimiento no valido (ya ha movido el rey).");
                    }

                break;
        }
    }

    private boolean comprobarEnroque() {
        Posicion posicionReyBlanco = new Posicion(1, 'e');
        Posicion posicionReyNegro = new Posicion(8, 'e');
        if ((posicion.equals(posicionReyBlanco) || (posicion.equals(posicionReyNegro))) && (totalMovimientos == 0)) {
            enroqueCorrecto = true;
        }

        return enroqueCorrecto;
    }

    public Color getColor() {
        return color;
    }

    private void setColor(Color color) {
        if (color == null) {
            throw new NullPointerException("ERROR: El color no puede ser nulo.");
        }
        this.color = color;
    }

    public Posicion getPosicion() {
        return new Posicion(posicion);
    }

    private void setPosicion(Posicion posicion) {
        if (posicion == null) {
            throw new NullPointerException("ERROR: La posicion no puede ser nula.");
        }
        this.posicion = new Posicion(posicion);
    }

    @Override
    public String toString() {
        return "color="  + color +
                ", posicion=(" + posicion+")";
    }
}
