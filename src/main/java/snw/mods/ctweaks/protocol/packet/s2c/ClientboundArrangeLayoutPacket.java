package snw.mods.ctweaks.protocol.packet.s2c;

import com.google.common.io.ByteArrayDataOutput;
import snw.lib.protocol.packet.Packet;
import snw.mods.ctweaks.object.IntKeyed;
import snw.mods.ctweaks.protocol.handler.ClientboundPacketHandler;

public class ClientboundArrangeLayoutPacket extends Packet<ClientboundPacketHandler> {
    public static final String TYPE = "arrange_layout";

    private final IntKeyed.Descriptor target;

    public ClientboundArrangeLayoutPacket(IntKeyed.Descriptor target, String nonce) {
        super(nonce);
        this.target = target;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    protected void doSerialization(ByteArrayDataOutput output) {
        IntKeyed.Descriptor.WRITER.write(output, this.target);
    }

    @Override
    public void handle(ClientboundPacketHandler handler) {
        handler.handleArrangeLayout(this);
    }
}
