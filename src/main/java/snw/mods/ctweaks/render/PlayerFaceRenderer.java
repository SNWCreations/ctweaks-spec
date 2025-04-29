package snw.mods.ctweaks.render;

import net.kyori.adventure.key.Key;
import snw.mods.ctweaks.object.IntSized;
import snw.mods.ctweaks.object.ObjectUpdater;
import snw.mods.ctweaks.object.pos.PlanePosition;

import java.util.UUID;

import static snw.mods.ctweaks.Keys.modKey;

public interface PlayerFaceRenderer extends Renderer, PlanePosition.Getter, IntSized {
    Key TYPE = modKey("player_face");

    @Override
    default Key getType() {
        return TYPE;
    }

    UUID getTarget();

    Updater newUpdater();

    interface Updater extends ObjectUpdater, IntSized.Updater<Updater> {

        Updater setTarget(UUID target);

        Updater setPosition(PlanePosition position);

    }
}
