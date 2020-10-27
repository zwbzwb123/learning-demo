package patterns.mediator.impl;


import patterns.mediator.ColleagueMediator;

public class ColleagueA extends AbstractColleague {

    ColleagueMediator mediator;

    public ColleagueA (ColleagueMediator mediator){
        this.mediator = mediator;
    }

    public void startWork() {
        System.out.println("ColleagueA starts ..");
        super.startWork();
    }

    public void helpWork() {
        System.out.println("ColleagueA help");
        startWork();
    }

    @Override
    public void findHelp() {
        mediator.findHelp();
    }
}
