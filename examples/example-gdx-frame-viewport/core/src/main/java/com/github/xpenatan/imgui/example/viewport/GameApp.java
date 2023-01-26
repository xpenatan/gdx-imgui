package com.github.xpenatan.imgui.example.viewport;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;

public class GameApp implements ApplicationListener {

    private static Vector3 TMP_VEC01 = new Vector3();

    private Texture texture;

    private ShapeRenderer shapeRenderer;
    private OrthographicCamera camera;

    private SpriteBatch batch;

    private float x1 = 100;
    private float y1 = 100;
    private float x2 = 200;
    private float y2 = 100;
    private float speed = 100;

    private InputMultiplexer base = new InputMultiplexer();
    private InputMultiplexer input01 = new InputMultiplexer();
    private InputMultiplexer input02 = new InputMultiplexer();

    @Override
    public void create() {
        camera = new OrthographicCamera();
        shapeRenderer = new ShapeRenderer();
        camera.setToOrtho(false);
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("data/badlogicsmall.jpg"));

        base.addProcessor(input01);
        base.addProcessor(input02);
        Gdx.input.setInputProcessor(base);

        input01.addProcessor(new InputAdapter() {

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {

                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                if(button == Input.Buttons.LEFT) {
                    camera.unproject(TMP_VEC01.set(screenX, screenY, 0));
                    x1 = TMP_VEC01.x;
                    y1 = TMP_VEC01.y;
                    return true;
                }
                return false;
            }
        });

        input02.addProcessor(new InputAdapter() {
            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                camera.unproject(TMP_VEC01.set(screenX, screenY, 0));
                x2 = TMP_VEC01.x;
                y2 = TMP_VEC01.y;
                return false;
            }
        });
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);
        shapeRenderer.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(texture, x1, y1);
        batch.draw(texture, x2 + 10, y2);
        batch.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        shapeRenderer.circle(100, 100, 30);
        shapeRenderer.end();

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            x1 -= speed * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            x1 += speed * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            y1 -= speed * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            y1 += speed * Gdx.graphics.getDeltaTime();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
        shapeRenderer.dispose();
    }
}
