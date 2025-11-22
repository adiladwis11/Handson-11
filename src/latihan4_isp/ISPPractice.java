package latihan4_isp;

// import latihan4_isp.good.*; // Uncomment setelah refactoring selesai

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
         *
         * Tujuan Latihan:
         * 1. Memahami masalah fat interface
         * 2. Belajar mengidentifikasi capabilities yang berbeda
         * 3. Memisahkan interface besar menjadi interface-interface capability-based
         * 4. Merasakan benefits dari ISP
         */

        // ===== PART 1: BAD PRACTICE - Melanggar ISP =====
        System.out.println("=== BAD PRACTICE: Melanggar ISP ===\n");

        System.out.println("--- Testing PDF Document ---");
        latihan4_isp.bad.Document pdf = new latihan4_isp.bad.PdfDocument("Contract.pdf");
        pdf.read(); // PDF bisa dibaca
        pdf.print(); // PDF bisa dicetak

        System.out.println("\nTrying to edit PDF (not supported):");
        try {
            pdf.edit("New content");
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\n--- Testing Image Document ---");
        latihan4_isp.bad.Document image = new latihan4_isp.bad.ImageDocument("Photo.jpg");
        image.read(); // Image bisa dibaca

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
         * INSTRUKSI REFACTORING:
         *
         * 1. Buka folder good/
         * 2. Lengkapi interface-interface berikut dengan uncomment dan isi implementation:
         *
         *    a. Readable.java
         *       - Capability: Membaca dokumen
         *       - Method: read()
         *
         *    b. Editable.java
         *       - Capability: Mengedit dokumen
         *       - Method: edit(String content)
         *
         *    c. Printable.java
         *       - Capability: Mencetak dokumen
         *       - Method: print()
         *
         *    d. Calculable.java
         *       - Capability: Melakukan kalkulasi (untuk spreadsheet)
         *       - Method: calculate(String formula)
         *
         *    e. Resizable.java
         *       - Capability: Mengubah ukuran (untuk image)
         *       - Method: resize(int width, int height)
         *
         *    f. PdfDocument.java
         *       - Implement: Readable, Printable
         *       - PDF hanya bisa dibaca dan dicetak
         *
         *    g. WordDocument.java
         *       - Implement: Readable, Editable, Printable
         *       - Word bisa dibaca, diedit, dan dicetak
         *
         *    h. SpreadsheetDocument.java
         *       - Implement: Readable, Editable, Printable, Calculable
         *       - Spreadsheet full-featured
         *
         *    i. ImageDocument.java
         *       - Implement: Readable, Resizable
         *       - Image hanya bisa dibaca dan diresize
         *
         * 3. Setelah selesai, uncomment code di bawah untuk testing
         */

        // UNCOMMENT CODE DI BAWAH SETELAH REFACTORING SELESAI
        /*
        System.out.println("--- Testing PDF Document ---");
        PdfDocument goodPdf = new PdfDocument("Contract.pdf");
        goodPdf.read();
        goodPdf.print();
        // goodPdf.edit(); // COMPILE ERROR - method tidak ada, tidak perlu throw exception

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
        // goodImage.print(); // COMPILE ERROR - method tidak ada

        System.out.println("\n--- Polymorphic Usage ---");
        // Bisa menggunakan interface sesuai kebutuhan
        Readable readable1 = new PdfDocument("Doc1.pdf");
        Readable readable2 = new ImageDocument("Image1.jpg");
        readable1.read();
        readable2.read();

        // Hanya dokumen yang printable yang bisa masuk ke list ini
        List<Printable> printableDocuments = new ArrayList<>();
        printableDocuments.add(new PdfDocument("Doc.pdf"));
        printableDocuments.add(new WordDocument("Report.docx"));
        printableDocuments.add(new SpreadsheetDocument("Data.xlsx"));
        // printableDocuments.add(new ImageDocument("Photo.jpg")); // COMPILE ERROR - bagus!

        System.out.println("\nPrinting all printable documents:");
        for (Printable doc : printableDocuments) {
            doc.print();
        }

        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println("✓ Focused - Setiap interface punya capability yang jelas dan spesifik");
        System.out.println("✓ Flexible - Class hanya implement capability yang benar-benar dimiliki");
        System.out.println("✓ Type-safe - Compile-time checking, bukan runtime exception");
        System.out.println("✓ Clean - Tidak ada method yang throw UnsupportedOperationException");
        System.out.println("✓ Extensible - Mudah tambah document type baru dengan capability mix & match");
        */

        /*
         * EKSPEKTASI OUTPUT:
         *
         * === BAD PRACTICE: Melanggar ISP ===
         *
         * --- Testing PDF Document ---
         * [PDF] Reading document: Contract.pdf
         * [PDF] Printing document: Contract.pdf
         *
         * Trying to edit PDF (not supported):
         * ERROR: PDF documents cannot be edited
         *
         * --- Testing Image Document ---
         * [IMAGE] Reading image: Photo.jpg
         *
         * Trying to print image (not supported):
         * ERROR: Image documents cannot be printed
         *
         * --- Analisis Masalah ---
         * Document interface terlalu BESAR (FAT INTERFACE):
         * 1. read() - semua dokumen butuh ✓
         * 2. edit() - hanya Word & Spreadsheet butuh ✗
         * 3. print() - PDF, Word, Spreadsheet butuh (Image tidak) ✗
         * 4. calculate() - hanya Spreadsheet butuh ✗
         * 5. resize() - hanya Image butuh ✗
         *
         * PDF & Image dipaksa implement method yang tidak digunakan!
         * Banyak method yang hanya throw UnsupportedOperationException!
         * Interface tidak fleksibel = MELANGGAR ISP!
         *
         * ======================================================================
         *
         * === GOOD PRACTICE: Mengikuti ISP ===
         *
         * --- Testing PDF Document ---
         * [PdfDocument] Reading PDF: Contract.pdf
         * [PdfDocument] Printing PDF: Contract.pdf
         *
         * --- Testing Word Document ---
         * [WordDocument] Reading Word: Report.docx
         * [WordDocument] Editing Word: Report.docx with content: Updated content for report
         * [WordDocument] Printing Word: Report.docx
         *
         * --- Testing Spreadsheet Document ---
         * [SpreadsheetDocument] Reading Spreadsheet: Budget.xlsx
         * [SpreadsheetDocument] Editing Spreadsheet: Budget.xlsx with content: A1: 1000
         * [SpreadsheetDocument] Calculating formula: SUM(A1:A10) = 5500
         * [SpreadsheetDocument] Printing Spreadsheet: Budget.xlsx
         *
         * --- Testing Image Document ---
         * [ImageDocument] Reading Image: Photo.jpg
         * [ImageDocument] Resizing Image: Photo.jpg to 800x600
         *
         * --- Polymorphic Usage ---
         * [PdfDocument] Reading PDF: Doc1.pdf
         * [ImageDocument] Reading Image: Image1.jpg
         *
         * Printing all printable documents:
         * [PdfDocument] Printing PDF: Doc.pdf
         * [WordDocument] Printing Word: Report.docx
         * [SpreadsheetDocument] Printing Spreadsheet: Data.xlsx
         *
         * --- Keuntungan Setelah Refactoring ---
         * ✓ Focused - Setiap interface punya capability yang jelas dan spesifik
         * ✓ Flexible - Class hanya implement capability yang benar-benar dimiliki
         * ✓ Type-safe - Compile-time checking, bukan runtime exception
         * ✓ Clean - Tidak ada method yang throw UnsupportedOperationException
         * ✓ Extensible - Mudah tambah document type baru dengan capability mix & match
         */
    }
}