package snw.mods.ctweaks.protocol.packet.c2s;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import snw.lib.protocol.packet.Packet;
import snw.mods.ctweaks.protocol.handler.ServerboundPacketHandler;

public class ServerboundObjectUpdatedPacket extends Packet<ServerboundPacketHandler> {
    public static final String TYPE = "object_updated";

    public ServerboundObjectUpdatedPacket(String nonce) {
        super(nonce);
    }

    public ServerboundObjectUpdatedPacket(ByteArrayDataInput input) {
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
        handler.handleObjectUpdated(this);
    }

    @Override
    public String toString() {
        return "ServerboundObjectUpdatedPacket{" +
                "nonce=" + getNonce() +
                "}";
    }
}
