package ru.netology.manager;

import ru.netology.domain.FilmItem;

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
        System.arraycopy(items, 0, tmp, 0, items.length);
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public FilmItem[] getAll(int topCount) {
        if (topCount <= 0)
            return null;

        if (lengthOfFilms > items.length) {
            lengthOfFilms = items.length;
        }

        if (lengthOfFilms >= topCount)
            lengthOfFilms = topCount;
        FilmItem[] result = new FilmItem[lengthOfFilms];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
            if (i == topCount - 1)
                break;
        }
        return result;
    }
}
