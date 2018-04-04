// 파일 다루기 - java.io.File 클래스
package step16;

import java.io.File;

public class Exam02 {
    public static void main(String[] args) throws Exception {
        // File 클래스
        // => 파일이나 디렉토리 정보를 관리
        // => 파일이나 디렉토리를 생성, 삭제, 변경 가능
        
        // 1) 현재 폴더 정보 조회
        // "."  - 현재 폴더
        // ".." - 상위 폴더
        File currentDir = new File("./src/step16");
        System.out.printf("폴더명: %s\n", currentDir.getName());
        System.out.printf("경로: %s\n", currentDir.getPath());
        System.out.printf("절대경로: %s\n", currentDir.getAbsolutePath());
        System.out.printf("계산된절대경로: %s\n", currentDir.getCanonicalPath());
        System.out.printf("총크기: %d\n", currentDir.getTotalSpace());
        System.out.printf("남은크기: %d\n", currentDir.getFreeSpace());
        System.out.printf("가용크기: %d\n", currentDir.getUsableSpace());
        System.out.printf("디렉토리여부: %b\n", currentDir.isDirectory());
        System.out.printf("파일여부: %b\n", currentDir.isFile());
        System.out.printf("감춤폴더여부: %b\n", currentDir.isHidden());
        System.out.printf("존재여부: %b\n", currentDir.exists());
        System.out.printf("실행가능여부: %b\n", currentDir.canExecute());
        
        System.out.println("-------------------------------");
        
        // 2) 상위 폴더 정보 조회
        File parentDir = new File("../bitcamp-java-project/src");
        System.out.printf("폴더명: %s\n", parentDir.getName());
        System.out.printf("경로: %s\n", parentDir.getPath());
        System.out.printf("절대경로: %s\n", parentDir.getAbsolutePath());
        System.out.printf("계산된절대경로: %s\n", parentDir.getCanonicalPath());
        System.out.printf("총크기: %d\n", parentDir.getTotalSpace());
        System.out.printf("남은크기: %d\n", parentDir.getFreeSpace());
        System.out.printf("가용크기: %d\n", parentDir.getUsableSpace());
        System.out.printf("디렉토리여부: %b\n", parentDir.isDirectory());
        System.out.printf("감춤폴더여부: %b\n", parentDir.isHidden());
        System.out.printf("존재여부: %b\n", parentDir.exists());
        System.out.printf("실행가능여부: %b\n", parentDir.canExecute());
        
    }
}
