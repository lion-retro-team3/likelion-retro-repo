package controller;

import dto.MemberDTO;
import io.ConsoleOutput;
import io.UserInput;
import service.MemberService;

import java.util.List;

public class MemberController {

    private final MemberService memberService = new MemberService();

    public void signUp() {
        ConsoleOutput.signUpHeader();
        String email = UserInput.emailInput();
        String name = UserInput.nameInput();
        memberService.createMember(email, name);
        ConsoleOutput.signUpSuccess();
    }

    public MemberDTO login() {
        ConsoleOutput.loginHeader();
        String email = UserInput.emailInput();
        MemberDTO loginMember = memberService.login(email);
        ConsoleOutput.loginSuccess(loginMember.getName());
        return loginMember;
    }

    public void searchMembers() {
        List<MemberDTO> members = memberService.searchMembers();
        ConsoleOutput.printMembers(members);
    }

    public void delete(MemberDTO loginMember) {
        memberService.deleteMember(loginMember.getMemberId());
        ConsoleOutput.deleteMember();
    }
}
