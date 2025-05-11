package snw.mods.ctweaks.render;

import net.kyori.adventure.key.Key;
import snw.mods.ctweaks.object.Removable;
import snw.mods.ctweaks.render.layout.LayoutElement;

import static snw.mods.ctweaks.Keys.modKey;

public interface Renderer extends Renderable, Removable, LayoutElement {
    Key TYPE = modKey("renderer");

    @Override
    default Key getType() {
        return TYPE;
    }

    interface PropertySetter<T extends PropertySetter<T>> extends LayoutElement.PropertySetter<T> {
    }

}
