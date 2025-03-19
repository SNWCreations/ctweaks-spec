package snw.mods.ctweaks.protocol.packet.s2c;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import lombok.Getter;
import net.kyori.adventure.key.Key;
import snw.lib.protocol.packet.Packet;
import snw.mods.ctweaks.protocol.handler.ClientboundPacketHandler;
import snw.mods.ctweaks.protocol.util.PacketReaders;
import snw.mods.ctweaks.protocol.util.PacketWriters;

@Getter
public class ClientboundAddRendererPacket extends Packet<ClientboundPacketHandler> {
    public static final String TYPE = "add_renderer";

    private final int id;
    private final Key type;

    public ClientboundAddRendererPacket(int id, Key type, String nonce) {
        super(nonce);
        this.id = id;
        this.type = type;
    }

    public ClientboundAddRendererPacket(ByteArrayDataInput input) {
        super(input);
        this.id = input.readInt();
        this.type = PacketReaders.NAMESPACED_KEY.read(input);
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public void handle(ClientboundPacketHandler handler) {
        handler.handleAddRenderer(this);
    }

    @Override
    protected void doSerialization(ByteArrayDataOutput output) {
        output.writeInt(this.id);
        PacketWriters.NAMESPACED_KEY.write(output, this.type);
    }
}
