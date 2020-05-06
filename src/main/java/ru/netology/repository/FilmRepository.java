package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.FilmItem;

@NoArgsConstructor
@AllArgsConstructor
public class FilmRepository {
    private FilmItem[] films = new FilmItem[0];

    public FilmItem[] findAll() {
        return films;
    }

    public void save(FilmItem film) {
        FilmItem[] tmp = new FilmItem[films.length +1];
        System.arraycopy(films, 0, tmp, 0, films.length);
        tmp[tmp.length -1] = film;
        films = tmp;
    }

    public FilmItem findById(int id) {
        for (FilmItem film : films) {
            if (film.getId() == id) {
                return film;
            }
        }
        return null;
    }

    public void removeById(int id) {

        boolean canBeRemoved = false;
        for (FilmItem film : films) {
            if (film.getId() == id) {
                canBeRemoved= true;
                break;
            }
        }
        if(!canBeRemoved)
            return;

        int length = films.length - 1;
        FilmItem[] tmp = new FilmItem[length];
        int index = 0;
        for (FilmItem film : films) {
            if (film.getId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        films = tmp;
    }

    public void removeAll() {
        films = new FilmItem[0];
    }
}
