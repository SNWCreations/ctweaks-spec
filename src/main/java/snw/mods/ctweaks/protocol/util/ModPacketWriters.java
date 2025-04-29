package snw.mods.ctweaks.protocol.util;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.json.JSONComponentSerializer;
import snw.lib.protocol.io.PacketWriter;
import snw.mods.ctweaks.object.pos.PlanePosition;

public final class ModPacketWriters {
    public static final PacketWriter<Key> NAMESPACED_KEY;
    public static final PacketWriter<Component> COMPONENT;
    public static final PacketWriter<PlanePosition> PLANE_POSITION;

    static {
        NAMESPACED_KEY = (output, key) -> {
            output.writeUTF(key.namespace());
            output.writeUTF(key.value());
        };
        COMPONENT = (output, component) -> {
            final String raw = JSONComponentSerializer.json().serialize(component);
            output.writeUTF(raw);
        };
        PLANE_POSITION = (output, planePosition) -> {
            final int x = planePosition.x();
            final int y = planePosition.y();
            output.writeInt(x);
            output.writeInt(y);
        };
    }

    private ModPacketWriters() {
    }
}
