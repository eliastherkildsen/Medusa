package org.apollo.template.model.Food;

import org.apollo.template.model.Character;

public interface Eatable {
    void eat(Character character);
    void add(int x, int y);
    void remove();

}
