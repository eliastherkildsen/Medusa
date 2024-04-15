package org.apollo.template.model.Food;

import javafx.util.Duration;
import org.apollo.template.model.Character;

public interface Eatable {
    void eat(Character character);
    void update();

}
