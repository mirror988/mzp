package org.gulingjingguai.mzp.design;

public class Design {
    public static void main(String[] args) {
        BufferReader bufferFileReader = new BufferReader(new FileReader_());

        bufferFileReader.readFile();

        BufferReader bufferStringReader = new BufferReader(new StringReader_());

        bufferStringReader.readString();
    }
}
