package snw.mods.ctweaks.protocol.packet.s2c;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import lombok.Getter;
import lombok.ToString;
import snw.lib.protocol.packet.Packet;
import snw.mods.ctweaks.protocol.handler.ClientboundPacketHandler;

@ToString
public class ClientboundClearLayoutPacket extends Packet<ClientboundPacketHandler> {
    public static final String TYPE = "clear_layout";

    public ClientboundClearLayoutPacket(String nonce) {
        super(nonce);
    }

    public ClientboundClearLayoutPacket(ByteArrayDataInput input) {
        super(input);
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public void handle(ClientboundPacketHandler handler) {
        handler.handleClearLayout(this);
    }

    @Override
    protected void doSerialization(ByteArrayDataOutput output) {
    }
}
