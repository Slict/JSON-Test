package textfield.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MyGdxGame extends ApplicationAdapter {

    SpriteBatch batch;
    Texture img;
    TextFieldStyle textstyle;
    Skin textboxskin;
    TextField text;
    BitmapFont font;
    Stage stage;
    Table table;
    Texture texCur;
    TextureAtlas atlas;
    TextFieldListener tfl;
    OrthographicCamera camera;

    @Override
    public void create() {
        batch = new SpriteBatch();
        stage = new Stage();
        font = new BitmapFont();
        textboxskin = new Skin();
        textstyle = new TextFieldStyle();
        table = new Table();
        atlas = new TextureAtlas(Gdx.files.internal("Buttons.pack"));
        texCur = new Texture(Gdx.files.internal("cursor.png"));
        
        textboxskin.addRegions(atlas);


        textstyle.background = textboxskin.getDrawable("ButtonUp");
        textstyle.font = font;
        textstyle.cursor = new TextureRegionDrawable(new TextureRegion(texCur));
        
        textstyle.fontColor = Color.BLACK;

        text = new TextField("",textstyle);
        text.setWidth(200);
        text.setHeight(60);
        text.setX(200);
        text.setY(200);
        text.setTextFieldListener(new TextFieldListener() {
            @Override
            public void keyTyped(TextField textField, char key) {
            }
        });
//        table.add(text).expandX().padBottom(20);
//        table.row();
//        table.setX(200);
//        table.setY(200);

        stage.addActor(text);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        if (Gdx.input.isKeyJustPressed(Keys.ENTER)){
        String sText = text.getText();
        System.out.println(sText);
        text.remove();
        }
        
    }
}
