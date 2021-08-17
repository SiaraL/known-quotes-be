package siara.lukasz.decertobackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siara.lukasz.decertobackend.model.Quote;
import siara.lukasz.decertobackend.repository.impl.QuoteRepositoryImpl;

import java.util.List;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepositoryImpl quoteRepository;

    private long simulateAutoincrementId = 0;

    public List<Quote> getQuotes(){
        return quoteRepository.getAll();
    }

    public long addQuote(Quote quote){
        simulateAutoincrementId++;
        System.out.println(simulateAutoincrementId);
        quote.setId(simulateAutoincrementId);
        return quoteRepository.add(simulateAutoincrementId, quote);
    }

    public void updateQuote(long id, Quote quote){
        quoteRepository.update(id, quote);
    }

    public void deleteQuote(long id){
        quoteRepository.delete(id);
    }
}
