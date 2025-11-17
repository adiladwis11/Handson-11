package latihan4_isp.bad;

public class ImageDocument implements Document {

    private String name;

    public ImageDocument(String name) {
        this.name = name;
    }

    @Override
    public void read() {
        System.out.println("[IMAGE] Reading image: " + name);
    }

    @Override
    public void edit(String content) {
        throw new UnsupportedOperationException("Image documents cannot be edited");
    }

    @Override
    public void print() {
        throw new UnsupportedOperationException("Image documents cannot be printed");
    }

    @Override
    public void calculate(String formula) {
        throw new UnsupportedOperationException("Image documents cannot perform calculations");
    }

    @Override
    public void resize(int width, int height) {
        System.out.println("[IMAGE] Resizing image: " + name + " to " + width + "x" + height);
    }
}
