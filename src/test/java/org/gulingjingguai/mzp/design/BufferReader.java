package org.gulingjingguai.mzp.design;

public class BufferReader extends Reader_{
    private Reader_ reader_;

    public BufferReader(Reader_ reader_) {
        this.reader_ = reader_;
    }

    @Override
    public void readFile() {
        this.reader_.readFile();
    }

    @Override
    public void readString() {
        this.reader_.readString();
    }
}
