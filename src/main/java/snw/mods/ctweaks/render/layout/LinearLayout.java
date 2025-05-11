package snw.mods.ctweaks.render.layout;

import net.kyori.adventure.key.Key;
import snw.mods.ctweaks.object.Orientation;
import snw.mods.ctweaks.object.Spaced;

import static snw.mods.ctweaks.Keys.modKey;

public interface LinearLayout extends PlaneLayout, Orientation.Getter, Spaced {
    Key EXACT_TYPE = modKey("linear");

    @Override
    default Key getExactType() {
        return EXACT_TYPE;
    }

    Updater newUpdater();

    interface PropertySetter<T extends PropertySetter<T>> extends
            PlaneLayout.PropertySetter<T>,
            Orientation.PropertySetter<T>,
            Spaced.PropertySetter<T>
    {
        T addChild(LayoutElement element);

        T setChild(int index, LayoutElement element);
    }

    interface Updater extends PlaneLayout.Updater<Updater>, PropertySetter<Updater> {
        Updater removeChild(int index);

        Updater removeChild(LayoutElement element);
    }

    interface Builder extends PlaneLayout.Builder<Builder, LinearLayout>, PropertySetter<Builder> {
    }
}
