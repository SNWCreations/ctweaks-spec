package snw.mods.ctweaks.protocol.packet.s2c;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import lombok.Getter;
import lombok.ToString;
import snw.lib.protocol.packet.Packet;
import snw.mods.ctweaks.protocol.handler.ClientboundPacketHandler;

@ToString
@Getter
public class ClientboundRemoveRendererPacket extends Packet<ClientboundPacketHandler> {
    public static final String TYPE = "remove_renderer";

    private final int id;

    public ClientboundRemoveRendererPacket(int id, String nonce) {
        super(nonce);
        this.id = id;
    }

    public ClientboundRemoveRendererPacket(ByteArrayDataInput input) {
        super(input);
        this.id = input.readInt();
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public void handle(ClientboundPacketHandler handler) {
        handler.handleRemoveRenderer(this);
    }

    @Override
    protected void doSerialization(ByteArrayDataOutput output) {
        output.writeInt(this.id);
    }
}
