package siara.lukasz.decertobackend.repository.impl;

import org.springframework.stereotype.Repository;
import siara.lukasz.decertobackend.dto.QuoteDto;
import siara.lukasz.decertobackend.model.Quote;
import siara.lukasz.decertobackend.repository.ModelRepository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class QuoteRepositoryImpl implements ModelRepository<Quote> {

    public ConcurrentHashMap<Long, Quote> data;

    public QuoteRepositoryImpl(){
        data = new ConcurrentHashMap<>();
    }

    public ConcurrentHashMap<Long, Quote> getData() {
        return data;
    }

    public void setData(ConcurrentHashMap<Long, Quote> data) {
        this.data = data;
    }

    @Override
    public void add(Quote object) {
        data.put(object.getId(), object);
    }

    @Override
    public List<QuoteDto> getAll() {
        return data.values().stream().map(q -> new QuoteDto(q)).collect(Collectors.toList());
    }

    @Override
    public void update(long id, Quote object) {
        if (data.get(id) == null) return;
        data.put(id, object);
    }

    @Override
    public void delete(long id) {
        data.remove(id);
    }
}
