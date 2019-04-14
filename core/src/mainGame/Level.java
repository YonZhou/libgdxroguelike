package mainGame;

import Entities.BasicZombie;
import Entities.Enemy;
import Entities.Entity;
import Tiles.Tiles;
import Tiles.gameMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level {
    protected int height;
    protected int width;
    protected Entity[][] map;
    int level = 1;
    protected List<Enemy> enemyList;
    protected gameMap currentMap;

    public Level() {
        this.enemyList = new ArrayList<Enemy>();
    }

    public gameMap getMap() {
        return this.currentMap;
    }
    public void generateEnemies() {
        if(this.currentMap == null) {
            throw new RuntimeException("game map not initialized");
        }

        for(int i = 0; i < this.level * 10; i++) {
            Random rand = new Random();
            int randX = rand.nextInt((this.currentMap.getWidth() - 0) + 1);
            int randY = rand.nextInt((this.currentMap.getHeight() - 0) + 1);
            BasicZombie zombie = new BasicZombie(randX*Tiles.TILE_SIZE, randY*Tiles.TILE_SIZE);
            this.enemyList.add(zombie);
        }
        for(Enemy e : enemyList){
            System.out.println(e.getX());
            System.out.println(e.getY());
            System.out.println("/////");

        }
    }

    public List<Enemy> getEnemies() {
        return this.enemyList;
    }
}
