package snw.mods.ctweaks.protocol.packet.s2c;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import net.kyori.adventure.text.Component;
import snw.lib.protocol.packet.Packet;
import snw.mods.ctweaks.protocol.handler.ClientboundPacketHandler;
import snw.mods.ctweaks.protocol.util.PacketReaders;
import snw.mods.ctweaks.protocol.util.PacketWriters;

public class ClientboundUpdateTextRendererPacket extends Packet<ClientboundPacketHandler> {
    public static final String TYPE = "update_renderer";

    private final int id;
    private final Component text;

    public ClientboundUpdateTextRendererPacket(int id, Component text, String nonce) {
        super(nonce);
        this.id = id;
        this.text = text;
    }

    public ClientboundUpdateTextRendererPacket(ByteArrayDataInput input) {
        super(input);
        this.id = input.readInt();
        this.text = PacketReaders.COMPONENT.read(input);
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    protected void doSerialization(ByteArrayDataOutput output) {
        output.writeInt(this.id);
        PacketWriters.COMPONENT.write(output, this.text);
    }

    @Override
    public void handle(ClientboundPacketHandler handler) {
        handler.handleUpdateTextRenderer(this);
    }
}
