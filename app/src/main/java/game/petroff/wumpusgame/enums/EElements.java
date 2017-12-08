package game.petroff.wumpusgame.enums;

/**
 * Created by petroff on 12/6/17.
 */

public enum EElements {

   WATER_WELL_NUMBER(3),
   WALL_NUMBER(3),
   ARRAY_SIZE (5),
   PLAYER(5),
   WALL(4),
   PIT(3),
   GOLD(2),
   ARROWS(2),
   HAS_PASSED(6),
   WUMPUS(1);

   private int code;

   private EElements(int code) {
      this.code = code;
   }

   public int getCode() {
      return code;
   }
}
