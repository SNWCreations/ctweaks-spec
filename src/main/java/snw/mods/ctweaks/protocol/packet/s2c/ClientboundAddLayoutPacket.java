package snw.mods.ctweaks.protocol.packet.s2c;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import lombok.Getter;
import lombok.ToString;
import snw.lib.protocol.packet.Packet;
import snw.mods.ctweaks.object.IntKeyed;
import snw.mods.ctweaks.protocol.handler.ClientboundPacketHandler;

@ToString
@Getter
public class ClientboundAddLayoutPacket extends Packet<ClientboundPacketHandler> {
    public static final String TYPE = "add_layout";

    private final IntKeyed.Descriptor descriptor;

    public ClientboundAddLayoutPacket(IntKeyed.Descriptor descriptor, String nonce) {
        super(nonce);
        this.descriptor = descriptor;
    }

    public ClientboundAddLayoutPacket(ByteArrayDataInput input) {
        super(input);
        this.descriptor = IntKeyed.Descriptor.READER.read(input);
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    protected void doSerialization(ByteArrayDataOutput output) {
        IntKeyed.Descriptor.WRITER.write(output, this.descriptor);
    }

    @Override
    public void handle(ClientboundPacketHandler handler) {
        handler.handleAddLayout(this);
    }
}
