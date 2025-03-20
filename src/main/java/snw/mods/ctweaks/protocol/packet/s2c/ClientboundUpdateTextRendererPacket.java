package snw.mods.ctweaks.protocol.packet.s2c;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;
import snw.lib.protocol.packet.Packet;
import snw.mods.ctweaks.object.pos.PlanePosition;
import snw.mods.ctweaks.protocol.handler.ClientboundPacketHandler;
import snw.mods.ctweaks.protocol.util.PacketReaders;
import snw.mods.ctweaks.protocol.util.PacketWriters;

import static snw.lib.protocol.util.PacketHelper.readNullable;

@Getter
public class ClientboundUpdateTextRendererPacket extends Packet<ClientboundPacketHandler> {
    public static final String TYPE = "update_renderer";

    private final int id;
    private final @Nullable Component text;
    private final @Nullable PlanePosition newPosition;

    public ClientboundUpdateTextRendererPacket(int id, @Nullable Component text, @Nullable PlanePosition newPosition, String nonce) {
        super(nonce);
        this.id = id;
        this.text = text;
        this.newPosition = newPosition;
    }

    public ClientboundUpdateTextRendererPacket(ByteArrayDataInput input) {
        super(input);
        this.id = input.readInt();
        this.text = readNullable(input, PacketReaders.COMPONENT);
        this.newPosition = readNullable(input, PacketReaders.PLANE_POSITION);
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
