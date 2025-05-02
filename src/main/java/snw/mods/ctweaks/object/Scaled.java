package snw.mods.ctweaks.object;

public interface Scaled {

    float getScale();

    interface PropertySetter<T extends PropertySetter<T>> {
        T setScale(float scale);
    }
}
