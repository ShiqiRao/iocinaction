package gg.letsgo.boutframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Properties {
    private Map<String, Object> propertyMap = new ConcurrentHashMap<>();

    public void addProperty(String name, Object property) {
        propertyMap.put(name, property);
    }

    public Map<String, Object> getPropertyMap() {
        return this.propertyMap;
    }
}
