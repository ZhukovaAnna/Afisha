package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmManagerNullArrayTest {
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
    public void setUp() {
        manager = new FilmManager(0);
    }

    @Test
    void shouldNotDisplayFilmsIfNoFilms() {
        FilmItem[] expected = new FilmItem[]{};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotDisplayFilmsIfFilms() {
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
    }
}