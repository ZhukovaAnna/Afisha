package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.FilmItem;
import ru.netology.manager.FilmManager;
import ru.netology.repository.FilmRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FilmManagerNullArrayTest {
    @Mock
    FilmRepository repository;
    @InjectMocks
    FilmManager manager = new FilmManager(repository);
    FilmItem first = new FilmItem(1, "Бладшот", "боевик");
    FilmItem second = new FilmItem(2, "Вперёд", "мультфильм");
    FilmItem third = new FilmItem(3, "Отель Белград", "комедия");
    FilmItem fourth = new FilmItem(4, "Джентельмены", "боевик");
    FilmItem fifth = new FilmItem(5, "Человек-невидимка", "ужасы");
    FilmItem sixth = new FilmItem(6, "Тролли", "мультфильм");
    FilmItem seventh = new FilmItem(7, "Номер 1", "комедия");

    void setUp() {
        manager = new FilmManager(repository, 0);
    }

    @Test
    void shouldNotDisplayFilmsIfNoFilms() {
        doReturn(new FilmItem[]{}).when(repository).findAll();
        FilmItem[] expected = new FilmItem[]{};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void shouldNotDisplayFilmsIfFilms() {
        doReturn(new FilmItem[]{}).when(repository).findAll();
        manager.add(first);
        manager.add(second);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(third);
        manager.add(seventh);
        FilmItem[] expected = new FilmItem[]{};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }
}