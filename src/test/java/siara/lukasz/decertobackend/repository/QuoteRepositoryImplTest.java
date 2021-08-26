package siara.lukasz.decertobackend.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.springframework.boot.test.context.SpringBootTest;
import siara.lukasz.decertobackend.model.Author;
import siara.lukasz.decertobackend.model.Quote;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
public class QuoteRepositoryImplTest {

    @Test
    @DisplayName("Check if ids of quotes are thread safety.")
    public void checkIsQuoteIdThreadSafety(){
        List<Quote> quotes = new ArrayList<>();
        IntStream.rangeClosed(1, 100).parallel().forEach(i -> {
            Author author = new Author();
            author.setFirstName("FirstName");
            author.setLastName("LastName");
            Quote quote = new Quote();
            quote.setAuthor(author);
            quote.setValue("Lorem ipsum...");
            quotes.add(quote);
        });

        List<Quote> result = quotes.stream().sorted(Comparator.comparingLong(Quote::getId)).collect(Collectors.toList());

        long previewId = 0;
        for (Quote q: result) {
            if(q.getId() == previewId){
                throw new AssertionFailedError("List isn't iterated properly. This is propably thread safe issue.");
            }
            previewId = q.getId();
        }
    }

    @Test
    @DisplayName("Check if quotes data map is thread safety.")
    public void checkIsQuotesMapThreadSafety(){
        ConcurrentHashMap<Long, Quote> quotes = (new siara.lukasz.decertobackend.repository.impl.QuoteRepositoryImpl()).getData();
        IntStream.rangeClosed(1, 1000).parallel().forEach(i -> quotes.put(Long.valueOf(i), new Quote()));

        Assertions.assertEquals(1000, quotes.size());
    }

}
