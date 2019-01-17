// 업무로직 구현체 - 고객사마다 다른 구현을 할 수 있다.
package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.HashTagDao;
import bitcamp.java106.pms.dao.StudyInfoDao;
import bitcamp.java106.pms.domain.HashTag;
import bitcamp.java106.pms.domain.StudyInfo;
import bitcamp.java106.pms.service.StudyInfoService;

@Service
public class StudyInfoServiceImpl implements StudyInfoService {

    StudyInfoDao studyInfoDao;
    HashTagDao hashTagDao;
    
    public StudyInfoServiceImpl(StudyInfoDao studyInfoDao, HashTagDao hashTagDao) {
        this.studyInfoDao = studyInfoDao;
        this.hashTagDao = hashTagDao;
    }
    
    @Override
    public List<StudyInfo> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        return studyInfoDao.selectList(params);
    }
    
    @Override
    public List<StudyInfo> listSearch(Map<String,Object> params) {
       /* HashMap<String,Object> searchs = new HashMap<>();
        String city = (String)params.get("city");
        String county =(String)params.get("county");
        String category=(String)params.get("category");
        String hashtag =(String)params.get("hashtag");
        searchs.put("city", city);
        searchs.put("county", county);
        searchs.put("category", category);
        searchs.put("hashtag", hashtag);
        */
        System.out.println("service" + params);
        return studyInfoDao.selectSearchList(params);
    }
    
    /*@Override
    public List<HashTag> listTag(int no) {
        return hashTagDao.selectList(no);
    }*/
    

    @Override
    public StudyInfo get(int no) {
        return studyInfoDao.selectOne(no);
    }

    @Override
    public int add(StudyInfo studyInfo) {
        return studyInfoDao.insert(studyInfo);
    }

    @Override
    public int addTag(String[] tag) {
        int num = studyInfoDao.selectlimitOne().getNo();
        System.out.println(num);
        for(int i = 0; i < tag.length; i++) {
            System.out.println(tag[i]);
            HashTag hashTag = new HashTag();
            hashTag.setNo(num);
            hashTag.setHashtag(tag[i]);
            hashTagDao.insert(hashTag);
        }
        return 0;
    }
    
    @Override
    public int update(StudyInfo studyInfo) {
        return studyInfoDao.update(studyInfo);
    }
    
    @Override
    public int delete(int no) {
        return studyInfoDao.delete(no);
    }

    @Override
    public int getLimitOne() {
        return studyInfoDao.selectlimitOne().getNo();
    }

}
