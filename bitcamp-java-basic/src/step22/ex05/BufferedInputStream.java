package step22.ex05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStream extends FileInputStream {
    
    byte[] buf = new byte[8196];
    int size;   // 배열에 저장되어 있는 바이트의 수
    int cursor; // 바이트 읽은 배열의 위치
    
    public BufferedInputStream(String filename) throws FileNotFoundException {
        super(filename);
    }

    @Override
    public int read() throws IOException {
        if (cursor == size) { // 버퍼에 저장되어 있는 데이터를 모두 읽었다는 의미
            if ((size = this.read(buf)) == -1) { // 파일에서 데이터를 모두 읽었다는 의미
                return -1;
            }
            cursor = 0;
        }
        return 0x000000ff & buf[cursor++];
    }
    
    
    
}
