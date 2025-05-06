package snw.mods.ctweaks.protocol.packet.s2c;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import lombok.Getter;
import lombok.ToString;
import net.kyori.adventure.key.Key;
import snw.lib.protocol.packet.Packet;
import snw.mods.ctweaks.object.IntKeyed;
import snw.mods.ctweaks.protocol.handler.ClientboundPacketHandler;

@ToString
@Getter
public class ClientboundAddRendererPacket extends Packet<ClientboundPacketHandler> {
    public static final String TYPE = "add_renderer";

    private final IntKeyed.Descriptor descriptor;

    @Deprecated
    public ClientboundAddRendererPacket(int id, Key rendererType, String nonce) {
        this(new IntKeyed.Descriptor(id, rendererType), nonce);
    }

    public ClientboundAddRendererPacket(IntKeyed.Descriptor descriptor, String nonce) {
        super(nonce);
        this.descriptor = descriptor;
    }

    public ClientboundAddRendererPacket(ByteArrayDataInput input) {
        super(input);
        this.descriptor = IntKeyed.Descriptor.READER.read(input);
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
        IntKeyed.Descriptor.WRITER.write(output, this.descriptor);
    }
}
