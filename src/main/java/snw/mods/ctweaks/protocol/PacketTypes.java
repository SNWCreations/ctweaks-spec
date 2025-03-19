package snw.mods.ctweaks.protocol;

import snw.lib.protocol.packet.type.PacketTypeSet;
import snw.mods.ctweaks.protocol.handler.ClientboundPacketHandler;
import snw.mods.ctweaks.protocol.handler.ServerboundPacketHandler;
import snw.mods.ctweaks.protocol.packet.s2c.ClientboundAddRendererPacket;
import snw.mods.ctweaks.protocol.packet.s2c.ClientboundRemoveRendererPacket;

public final class PacketTypes {
    public static final PacketTypeSet<ServerboundPacketHandler> CLIENTSIDE;
    public static final PacketTypeSet<ClientboundPacketHandler> SERVERSIDE;

    static {
        CLIENTSIDE = new PacketTypeSet<>() {
            {
            }
        };
        SERVERSIDE = new PacketTypeSet<>() {
            {
                register(ClientboundAddRendererPacket.TYPE, ClientboundAddRendererPacket::new);
                register(ClientboundRemoveRendererPacket.TYPE, ClientboundRemoveRendererPacket::new);
            }
        };
    }

    private PacketTypes() {
    }
}
