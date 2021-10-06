package tonder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tonder.entity.Choice;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Integer> {
}
