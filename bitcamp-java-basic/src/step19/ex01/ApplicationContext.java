// 지정된 폴더의 파일 목록만 가져온다.
package step19.ex01;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext {
    private ArrayList<File> list = new ArrayList<>();

    public ApplicationContext(File dir) {
        findFiles(dir);
    }

    private List<File> findFiles(File dir) {
        File[] files = dir.listFiles();
        for (File f : files) {
           list.add(f);
        }
        return list;
    }
    
    // list를 리턴해주는 getFiles() 메소드 만든다.
    public List<File> getFiles() {
        return this.list;
    }



}
