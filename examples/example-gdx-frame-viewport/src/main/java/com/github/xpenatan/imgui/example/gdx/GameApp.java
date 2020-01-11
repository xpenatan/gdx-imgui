package com.github.xpenatan.imgui.example.gdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameApp implements ApplicationListener {
    private Texture texture;

    private ShapeRenderer shapeRenderer;
    private OrthographicCamera camera;

    private SpriteBatch batch;

    private float x = 100;
    private float y = 100;
    private float speed = 100;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        shapeRenderer = new ShapeRenderer();
        camera.setToOrtho(true);
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("data/badlogicsmall.jpg"));

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);
        shapeRenderer.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(texture, x, y);
        batch.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        shapeRenderer.circle(100,100, 30);
        shapeRenderer.end();

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            x -= speed * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            x += speed * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            y -= speed * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            y += speed * Gdx.graphics.getDeltaTime();
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
