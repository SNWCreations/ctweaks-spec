package snw.mods.ctweaks.render.layout;

import net.kyori.adventure.key.Key;
import org.jetbrains.annotations.Range;
import snw.mods.ctweaks.object.Spaced;
import snw.mods.ctweaks.object.SpacedLike;

import static snw.mods.ctweaks.Keys.modKey;

public interface GridLayout extends PlaneLayout, SpacedLike {
    Key EXACT_TYPE = modKey("grid");

    @Override
    default Key getExactType() {
        return EXACT_TYPE;
    }

    int getRowSpacing();

    int getColumnSpacing();

    int getRowCount();

    int getColumnCount();

    Updater newUpdater();

    interface PropertySetter<T extends PropertySetter<T>> extends PlaneLayout.PropertySetter<T>, Spaced.PropertySetter<T> {
        T addChild(LayoutElement element);

        T addChild(int index, LayoutElement element);

        T setChild(int index, LayoutElement element);

        T setRowSpacing(@Range(from = 0, to = Integer.MAX_VALUE) int rowSpacing);

        T setColumnSpacing(@Range(from = 0, to = Integer.MAX_VALUE) int columnSpacing);

        T setRowCount(@Range(from = 1, to = Integer.MAX_VALUE) int rowCount);

        T setColumnCount(@Range(from = 1, to = Integer.MAX_VALUE) int columnCount);

        @Override
        default T setSpacing(@Range(from = 0, to = Integer.MAX_VALUE) int spacing) {
            return setRowSpacing(spacing).setColumnSpacing(spacing);
        }
    }

    interface Updater extends PlaneLayout.Updater<Updater>, PropertySetter<Updater> {
        Updater removeChild(int index);

        Updater removeChild(LayoutElement element);
    }

    interface Builder extends PlaneLayout.Builder<Builder, GridLayout>, PropertySetter<Builder> {
    }
}
