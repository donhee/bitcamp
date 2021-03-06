// 게시판 관련 기능을 모아 둔 클래스
package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.util.Console;

public class BoardController implements Controller {
    // 이 클래스를 사용하기 전에 App 클래스에서 준비한 Scanner 객체를
    // keyScan 변수에 저장하라!
    Scanner keyScan;

    BoardDao boardDao = new BoardDao();
    
    public BoardController(Scanner scanner) {
        // BoardController의 메서드를 이용하려면 반드시 설정해야 하는 값이 있다.
        // Board[] 배열이나 boardIndex 처럼 내부에서 생성하는 값이 있고,
        // Scanner 처럼 외부에서 받아야 하는 값이 있다.
        // 외부에서 반드시 받아야 하는 값은 생성자를 통해 입력 받도록 하면 된다.
        // 이것이 생성자가 필요한 이유이다.
        // 즉 객체가 작업하는데 필수적으로 요구되는 값을 준비시키는 역할을 수행하는게 
        // 바로 "생성자"이다.
        //
        // BoardController 객체를 생성할 때
        // 필수 값을 반드시 입력 받도록 선언한다.
        // 필수 값이 설정되어 있어야만 작업을 수행할 수 있기 때문이다.
        this.keyScan = scanner;
    }
    public void service(String menu, String option) {
        if (menu.equals("board/add")) {
            this.onBoardAdd();
        } else if (menu.equals("board/list")) {
            this.onBoardList();
        } else if (menu.equals("board/view")) {
            this.onBoardView(option);
        } else if (menu.equals("board/update")) {
            this.onBoardUpdate(option);
        } else if (menu.equals("board/delete")) {
            this.onBoardDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    void onBoardAdd() {
        System.out.println("[게시물 입력]");
        Board board = new Board();

        System.out.print("제목? ");
        board.setTitle(this.keyScan.nextLine());

        System.out.print("내용? ");
        board.setContent(this.keyScan.nextLine());

        System.out.print("등록일? ");
        board.setCreatedDate(Date.valueOf(this.keyScan.nextLine()));

        boardDao.insert(board);
    }

    void onBoardList() {
        System.out.println("[게시물 목록]");
        Iterator<Board> iterator = boardDao.list();
        while (iterator.hasNext()) {
            Board board = iterator.next();
            System.out.printf("%d, %s, %s\n",
                    board.getNo(), board.getTitle(), board.getCreatedDate());
        }
    }

    void onBoardView(String option) {
        System.out.println("[게시물 조회]");
        if (option == null) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return;
        }
        
        Board board = boardDao.get(Integer.parseInt(option));
        
        if (board == null) {
            System.out.println("유효하지 않은 게시물 번호입니다.");
        } else {
            System.out.printf("팀명: %s\n", board.getTitle());
            System.out.printf("설명: %s\n", board.getContent());
            System.out.printf("등록일: %s\n", board.getCreatedDate());
        }
    }

    void onBoardUpdate(String option) {
        System.out.println("[게시물 변경]");
        if (option == null) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return;
        }
                                                                                   
        Board board = boardDao.get(Integer.parseInt(option));
        
        if (board == null) {
            System.out.println("유효하지 않은 게시물 번호입니다.");
        } else {
            Board updateBoard = new Board();
            updateBoard.setNo(board.getNo());

            System.out.printf("제목(%s)? ", board.getTitle());
            updateBoard.setTitle(this.keyScan.nextLine());
            System.out.printf("설명(%s)? ", board.getContent());
            updateBoard.setContent(this.keyScan.nextLine());
            updateBoard.setCreatedDate(board.getCreatedDate());
            
            int index = boardDao.indexOf(board.getNo());
            boardDao.update(index, updateBoard);
            System.out.println("변경하였습니다.");
        }
    }

    void onBoardDelete(String option) {
        System.out.println("[게시물 삭제]");
        if (option == null) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return; 
        }
        
        int i = Integer.parseInt(option);
        Board board = boardDao.get(i);
        
        if (board == null) {
            System.out.println("유효하지 않은 게시물 번호입니다.");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                boardDao.delete(i);
                System.out.println("삭제하였습니다.");
            }
        }
    }
    
}

// ver 18 - BoardDao 변경 사항에 맞춰 이 클래스를 변경한다.