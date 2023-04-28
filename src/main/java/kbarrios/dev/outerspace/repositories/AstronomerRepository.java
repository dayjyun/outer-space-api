package kbarrios.dev.outerspace.repositories;

import kbarrios.dev.outerspace.models.Astronomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AstronomerRepository extends JpaRepository<Astronomer, Long> {
   Astronomer findAstronomerByEmail(String email);

   Astronomer findAstronomerById(Long astronomerId);
}
