package snw.mods.ctweaks.protocol.util;

import it.unimi.dsi.fastutil.Pair;
import it.unimi.dsi.fastutil.objects.ObjectObjectImmutablePair;
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
    @Deprecated(forRemoval = true)
    public static final PacketReader<PlanePosition> PLANE_POSITION = PlanePosition.READER;
    @Deprecated(forRemoval = true)
    public static final PacketReader<Rectangle> RECTANGLE = Rectangle.READER;
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
        ORIENTATION = enumReader(Orientation.class);
    }

    public static <T, R> PacketReader<Pair<T, R>> pairReader(PacketReader<T> tReader, PacketReader<R> rReader) {
        return input -> {
            T t = tReader.read(input);
            R r = rReader.read(input);
            return new ObjectObjectImmutablePair<>(t, r);
        };
    }

    private ModPacketReaders() {
    }
}
