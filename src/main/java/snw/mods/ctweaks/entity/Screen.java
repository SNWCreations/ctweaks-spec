package snw.mods.ctweaks.entity;

import org.jetbrains.annotations.UnmodifiableView;
import snw.mods.ctweaks.object.pos.PlanePosition;
import snw.mods.ctweaks.render.Renderer;
import snw.mods.ctweaks.render.TextRenderer;

import java.util.Collection;

public interface Screen {
    Player getOwner();

    TextRenderer addTextRenderer(PlanePosition position);

    @UnmodifiableView
    Collection<Renderer> getRenderers();

    void clearRenderers();
}
