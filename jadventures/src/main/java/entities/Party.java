package entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Party 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String authentication_sel;
    private String motto;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "party_id")
    public Adventurer party_leader;

    @JsonIgnore
    @OneToMany(mappedBy = "party",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private List<Adventurer> adventures; 

    @JsonIgnore
    @OneToMany(mappedBy = "quest",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private List<Quest> quests;
    
}
