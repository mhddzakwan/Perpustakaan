package org.example.perpustakaan.Decorator;

import org.example.perpustakaan.Model.Printer;

import java.util.List;

public class WatermarkPrinterDecorator extends PrinterDecorator {

    public WatermarkPrinterDecorator(Printer printer) {
        super(printer);
    }

    @Override
    public void printText(String idPeminjaman, String nama, String nim, String tanggalPinjam, String tenggat, List<?> books) throws Exception {

    }

    @Override
    public void printBarcode(String id) throws Exception {

    }

    public void print(String text) {
        decoratedPrinter.print(text + "\n--- Sedang mencetak");
    }
}

