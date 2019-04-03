package Weapons;

import Entities.Entity;
import Entities.Living;
import Entities.State;
import Input.Direction;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Sword extends Weapon {
    private static Texture basicSword = new Texture("Weapons/basic_sword.png");
    protected int reach;
    protected Direction direction;
    private double runTime;


    public Sword(int x, int y, Living e) {
        super(x, y, e);
        this.texture = basicSword;
        this.sprite = new Sprite(this.texture);
        this.width = 100;
        this.height = 100;
        this.sprite.setSize(width, height);
    }

    @Override
    public void updateWeapon(double deltaTime) {
        runTime += deltaTime;

        if(runTime / deltaTime > 50) {
            this.equippedE.setAttackingState(State.NOT_ATTACKING);
            return;
        }

        getSprite().setCenter(equippedE.getX(), equippedE.getY());

        switch(direction){
            case UP:
                getSprite().setPosition(equippedE.getX(), equippedE.getY() + equippedE.getHeight());
                break;
            case DOWN:
                getSprite().setPosition(equippedE.getX(), equippedE.getY() );
                //sBatch.draw(getSprite(), playerEntity.getX(), playerEntity.getY() - playerEntity.getHeight(), width, height);
                break;
            case LEFT:
                getSprite().setPosition(equippedE.getX() - equippedE.getWidth()/2, equippedE.getY() + equippedE.getHeight()/2);
                break;
            case RIGHT:
                getSprite().setPosition(equippedE.getX() + equippedE.getWidth()/2, equippedE.getY() + equippedE.getHeight()/2);
                break;
        }
        getSprite().rotate(-4);

    }

    @Override
    public void attack(int x, int y){
        this.runTime = Gdx.graphics.getDeltaTime();
        this.equippedE.setAttackingState(State.SWORD_SWINGING);

        double angle = Math.atan2(y, x);
        getSprite().setOrigin(getSprite().getWidth()/2, 0);

        if(angle >= Math.PI/4 && angle < Math.PI/4 * 3){
            // top quadrant
            this.direction = Direction.UP;
            getSprite().setPosition(equippedE.getX(), equippedE.getY() + equippedE.getHeight());
            getSprite().setRotation(90);
        } else if (angle >= -Math.PI/4 && angle < Math.PI/4) {
            // right quadrant
            this.direction = Direction.RIGHT;
            getSprite().setPosition(equippedE.getX() + equippedE.getWidth()/2, equippedE.getY() + equippedE.getHeight()/2);
            getSprite().setRotation(0);
        } else if (angle < -Math.PI/4 && angle >= -Math.PI/4 * 3) {
            // bottom quadrant
            this.direction = Direction.DOWN;
            getSprite().setPosition(equippedE.getX(), equippedE.getY());
            getSprite().setRotation(-90);
        } else {
            // left quadrant
            this.direction = Direction.LEFT;
            getSprite().setPosition(equippedE.getX(), equippedE.getY() + equippedE.getHeight()/2);
            getSprite().setRotation(180);
        }
    }
}
