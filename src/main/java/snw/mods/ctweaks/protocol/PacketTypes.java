package snw.mods.ctweaks.protocol;

import snw.lib.protocol.packet.type.PacketTypeSet;
import snw.mods.ctweaks.protocol.handler.ClientboundPacketHandler;
import snw.mods.ctweaks.protocol.handler.ServerboundPacketHandler;
import snw.mods.ctweaks.protocol.packet.c2s.*;
import snw.mods.ctweaks.protocol.packet.s2c.*;

public final class PacketTypes {
    public static final PacketTypeSet<ServerboundPacketHandler> CLIENTSIDE;
    public static final PacketTypeSet<ClientboundPacketHandler> SERVERSIDE;

    static {
        CLIENTSIDE = new PacketTypeSet<>() {
            {
                register(ServerboundReadyPacket.TYPE, ServerboundReadyPacket::new);
                register(ServerboundSetObjectPlanePosPacket.TYPE, ServerboundSetObjectPlanePosPacket::new);
                register(ServerboundWindowPropertiesPacket.TYPE, ServerboundWindowPropertiesPacket::new);
            }
        };
        SERVERSIDE = new PacketTypeSet<>() {
            {
                register(ClientboundAddLayoutPacket.TYPE, ClientboundAddLayoutPacket::new);
                register(ClientboundAddRendererPacket.TYPE, ClientboundAddRendererPacket::new);
                register(ClientboundClearLayoutPacket.TYPE, ClientboundClearLayoutPacket::new);
                register(ClientboundClearRendererPacket.TYPE, ClientboundClearRendererPacket::new);
                register(ClientboundHelloPacket.TYPE, ClientboundHelloPacket::new);
                register(ClientboundRemoveLayoutPacket.TYPE, ClientboundRemoveLayoutPacket::new);
                register(ClientboundRemoveRendererPacket.TYPE, ClientboundRemoveRendererPacket::new);
                register(ClientboundUpdateGridLayoutPacket.TYPE, ClientboundUpdateGridLayoutPacket::new);
                register(ClientboundUpdateLinearLayoutPacket.TYPE, ClientboundUpdateLinearLayoutPacket::new);
                register(ClientboundUpdatePlayerFaceRendererPacket.TYPE, ClientboundUpdatePlayerFaceRendererPacket::new);
                register(ClientboundUpdateTextRendererPacket.TYPE, ClientboundUpdateTextRendererPacket::new);
            }
        };
    }

    private PacketTypes() {
    }
}
