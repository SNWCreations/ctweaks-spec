package snw.mods.ctweaks.object;

public interface Scaled {

    float getScale();

    interface Updater<T extends Updater<T>> {
        T setScale(float scale);
    }
}
