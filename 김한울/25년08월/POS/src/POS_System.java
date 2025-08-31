public class POS_System {


    public void showInfo(){
        StringBuilder menu = new StringBuilder();
        int i =1;
        System.out.println("==================================");
        for (SystemMenu systemMenu : SystemMenu.values()) {
            menu.append(i).append(". ").append(systemMenu.getDescription()).append("\t");
            if (i%3==0) menu.append("\n");
            i++;
        }
        System.out.println(menu);
        System.out.println("==================================");
        System.out.print("[메뉴] 번호를 입력해주세요 → ");
    }




}
