package snw.mods.ctweaks.protocol.packet.c2s;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import it.unimi.dsi.fastutil.Pair;
import it.unimi.dsi.fastutil.objects.ObjectObjectImmutablePair;
import lombok.Getter;
import lombok.ToString;
import snw.lib.protocol.io.PacketReader;
import snw.lib.protocol.io.PacketWriter;
import snw.lib.protocol.packet.Packet;
import snw.mods.ctweaks.object.IntKeyed;
import snw.mods.ctweaks.object.pos.PlanePosition;
import snw.mods.ctweaks.protocol.handler.ServerboundPacketHandler;
import snw.mods.ctweaks.protocol.util.ModPacketReaders;
import snw.mods.ctweaks.protocol.util.ModPacketWriters;

import java.util.ArrayList;
import java.util.List;

import static snw.lib.protocol.util.PacketHelper.readCollection;
import static snw.lib.protocol.util.PacketHelper.writeCollection;
import static snw.mods.ctweaks.protocol.util.ModPacketReaders.pairReader;
import static snw.mods.ctweaks.protocol.util.ModPacketWriters.pairWriter;

@ToString
@Getter
public class ServerboundSetObjectPlanePosPacket extends Packet<ServerboundPacketHandler> {
    public static final String TYPE = "set_plane_pos";

    private static PacketReader<Pair<IntKeyed.Descriptor, PlanePosition>> targetPairReader() {
        return pairReader(IntKeyed.Descriptor.READER, PlanePosition.READER);
    }

    private static PacketWriter<Pair<IntKeyed.Descriptor, PlanePosition>> targetPairWriter() {
        return pairWriter(IntKeyed.Descriptor.WRITER, PlanePosition.WRITER);
    }

    private final List<Pair<IntKeyed.Descriptor, PlanePosition>> targets;

    public ServerboundSetObjectPlanePosPacket(IntKeyed.Descriptor targetDescriptor, PlanePosition newPosition, String nonce) {
        super(nonce);
        this.targets = List.of(ObjectObjectImmutablePair.of(targetDescriptor, newPosition));
    }

    public ServerboundSetObjectPlanePosPacket(List<Pair<IntKeyed.Descriptor, PlanePosition>> targets, String nonce) {
        super(nonce);
        this.targets = targets;
    }

    public ServerboundSetObjectPlanePosPacket(ByteArrayDataInput input) {
        super(input);
        this.targets = readCollection(input, ArrayList::new, targetPairReader());
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    protected void doSerialization(ByteArrayDataOutput output) {
        writeCollection(output, this.targets, targetPairWriter());
    }

    @Override
    public void handle(ServerboundPacketHandler handler) {
        handler.handleSetPlanePos(this);
    }
}
