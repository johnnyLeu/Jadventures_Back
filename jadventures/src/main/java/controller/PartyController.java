package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import converter.PartyConverter;
import dto.party.PartyDtoR;
import dto.party.PartyDtoWFull;
import entities.Party;
import repository.PartyRepository;


@RestController
public class PartyController 
{

    @Autowired
    PartyRepository repo;
    @Autowired
    PartyConverter conv;

    @GetMapping("/party")
    public List<PartyDtoWFull> getParty() {
        return repo.findAll()
               .stream()
               .map(e -> conv.partyToDtoWFull(e))
               .toList();
    }

    @GetMapping("/party/{id}")
    public PartyDtoWFull getMethodName(@PathVariable Integer id) {
        return conv.partyToDtoWFull(repo.findById(id).get());
    }

    @PostMapping("/party") 
    public Party insertParty(@RequestBody PartyDtoR dto) {        
        return repo.save(conv.dtoRtoParty(dto));
    }

    @PutMapping("/party/{id}")
    public PartyDtoWFull updateParty(@RequestBody PartyDtoR dto,@PathVariable Integer id) {
        Party a = conv.dtoRtoParty(dto);
        a.setId(id);
        return conv.partyToDtoWFull(repo.save(a));
    }

    @DeleteMapping("/party/{id}")
    public void  deleteParty(@PathVariable Integer id) {
         repo.deleteById(id);
    }
    
}
