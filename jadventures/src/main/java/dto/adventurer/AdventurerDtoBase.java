package dto.adventurer;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class AdventurerDtoBase 
{
    
    private String name,surname;
    private LocalDate dob;
    private String role;
        
}
