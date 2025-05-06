package snw.mods.ctweaks.object;

import org.jetbrains.annotations.Range;

public interface Spaced extends SpacedLike {
    int getSpacing();

    interface PropertySetter<T extends PropertySetter<T>> {
        T setSpacing(@Range(from = 0, to = Integer.MAX_VALUE) int spacing);
    }
}
