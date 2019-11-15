package net.broscorp.d_gc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;


public class Resurrection {

  private static final Logger LOGGER = Logger.getLogger(Resurrection.class.getName());
  private static final ArrayList<Zombie> HAVEN = new ArrayList<Zombie>();


  public static void main(String[] args)
      throws SecurityException, IOException, InterruptedException {


    for (int i = 0; i < 3; i++)
      HAVEN.add(new Zombie(i));
    for (int j = 0; j < 6; j++) {
      LOGGER.info("HAVEN: " + HAVEN);
      HAVEN.clear();
      System.gc();
      Thread.sleep(1000);
    }

  }

  static class Zombie {

    int number;

    public Zombie(int number) {
      this.number = number;
    }

    @Override
    protected void finalize() {
      LOGGER.info("Resurect: " + number);
      HAVEN.add(this);

    }

    @Override
    public String toString() {
      return "Zombie [number=" + number + "]";
    }

  }
}
