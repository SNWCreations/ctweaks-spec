package snw.mods.ctweaks.render;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;
import snw.mods.ctweaks.object.ObjectUpdater;
import snw.mods.ctweaks.object.Scaled;
import snw.mods.ctweaks.object.pos.PlanePosition;

import static snw.mods.ctweaks.Keys.modKey;

public interface TextRenderer extends Renderer, PlanePosition.Getter, Scaled {
    Key TYPE = modKey("text");

    default Key getType() {
        return TYPE;
    }

    @Nullable Component getText();

    boolean isNoShadow();

    Updater newUpdater();

    interface Updater extends ObjectUpdater, Scaled.Updater<Updater> {
        Updater setText(Component text);

        Updater setPosition(PlanePosition position);

        Updater setNoShadow(boolean noShadow);
    }
}
