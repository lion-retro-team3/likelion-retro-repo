package repository;

import common.DBUtil;
import dto.EmailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmailDAOImpl implements EmailDAO{
    @Override
    public int createEmail(EmailDTO dto) {
        int id = 0;
        String sql = "insert into " +
                "emails(member_id,mail_type,sender,recipient,title,content) " +
                "values(?,?,?,?,?,?)";
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            ps.setInt(1, dto.getMemberId());
            ps.setString(2, dto.getMailType());
            ps.setString(3, dto.getSender());
            ps.setString(4, dto.getRecipient());
            ps.setString(5, dto.getTitle());
            ps.setString(6, dto.getContent());
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
                System.out.println("메일 전송 실패");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

    @Override
    public boolean updateIsRead(int id) {
        boolean result = false;
        String sql = "update emails set is_read = true where email_id = ?";
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean deleteEmail(int id) {
        boolean result = false;
        String sql = "delete from emails where email_id = ?";
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
    public List<EmailDTO> getEmails(int memberId) {
        List<EmailDTO> emails = new ArrayList<>();
        String sql = "select * from emails where member_id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, memberId);
            rs = ps.executeQuery();
            while (rs.next()) {
                emails.add(resultSetToEmails(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        return emails;
    }

    @Override
    public EmailDTO getEmail(int id) {
        EmailDTO dto = null;
        String sql = "select * from emails where email_id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                dto = resultSetToEmails(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        return dto;
    }

    private static EmailDTO resultSetToEmails(ResultSet rs) throws SQLException {
        EmailDTO dto = new EmailDTO();
        dto.setMailId(rs.getInt("email_id"));
        dto.setMemberId(rs.getInt("member_id"));
        dto.setMailType(rs.getString("mail_type"));
        dto.setSender(rs.getString("sender"));
        dto.setRecipient(rs.getString("recipient"));
        dto.setTitle(rs.getString("title"));
        dto.setContent(rs.getString("content"));
        dto.setRead(rs.getBoolean("is_read"));
        dto.setSentAt((LocalDateTime) rs.getObject("sent_at"));
        return dto;
    }
}
