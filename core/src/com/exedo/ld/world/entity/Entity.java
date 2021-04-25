package com.exedo.ld.world.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.exedo.ld.world.chunk.ChunkManager;

public abstract class Entity {
    protected Vector2 pos;
    protected Vector2 velocity = Vector2.Zero;
    protected Vector2 acceleration = Vector2.Zero;

    protected Rectangle boundingBox;

    public Entity(float x, float y) {
        pos = new Vector2(x, y);
        boundingBox = new Rectangle(x, y, ChunkManager.TILE_SIZE, ChunkManager.TILE_SIZE);
    }

    public void update() {
        velocity.add(acceleration.cpy().scl(Gdx.graphics.getDeltaTime()));
        pos.add(velocity.cpy().scl(Gdx.graphics.getDeltaTime()));
    }

    public void drawBoundingBox(ShapeRenderer renderer, Color color) {
        renderer.setColor(color);
        renderer.rect(boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
    }
}
