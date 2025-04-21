package snw.mods.ctweaks.protocol.packet.s2c;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import lombok.ToString;
import snw.lib.protocol.packet.Packet;
import snw.mods.ctweaks.protocol.handler.ClientboundPacketHandler;

@ToString
public class ClientboundClearRendererPacket extends Packet<ClientboundPacketHandler> {
    public static final String TYPE = "clear_renderer";

    public ClientboundClearRendererPacket(String nonce) {
        super(nonce);
    }

    public ClientboundClearRendererPacket(ByteArrayDataInput input) {
        super(input);
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    protected void doSerialization(ByteArrayDataOutput output) {
    }

    @Override
    public void handle(ClientboundPacketHandler handler) {
        handler.handleClearRenderer(this);
    }
}
