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
import snw.mods.ctweaks.protocol.util.ModPacketReaders;
import snw.mods.ctweaks.protocol.util.ModPacketWriters;

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
    private final @Nullable Integer outlineColor;

    public ClientboundUpdateTextRendererPacket(
            int id,
            @Nullable Component text,
            @Nullable PlanePosition newPosition,
            @Nullable Boolean noShadow,
            @Nullable Float scale,
            @Nullable Integer outlineColor,
            String nonce
    ) {
        super(nonce);
        this.id = id;
        this.text = text;
        this.newPosition = newPosition;
        this.noShadow = noShadow;
        this.scale = scale;
        this.outlineColor = outlineColor;
    }

    public ClientboundUpdateTextRendererPacket(ByteArrayDataInput input) {
        super(input);
        this.id = input.readInt();
        this.text = readNullable(input, ModPacketReaders.COMPONENT);
        this.newPosition = readNullable(input, PlanePosition.READER);
        this.noShadow = readNullable(input, ByteArrayDataInput::readBoolean);
        this.scale = readNullable(input, ByteArrayDataInput::readFloat);
        this.outlineColor = readNullable(input, ByteArrayDataInput::readInt);
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    protected void doSerialization(ByteArrayDataOutput output) {
        output.writeInt(this.id);
        writeNullable(output, this.text, ModPacketWriters.COMPONENT);
        writeNullable(output, this.newPosition, PlanePosition.WRITER);
        writeNullable(output, this.noShadow, ByteArrayDataOutput::writeBoolean);
        writeNullable(output, this.scale, ByteArrayDataOutput::writeFloat);
        writeNullable(output, this.outlineColor, ByteArrayDataOutput::writeInt);
    }

    @Override
    public void handle(ClientboundPacketHandler handler) {
        handler.handleUpdateTextRenderer(this);
    }
}
