package snw.mods.ctweaks.protocol.packet.s2c;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;
import snw.lib.protocol.io.PacketReaders;
import snw.lib.protocol.io.PacketWriters;
import snw.lib.protocol.packet.Packet;
import snw.mods.ctweaks.object.IntIdentified;
import snw.mods.ctweaks.object.pos.PlanePosition;
import snw.mods.ctweaks.protocol.handler.ClientboundPacketHandler;

import java.util.UUID;

import static snw.lib.protocol.util.PacketHelper.readNullable;
import static snw.lib.protocol.util.PacketHelper.writeNullable;

@ToString
@Getter
public class ClientboundUpdatePlayerFaceRendererPacket extends Packet<ClientboundPacketHandler> implements IntIdentified {
    public static final String TYPE = "update_player_face_renderer";

    private final int id;
    private final UUID target;
    private final @Nullable PlanePosition position;
    private final @Nullable Integer size;

    public ClientboundUpdatePlayerFaceRendererPacket(int id, UUID target, @Nullable PlanePosition position, @Nullable Integer size, String nonce) {
        super(nonce);
        this.id = id;
        this.target = target;
        this.position = position;
        this.size = size;
    }

    public ClientboundUpdatePlayerFaceRendererPacket(ByteArrayDataInput input) {
        super(input);
        this.id = input.readInt();
        this.target = PacketReaders.UUID.read(input);
        this.position = readNullable(input, snw.mods.ctweaks.protocol.util.PacketReaders.PLANE_POSITION);
        this.size = readNullable(input, ByteArrayDataInput::readInt);
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    protected void doSerialization(ByteArrayDataOutput output) {
        output.writeInt(this.id);
        PacketWriters.UUID.write(output, this.target);
        writeNullable(output, this.position, snw.mods.ctweaks.protocol.util.PacketWriters.PLANE_POSITION);
        writeNullable(output, this.size, ByteArrayDataOutput::writeInt);
    }

    @Override
    public void handle(ClientboundPacketHandler handler) {
        handler.handleUpdatePlayerFaceRenderer(this);
    }
}
