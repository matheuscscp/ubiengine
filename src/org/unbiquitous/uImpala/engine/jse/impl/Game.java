package org.unbiquitous.uImpala.engine.jse.impl;

import org.unbiquitous.uImpala.engine.core.GameSettings;

public final class Game extends org.unbiquitous.uImpala.engine.core.Game {
  public static void run(GameSettings settings) {
    org.unbiquitous.uImpala.engine.core.Game.run(Game.class.getName(), settings);
  }
  
  protected AssetManager createAssetManager() {
    return new AssetManager();
  }
}