package patterns.mediator;

import patterns.mediator.impl.ColleagueA;
import patterns.mediator.impl.ColleagueB;
import patterns.mediator.impl.ConcreteMediator;

public class Client {
    public static void main(String[] args) {
        ColleagueMediator mediator = new ConcreteMediator();
        Colleague colleagueA = new ColleagueA(mediator);
        Colleague colleagueB = new ColleagueB(mediator);


        mediator.addColleague(colleagueA);
        mediator.addColleague(colleagueB);

        colleagueA.startWork();
        colleagueA.findHelp();

    }
}
