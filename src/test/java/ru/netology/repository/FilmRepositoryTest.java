package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;
import ru.netology.manager.FilmManager;

import static org.junit.jupiter.api.Assertions.*;

class FilmRepositoryTest {
    FilmRepository repository = new FilmRepository();
    FilmItem first = new FilmItem(1, "Бладшот", "боевик");
    FilmItem second = new FilmItem(2, "Вперёд", "мультфильм");
    FilmItem third = new FilmItem(3, "Отель Белград", "комедия");
    FilmItem fourth = new FilmItem(4, "Джентельмены", "боевик");
    FilmItem fifth = new FilmItem(5, "Человек-невидимка", "ужасы");

    @Test
    void shouldFindIfExists() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        int idToFind = 2;
        FilmItem findFilm= repository.findById(idToFind);
        assertEquals(second, findFilm);

    }

    @Test
    void shouldReturnNullIfNotExists() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        int idToFind = 5;
        FilmItem findFilm = repository.findById(idToFind);
        assertEquals(null, findFilm);

    }

    @Test
    void shouldRemoveIfExists() {
        int idToRemove = 1;
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.removeById(idToRemove);
        FilmItem[] actual = repository.findAll();
        FilmItem[] expected = new FilmItem[]{second, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.removeById(idToRemove);
        FilmItem findFilm = repository.findById(idToRemove);
        assertEquals(null, findFilm);
    }

    @Test
    void shouldRemoveAll() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.removeAll();
        FilmItem[] expected = new FilmItem[]{};
        FilmItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}