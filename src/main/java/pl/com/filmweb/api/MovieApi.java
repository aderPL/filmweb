package pl.com.filmweb.api;

import pl.com.filmweb.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.com.filmweb.menager.MovieMenager;

import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieApi {


    private MovieMenager movies;

    @Autowired
    public MovieApi(MovieMenager movieMenager) {
        this.movies = movieMenager;
    }

    // Pobieranie wszystkich filmow
    @GetMapping("/all")
    public Iterable<Movie> getAll() {
        return movies.findAll();
    }

    // pobieranie przez id
    @GetMapping
    public Optional<Movie> getById(@RequestParam Long id) {
        return movies.findById(id);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movies.save(movie);
    }

    // modyfikowanie nadpisywanie elementu
    @PutMapping
    public Movie updateMovie(@RequestBody Movie movie) {
        return movies.save(movie);
    }

    @DeleteMapping
    public void deleteMovie(@RequestParam Long id) {
        movies.deleteById(id);
    }


}
