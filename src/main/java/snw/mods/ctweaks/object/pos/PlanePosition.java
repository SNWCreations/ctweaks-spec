package snw.mods.ctweaks.object.pos;

public record PlanePosition(int x, int y) {
    public interface Getter {
        PlanePosition getPosition();
    }
}
