package snw.mods.ctweaks.protocol.packet.s2c;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import lombok.Getter;
import lombok.ToString;
import snw.lib.protocol.packet.Packet;
import snw.mods.ctweaks.protocol.handler.ClientboundPacketHandler;

@ToString
@Getter
public class ClientboundHelloPacket extends Packet<ClientboundPacketHandler> {
    public static final String TYPE = "hello";

    private final int protocolVersion;

    public ClientboundHelloPacket(int protocolVersion, String nonce) {
        super(nonce);
        this.protocolVersion = protocolVersion;
    }

    public ClientboundHelloPacket(ByteArrayDataInput input) {
        super(input);
        this.protocolVersion = input.readInt();
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    protected void doSerialization(ByteArrayDataOutput output) {
        output.writeInt(this.protocolVersion);
    }

    @Override
    public void handle(ClientboundPacketHandler handler) {
        handler.handleHello(this);
    }
}
