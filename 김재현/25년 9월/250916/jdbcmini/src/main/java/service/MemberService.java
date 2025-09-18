package service;

import dto.MemberDTO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

import java.util.List;

public class MemberService {
    private final MemberDAO memberDAO = new MemberDAOImpl();

    public void createMember(String email, String name) {
        MemberDTO memberDTO = new MemberDTO(email, name);
        memberDAO.createMember(memberDTO);
    }

    public MemberDTO login(String email) {
        MemberDTO member = memberDAO.getMemberByEmail(email);
        if (member == null) {
            throw new IllegalArgumentException("[오류] 가입정보가 존재하지 않습니다.");
        }
        return member;
    }

    public boolean deleteMember(int id) {
        return memberDAO.deleteMember(id);
    }

    public List<MemberDTO> searchMembers() {
        return memberDAO.getMembers();
    }


}
