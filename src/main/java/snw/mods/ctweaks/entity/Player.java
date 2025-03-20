package snw.mods.ctweaks.entity;

import java.util.UUID;

public interface Player {
    UUID getUUID();

    Screen getScreen();

    boolean isOnline();
}
