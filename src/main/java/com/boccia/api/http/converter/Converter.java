package com.boccia.api.http.converter;

public class Converter {

    private Converter() {
        // Prevent instantiation
    }

    public static interface Model<T, M> {
        T toDto(M model);

        M toModel(T dto);
    }
}
