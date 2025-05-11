package snw.mods.ctweaks.render.layout;

import net.kyori.adventure.key.Key;
import org.jetbrains.annotations.Nullable;
import snw.mods.ctweaks.object.ObjectUpdater;
import snw.mods.ctweaks.object.pos.PlanePosition;
import snw.mods.ctweaks.object.range.Ranged;
import snw.mods.ctweaks.object.range.Rectangle;

import static snw.mods.ctweaks.Keys.modKey;

public interface PlaneLayout extends Layout, PlanePosition.Getter, PlanePosition.Setter, Ranged<@Nullable Rectangle> {
    Key EXACT_TYPE = modKey("plane");

    @Override
    default Key getExactType() {
        return EXACT_TYPE;
    }

    interface PropertySetter<T extends PropertySetter<T>> extends
            Layout.PropertySetter<T>,
            PlanePosition.PropertySetter<T>,
            Ranged.PropertySetter<T, @Nullable Rectangle>
    {
    }

    interface Updater<T extends Updater<T>> extends ObjectUpdater, PropertySetter<T> {
    }

    interface Builder<T extends Builder<T, R>, R extends PlaneLayout> extends Layout.Builder<T, R>, PropertySetter<T> {
    }
}
