package latihan4_isp.bad;

public class WordDocument implements Document {

    private String name;

    public WordDocument(String name) {
        this.name = name;
    }

    @Override
    public void read() {
        System.out.println("[WORD] Reading Word document: " + name);
    }

    @Override
    public void edit(String content) {
        System.out.println("[WORD] Editing Word document: " + name + " with content: " + content);
    }

    @Override
    public void print() {
        System.out.println("[WORD] Printing Word document: " + name);
    }

    @Override
    public void calculate(String formula) {
        throw new UnsupportedOperationException("Word documents cannot calculate formulas");
    }

    @Override
    public void resize(int width, int height) {
        throw new UnsupportedOperationException("Word documents cannot be resized");
    }
}
