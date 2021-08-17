package siara.lukasz.decertobackend.repository;

import java.util.List;

public interface ModelRepository<T> {

    long add(long simulateAutoincrementId, T object);
    List<T> getAll();
    void update(long id, T object);
    void delete(long id);
}
