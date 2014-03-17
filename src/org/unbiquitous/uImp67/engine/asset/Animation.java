package org.unbiquitous.uImp67.engine.asset;

import org.unbiquitous.uImp67.engine.io.Screen;
import org.unbiquitous.uImp67.engine.time.Time;

/**
 * Class to animate a sprite sheet.
 * @author Pimenta
 *
 */
public class Animation extends Sprite {
  /**
   * Constructor to load the sprite sheet and set class parameters.
   * @param assets Object to load the image.
   * @param path Image path.
   * @param frames Amount of frames to divide the image.
   * @param fps Animation rate in frames per second.
   */
  public Animation(AssetManager assets, String path, int frames, float fps) {
    super(assets, path);
    this.frames = frames;
    this.fps = fps;
    frame = 0;
    frameInt = 0;
    clipWidth = getWidth()/frames;
    clipHeight = getHeight();
    lastTime = Time.get();
  }
  
  public void render(float x, float y, Screen screen, float opacity) {
    update();
    super.render(x, y, screen, opacity);
  }
  
  public void render(Screen screen, float x, float y, float angle, float scaleX, float scaleY, float opacity) {
    update();
    super.render(screen, x, y, angle, scaleX, scaleY, opacity);
  }
//==============================================================================
//nothings else matters from here to below
//==============================================================================
  private void update() {
    long now = Time.get();
    float dt = (now - lastTime)/1000f;
    lastTime = now;
    
    frame += fps*dt;
    frame -= frames*Math.floor(frame/frames);
    if (frameInt != (int)frame) {
      frameInt = (int)frame;
      clip(clipWidth*frameInt, 0, clipWidth, clipHeight);
    }
  }
  
  private int frames, frameInt, clipWidth, clipHeight;
  private long lastTime;
  private float fps, frame;
}