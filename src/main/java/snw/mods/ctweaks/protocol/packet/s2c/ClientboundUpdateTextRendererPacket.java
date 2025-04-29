package snw.mods.ctweaks.protocol.packet.s2c;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import lombok.Getter;
import lombok.ToString;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;
import snw.lib.protocol.packet.Packet;
import snw.mods.ctweaks.object.IntIdentified;
import snw.mods.ctweaks.object.pos.PlanePosition;
import snw.mods.ctweaks.protocol.handler.ClientboundPacketHandler;
import snw.mods.ctweaks.protocol.util.PacketReaders;
import snw.mods.ctweaks.protocol.util.PacketWriters;

import static snw.lib.protocol.util.PacketHelper.readNullable;
import static snw.lib.protocol.util.PacketHelper.writeNullable;

@ToString
@Getter
public class ClientboundUpdateTextRendererPacket extends Packet<ClientboundPacketHandler> implements IntIdentified {
    public static final String TYPE = "update_text_renderer";

    private final int id;
    private final @Nullable Component text;
    private final @Nullable PlanePosition newPosition;
    private final @Nullable Boolean noShadow;
    private final @Nullable Float scale;

    public ClientboundUpdateTextRendererPacket(
            int id,
            @Nullable Component text,
            @Nullable PlanePosition newPosition,
            @Nullable Boolean noShadow,
            @Nullable Float scale,
            String nonce
    ) {
        super(nonce);
        this.id = id;
        this.text = text;
        this.newPosition = newPosition;
        this.noShadow = noShadow;
        this.scale = scale;
    }

    public ClientboundUpdateTextRendererPacket(ByteArrayDataInput input) {
        super(input);
        this.id = input.readInt();
        this.text = readNullable(input, PacketReaders.COMPONENT);
        this.newPosition = readNullable(input, PacketReaders.PLANE_POSITION);
        this.noShadow = readNullable(input, ByteArrayDataInput::readBoolean);
        this.scale = readNullable(input, ByteArrayDataInput::readFloat);
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    protected void doSerialization(ByteArrayDataOutput output) {
        output.writeInt(this.id);
        writeNullable(output, this.text, PacketWriters.COMPONENT);
        writeNullable(output, this.newPosition, PacketWriters.PLANE_POSITION);
        writeNullable(output, this.noShadow, ByteArrayDataOutput::writeBoolean);
        writeNullable(output, this.scale, ByteArrayDataOutput::writeFloat);
    }

    @Override
    public void handle(ClientboundPacketHandler handler) {
        handler.handleUpdateTextRenderer(this);
    }
}
