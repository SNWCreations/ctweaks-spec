package snw.mods.ctweaks.render;

import net.kyori.adventure.key.Key;
import snw.mods.ctweaks.object.IntIdentified;
import snw.mods.ctweaks.object.Removable;

public interface Renderer extends IntIdentified, Removable {
    Key getType();
}
