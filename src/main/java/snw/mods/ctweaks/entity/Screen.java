package snw.mods.ctweaks.entity;

import org.jetbrains.annotations.UnmodifiableView;
import snw.mods.ctweaks.object.pos.PlanePosition;
import snw.mods.ctweaks.render.PlayerFaceRenderer;
import snw.mods.ctweaks.render.Renderer;
import snw.mods.ctweaks.render.TextRenderer;

import java.util.Collection;
import java.util.UUID;

public interface Screen {
    Player getOwner();

    TextRenderer addTextRenderer(PlanePosition position);

    PlayerFaceRenderer addPlayerFaceRenderer(UUID target, PlanePosition position, float scale);

    @UnmodifiableView
    Collection<Renderer> getRenderers();

    void clearRenderers();

    int getWidth();

    int getHeight();

    boolean isNowFullScreen();
}
