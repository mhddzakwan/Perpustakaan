package org.example.perpustakaan.Decorator;

import org.example.perpustakaan.Model.Printer;

public abstract class PrinterDecorator implements Printer {
    protected Printer decoratedPrinter;

    public PrinterDecorator(Printer printer) {
        this.decoratedPrinter = printer;
    }

    public void print(String text) {
        decoratedPrinter.print(text); // default behavior
    }
}

