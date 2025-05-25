package snw.mods.ctweaks.protocol.util;

import it.unimi.dsi.fastutil.Pair;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.json.JSONComponentSerializer;
import snw.lib.protocol.io.PacketWriter;
import snw.mods.ctweaks.object.pos.PlanePosition;
import snw.mods.ctweaks.object.range.Rectangle;

public final class ModPacketWriters {
    public static final PacketWriter<Key> NAMESPACED_KEY;
    public static final PacketWriter<Component> COMPONENT;
    @Deprecated(forRemoval = true)
    public static final PacketWriter<PlanePosition> PLANE_POSITION = PlanePosition.WRITER;
    @Deprecated(forRemoval = true)
    public static final PacketWriter<Rectangle> RECTANGLE = Rectangle.WRITER;

    static {
        NAMESPACED_KEY = (output, key) -> {
            output.writeUTF(key.namespace());
            output.writeUTF(key.value());
        };
        COMPONENT = (output, component) -> {
            final String raw = JSONComponentSerializer.json().serialize(component);
            output.writeUTF(raw);
        };
    }

    public static <T, R> PacketWriter<Pair<T, R>> pairWriter(PacketWriter<T> tWriter, PacketWriter<R> rWriter) {
        return (output, pair) -> {
            T t = pair.left();
            R r = pair.right();
            tWriter.write(output, t);
            rWriter.write(output, r);
        };
    }

    private ModPacketWriters() {
    }
}
