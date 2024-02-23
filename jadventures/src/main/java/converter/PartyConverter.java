package converter;

import org.springframework.stereotype.Service;

import dto.party.PartyDtoWFull;
import dto.party.PartyDtoR;
import entities.Party;

@Service
public class PartyConverter 
{
    public Party dtoRtoParty (PartyDtoR dto)
    {
        return Party
                .builder()
                .name(dto.getName())
                .authentication_sel(dto.getAuthentication_sel())
                .build();
    }

    public PartyDtoWFull partyToDtoWFull (Party p) {
    
        return PartyDtoWFull
                .builder()
                .id(p.getId())
                .name(p.getName())
                .authentication_sel(p.getAuthentication_sel())
                .motto(p.getMotto())
                .party_leader(p.getParty_leader())
                .adventures(p.getAdventures())
                .quests(p.getQuests())
                .build();
            
    }
}
