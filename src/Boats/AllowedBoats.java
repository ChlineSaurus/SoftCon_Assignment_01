package Boats;

import java.util.HashMap;
import java.util.Map;

public enum AllowedBoats {
    Zero(0),

    One(1),
    Two(2),
    Three(3),
    Four(4);
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

