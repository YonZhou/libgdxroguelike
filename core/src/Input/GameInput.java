package Input;

import Entities.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;

public class GameInput implements InputProcessor {
    private Entity mainEntity ;
    public GameInput(Entity e) {this.mainEntity = e;};

    @Override
    public boolean keyDown(int keycode) {

        switch(keycode){
            case Keys.W : mainEntity.setMovingUp(true);;
            return true;
            case Keys.S : mainEntity.setMovingDown(true);
            return true;
            case Keys.A : mainEntity.setMovingLeft(true);
            return true;
            case Keys.D : mainEntity.setMovingRight(true);
            return true;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch(keycode){
            case Keys.W : mainEntity.setMovingUp(false);;
                return true;
            case Keys.S : mainEntity.setMovingDown(false);
                return true;
            case Keys.A : mainEntity.setMovingLeft(false);
                return true;
            case Keys.D : mainEntity.setMovingRight(false);
                return true;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
