// 업무로직 구현체 - 고객사마다 다른 구현을 할 수 있다.
package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.StudyDao;
import bitcamp.java106.pms.domain.Study;
import bitcamp.java106.pms.service.StudyService;

@Service
public class StudyServiceImpl implements StudyService {

    StudyDao studyDao;
    
    public StudyServiceImpl(StudyDao studyDao) {
        this.studyDao = studyDao;
    }
    
    @Override
    public List<Study> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        return studyDao.selectList(params);
    }

    @Override
    public Study get(int no) {
        return studyDao.selectOne(no);
    }

    
    @Override
    public int add(Study study) {
        return studyDao.insert(study);
    }
    
    @Override
    public int update(Study study) {
        return studyDao.update(study);
    }
    
    @Override
    public int delete(int no) {
        return studyDao.delete(no);
    }

    @Override
    public int getLimitOne() {
        return studyDao.selectlimitOne().getNo();
    }
    
}
