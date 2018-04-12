// 버퍼 기능을 입출력 플러그인/장신구(decorator)로 전환한다.
package step22.ex07;

import java.io.IOException;
import java.io.OutputStream;

public class BufferedOutputStream {
    
    OutputStream out;
    
    byte[] buf = new byte[8196];
    int cursor;
    
    
    public BufferedOutputStream(OutputStream out)  {
        this.out = out;
    }

    public void write(int b) throws IOException {
        // 버퍼가 다차면 버퍼에 있는 바이트를 한번에 출력할 것이다.
        if (cursor == buf.length) { // 버퍼가 다 차면            ---> 버퍼에 남아있는 데이터가 존재할수도 있기 때문에 close() 오버라이딩
            out.write(buf); // 버퍼에 들어있는 데이터를 한 번에 출력한다.
            cursor = 0; // 다시 cursor를 0으로 초기화시킨다.
        }
        // 1바이트 출력하라고 하면 일단 버퍼에 저장할 것이다.
        buf[cursor++] = (byte)b;
    }

    public void close() throws IOException {
        this.flush();
        out.close();
    }
    
    // close() 하지 않아도 버퍼에 남아있는 데이터가 있으면 출력해라.
    public void flush() throws IOException {
        if (cursor > 0) { // 버퍼에 남아있는 데이터가 있다면
            out.write(buf, 0, cursor);
            cursor = 0;
        }
    }
    
}
