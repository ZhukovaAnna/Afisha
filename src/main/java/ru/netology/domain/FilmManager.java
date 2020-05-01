package ru.netology.domain;

public class FilmManager {
    private FilmItem[] items = new FilmItem[0];
    private int lengthOfFilms = 10;

    public FilmManager(int lengthOfFilms) {
        this.lengthOfFilms = lengthOfFilms;
    }

    public FilmManager() {

    }

    public void add(FilmItem item) {
        int length = items.length + 1;
        FilmItem[] tmp = new FilmItem[length];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public FilmItem[] getAll() {
        if (lengthOfFilms > items.length) {
            lengthOfFilms = items.length;
        }
        FilmItem[] result = new FilmItem[lengthOfFilms];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
