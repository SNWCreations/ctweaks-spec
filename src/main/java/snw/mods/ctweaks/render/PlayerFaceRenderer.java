package snw.mods.ctweaks.render;

import snw.mods.ctweaks.object.ObjectUpdater;
import snw.mods.ctweaks.object.Scaled;
import snw.mods.ctweaks.object.pos.PlanePosition;

import java.util.UUID;

public interface PlayerFaceRenderer extends Renderer, PlanePosition.Getter, Scaled {

    UUID getTarget();

    Updater newUpdater();

    interface Updater extends ObjectUpdater, Scaled.Updater<Updater> {

        Updater setTarget(UUID target);

        Updater setPosition(PlanePosition position);

    }
}
