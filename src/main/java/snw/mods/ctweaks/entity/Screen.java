package snw.mods.ctweaks.entity;

import org.jetbrains.annotations.UnmodifiableView;
import snw.mods.ctweaks.render.Renderer;
import snw.mods.ctweaks.render.TextRenderer;

import java.util.Collection;

public interface Screen {
    Player getOwner();

    TextRenderer addTextRenderer();

    void removeRenderer(Renderer renderer);

    @UnmodifiableView
    Collection<Renderer> getRenderers();

    void clearRenderers();
}
