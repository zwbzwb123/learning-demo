package patterns.mediator;

/*
*   封装对象的交互，使得对象与对象中间不直接交互，而是通过中介者处理
* */
public interface ColleagueMediator {

    void findHelp();

    void addColleague(Colleague colleague);

    void removeColleague(Colleague colleague);
}
