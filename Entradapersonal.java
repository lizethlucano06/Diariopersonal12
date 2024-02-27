package Diario;

import java.util.*;


class Entrada {
    private Date fecha;
    private String descripcion;

    public Entrada(Date fecha, String descripcion) {
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

	public int getId() {
		return 0;
	}
}