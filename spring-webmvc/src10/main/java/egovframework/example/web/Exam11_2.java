package egovframework.example.web;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;

@RestController
@RequestMapping("/exam11_2")
public class Exam11_2 {
    @Autowired ServletContext sc;
    
    @PostMapping("upload01") 
    public Object upload01(MultipartFile files) {
        HashMap<String,Object> jsonData = new HashMap<>();
        
        String fileDir = sc.getRealPath("/files");
        System.out.println(fileDir);
        
        String filename = UUID.randomUUID().toString();
        jsonData.put("filename", filename);
        jsonData.put("fileSize", files.getSize());
        jsonData.put("filehashCode", files.hashCode());
        jsonData.put("originName", files.getOriginalFilename());
        try {
            File path = new File(fileDir + "/" + filename);
            files.transferTo(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonData;
    }
    
    @PostMapping("upload02") 
    public Object upload02(MultipartFile[] files) {
        String filesDir = sc.getRealPath("/files");
        
        ArrayList<Map<String,Object>> jsonDataList = new ArrayList<>();
        
        for (int i = 0; i < files.length; i++) {
            HashMap<String,Object> jsonData = new HashMap<>();
            String filename = UUID.randomUUID().toString();
            jsonData.put("filename", filename);
            jsonData.put("fileSize", files[i].getSize());
            jsonData.put("originName", files[i].getOriginalFilename());
        
            try {
                File path = new File(filesDir + "/" + filename);
                files[i].transferTo(path);
                jsonDataList.add(jsonData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jsonDataList;
    }
    
    @PostMapping("upload03")
    public Object upload03(String name, int age, MultipartFile[] files) {
        String filesDir = sc.getRealPath("/files");
        
        HashMap<String,Object> returnData = new HashMap<>();
        returnData.put("name", name);
        returnData.put("age", age);
        
        ArrayList<Map<String,Object>> jsonDataList = new ArrayList<>();
        returnData.put("files", jsonDataList);
        
        for (int i = 0; i < files.length; i++) {
            HashMap<String,Object> jsonData = new HashMap<>();
            String filename = UUID.randomUUID().toString();
            jsonData.put("filename", filename);
            jsonData.put("fileSize", files[i].getSize());
            jsonData.put("originName", files[i].getOriginalFilename());
        
            try {
                File path = new File(filesDir + "/" + filename);
                files[i].transferTo(path);
                jsonDataList.add(jsonData);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return returnData;
    }
    
    @PostMapping("upload04")
    public Object upload04(MultipartFile files) {
        
        HashMap<String,Object> jsonData = new HashMap<>();
        
        String filesDir = sc.getRealPath("/files");
        
        String filename = UUID.randomUUID().toString();
        jsonData.put("filename", filename);
        jsonData.put("fileSize", files.getSize());
        jsonData.put("originName", files.getOriginalFilename());
        try {
            File path = new File(filesDir + "/" + filename);
            System.out.println(path);
            files.transferTo(path);
            
            String thumbnailPath = path.getCanonicalPath() + "_50x50";
            // 썸네일 이미지 생성
            Thumbnails.of(path)
                    .size(50, 50)
                    .outputFormat("png")
                    .toFile(thumbnailPath);
                    
            System.out.println(thumbnailPath);
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return jsonData;
    }
}
