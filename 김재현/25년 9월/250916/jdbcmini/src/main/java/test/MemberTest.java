package test;

import dto.MemberDTO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberTest {
    public static void main(String[] args) {
        MemberDAO memberDAO = new MemberDAOImpl();

        // int id = memberDAO.createMember(new MemberDTO("test1@lion.com", "kim"));
        // System.out.println("id = " + id);
        //
        // if (memberDAO.updateMember(id, new MemberDTO("test1@lion.com", "kim"))) {
        //     System.out.println("업데이트 성공");
        // }
        //
        // if (memberDAO.deleteMember(id)) {
        //     System.out.println("삭제 성공");
        // }

        for (MemberDTO member : memberDAO.getMembers()) {
            System.out.println(member);
        }

        System.out.println(memberDAO.getMember(7));
        System.out.println(memberDAO.getMember(8));


    }
}
