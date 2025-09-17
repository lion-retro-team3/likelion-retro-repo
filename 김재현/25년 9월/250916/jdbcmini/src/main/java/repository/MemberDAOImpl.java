package repository;

import common.DBUtil;
import dto.MemberDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {
    @Override
    public int createMember(MemberDTO dto) {
        int id = 0;
        String sql = "insert into members(email,name) values(?,?)";
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)
        ) {

            ps.setString(1, dto.getEmail());
            ps.setString(2, dto.getName());
            int count = ps.executeUpdate();
            if (count > 0) {
                try (
                        ResultSet rs = ps.getGeneratedKeys()
                ) {
                    if (rs.next()) {
                        id = rs.getInt(1);
                    }
                }
            } else {
                System.out.println("회원가입 실패");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

    @Override
    public boolean updateMember(int id, MemberDTO dto) {
        boolean result = false;
        String sql = "update members " +
                "set email = ?, name = ? " +
                "where member_id = ?";
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, dto.getEmail());
            ps.setString(2, dto.getName());
            ps.setInt(3, id);
            int count = ps.executeUpdate();
            if (count > 0) {
                result = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean deleteMember(int id) {
        boolean result = false;
        String sql = "delete from members where member_id = ?";
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            if (count > 0) {
                result = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public List<MemberDTO> getMembers() {
        List<MemberDTO> members = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from members";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                members.add(resultSetToMembers(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        return members;
    }

    @Override
    public MemberDTO getMember(int id) {
        MemberDTO dto = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from members where member_id = ?";

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                dto = resultSetToMembers(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        return dto;
    }

    @Override
    public MemberDTO getMemberByEmail(String email) {
        MemberDTO dto = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from members where email = ?";

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                dto = resultSetToMembers(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        return dto;
    }

    private MemberDTO resultSetToMembers(ResultSet rs) throws SQLException {
        MemberDTO dto = new MemberDTO();
        dto.setMemberId(rs.getInt("member_id"));
        dto.setEmail(rs.getString("email"));
        dto.setName(rs.getString("name"));
        return dto;
    }
}
