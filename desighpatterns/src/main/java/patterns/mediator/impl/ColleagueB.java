package patterns.mediator.impl;

import patterns.mediator.ColleagueMediator;

public class ColleagueB extends AbstractColleague {


    private ColleagueMediator mediator;

    public ColleagueB(ColleagueMediator mediator){
        this.mediator = mediator;
    }

    public void startWork() {
        System.out.println("ColleagueB starts");
        super.startWork();
    }

    public void helpWork() {
        System.out.println("ColleagueB help");
        startWork();
    }

    @Override
    public void findHelp() {
        mediator.findHelp();
    }
}
