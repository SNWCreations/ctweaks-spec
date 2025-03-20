package snw.mods.ctweaks.render;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import snw.mods.ctweaks.object.ObjectUpdater;
import snw.mods.ctweaks.object.pos.PlanePosition;

import static snw.mods.ctweaks.Keys.modKey;

public interface TextRenderer extends Renderer {
    Key TYPE = modKey("text");

    default Key getType() {
        return TYPE;
    }

    PlanePosition getPosition();

    Component getText();

    Updater newUpdater();

    interface Updater extends ObjectUpdater {
        void setText(Component text);

        void setPosition(PlanePosition position);
    }
}
