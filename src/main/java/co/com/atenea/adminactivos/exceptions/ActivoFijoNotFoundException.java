package co.com.atenea.adminactivos.exceptions;

public class ActivoFijoNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final Long id;

    public ActivoFijoNotFoundException(Long id) {
        super("No se encontró el activo con ID: " + id);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
