package com.tecsup.petclinic.exceptions;

/**
 * Excepción personalizada lanzada cuando no se encuentra un dueño (Owner)
 * en operaciones de consulta o eliminación.
 */
public class OwnerNotFoundException extends RuntimeException {

    public OwnerNotFoundException() {
        super("No se encontraron dueños con los criterios especificados");
    }

    public OwnerNotFoundException(String message) {
        super(message);
    }

    public OwnerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}