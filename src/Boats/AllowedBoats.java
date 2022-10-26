package Boats;

import java.util.HashMap;
import java.util.Map;

public enum AllowedBoats {
    ZeroBoats(0),

    OneBoat(1),
    TwoBoats(2),
    ThreeBoats(3),
    FourHitPoints(4);
    private final int value;
    private static Map map = new HashMap<>();
    AllowedBoats(int value){
        this.value=value;
    }

    static {
        for (AllowedBoats HITPOINTCLASS : AllowedBoats.values()) {
            map.put(HITPOINTCLASS.value, HITPOINTCLASS);
        }

    }
    public static AllowedBoats valueOf(int value) {
        return (AllowedBoats) map.get(value);
    }
    int getHitpointValue(){
        return value;
    }
}

