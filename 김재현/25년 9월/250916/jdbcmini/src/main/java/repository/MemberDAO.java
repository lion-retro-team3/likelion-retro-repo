package repository;

import dto.MemberDTO;

import java.util.List;

public interface MemberDAO {
    int createMember(MemberDTO dto);

    boolean updateMember(int id, MemberDTO dto);

    boolean deleteMember(int id);

    List<MemberDTO> getMembers();

    MemberDTO getMember(int id);

    MemberDTO getMemberByEmail(String email);

}
