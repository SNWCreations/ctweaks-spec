package snw.mods.ctweaks.object;

public interface IntSized {

    int getSize();

    interface Updater<T extends Updater<T>> {
        T setSize(int size);
    }
}
