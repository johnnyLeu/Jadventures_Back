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

import converter.AdventurerConverter;
import dto.adventurer.AdventurerDtoR;
import dto.adventurer.AdventurerDtoWFull;
import entities.Adventurer;
import repository.AdventurerRepository;



@RestController
public class AdventurerController 
{
    @Autowired
    AdventurerRepository repo;
    @Autowired
    AdventurerConverter conv;

    @GetMapping("/adventurer")
    public List<AdventurerDtoWFull> getAdventurer() {
        return repo.findAll()
               .stream()
               .map(e -> conv.AdventurerToDtoWFull(e))
               .toList();
    }

    @GetMapping("/adventurer/{id}")
    public AdventurerDtoWFull getMethodName(@PathVariable Integer id) {
        return conv.AdventurerToDtoWFull(repo.findById(id).get());
    }

    @PostMapping("/adventurer") 
    public Adventurer insertAdventurer(@RequestBody AdventurerDtoR dto) {        
        return repo.save(conv.dtoRtoAdventurer(dto));
    }

    @PutMapping("/adventurer/{id}")
    public AdventurerDtoWFull updateAdventurer(@RequestBody AdventurerDtoR dto,@PathVariable Integer id) {
        Adventurer a = conv.dtoRtoAdventurer(dto);
        a.setId(id);
        return conv.AdventurerToDtoWFull(repo.save(a));
    }

    @DeleteMapping("/adventurer/{id}")
    public void  deleteAdventurer(@PathVariable Integer id) {
         repo.deleteById(id);
    }
    
}
