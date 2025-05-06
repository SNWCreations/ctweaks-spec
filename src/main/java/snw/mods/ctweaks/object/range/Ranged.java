package snw.mods.ctweaks.object.range;

public interface Ranged<T extends Range> {
    T getRange();

    interface PropertySetter<T extends PropertySetter<T, R>, R extends Range> {
        T setRange(R range);
    }
}
