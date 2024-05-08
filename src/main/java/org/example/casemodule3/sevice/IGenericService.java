package org.example.casemodule3.sevice;

import java.util.List;

public interface IGenericService <T> {
    List<T> findAll();
    T findByID(int id);
    void create(T o);
    void updateByID(int id, T o);
    void deleteByID(int id);
}
