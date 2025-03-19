package snw.mods.ctweaks.protocol.util;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.json.JSONComponentSerializer;
import snw.lib.protocol.io.PacketWriter;

public final class PacketWriters {
    public static final PacketWriter<Key> NAMESPACED_KEY;
    public static final PacketWriter<Component> COMPONENT;

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

    private PacketWriters() {
    }
}
