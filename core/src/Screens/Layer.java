package Screens;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.List;

import java.util.ArrayList;

public class Layer {
    protected ArrayList<Sprite> sprites;
    protected String name;

    public Layer() {
        this.sprites = new ArrayList<Sprite>();
    }

    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }

    public void render(SpriteBatch b) {
        for(Sprite s : sprites) {
            s.draw(b);
        }
    }
}
