package snw.mods.ctweaks.object;

import net.kyori.adventure.key.Key;
import snw.lib.protocol.io.PacketReader;
import snw.lib.protocol.io.PacketWriter;
import snw.mods.ctweaks.protocol.util.ModPacketReaders;
import snw.mods.ctweaks.protocol.util.ModPacketWriters;

public interface IntKeyed extends IntIdentified, KeyTyped {

    default Descriptor describe() {
        return new Descriptor(getId(), getType());
    }

    record Descriptor(int id, Key type) {
        public static final PacketReader<Descriptor> READER;
        public static final PacketWriter<Descriptor> WRITER;

        static {
            READER = input -> {
                final int id = input.readInt();
                final Key type = ModPacketReaders.NAMESPACED_KEY.read(input);
                return new Descriptor(id, type);
            };
            WRITER = (output, desc) -> {
                final int id = desc.id();
                final Key type = desc.type();
                output.writeInt(id);
                ModPacketWriters.NAMESPACED_KEY.write(output, type);
            };
        }
    }
}
