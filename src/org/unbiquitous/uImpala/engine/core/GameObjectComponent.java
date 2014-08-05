package org.unbiquitous.uImpala.engine.core;

/**
 * Use this class to implement components for the component-based
 * game object class.
 * @see ComponentGameObject
 * @author Pimenta
 *
 */
public abstract class GameObjectComponent {
  protected ComponentGameObject object;
  
  /**
   * Constructor to assign parent game object.
   * @param object The parent game object.
   */
  public GameObjectComponent(ComponentGameObject object) {
    this.object = object;
  }
  
  /**
   * Method to hook on a field. Every time the field is written, handle will
   * be called.
   * @param field Field name.
   */
  protected void hook(String field) {
    object.hook(field, getClass());
  }
  
  /**
   * Method to unhook on a field. The handle method will stop being called
   * every time the field is written.
   * @param field Field name.
   */
  protected void unhook(String field) {
    object.unhook(field, getClass());
  }
  
  /**
   * Method to add a rendering operation to the container.
   * @param z Plane of renderization. The renderization will happen
   * in ascending order.
   * @param renderer Renderer to be called.
   */
  protected void render(int z, Runnable renderer) {
    object.putRenderer(z, renderer);
  }
  
  /**
   * Method to implement update.
   */
  protected abstract void update();
  
  /**
   * Handle a pop from the stack of game scenes.
   * @param args Arguments passed from the scene popped.
   */
  protected abstract void wakeup(Object... args);
  
  /**
   * Method to close whatever is necessary.
   */
  protected abstract void destroy();
  
  /**
   * Method to handle a field write.
   * @param field Field name.
   * @param value Field value.
   */
  protected abstract void handle(String field, Object value);
}