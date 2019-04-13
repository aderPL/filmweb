package pl.com.filmweb.menager;


import pl.com.filmweb.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.com.filmweb.repository.MovieRepository;

import java.util.Optional;

@Service
public class MovieMenager {

    private MovieRepository movieRepository;

    @Autowired
    public MovieMenager(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    public Iterable<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    // zapisujemy do bazy
    // EventListener wywoła tą metodę gdy app się uruchomi
    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {

        save(new Movie(1L, "Titanic", 1995));
        save(new Movie(2L, "Pulp Fiction", 1990));
    }
}
