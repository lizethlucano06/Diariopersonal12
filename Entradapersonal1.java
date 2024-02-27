package Diario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

class Diario {
    private List<Entrada> entradas;

    public Diario() {
        entradas = new ArrayList<>();
    }

    public void agregarEntrada(Date fecha, String descripcion) {
        entradas.add(new Entrada(fecha, descripcion));
    }

    public Entrada obtenerEntrada(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        fecha = cal.getTime();

        for (Entrada entrada : entradas) {
            Calendar calEntrada = Calendar.getInstance();
            calEntrada.setTime(entrada.getFecha());
            calEntrada.set(Calendar.HOUR_OF_DAY, 0);
            calEntrada.set(Calendar.MINUTE, 0);
            calEntrada.set(Calendar.SECOND, 0);
            calEntrada.set(Calendar.MILLISECOND, 0);
            Date fechaEntrada = calEntrada.getTime();

            if (fechaEntrada.equals(fecha)) {
                return entrada;
            }
        }
        return null;
    }

    public void modificarEntrada(Date fecha, String nuevaDescripcion) {
        Entrada entrada = obtenerEntrada(fecha);
        if (entrada != null) {
            entrada.setDescripcion(nuevaDescripcion);
            System.out.println("Entrada modificada exitosamente.");
        } else {
            System.out.println("No se encontró ninguna entrada para la fecha especificada.");
        }
    }

    public void eliminarEntrada(Date fecha) {
        Entrada entrada = obtenerEntrada(fecha);
        if (entrada != null) {
            entradas.remove(entrada);
            System.out.println("Entrada eliminada exitosamente.");
        } else {
            System.out.println("No se encontró ninguna entrada para la fecha especificada.");
        }
    }

	

    public boolean eliminarEntradaPorId(int id) {
        Iterator<Entrada> it = entradas.iterator();
        while (it.hasNext()) {
            Entrada entrada = it.next();
            if (entrada.getId() == id) {
                it.remove();
                return true;
            }
        }
        return false;
    }
}