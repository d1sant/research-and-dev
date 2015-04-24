package com.my.research.and.dev.stream;

import java.util.function.Consumer;

public class PrintHandler {

    private Printer printer;

    public PrintHandler() {
        this.printer = new Printer();
    }

    public void print(final Consumer<Printer> toPrint) {
        printer.prepare();
        toPrint.accept(printer);
        printer.sleep();
    }
}
