package snw.mods.ctweaks.object;

public enum Orientation {
    HORIZONAL,
    VERTICAL;

    public interface Getter {
        Orientation getOrientation();
    }

    public interface PropertySetter<T extends PropertySetter<T>> {
        T setOrientation(Orientation orientation);
    }
}
