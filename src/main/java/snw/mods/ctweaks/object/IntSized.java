package snw.mods.ctweaks.object;

public interface IntSized {

    int getSize();

    interface PropertySetter<T extends PropertySetter<T>> {
        T setSize(int size);
    }
}
