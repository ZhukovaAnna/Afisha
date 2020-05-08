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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FilmManagerTest {
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
    FilmItem eighth = new FilmItem(8, "Маленькие женщины", "драма");
    FilmItem ninth = new FilmItem(9, "Последняя пуля", "боевик");
    FilmItem tenth = new FilmItem(10, "Дело Коллини", "триллер");
    FilmItem eleventh = new FilmItem(11, "Алладин", "приключения");

    @BeforeEach
    void setUp() {
        manager = new FilmManager(repository, 10);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
    }

    @Test
    public void shouldAdd() {
        doReturn(new FilmItem[]{first}).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{first};
        manager.add(first);
        assertArrayEquals(expected, manager.getAll());

        verify(repository).findAll();
    }

    @Test
    public void shouldAddFilm() {
        doReturn(new FilmItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth}).when(repository).findAll();

        FilmItem filmToAdd = tenth;
        manager.add(tenth);
        assertEquals(tenth, manager.getAll()[0]);

        verify(repository, times(1)).findAll();
    }

    @Test
    public void shouldDisplayLastTenFilm() {
        doReturn(new FilmItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth,tenth}).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{tenth,ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository,times(1)).findAll();
    }

    @Test
    public void shouldDisplayTenFilmIfMoreFilm() {
        doReturn(new FilmItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh}).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository,times(1)).findAll();
    }

    @Test
    public void shouldReturnEmptyArray() {
        doReturn(new FilmItem[]{}).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}