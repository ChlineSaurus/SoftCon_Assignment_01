package Boats;

import java.util.HashMap;
import java.util.Map;

public enum HitpointManager {

        ZeroHitPoints(0),

        OneHitPoint(1),
        TwoHitPoints(2),
        ThreeHitPoints(3),
        FourHitPoints(4),
        FiveHitPoints(5);

        private final int value;
        private static Map map = new HashMap<>();
        HitpointManager(int value){
            this.value=value;
        }

        static {
            for (HitpointManager HITPOINTCLASS : HitpointManager.values()) {
                map.put(HITPOINTCLASS.value, HITPOINTCLASS);
            }

        }
        public static HitpointManager valueOf(int value) {
            return (HitpointManager) map.get(value);
        }
        int getHitpointValue(){
            return value;
        }
    }

