package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Task;

public class TaskDao {
    Task[] tasks = new Task[1000];
    int taskIndex = 0;
    
    public void insert(Task task) {
        task.setNo(taskIndex);
        this.tasks[this.taskIndex++] = task;
    }
    
    private int count(String teamName) {
        int cnt = 0;
        for (int i = 0; i < taskIndex; i++) {
            if (tasks[i] == null) continue;
            if (tasks[i].getTeam().getName().toLowerCase().equals(teamName)) {
                cnt++;
            }
        }
        return cnt;
    }
    
    public Task[] list(String teamName) {
        Task[] arr = new Task[this.count(teamName)];
        for (int i = 0, x = 0; i < taskIndex; i++) {
            if (tasks[i] == null) continue;
            if (tasks[i].getTeam().getName().toLowerCase().equals(teamName)) {
                arr[x++] = tasks[i];
            }
        }
        return arr;
    }
    
    
    /*
    public Task[] list() {
        Task[] arr = new Task[this.taskIndex];
        for (int i = 0; i < this.taskIndex; i++) 
            arr[i] = this.tasks[i];
        return arr;
    }
    
    public Task get(String name) {       
        int i = this.getTaskIndex(name);
        if (i == -1)
            return null;
        return this.tasks[i];
    }
    
    public void update(Task task) {
        int i = this.getTaskIndex(task.getName());
        if (i != -1)
            this.tasks[i] = task;
//        for (int i = 0; i < taskIndex; i++) {
//            if (this.tasks[i] == null) continue;
//            if (task.name.equals(tasks[i].name.toLowerCase())) {
//                this.tasks[i] = task;
//                break;
//            }
//        }
    }
    
    public void delete(String name) {
        int i = this.getTaskIndex(name);
        if (i != -1)
            this.tasks[i] = null;
//        for (int i = 0; i < taskIndex; i++) {
//            if (this.tasks[i] == null) continue;
//            if (name.equals(tasks[i].name.toLowerCase())) {
//                this.tasks[i] = null;
//                break;
//            }
//        }
    }
    // 다음 메서드는 내부에서만 사용할 것이기 때문에 공개하지 않는다.
    private int getTaskIndex(String name) {
        for (int i = 0; i < taskIndex; i++) {
            if (this.tasks[i] == null) continue;
            if (name.equals(this.tasks[i].getName().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
   */
}