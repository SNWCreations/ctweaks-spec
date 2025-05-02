package snw.mods.ctweaks.entity;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;
import snw.mods.ctweaks.object.pos.PlanePosition;
import snw.mods.ctweaks.render.PlayerFaceRenderer;
import snw.mods.ctweaks.render.Renderer;
import snw.mods.ctweaks.render.TextRenderer;

import java.util.Collection;
import java.util.UUID;

public interface Screen {
    Player getOwner();

    TextRenderer addTextRenderer(PlanePosition position, @Nullable Component text);

    TextRenderer.Builder textRendererBuilder();

    PlayerFaceRenderer addPlayerFaceRenderer(UUID target, PlanePosition position);

    PlayerFaceRenderer.Builder playerFaceRendererBuilder();

    @UnmodifiableView
    Collection<Renderer> getRenderers();

    void clearRenderers();

    int getWidth();

    int getHeight();

    boolean isNowFullScreen();
}
