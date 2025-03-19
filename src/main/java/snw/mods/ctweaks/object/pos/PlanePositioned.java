package snw.mods.ctweaks.object.pos;

public interface PlanePositioned {
    PlanePosition getPosition();

    void setPosition(int x, int y);

    void setPosition(PlanePosition position);
}
