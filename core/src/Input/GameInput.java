package Input;

import Entities.Entity;
import Entities.Living;
import Entities.Player;
import Screens.AbstractScreen;
import Screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Input.Buttons;



public class GameInput implements InputProcessor {
    private Living mainEntity ;
    private AbstractScreen screen;

    public GameInput(Living e, AbstractScreen screen) {
        this.mainEntity = e;
        this.screen = screen;
    }

    @Override
    public boolean keyDown(int keycode) {

        switch(keycode){
            case Keys.W : mainEntity.setMovingUp(true);
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
        if (button == Input.Buttons.LEFT){
            ((GameScreen)screen).processLeftClick(screenX, screenY);
            System.out.println("screenx at " + screenX + ", screeny at " + screenY);
            return true;
        }
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
