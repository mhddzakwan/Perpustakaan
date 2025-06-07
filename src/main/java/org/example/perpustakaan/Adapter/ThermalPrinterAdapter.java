package org.example.perpustakaan.Adapter;

import org.example.perpustakaan.Model.BookRow;
import org.example.perpustakaan.Model.Printer;

import javax.print.*;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class ThermalPrinterAdapter implements Printer {

    public void printText(String idPeminjaman, String nama, String nim, String tanggalPinjam, String tenggat, List<?> books) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append((char) 27).append((char) 97).append((char) 1); // Center
        sb.append("PERPUSTAKAAN\n========================\n\n");
        sb.append((char) 27).append((char) 97).append((char) 0); // Left
        sb.append("ID Peminjaman : ").append(idPeminjaman).append("\n");
        sb.append("Nama          : ").append(nama).append("\n");
        sb.append("NIM           : ").append(nim).append("\n");
        sb.append("Peminjaman    : ").append(tanggalPinjam).append("\n");
        sb.append("Deadline      : ").append(tenggat).append("\n");
        sb.append("----------------------------\nDaftar Buku:\n");

        for (Object obj : books) {
            BookRow book = (BookRow) obj;
            sb.append("- ").append(book.getId()).append(" : ").append(book.getTitle()).append("\n");
        }

        sb.append("\nTerima kasih!\n============================\n");
        sb.append((char) 27).append((char) 100).append((char) 4); // Feed
        sb.append((char) 29).append((char) 86).append((char) 66).append((char) 0); // Cut

        byte[] bytes = sb.toString().getBytes("Cp437");
        sendToPrinter(bytes);
    }

    @Override
    public void printBarcode(String id) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(new byte[]{0x1B, 0x61, 0x01});
        outputStream.write("PERPUSTAKAAN\n\n".getBytes("Cp437"));
        outputStream.write(new byte[]{0x1D, 0x48, 0x02});
        outputStream.write(new byte[]{0x1D, 0x66, 0x00});
        outputStream.write(new byte[]{0x1D, 0x77, 0x02});
        outputStream.write(new byte[]{0x1D, 0x68, 0x50});
        outputStream.write(new byte[]{0x1D, 0x6B, 0x04});
        outputStream.write(id.getBytes("US-ASCII"));
        outputStream.write(0x00);
        outputStream.write("\n\n".getBytes("Cp437"));
        outputStream.write(new byte[]{0x1D, 0x56, 0x42, 0x00});

        sendToPrinter(outputStream.toByteArray());
    }

    private void sendToPrinter(byte[] data) throws Exception {
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        PrintService[] services = PrintServiceLookup.lookupPrintServices(flavor, null);
        PrintService thermalPrinter = null;

        for (PrintService service : services) {
            if (service.getName().toLowerCase().contains("thermal")) {
                thermalPrinter = service;
                break;
            }
        }

        if (thermalPrinter != null) {
            DocPrintJob job = thermalPrinter.createPrintJob();
            Doc doc = new SimpleDoc(data, flavor, null);
            job.print(doc, null);
        } else {
            System.out.println("PrinterThermal thermal tidak ditemukan.");
        }
    }

    @Override
    public void print(String content) {
        // logika koneksi ke printer dan kirim data
        System.out.println("Printing to thermal printer: " + content);
    }
}
