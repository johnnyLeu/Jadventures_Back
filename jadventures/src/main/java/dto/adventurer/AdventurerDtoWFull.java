package dto.adventurer;

import java.time.LocalDate;

import entities.Party;
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
public class AdventurerDtoWFull extends AdventurerDtoBase
{
    
    private Integer id;    
    private String name,surname;  
    private LocalDate dob;
    private String rank;
    private String role;   
    public Party party;
    
}
