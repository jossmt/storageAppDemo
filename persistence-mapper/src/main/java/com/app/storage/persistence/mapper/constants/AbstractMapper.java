package com.app.storage.persistence.mapper.constants;

/**
 * Abstract mapper interface
 */
public interface AbstractMapper<T,R> {

    /** Maps from Object A to Object B */
    T mapTo(R object);

    /** Maps from Object B to Object A */
    R mapFrom(T object);
}
