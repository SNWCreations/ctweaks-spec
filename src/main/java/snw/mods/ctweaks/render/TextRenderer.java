package snw.mods.ctweaks.render;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import snw.mods.ctweaks.object.ObjectUpdater;
import snw.mods.ctweaks.object.pos.PlanePositioned;

import static snw.mods.ctweaks.Keys.modKey;

public interface TextRenderer extends Renderer, PlanePositioned {
    Key TYPE = modKey("text");

    default Key getType() {
        return TYPE;
    }

    Component getText();

    Updater newUpdater();

    interface Updater extends ObjectUpdater {
        void setText(Component text);
    }
}
