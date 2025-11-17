package latihan4_isp.good;

public class ImageDocument implements Readable, Resizable {
    private String name;

    public ImageDocument(String name) {
        this.name = name;
    }

    @Override
    public void read() {
        System.out.println("[ImageDocument] Reading Image: " + name);
    }

    @Override
    public void resize(int width, int height) {
        System.out.println("[ImageDocument] Resizing Image: " + name + " to " + width + "x" + height);
    }
}
