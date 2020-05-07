package com.chinita.company.gestionprocedimientos.api.shared.model;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Generated
@Getter
@NoArgsConstructor
@AllArgsConstructor
public final class ResponsePagination<T> implements Serializable {

    private List<T> result;

    private long total;

    private Integer page;

    private Integer returnedRecords;


    public static <E> ResponsePagination<E> fromObject(List<E> result, long total, Integer page,
                                                       Integer returnedRecords) {
        return new ResponsePagination<>(result, total, page, returnedRecords);
    }
}
