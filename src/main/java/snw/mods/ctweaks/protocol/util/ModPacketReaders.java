package snw.mods.ctweaks.protocol.util;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.json.JSONComponentSerializer;
import org.jetbrains.annotations.Nullable;
import snw.lib.protocol.io.PacketReader;
import snw.mods.ctweaks.object.Orientation;
import snw.mods.ctweaks.object.pos.PlanePosition;
import snw.mods.ctweaks.object.range.Rectangle;

import static snw.lib.protocol.io.PacketReaders.enumReader;

@SuppressWarnings("PatternValidation")
public final class ModPacketReaders {
    public static final PacketReader<Key> NAMESPACED_KEY;
    public static final PacketReader<Component> COMPONENT;
    public static final PacketReader<PlanePosition> PLANE_POSITION;
    public static final PacketReader<Rectangle> RECTANGLE;
    public static final PacketReader<@Nullable Orientation> ORIENTATION;

    static {
        NAMESPACED_KEY = input -> {
            final String namespace = input.readUTF();
            final String key = input.readUTF();
            return Key.key(namespace, key);
        };
        COMPONENT = input -> {
            final String raw = input.readUTF();
            return JSONComponentSerializer.json().deserialize(raw);
        };
        PLANE_POSITION = input -> {
            final int x = input.readInt();
            final int y = input.readInt();
            return new PlanePosition(x, y);
        };
        RECTANGLE = input -> {
            final int width = input.readInt();
            final int height = input.readInt();
            return new Rectangle(width, height);
        };
        ORIENTATION = enumReader(Orientation.class);
    }

    private ModPacketReaders() {
    }
}
