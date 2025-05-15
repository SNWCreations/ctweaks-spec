package snw.mods.ctweaks.render.layout;

import net.kyori.adventure.key.Key;
import org.jetbrains.annotations.UnmodifiableView;
import snw.mods.ctweaks.object.*;
import snw.mods.ctweaks.render.Renderable;

import java.util.List;
import java.util.function.Consumer;

import static snw.mods.ctweaks.Keys.modKey;

public interface Layout extends LayoutElement, Renderable, Removable, IntIdentified {
    Key TYPE = modKey("layout");

    @Override
    default Key getType() {
        return TYPE;
    }

    void arrangeElements();

    @UnmodifiableView
    List<LayoutElement> getChildren();

    void visitChildren(Consumer<LayoutElement> visitor);

    void clear();

    interface PropertySetter<T extends PropertySetter<T>> extends LayoutElement.PropertySetter<T> {
        T setAfterUpdateCallback(Runnable callback);
    }

    interface Updater<T extends Updater<T>> extends ObjectUpdater, PropertySetter<T> {
        T removeChild(LayoutElement element);

        T removeChild(int index);
    }

    interface Builder<T extends Builder<T, R>, R extends Layout> extends ObjectBuilder<R>, PropertySetter<T> {
    }
}
