package miniProject.lionGym.start;

import miniProject.lionGym.gym.GymFunctions;
import miniProject.lionGym.gym.GymFunctionsImpl;
import miniProject.lionGym.people.Member;
import miniProject.lionGym.people.Trainer;
import miniProject.lionGym.util.In;

/**
 * 메인 클래스
 * @author dahee
 * @since 25.08.30
 */
public class Main {
    public static void main(String[] args) {
        GymFunctions gymFunctions = new GymFunctionsImpl();

        // 초기 데이터 세팅
        gymFunctions.dataInit();

        System.out.println("╭╼|══════════════════════════════════════════════|╾╮");
        System.out.println("|      Welcome to LionGym Management System !      |");
        System.out.println("╰╼|══════════════════════════════════════════════|╾╯");

        while (true) {
            System.out.println("╭╼ [1]회원등록 [2]트레이너등록 [3]PT등록 [4]PT사용 ╾╮");
            System.out.println("╰╼ [5]회원목록 [6]트레이너목록          [0]종료   ╾╯");
            System.out.print("▶︎ 메뉴를 선택하세요: ");

            switch (Integer.parseInt(In.getString())) {
                case 1:
                    System.out.println("▶︎ 회원 정보를 입력 해 주세요.");
                    Member member = new Member();
                    System.out.print(" - 이름: ");
                    member.setName(In.getString());
                    System.out.print(" - 연락처 [010-0000-0000 형식으로 입력]: ");
                    member.setPhone(In.getString());
                    System.out.print(" - (선택)담당트레이너ID: ");
                    member.setTrainerId(In.getString());
                    System.out.print(" - (선택)PT수업횟수: ");
                    String input = In.getString().trim();
                    if(!input.isEmpty()) member.setSession(Integer.parseInt(input));
                    gymFunctions.registerMember(member);
                    System.out.println("✅ " + member.getName() + "님이 회원으로 등록되었습니다.");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("▶︎ 트레이너 정보를 입력 해 주세요.");
                    Trainer trainer = new Trainer();
                    System.out.print(" - 이름: ");
                    trainer.setName(In.getString());
                    System.out.print(" - 연락처 [010-0000-0000 형식으로 입력]: ");
                    trainer.setPhone(In.getString());
                    System.out.print(" - 기본급: ");
                    trainer.setBaseSalary(Integer.parseInt(In.getString()));
                    System.out.print(" - 수업당 성과금: ");
                    trainer.setBonus(Integer.parseInt(In.getString()));
                    gymFunctions.registerTrainer(trainer);
                    System.out.println("✅ " + trainer.getName() + "님이 트레이너로 등록되었습니다.");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("▶︎ PT 등록 정보를 입력 해 주세요.");
                    Member ptMember = new Member();
                    System.out.print(" - 회원ID: ");
                    ptMember.setId(In.getString());
                    System.out.print(" - 트레이너ID: ");
                    ptMember.setTrainerId(In.getString());
                    System.out.print(" - 등록횟수: ");
                    ptMember.setSession(Integer.parseInt(In.getString()));
                    gymFunctions.buyPt(ptMember);
                    System.out.println("✅ PT가 등록되었습니다.");
                    System.out.println();
                    break;
                case 4:
                    System.out.println("▶︎ PT 사용 정보를 입력 해 주세요.");
                    System.out.print(" - 회원ID: ");
                    String memberId = In.getString();
                    System.out.print(" - 수업차감횟수: ");
                    int useSession = Integer.parseInt(In.getString());
                    gymFunctions.usePt(memberId, useSession);
                    System.out.println("✅ PT수업이 " + useSession + "회 차감되었습니다.");
                    System.out.println();
                    break;
                case 5:
                    System.out.println("ID  |  이름  |    연락처     | 담당트레이너 | 남은수업");
                    for (Member m : gymFunctions.memberList()) {
                        Trainer t = gymFunctions.getTrainerInfo(m.getTrainerId());
                        String trainerNm = t != null ? t.getName() : "   -   ";
                        System.out.println(m.getId() + "  | "
                                + m.getName() + " | "
                                + m.getPhone() + " | "
                                + trainerNm + "  | "
                                + m.getSession() + "회");
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.println("ID  |   이름   |     연락처      | 수업횟수 | 예상급여");
                    for (Trainer t : gymFunctions.trainerList()) {
                        System.out.println(t.getId() + "  | "
                                + t.getName() + " | "
                                + t.getPhone() + " |  "
                                + t.getLessons() + "회" + "  | "
                                + t.calculatePay() + "원");
                    }
                    System.out.println();
                    break;
                case 0:
                    System.out.println("╭╼|══════════════════════════════════════════════|╾╮");
                    System.out.println("|              Bye ! See You Next Time !           |");
                    System.out.println("╰╼|══════════════════════════════════════════════|╾╯");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다. 0~6 사이의 숫자를 입력해주세요.");
            }
        }
    }
}
