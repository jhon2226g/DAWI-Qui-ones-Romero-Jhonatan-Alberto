package pe.edu.i202224216.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.i202224216.model.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Integer>{

}
