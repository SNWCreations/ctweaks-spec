package snw.mods.ctweaks.entity;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;
import snw.mods.ctweaks.object.pos.PlanePosition;
import snw.mods.ctweaks.render.PlayerFaceRenderer;
import snw.mods.ctweaks.render.Renderer;
import snw.mods.ctweaks.render.TextRenderer;
import snw.mods.ctweaks.render.layout.GridLayout;
import snw.mods.ctweaks.render.layout.Layout;
import snw.mods.ctweaks.render.layout.LinearLayout;

import java.util.Collection;
import java.util.UUID;

public interface Screen {
    Player getOwner();

    TextRenderer addTextRenderer(PlanePosition position, @Nullable Component text);

    TextRenderer.Builder textRendererBuilder();

    PlayerFaceRenderer addPlayerFaceRenderer(UUID target, PlanePosition position);

    PlayerFaceRenderer.Builder playerFaceRendererBuilder();

    GridLayout.Builder gridLayoutBuilder();

    LinearLayout.Builder linearLayoutBuilder();

    @UnmodifiableView
    Collection<? extends Renderer> getRenderers();

    @UnmodifiableView
    Collection<? extends Layout> getLayouts();

    void clearRenderers();

    void clearLayouts();

    int getWidth();

    int getHeight();

    boolean isNowFullScreen();
}
