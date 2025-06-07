package org.example.perpustakaan.Decorator;

import org.example.perpustakaan.Model.Printer;

import java.util.List;

public class LoggingPrinterDecorator extends PrinterDecorator {
    public LoggingPrinterDecorator(Printer printer) {
        super(printer);
    }

    @Override
    public void printText(String idPeminjaman, String nama, String nim, String tanggalPinjam, String tenggat, List<?> books) throws Exception {

    }

    @Override
    public void printBarcode(String id) throws Exception {

    }

    public void print(String text) {
        System.out.println("[LOG] Mulai mencetak...");
        decoratedPrinter.print(text);
        System.out.println("[LOG] Selesai mencetak.");
    }
}

