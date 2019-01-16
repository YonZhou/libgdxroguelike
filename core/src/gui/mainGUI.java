package gui;

import Entities.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class mainGUI {
    private Viewport view;
    private OrthographicCamera cam;
    public Stage stage;
    public SpriteBatch sBatch;
    private Label FPSLabel;
    private Label healthLabel;
    private Player player;



    public mainGUI(SpriteBatch sBatch, Player p){
        this.player = p;
        this.sBatch = sBatch;
        this.cam = new OrthographicCamera();
        this.view = new FitViewport(1280, 720, cam);
        this.stage = new Stage(view, sBatch);

        Table table = new Table();
        table.bottom();
        table.setFillParent(true);

        FPSLabel = new Label(Float.toString(Gdx.graphics.getFramesPerSecond()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        table.add(FPSLabel).padBottom(10);

        healthLabel = new Label(Float.toString(Gdx.graphics.getFramesPerSecond()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        table.add(healthLabel).padBottom(20);

        stage.addActor(table);

    }

    public void render(){
        FPSLabel.setText(Float.toString(Gdx.graphics.getFramesPerSecond()));
        healthLabel.setText(Integer.toString(player.getHealth()));
        stage.draw();
    }
}
