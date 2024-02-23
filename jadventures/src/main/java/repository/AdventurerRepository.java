package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Adventurer;

public interface AdventurerRepository extends JpaRepository<Adventurer,Integer>
{

}
