package snw.mods.ctweaks.protocol.packet.c2s;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import lombok.Getter;
import lombok.ToString;
import snw.lib.protocol.packet.Packet;
import snw.mods.ctweaks.protocol.handler.ServerboundPacketHandler;

@ToString
@Getter
public class ServerboundWindowPropertiesPacket extends Packet<ServerboundPacketHandler> {
    public static final String TYPE = "screen_status";

    private final int width;
    private final int height;
    private final boolean nowFullScreen;

    public ServerboundWindowPropertiesPacket(int width, int height, boolean nowFullScreen, String nonce) {
        super(nonce);
        this.width = width;
        this.height = height;
        this.nowFullScreen = nowFullScreen;
    }

    protected ServerboundWindowPropertiesPacket(ByteArrayDataInput input) {
        super(input);
        this.width = input.readInt();
        this.height = input.readInt();
        this.nowFullScreen = input.readBoolean();
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    protected void doSerialization(ByteArrayDataOutput output) {
        output.writeInt(this.width);
        output.writeInt(this.height);
        output.writeBoolean(this.nowFullScreen);
    }

    @Override
    public void handle(ServerboundPacketHandler handler) {
        handler.handleWindowProperties(this);
    }
}
