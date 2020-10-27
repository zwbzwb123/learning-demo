package patterns.mediator.impl;

import patterns.mediator.Colleague;
import patterns.mediator.ColleagueMediator;

import java.util.ArrayList;

public class ConcreteMediator implements ColleagueMediator {

    private ArrayList<Colleague> colleages = new ArrayList<Colleague>(10);


    /*
    *    通过中介者，开始工作的“同事”不需要知道其他“同事”，即可找到帮助
    * */
    public void findHelp() {
        colleages.stream().forEach(c ->{
            if (c.hasFreeTime()) {
                c.helpWork();
                return;
            }
        });
    }

    public void addColleague(Colleague colleage){
        colleages.add(colleage);
    }

    public void removeColleague(Colleague colleage){
        colleages.remove(colleage);
    }
}
