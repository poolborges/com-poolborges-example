package com.poolborges.example.springmvc.domain;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Borges
 */
public class MovieDao {

    @Autowired
    private EntityManager entityManager;

    public void createMovies() {

        entityManager.persist(new Movie("Quentin Tarantino", "Reservoir Dogs", 1992));
        entityManager.persist(new Movie("Joel Coen", "Fargo", 1996));
        entityManager.persist(new Movie("Joel Coen", "The Big Lebowski", 1998));
    }

    public void addMovie(Movie movie) throws Exception {
        entityManager.persist(movie);
    }

    public void deleteMovie(Movie movie) throws Exception {
        entityManager.remove(movie);
    }

    public List<Movie> getMovies() throws Exception {
        TypedQuery<Movie> query = entityManager.createQuery("SELECT m from Movie as m", Movie.class);
        return query.getResultList();
    }
}
