package WhoAreYouProject;

public enum Job {
    LABOR_ATTORNEY("공인노무사"),
    REALTOR("공인중개사"),
    JUDICIAL_SCRIVENER("법무사"),
    PATENT_ATTORNEY("변리사"),
    TAX_ACCOUNTANT("세무사"),
    ADMINISTRATIVE_AGENT("행정사"),
    ATTORNEY("변호사"),
    JUDGE("판사"),
    PROSECUTOR("검사");

    private final String Jmean;

    Job(String Jmean){
       this.Jmean = Jmean;
   }

    public String getJmean() {
        return Jmean;
    }

    @Override
    public String toString() {
        return  Jmean;
    }
    public static Job fromJmean(String korean){
        if(korean == null) throw new IllegalArgumentException("직업을 한국어로 입력해주십시오.");
        String key = korean.trim();
        for(Job j : values()){
            if (j.getJmean().equals(key)){
                return j;
            }
        }
        throw new IllegalArgumentException("해당 직업은 포함하고 있지 않습니다.");
    }
}
