package snw.mods.ctweaks.object.range;

import net.kyori.adventure.key.Key;

import static snw.mods.ctweaks.Keys.modKey;

public record Rectangle(int width, int height) implements Range {
    public static final Key TYPE = modKey("rectangle");

    @Override
    public Key getType() {
        return TYPE;
    }
}
