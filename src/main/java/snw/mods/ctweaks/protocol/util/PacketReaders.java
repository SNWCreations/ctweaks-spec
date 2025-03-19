package snw.mods.ctweaks.protocol.util;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.json.JSONComponentSerializer;
import snw.lib.protocol.io.PacketReader;

@SuppressWarnings("PatternValidation")
public final class PacketReaders {
    public static final PacketReader<Key> NAMESPACED_KEY;
    public static final PacketReader<Component> COMPONENT;

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
    }

    private PacketReaders() {
    }
}
