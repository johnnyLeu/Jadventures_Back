package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Party;

public interface PartyRepository extends JpaRepository<Party,Integer>
{

}
