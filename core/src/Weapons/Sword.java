package Weapons;

import Entities.Entity;
import Entities.Living;
import Entities.State;
import Input.Direction;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Sword extends Weapon {
    // angles per second in rotation(base speed, can be changed or improved later)
    protected int timeToUse = 2;
    protected final int SPEED = 180*timeToUse;

    private static Texture basicSword = new Texture("Weapons/basic_sword.png");
    protected int reach;
    protected double range;

    // speed is radians per deltaTime
    protected double speed;
    protected Direction direction;


    // rotation is relative to start of swing (represents swing rotation)
    public Sword(int x, int y, Living e) {
        super(x, y, e);
        this.texture = basicSword;
        this.sprite = new Sprite(this.texture);
        this.width = 100;
        this.height = 100;
        this.range = 180;
        this.cooldown = 2;
        this.sprite.setSize(width, height);
    }

    @Override
    public void updateWeapon() {

        // case for when motion should break
        if(rotation > this.range) {
            this.equippedE.setAttackingState(State.NOT_ATTACKING);
            active = false;
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
        getSprite().rotate(-(float)speed);
        rotation += speed;
    }

    @Override
    public void attack(int x, int y){
        rotation = 0;
        runTime = 0;
        active = true;
        this.speed = SPEED*Gdx.graphics.getDeltaTime();
        this.equippedE.setAttackingState(State.SWORD_SWINGING);
        this.ready =false;

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
