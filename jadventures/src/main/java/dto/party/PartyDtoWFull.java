package dto.party;

import java.util.List;

import entities.Adventurer;
import entities.Quest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PartyDtoWFull extends PartyDtoBase
{
    
    private Integer id;
    private String name;
    private String authentication_sel;
    private String motto;
    public Adventurer party_leader;
    private List<Adventurer> adventures; 
    private List<Quest> quests;
    
}