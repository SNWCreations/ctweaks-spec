package snw.mods.ctweaks.protocol.packet.s2c;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;
import snw.lib.protocol.packet.Packet;
import snw.lib.protocol.util.PacketHelper;
import snw.mods.ctweaks.object.IntIdentified;
import snw.mods.ctweaks.object.IntKeyed;
import snw.mods.ctweaks.object.Orientation;
import snw.mods.ctweaks.object.pos.PlanePosition;
import snw.mods.ctweaks.object.range.Rectangle;
import snw.mods.ctweaks.protocol.handler.ClientboundPacketHandler;
import snw.mods.ctweaks.protocol.util.ModPacketReaders;
import snw.mods.ctweaks.protocol.util.ModPacketWriters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static snw.lib.protocol.io.PacketReaders.optionalReader;
import static snw.lib.protocol.io.PacketWriters.optionalWriter;
import static snw.lib.protocol.util.PacketHelper.*;

@ToString
@Getter
@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class ClientboundUpdateLinearLayoutPacket extends Packet<ClientboundPacketHandler> implements IntIdentified {
    public static final String TYPE = "update_linear_layout";

    private final int id;
    private final @Nullable List<IntKeyed.Descriptor> newElements;
    private final @Nullable PlanePosition newPosition;
    private final @Nullable Optional<Rectangle> newRange;
    private final @Nullable Orientation newOrientation;
    private final @Nullable Integer newSpacing;

    public ClientboundUpdateLinearLayoutPacket(
            int id,
            @Nullable List<IntKeyed.Descriptor> newElements,
            @Nullable PlanePosition newPosition,
            @Nullable Optional<Rectangle> newRange,
            @Nullable Orientation newOrientation,
            @Nullable Integer newSpacing,
            String nonce
    ) {
        super(nonce);
        this.id = id;
        this.newElements = newElements;
        this.newPosition = newPosition;
        this.newRange = newRange;
        this.newOrientation = newOrientation;
        this.newSpacing = newSpacing;
    }

    public ClientboundUpdateLinearLayoutPacket(ByteArrayDataInput input) {
        super(input);
        this.id = input.readInt();
        this.newElements = readNullable(input, in -> readCollection(in, ArrayList::new, IntKeyed.Descriptor.READER));
        this.newPosition = readNullable(input, PlanePosition.READER);
        this.newRange = readNullable(input, optionalReader(Rectangle.READER));
        this.newOrientation = ModPacketReaders.ORIENTATION.read(input);
        this.newSpacing = readNullable(input, ByteArrayDataInput::readInt);
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    protected void doSerialization(ByteArrayDataOutput output) {
        output.writeInt(this.id);
        writeNullable(output, this.newElements, (out, list) -> writeCollection(out, list, IntKeyed.Descriptor.WRITER));
        writeNullable(output, this.newPosition, PlanePosition.WRITER);
        writeNullable(output, this.newRange, optionalWriter(Rectangle.WRITER));
        PacketHelper.writeEnum(output, this.newOrientation);
        writeNullable(output, this.newSpacing, ByteArrayDataOutput::writeInt);
    }

    @Override
    public void handle(ClientboundPacketHandler handler) {
        handler.handleUpdateLinearLayout(this);
    }

}
