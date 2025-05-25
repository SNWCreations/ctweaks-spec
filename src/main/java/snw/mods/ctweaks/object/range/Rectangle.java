package snw.mods.ctweaks.object.range;

import net.kyori.adventure.key.Key;
import snw.lib.protocol.io.PacketReader;
import snw.lib.protocol.io.PacketWriter;

import static snw.mods.ctweaks.Keys.modKey;

public record Rectangle(int width, int height) implements Range {
    public static final Key TYPE = modKey("rectangle");
    public static final PacketReader<Rectangle> READER;
    public static final PacketWriter<Rectangle> WRITER;

    static {
        READER = input -> {
            final int width = input.readInt();
            final int height = input.readInt();
            return new Rectangle(width, height);
        };
        WRITER = (output, rectangle) -> {
            final int width = rectangle.width();
            final int height = rectangle.height();
            output.writeInt(width);
            output.writeInt(height);
        };
    }

    @Override
    public Key getType() {
        return TYPE;
    }
}
