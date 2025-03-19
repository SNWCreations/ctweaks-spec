package snw.mods.ctweaks;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.key.KeyPattern;

public final class Keys {
    public static final String NAMESPACE = "snwctweaks";

    public static Key modKey(@KeyPattern.Value String value) {
        return Key.key(NAMESPACE, value);
    }

    private Keys() {
    }
}
