package pe.edu.i202224216.dto;

import java.time.LocalDateTime;

public record FilmDetailDTO(				
		Integer filmId,
		String title,
		String description,
		Integer realese,
		String LanguageName,					
		String rating,
		LocalDateTime lastUpdate
		) {

}
