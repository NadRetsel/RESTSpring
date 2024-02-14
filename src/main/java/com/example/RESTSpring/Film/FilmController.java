package com.example.RESTSpring.Film;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/films")
public class FilmController {

    private FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("")
    public Iterable<Film> GetAllFilms()
    {
        return this.filmService.GetAllFilms();
    }

    @GetMapping("/{id}")
    public Film GetFilm(@PathVariable("id") Integer filmId)
    {
        return  this.filmService.GetFilm(filmId);
		/*
		return actor_repo
				.findById(actor_id)
				.orElseThrow(() -> new ResourceAccessException("Actor not found"));
		 */
    }

    @PostMapping("")
    public Film AddFilm(@RequestBody Film newFilm)
    {
        return this.filmService.AddFilm(newFilm);
    }

    @DeleteMapping("/{id}")
    public Film DeleteFilm(@PathVariable("id") Integer filmId)
    {
        return this.filmService.DeleteFilm(filmId);

    }

    @PutMapping("/{id}")
    public Film UpdateFilm(@PathVariable("id") Integer filmId, @RequestBody FilmDTO filmDto)
    {
        return this.filmService.UpdateFilm(filmId, filmDto);
    }


    /*
    @PutMapping("/addActor")
    public Film AddActorToFilm(@RequestBody Map<String,Integer> film_actor_request)
    {
        Integer id = film_actor_request.get("film_id");
        return this.film_service.AddActorToFilm(film_actor_request);
    }

        // ===== FILMS + ACTORS
    @GetMapping("/allFilmActors")
    public Iterable<Set<Actor>> AllFilmActors()
    {
        return this.film_service.AllFilmActors();
    }

     */










}
