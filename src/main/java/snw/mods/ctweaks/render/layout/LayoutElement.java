package snw.mods.ctweaks.render.layout;

import net.kyori.adventure.key.Key;
import snw.mods.ctweaks.object.IntKeyed;
import snw.mods.ctweaks.object.pos.PlanePosition;

public interface LayoutElement extends IntKeyed {
    Key getExactType();

    interface PropertySetter<T extends PropertySetter<T>> extends PlanePosition.PropertySetter<T> {
    }
}
