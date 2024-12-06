package pe.edu.i202224216.service.Impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.i202224216.dto.FilmDTO;
import pe.edu.i202224216.dto.FilmDetailDTO;
import pe.edu.i202224216.dto.FilmTosaveDTO;
import pe.edu.i202224216.model.Film;
import pe.edu.i202224216.model.Language;
import pe.edu.i202224216.repository.FilmRepository;
import pe.edu.i202224216.repository.LanguageRepository;
import pe.edu.i202224216.service.CrudFilmService;

@Service
public class CrudFilmServiceImpl implements CrudFilmService{
	@Autowired
	private FilmRepository _FilmRepository;
	@Autowired
	private LanguageRepository _LanguageRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<FilmDTO> findAll() {
	    return _FilmRepository.findAll()
	            .stream()
	            .map(film -> 
	                new FilmDTO(
	                    film.getFilmId(),
	                    film.getTitle(),
	                    film.getDescription(),
	                    film.getReleaseYear(),
	                    film.getRating()
	                )
	            )
	            .collect(Collectors.toList()); // Convierte el Stream a una List
	}
	@Transactional(readOnly = true)
	@Override
	public FilmDetailDTO getFilmDetail(Integer id) {
		return _FilmRepository.findById(id).map(film ->
			new FilmDetailDTO(id,
					film.getTitle(),
					film.getDescription(),
					film.getReleaseYear(),
					film.getLanguage().getName(),
					film.getRating(),
					film.getLastUpdate())
				).orElse(null);
	}
	@Transactional(readOnly = true)
	@Override
	public FilmTosaveDTO getFilmToSave(Integer id) {
		return _FilmRepository.findById(id).map(film ->
		new FilmTosaveDTO(film.getFilmId(),
				film.getTitle(),
				film.getDescription(),
				film.getReleaseYear(),
				film.getRentalDuration(),
				film.getRentalRate(),
				film.getLength(),
				film.getReplacementCost(),
				film.getRating(),
				film.getLanguage().getLanguageId())
				).orElse(new FilmTosaveDTO(null, "", "", 0, 0, 0.0, 0, 0.0, "",null));
	}
	@Transactional
	@Override
	public Film update(FilmTosaveDTO entity) {		
		return _FilmRepository.findById(entity.filmId()).map( (film) -> {							
			Film filmToSave = film;
			Language lang = _LanguageRepository.findById(entity.languageId()).orElseThrow();
			filmToSave.setTitle(entity.title());
			filmToSave.setDescription(entity.description());
			filmToSave.setReleaseYear(entity.realese());
			filmToSave.setRentalDuration(entity.rentalDuration());
			filmToSave.setRentalRate(entity.rentalRate());
			filmToSave.setLength(entity.length());
			filmToSave.setReplacementCost(entity.replacementCost());
			filmToSave.setRating(entity.rating());
			filmToSave.setLastUpdate(LocalDateTime.now());
			filmToSave.setLanguage(lang);
			return _FilmRepository.save(filmToSave);
		}).orElse(null);
	}
	@Transactional
	@Override
	public Film create(FilmTosaveDTO entity) {								
			Film filmToSave = new Film();
			Language lang = _LanguageRepository.findById(entity.languageId()).orElseThrow();
			filmToSave.setTitle(entity.title());
			filmToSave.setDescription(entity.description());
			filmToSave.setReleaseYear(entity.realese());
			filmToSave.setRentalDuration(entity.rentalDuration());
			filmToSave.setRentalRate(entity.rentalRate());
			filmToSave.setLength(entity.length());
			filmToSave.setReplacementCost(entity.replacementCost());
			filmToSave.setRating(entity.rating());
			filmToSave.setLastUpdate(LocalDateTime.now());
			filmToSave.setLanguage(lang);
			return _FilmRepository.save(filmToSave);
	}
	
	@Transactional
	@Override
	public boolean delete(Integer id) {
		if(_FilmRepository.existsById(id)) {
			_FilmRepository.deleteById(id);
			return true;
		}
		return false;
	}
	@Transactional(readOnly = true)
	@Override
	public List<Language> getAllLanguages() {
		return (List<Language>)_LanguageRepository.findAll();
	}



}
