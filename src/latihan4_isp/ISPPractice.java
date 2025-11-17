package latihan4_isp;

import latihan4_isp.bad.*;
// import latihan4_isp.good.*; // Uncomment setelah refactoring selesai
// import java.util.ArrayList;
// import java.util.List;

public class ISPPractice {
    public static void main(String[] args) {

        /*
         * LATIHAN 4: INTERFACE SEGREGATION PRINCIPLE (ISP)
         *
         * Definisi:
         * "A client should not be forced to depend on methods it does not use."
         *
         * Konteks:
         * Document Management System - mengelola berbagai jenis dokumen
         */

        // ===== PART 1: BAD PRACTICE - Melanggar ISP =====
        System.out.println("=== BAD PRACTICE: Melanggar ISP ===\n");

        System.out.println("--- Testing PDF Document ---");
        Document pdf = new PdfDocument("Contract.pdf");
        pdf.read(); // PDF bisa dibaca
        pdf.print(); // PDF bisa dicetak

        System.out.println("\nTrying to edit PDF (not supported):");
        try {
            pdf.edit("New content");
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\n--- Testing Image Document ---");
        Document image = new ImageDocument("Photo.jpg");
        image.read();

        System.out.println("\nTrying to print image (not supported):");
        try {
            image.print();
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\n--- Analisis Masalah ---");
        System.out.println("Document interface terlalu BESAR (FAT INTERFACE):");
        System.out.println("1. read() - semua dokumen butuh ✓");
        System.out.println("2. edit() - hanya Word & Spreadsheet butuh ✗");
        System.out.println("3. print() - PDF, Word, Spreadsheet butuh (Image tidak) ✗");
        System.out.println("4. calculate() - hanya Spreadsheet butuh ✗");
        System.out.println("5. resize() - hanya Image butuh ✗");
        System.out.println("\nPDF & Image dipaksa implement method yang tidak digunakan!");
        System.out.println("Banyak method yang hanya throw UnsupportedOperationException!");
        System.out.println("Interface tidak fleksibel = MELANGGAR ISP!");

        System.out.println("\n" + "=".repeat(70));


        // ===== PART 2: GOOD PRACTICE - Mengikuti ISP =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti ISP ===\n");

        /*
         * INSTRUKSI:
         * 1. Buka folder good/
         * 2. Buat interface Readable, Editable, Printable, Calculable, Resizable
         * 3. Buat class PdfDocument, WordDocument, SpreadsheetDocument, ImageDocument
         * 4. Setelah selesai → UNCOMMENT CODE di bawah
         */

        /*
        System.out.println("--- Testing PDF Document ---");
        PdfDocument goodPdf = new PdfDocument("Contract.pdf");
        goodPdf.read();
        goodPdf.print();

        System.out.println("\n--- Testing Word Document ---");
        WordDocument word = new WordDocument("Report.docx");
        word.read();
        word.edit("Updated content for report");
        word.print();

        System.out.println("\n--- Testing Spreadsheet Document ---");
        SpreadsheetDocument spreadsheet = new SpreadsheetDocument("Budget.xlsx");
        spreadsheet.read();
        spreadsheet.edit("A1: 1000");
        spreadsheet.calculate("SUM(A1:A10)");
        spreadsheet.print();

        System.out.println("\n--- Testing Image Document ---");
        ImageDocument goodImage = new ImageDocument("Photo.jpg");
        goodImage.read();
        goodImage.resize(800, 600);

        System.out.println("\n--- Polymorphic Usage ---");
        Readable readable1 = new PdfDocument("Doc1.pdf");
        Readable readable2 = new ImageDocument("Image1.jpg");
        readable1.read();
        readable2.read();

        List<Printable> printableDocuments = new ArrayList<>();
        printableDocuments.add(new PdfDocument("Doc.pdf"));
        printableDocuments.add(new WordDocument("Report.docx"));
        printableDocuments.add(new SpreadsheetDocument("Data.xlsx"));

        System.out.println("\nPrinting all printable documents:");
        for (Printable doc : printableDocuments) {
            doc.print();
        }

        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println(\"✓ Focused - Interface lebih kecil & spesifik\");
        System.out.println(\"✓ Flexible - Class hanya implement kemampuan yang dimiliki\");
        System.out.println(\"✓ Type-safe - Tidak ada error runtime karena method tidak relevan\");
        System.out.println(\"✓ Clean - Tidak ada UnsupportedOperationException\");
        System.out.println(\"✓ Extensible - Mudah tambah jenis dokumen baru\");
        */
    }
}
