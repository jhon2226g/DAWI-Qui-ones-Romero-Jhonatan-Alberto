package pe.edu.i202224216.repository;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.i202224216.model.Film;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> {
	
	@Cacheable(value = "film")
	List<Film> findAll();
	
	@CacheEvict(value = "film", allEntries = true)
	Film save(Film film);
	@CacheEvict(value = "film", allEntries = true)
	void deleteById(Integer id);
}
