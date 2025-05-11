package snw.mods.ctweaks.render;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;
import snw.mods.ctweaks.object.ObjectBuilder;
import snw.mods.ctweaks.object.ObjectUpdater;
import snw.mods.ctweaks.object.Scaled;
import snw.mods.ctweaks.object.pos.PlanePosition;

import static snw.mods.ctweaks.Keys.modKey;

public interface TextRenderer extends Renderer, PlanePosition.Getter, PlanePosition.Setter, Scaled {
    Key EXACT_TYPE = modKey("text");

    @Override
    default Key getExactType() {
        return EXACT_TYPE;
    }

    @Nullable Component getText();

    boolean isNoShadow();

    Updater newUpdater();

    interface PropertySetter<T extends PropertySetter<T>> extends Scaled.PropertySetter<T>, Renderer.PropertySetter<T> {
        T setText(Component text);

        T setNoShadow(boolean noShadow);

        T setOutlineColor(int outlineColor);
    }

    interface Updater extends ObjectUpdater, PropertySetter<Updater> {
    }

    interface Builder extends ObjectBuilder<TextRenderer>, PropertySetter<Builder> {
    }
}
