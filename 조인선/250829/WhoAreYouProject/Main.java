package WhoAreYouProject;

import java.util.Scanner;
    public class Main {
        public static void main(String[] args) {
            ConsoleDirectory dir = new ConsoleDirectory();
            Scanner sc = new Scanner(System.in);

            // 더미 데이터 검색용
            dir.add(new Profile("홍길동", "한국대학교", "사법시험", "40기", "홍길동 법률사무소", Job.ATTORNEY));
            dir.add(new Profile("이순신", "조선시대학교", "변호사시험", "1기", "이순신 법률사무소", Job.ATTORNEY));
            dir.add(new Profile("박판", "연대학교", "사법시험", "35기", "서울중앙지방법원", Job.JUDGE));
            dir.add(new Profile("박검사", "한국고등학교","사법시험", "36기", "서울중앙지방검찰청", Job.PROSECUTOR));
            dir.add(new Profile("최세무", "세무대학교", "세무사시험", "20기", "최세무 세무회계사무소", Job.TAX_ACCOUNTANT));
            dir.add(new Profile("홍길동", "한국대학교", "사법시험", "41기", "법무법인 활빈당 ", Job.ATTORNEY));
            dir.add(new Profile("을지문덕", "고대학교", "변호사시험", "1기", "법무법인 살수", Job.ATTORNEY));
            dir.add(new Profile("김판사", "연대학교", "사법시험", "35기", "춘천중앙지방법원", Job.JUDGE));
            dir.add(new Profile("강검사", "국학대학교", "사법시험", "36기", "제주지방검찰청", Job.PROSECUTOR));
            dir.add(new Profile("김세무", "하냥대학교", "세무사시험", "20기", "최고 세무법인", Job.TAX_ACCOUNTANT));
            dir.add(new Profile("김노동", "검정고시", "공인노무사시험", "12기", "김노동 노무법인", Job.LABOR_ATTORNEY));
            dir.add(new Profile("정중개", "동서울중학교", "공인중개사시험", "25기", "정중개 공인중개사 사무소", Job.REALTOR));
            dir.add(new Profile("조법무", "남강고등학교", "법무사시험", "5기", "조법무 법무사무소", Job.JUDICIAL_SCRIVENER));
            dir.add(new Profile("유특허", "하림과학대학교", "변리사시험", "35기", "유특허 특허법률사무소", Job.PATENT_ATTORNEY));
            dir.add(new Profile("김세무", "하냥대학교", "세무사시험", "20기", "최고 세무법인", Job.TAX_ACCOUNTANT));
            dir.add(new Profile("장행정", "검정고시", "행정사시험", "3기", "장행정 행정사무소", Job.ADMINISTRATIVE_AGENT));
            dir.add(new Profile("홍길동", "백양고등학교", "변호사시험", "1기", "홍길동 법률사무소", Job.ATTORNEY));
            dir.add(new Profile("김판결", "동백대학교", "사법시험", "35기", "서울중앙지방법원", Job.JUDGE));
            dir.add(new Profile("김검찰", "청송중학교", "사법시험", "36기", "서울중앙지검", Job.PROSECUTOR));


            while(true){
                dir.printMenu();
                int choice;
                try {
                    choice = Integer.parseInt(sc.nextLine().trim());
                }
                catch (NumberFormatException e){
                    dir.printError("숫자를 입력하시오.");
                    continue;
                }
                //직업으로 검색, 없는 직업일 시 오류 메세지 출력.
                switch(choice){
                    case 1:
                        System.out.println("검색할 직업을 입력하시오.(예) 변호사");
                        String jobInput = sc.nextLine().trim();
                    try{
                        Job job = Job.fromJmean(jobInput);
                        dir.printProfiles((dir.listByJob(job)));
                    } catch (IllegalArgumentException e) {
                        dir.printError("해당 직업은 포함하지 않고있습니다.");
                    }
                    break;

                    case 2:
                        System.out.println("찾을 인물의 이름을 입력하시오.");
                        String name = sc.nextLine().trim();
                        dir.printProfiles(dir.searchByName(name));
                        break;

                    case 3:
                        dir.printAll();
                        break;

                    case 4:
                        System.out.println("이름: ");
                        String n = sc.nextLine();
                        System.out.println("출신 학교: ");
                        String s = sc.nextLine();
                        System.out.println("시험명: ");
                        String exName = sc.nextLine();
                        System.out.println("시험기수: ");
                        String exClass = sc.nextLine();
                        System.out.println("직업 (예) 변호사 ");
                        String jobStr = sc.nextLine().trim();
                        Job job = Job.fromJmean(jobStr);
                        System.out.println("현 사무소: ");
                        String office = sc.nextLine();
                        try{
                            Job j =Job.fromJmean(jobStr);
                            Profile p = new Profile(n, s, exName, exClass, office, j);
                            dir.add(p);
                            dir.printMessage("정보 등록이 완료되었습니다.");
                        } catch (IllegalArgumentException e){
                            dir.printError("직업의 입력이 잘못되었습니다.");
                        }
                        break;

                    case 0:
                        System.out.println("시스템을 종료합니다. 이용해주셔서 감사합니다.");
                        return;

                    default:
                        dir.printError("없는 메뉴입니다. 다시 입력해주십시오.");

                }
            }
        }
    }

