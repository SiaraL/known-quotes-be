package siara.lukasz.decertobackend.repository.impl;

import siara.lukasz.decertobackend.model.Entity;
import siara.lukasz.decertobackend.repository.ModelRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

abstract class ModelRepositoryImpl<U extends Entity> implements ModelRepository<U> {

    public Map<Long, U> data;

    public ModelRepositoryImpl(){
        data = new HashMap<>();
    }

    public Map<Long, U> getData() {
        return data;
    }

    public void setData(Map<Long, U> data) {
        this.data = data;
    }

    @Override
    public long add(long simulateAutoincrementId, U object) {
        data.put(simulateAutoincrementId, object);
        return simulateAutoincrementId;
    }

    @Override
    public List<U> getAll() {
        return data.values().stream().collect(Collectors.toList());
    }

    @Override
    public void update(long id, U object) {
        if (data.get(id) == null) return;
        data.put(id, object);
    }

    @Override
    public void delete(long id) {
        data.remove(id);
    }

}
