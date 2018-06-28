package gg.letsgo.boutframework.io;

public class ResourceLoader {

    public Resource getResource(String location) {
        return new URLResouce(this.getClass().getClassLoader().getResource(location));
    }
}
