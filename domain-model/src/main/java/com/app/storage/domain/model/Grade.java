package com.app.storage.domain.model;

/** Enumeration of Grade (quality) of items. */
public enum Grade {

    A,

    B,

    C,

    D,

    E,

    F,

    UNKNOWN;


    /**
     * Returns grade if valid otherwise Unknown.
     *
     * @param value
     *         Grade
     * @return Grade enum.
     */
    public static Grade getGrade(final String value) {

        Grade convertedGrade = Grade.UNKNOWN;
        for (final Grade grade : Grade.values()) {

            if (grade.toString().equals(value)) {
                convertedGrade = grade;
            }
        }

        return convertedGrade;
    }
}
