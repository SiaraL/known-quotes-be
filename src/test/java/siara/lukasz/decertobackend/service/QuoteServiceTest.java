package siara.lukasz.decertobackend.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import siara.lukasz.decertobackend.dto.QuoteDto;
import siara.lukasz.decertobackend.model.Author;
import siara.lukasz.decertobackend.model.Quote;
import siara.lukasz.decertobackend.repository.impl.QuoteRepositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class QuoteServiceTest {

    @Mock
    QuoteRepositoryImpl quoteRepository;

    @InjectMocks
    QuoteService quoteService;

    private Map<Long, Quote> getData () {
        Author author1 = new Author();
        author1.setId(3);
        author1.setFirstName("Dariusz");
        author1.setLastName("Szpakowski");
        Quote quote1 = new Quote();
        quote1.setId(14);
        quote1.setAuthor(author1);
        quote1.setValue("Znów niecelne trafienie.");
        Quote quote2 = new Quote();
        quote2.setId(82);
        quote2.setAuthor(author1);
        quote2.setValue("Nikt nie stoi, proszę państwa, wszyscy wstali.");
        Map<Long, Quote> data = new HashMap<>();
        data.put(14l, quote1);
        data.put(82l, quote2);

        return data;
    }

    private List<QuoteDto> getResult () {
        List<QuoteDto> result = new ArrayList<>();
        result.add(new QuoteDto(getData().get(14l)));
        result.add(new QuoteDto(getData().get(82l)));

        return result;
    }

    @Nested
    @DisplayName("Does getting quotes works?")
    class Get {

        @Test
        @DisplayName("Does elements count is correct?")
        public void sizeComparison(){
            when(quoteRepository.getAll()).thenReturn(getResult());

            List<QuoteDto> result = quoteService.getQuotes();

            assertThat(result.size()).isEqualTo(2);
        }

        @Test
        @DisplayName("Does author comparison works?")
        public void authorComparison(){
            when(quoteRepository.getAll()).thenReturn(getResult());

            List<QuoteDto> result = quoteService.getQuotes();

            assertThat(result.get(0).getAuthor().getFirstName())
                    .isEqualTo(getData().get(14l).getAuthor().getFirstName());

            assertThat(result.get(0).getAuthor().getLastName())
                    .isEqualTo(getData().get(14l).getAuthor().getLastName());

            assertThat(result.get(1).getAuthor().getFirstName())
                    .isEqualTo(getData().get(82l).getAuthor().getFirstName());

            assertThat(result.get(1).getAuthor().getLastName())
                    .isEqualTo(getData().get(82l).getAuthor().getLastName());
        }

        @Test
        @DisplayName("Does quote value comparison works?")
        public void quoteValueComparison(){
            when(quoteRepository.getAll()).thenReturn(getResult());

            List<QuoteDto> result = quoteService.getQuotes();

            assertThat(result.get(1).getValue())
                    .isEqualTo(getData().get(82l).getValue());

            assertThat(result.get(1).getValue())
                    .isEqualTo(getData().get(82l).getValue());
        }
    }

}
