package com.jobzilla.enums;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public  enum ProfileType{
    CANDIDATE(1),
    RECRUITER(2);
    private final Integer value;

    private static final Map<Integer, ProfileType> ENUM_MAP;
    ProfileType(int value) {
        this.value = value;
    }
    public Integer getValue() {
        return this.value;
    }
    static {
        Map<Integer, ProfileType> map = new ConcurrentHashMap<Integer,ProfileType>();
        for (ProfileType instance : ProfileType.values()) {
            map.put(instance.getValue(),instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static ProfileType get (String name) {
        return ENUM_MAP.get(name.toLowerCase());
    }
}
