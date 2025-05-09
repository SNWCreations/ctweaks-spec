package snw.mods.ctweaks.protocol.packet.c2s;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import lombok.Getter;
import lombok.ToString;
import snw.lib.protocol.packet.Packet;
import snw.mods.ctweaks.object.IntKeyed;
import snw.mods.ctweaks.object.pos.PlanePosition;
import snw.mods.ctweaks.protocol.handler.ServerboundPacketHandler;
import snw.mods.ctweaks.protocol.util.ModPacketReaders;

@ToString
@Getter
public class ServerboundSetObjectPlanePosPacket extends Packet<ServerboundPacketHandler> {
    public static final String TYPE = "set_plane_pos";

    private final IntKeyed.Descriptor targetDescriptor;
    private final PlanePosition newPosition;

    public ServerboundSetObjectPlanePosPacket(IntKeyed.Descriptor targetDescriptor, PlanePosition newPosition, String nonce) {
        super(nonce);
        this.targetDescriptor = targetDescriptor;
        this.newPosition = newPosition;
    }

    public ServerboundSetObjectPlanePosPacket(ByteArrayDataInput input) {
        super(input);
        this.targetDescriptor = IntKeyed.Descriptor.READER.read(input);
        this.newPosition = ModPacketReaders.PLANE_POSITION.read(input);
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    protected void doSerialization(ByteArrayDataOutput output) {
        IntKeyed.Descriptor.WRITER.write(output, this.targetDescriptor);
    }

    @Override
    public void handle(ServerboundPacketHandler handler) {
        handler.handleSetPlanePos(this);
    }
}
