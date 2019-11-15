package net.broscorp.d_gc;

import java.io.IOException;
import java.util.logging.Logger;

public class GarbageCollectionConcept {

  static int count = 1;
  private static final Logger LOGGER = Logger.getLogger(GarbageCollectionConcept.class.getName());

  public static void main(String[] args) throws SecurityException, IOException {

    showGarbageCollection();

  }

  @Override
  protected void finalize() {
    LOGGER.info("Object; " + this.hashCode() + " has been deleted " + (count++));
  }

  public static void showGarbageCollection() {
    for (int i = 1; i <= 20; i++) {
      GarbageCollectionConcept gc = new GarbageCollectionConcept();
      LOGGER.info("Object: " + gc.hashCode() + " has been created " + i);
      gc = null;
    }
    System.gc();
  }
}

