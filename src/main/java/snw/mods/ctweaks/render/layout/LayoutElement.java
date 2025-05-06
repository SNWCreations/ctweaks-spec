package snw.mods.ctweaks.render.layout;

import net.kyori.adventure.key.Key;
import snw.mods.ctweaks.object.IntKeyed;
import snw.mods.ctweaks.object.pos.PlanePosition;

public interface LayoutElement extends PlanePosition.Getter, IntKeyed {
    Key getElementType();

    interface PropertySetter<T extends PropertySetter<T>> extends PlanePosition.PropertySetter<T> {
    }
}
