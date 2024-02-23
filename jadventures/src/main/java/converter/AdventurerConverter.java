package converter;

import org.springframework.stereotype.Service;

import dto.adventurer.AdventurerDtoWFull;
import entities.Adventurer;

@Service
public class AdventurerConverter 
{
    public Adventurer dtoRtoAdventurer (dto.adventurer.AdventurerDtoR dto)
    {
        return Adventurer
                .builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .dob(dto.getDob())
                .role(dto.getRole())
                .build();
    }

    public AdventurerDtoWFull AdventurerToDtoWFull (Adventurer a) {
    
        return AdventurerDtoWFull
                .builder()
                .name(a.getName())
                .surname(a.getSurname())
                .dob(a.getDob())
                .role(a.getRole())
                .rank(a.getRank())
                .party(a.getParty())
                .id(a.getId())
                .build();
            
    }
}
