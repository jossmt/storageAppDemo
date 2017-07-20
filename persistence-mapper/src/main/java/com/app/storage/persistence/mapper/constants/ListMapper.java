package com.app.storage.persistence.mapper.constants;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract list mapper that uses existing mapper classes but for mapping list elements more efficiently.
 * Takes param - boolean (to=true, from=false)
 */
@Component
public class ListMapper {

    /**
     * Maps lists of objects.
     */
    public <T, R> List<R> mapList(final AbstractMapper mapper, boolean isTo, final List<T> classA) {

        List<R> mappedObjectList = null;

        if (classA != null) {

            mappedObjectList = new ArrayList<R>();

            if (isTo) {
                for (final T classAObject : classA) {
                    mappedObjectList.add((R) mapper.mapTo(classAObject));
                }
            } else {
                for (final T classAObject : classA) {
                    mappedObjectList.add((R) mapper.mapFrom(classAObject));
                }
            }
        }

        return mappedObjectList;
    }
}
