package salaryNStream;

import java.time.LocalDate;



//멤버 변수

public class SalaryNStream {
    private LocalDate yearId;
    private String teamId;
    private String lgId;
    private String playerId;
    private int salary;

//생성자

    public SalaryNStream() {
    }

    public SalaryNStream(LocalDate yearId, String teamId, String lgId, String playerId, int salary) {
        this.yearId = yearId;
        this.teamId = teamId;
        this.lgId = lgId;
        this.playerId = playerId;
        this.salary = salary;
    }

    //getter, setter

    public LocalDate getYearId() {
        return yearId;
    }

    public void setYearId(LocalDate yearId) {
        this.yearId = yearId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getLgId() {
        return lgId;
    }

    public void setLgId(String lgId) {
        this.lgId = lgId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    //toString

    @Override
    public String toString() {
        return "SalaryNStream{" +
                "yearId=" + yearId +
                ", teamId='" + teamId + '\'' +
                ", lgId='" + lgId + '\'' +
                ", playerId='" + playerId + '\'' +
                ", salary=" + salary +
                '}';
    }
}
