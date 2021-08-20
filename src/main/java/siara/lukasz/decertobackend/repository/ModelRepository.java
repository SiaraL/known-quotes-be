package siara.lukasz.decertobackend.repository;

import java.util.List;

public interface ModelRepository<T> {

    void add(T object);
    List<T> getAll();
    void update(long id, T object);
    void delete(long id);
}
