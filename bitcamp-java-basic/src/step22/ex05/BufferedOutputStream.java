package step22.ex05;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStream extends FileOutputStream {
    byte[] buf = new byte[8196];
    int cursor;
    
    
    public BufferedOutputStream(String filename) throws FileNotFoundException {
        super(filename);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void write(int b) throws IOException {
        // 버퍼가 다차면 버퍼에 있는 바이트를 한번에 출력할 것이다.
        if (cursor == buf.length) { // 버퍼가 다 차면            ---> 버퍼에 남아있는 데이터가 존재할수도 있기 때문에 close() 오버라이딩
            this.write(buf); // 버퍼에 들어있는 데이터를 한 번에 출력한다.
            cursor = 0; // 다시 cursor를 0으로 초기화시킨다.
        }
        // 1바이트 출력하라고 하면 일단 버퍼에 저장할 것이다.
        buf[cursor++] = (byte)b;
    }

    @Override
    public void close() throws IOException {
        this.flush();
        super.close();
    }
    
    // close() 하지 않아도 버퍼에 남아있는 데이터가 있으면 출력해라.
    @Override
    public void flush() throws IOException {
        if (cursor > 0) { // 버퍼에 남아있는 데이터가 있다면
            this.write(buf, 0, cursor);
            cursor = 0;
        }
    }
    
}
