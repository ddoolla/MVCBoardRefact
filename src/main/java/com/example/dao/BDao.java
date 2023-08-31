package com.example.dao;

import com.example.dto.BDto;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BDao {

    private static BDao bDao = new BDao();

    private BDao() {
    }

    public static BDao getInstance() {
        return bDao;
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
            con = dataSource.getConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    } // getConnection()

    // 게시물 전체 조회
    public ArrayList<BDto> boardAll() {
        ArrayList<BDto> bDtos = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM mvc_board ORDER BY bGroup DESC, bStep ASC, bIndent ASC";
        System.out.println("sql = " + sql);
        System.out.println("======================================");


        try {
            con = getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String bId = rs.getString("bId");
                String bName = rs.getString("bName");
                String bTitle = rs.getString("bTitle");
                String bContent = rs.getString("bContent");
                String bDate = rs.getString("bDate");
                String bHit = rs.getString("bHit");
                String bGroup = rs.getString("bGroup");
                String bStep = rs.getString("bStep");
                String bIndent = rs.getString("bIndent");
                BDto bDto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
//                System.out.println("bDto = " + bDto);
                bDtos.add(bDto);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("boardAll() 실행 중 예외 발생");

        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bDtos;
    } // boardAll()

    // 선택한 게시글 1개 조회
    public BDto selectOne(String id) {
        BDto bDto = new BDto();

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM mvc_board WHERE bId = '" + id + "'";
        System.out.println("sql = " + sql);
        System.out.println("======================================");


        try {
            con = getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            rs.next();
            String bId = rs.getString("bId");
            String bName = rs.getString("bName");
            String bTitle = rs.getString("bTitle");
            String bContent = rs.getString("bContent");
            String bDate = rs.getString("bDate");
            String bHit = rs.getString("bHit");
            String bGroup = rs.getString("bGroup");
            String bStep = rs.getString("bStep");
            String bIndent = rs.getString("bIndent");
            bDto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
//            System.out.println("bDto = " + bDto);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("selectOne() 중 예외 발생");

        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bDto;
    } // selectOne()

    // 게시글 전체 개수 조회
    public int countAll() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) totalCnt FROM mvc_board";
        System.out.println("sql = " + sql);
        System.out.println("======================================");
        int totalCnt = 0;
        try {
            con = getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            rs.next();

            totalCnt = rs.getInt("totalCnt");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("countAll() 중 예외 발생");

        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return totalCnt;
    } // countAll()


    // 게시글 작성
    public int insertBoard(BDto bDto) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO mvc_board (bName, bTitle, bContent, bGroup) "
                + " VALUES (?, ?, ?, LAST_INSERT_ID() + 1)";
        System.out.println("sql = " + sql);
        System.out.println("======================================");


        int cnt = 0;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, bDto.getbName());
            pstmt.setString(2, bDto.getbTitle());
            pstmt.setString(3, bDto.getbContent());

            cnt = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("insertBoard() 중 예외 발생");

        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cnt;
    } // insertBoard()

    // 게시물 조회시 히트수 증가
    public int hitUpdate(String id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "UPDATE mvc_board SET bHit = bHit + 1 WHERE bId = ?";
        System.out.println("sql = " + sql);
        System.out.println("======================================");
        int cnt = 0;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, id);

            cnt = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("hitUpdate() 중 예외 발생");

        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cnt;
    } // hitUpdate()

    // 게시글 수정
    public int modifyContent(BDto bDto) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "UPDATE mvc_board SET "
                + " bName = ?, bTitle = ?, bContent = ? "
                + " WHERE bId = ? ";
        System.out.println("sql = " + sql);
        System.out.println("======================================");
        int cnt = 0;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, bDto.getbName());
            pstmt.setString(2, bDto.getbTitle());
            pstmt.setString(3, bDto.getbContent());
            pstmt.setString(4, bDto.getbId());

            cnt = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("modifyContent() 중 예외 발생");

        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cnt;
    } // modifyContent()

    // 게시글 삭제
    public int deleteBoard(String id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM mvc_board WHERE bId = ? ";
        System.out.println(sql);
        System.out.println("======================================");
        int cnt = 0;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, id);

            cnt = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("deleteBoard() 중 예외 발생");

        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cnt;
    } // deleteBoard()

    // 답변 등록
    public int insertReply(BDto bDto) {

        // 기존 답변 bStep + 1 업데이트
        // 최근 답변을 bStep = 1로 하고 기존 답변들의 bStep을 + 1씩 증가 시킴
        stepUpdate(bDto);

        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO mvc_board (bName, bTitle, bContent, bGroup, bStep, bIndent) " +
                " VALUES (?, ?, ?, ?, ?, ?) ";
        System.out.println("sql = " + sql);
        System.out.println("======================================");
        int cnt = 0;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, bDto.getbName());
            pstmt.setString(2, bDto.getbTitle());
            pstmt.setString(3, bDto.getbContent());
            pstmt.setString(4, bDto.getbGroup());
            pstmt.setInt(5, Integer.parseInt(bDto.getbStep()) + 1);
            pstmt.setInt(6, Integer.parseInt(bDto.getbIndent()) + 1);

            cnt = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("insertReply() 중 예외 발생");

        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cnt;
    } // insertReply()

    // 최근 순서에 맞게 스탭 업데이트
    public int stepUpdate(BDto bDto) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "UPDATE mvc_board SET "
                + " bStep = bStep + 1 "
                + " WHERE bGroup = ? AND bStep > ? ";

        System.out.println("sql = " + sql);
        System.out.println("======================================");
        int cnt = 0;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, bDto.getbGroup());
            pstmt.setString(2, bDto.getbStep());

            cnt = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("stepUpdate() 중 예외 발생");

        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cnt;
    } // stepUpdate()

}






















