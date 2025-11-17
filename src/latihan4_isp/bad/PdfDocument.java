package latihan4_isp.bad;

public class PdfDocument implements Document {

    private String name;

    public PdfDocument(String name) {
        this.name = name;
    }

    @Override
    public void read() {
        System.out.println("[PDF] Reading document: " + name);
    }

    @Override
    public void edit(String content) {
        throw new UnsupportedOperationException("PDF documents cannot be edited");
    }

    @Override
    public void print() {
        System.out.println("[PDF] Printing document: " + name);
    }

    @Override
    public void calculate(String formula) {
        throw new UnsupportedOperationException("PDF documents cannot perform calculations");
    }

    @Override
    public void resize(int width, int height) {
        throw new UnsupportedOperationException("PDF documents cannot be resized");
    }
}
