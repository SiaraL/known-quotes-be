package siara.lukasz.decertobackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siara.lukasz.decertobackend.dto.QuoteDto;
import siara.lukasz.decertobackend.model.Quote;
import siara.lukasz.decertobackend.repository.impl.QuoteRepositoryImpl;

import java.util.List;

@Service
public class QuoteService {

    @Autowired
    public QuoteService(QuoteRepositoryImpl quoteRepository){
        this.quoteRepository = quoteRepository;
    }

    QuoteRepositoryImpl quoteRepository;

    public List<QuoteDto> getQuotes(){
        return quoteRepository.getAll();
    }

    public void addQuote(Quote quote){
        quoteRepository.add(quote);
    }

    public void updateQuote(long id, Quote quote){
        quoteRepository.update(id, quote);
    }

    public void deleteQuote(long id){
        quoteRepository.delete(id);
    }
}
