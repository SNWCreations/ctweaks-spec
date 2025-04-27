package snw.mods.ctweaks.render;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;
import snw.mods.ctweaks.object.ObjectUpdater;
import snw.mods.ctweaks.object.pos.PlanePosition;

import static snw.mods.ctweaks.Keys.modKey;

public interface TextRenderer extends Renderer, PlanePosition.Getter {
    Key TYPE = modKey("text");

    default Key getType() {
        return TYPE;
    }

    @Nullable Component getText();

    Updater newUpdater();

    interface Updater extends ObjectUpdater {
        Updater setText(Component text);

        Updater setPosition(PlanePosition position);
    }
}
