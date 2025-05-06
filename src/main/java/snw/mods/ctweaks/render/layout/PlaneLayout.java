package snw.mods.ctweaks.render.layout;

import org.jetbrains.annotations.Nullable;
import snw.mods.ctweaks.object.ObjectUpdater;
import snw.mods.ctweaks.object.pos.PlanePosition;
import snw.mods.ctweaks.object.range.Ranged;
import snw.mods.ctweaks.object.range.Rectangle;

public interface PlaneLayout extends Layout, PlanePosition.Getter, Ranged<@Nullable Rectangle> {

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
