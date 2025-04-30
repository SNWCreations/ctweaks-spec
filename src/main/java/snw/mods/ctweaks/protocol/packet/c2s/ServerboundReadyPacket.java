package snw.mods.ctweaks.protocol.packet.c2s;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import snw.lib.protocol.packet.Packet;
import snw.mods.ctweaks.protocol.handler.ServerboundPacketHandler;

public class ServerboundReadyPacket extends Packet<ServerboundPacketHandler> {
    public static final String TYPE = "ready";

    public ServerboundReadyPacket(String nonce) {
        super(nonce);
    }

    public ServerboundReadyPacket(ByteArrayDataInput input) {
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
    public void handle(ServerboundPacketHandler handler) {
        handler.handleReady(this);
    }
}
