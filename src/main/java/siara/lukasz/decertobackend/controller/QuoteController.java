package siara.lukasz.decertobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import siara.lukasz.decertobackend.model.Quote;
import siara.lukasz.decertobackend.service.QuoteService;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class QuoteController {

    @Autowired
    QuoteService quoteService;

    @GetMapping("/quote")
    public List<Quote> getQuotes(){
        return quoteService.getQuotes();
    }

    @PostMapping("/quote")
    public void addQuote(@RequestBody Quote quote){
        quoteService.addQuote(quote);
    }

    @PatchMapping("/quote/{quoteId}")
    public void updateQuote(@PathVariable("quoteId") long quoteId, @RequestBody Quote quote){
        quote.setId(quoteId);
        quoteService.updateQuote(quoteId, quote);
    }

    @DeleteMapping("/quote/{quoteId}")
    public void deleteQuote(@PathVariable("quoteId") long quoteId){
        quoteService.deleteQuote(quoteId);
    }

}
