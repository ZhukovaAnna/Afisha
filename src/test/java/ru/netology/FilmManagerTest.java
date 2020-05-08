package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;
import ru.netology.manager.FilmManager;

import static org.junit.jupiter.api.Assertions.*;

class FilmManagerTest {
    FilmManager manager;
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
        manager = new FilmManager();
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
        FilmItem[] expected = new FilmItem[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        FilmItem[] actual = manager.getAll(10);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddFilm() {
        manager.add(tenth);
        assertEquals(tenth, manager.getAll(10)[0]);
    }

    @Test
    public void shouldDisplayLastTenFilm() {
        FilmItem[] actual = manager.getAll(10);
        FilmItem[] expected = new FilmItem[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDisplayTenFilmIfMoreFilm() {
        manager.add(tenth);
        manager.add(eleventh);
        FilmItem[] actual = manager.getAll(10);
        FilmItem[] expected = new FilmItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        assertEquals(expected[1], actual[actual.length - 1]);
    }
    
    @Test
    public void shouldReturnTopNWithMinusTop() {
        manager.add(tenth);
        manager.add(eleventh);
        FilmItem[] actual = manager.getAll(-1);

        assertArrayEquals(null, actual);
    }

    @Test
    public void shouldReturnTop10WithTop100() {
        manager.add(tenth);
        manager.add(eleventh);
        FilmItem[] actual = manager.getAll(100);
        assertEquals(10, actual.length);
    }

    @Test
    public void shouldReturnTop10WithTop5() {
        manager.add(tenth);
        manager.add(eleventh);
        FilmItem[] actual = manager.getAll(5);
        assertEquals(5, actual.length);
    }
}