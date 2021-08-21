package siara.lukasz.decertobackend.repository;

import siara.lukasz.decertobackend.dto.Dto;

import java.util.List;

public interface ModelRepository<T> {

    void add(T object);
    List<? extends Dto> getAll();
    void update(long id, T object);
    void delete(long id);
}
