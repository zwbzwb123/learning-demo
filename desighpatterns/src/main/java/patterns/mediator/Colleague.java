package patterns.mediator;


public interface Colleague {

    // 一位“同事”开始工作后，可以通知其他“同事”帮忙
    void startWork();

    void helpWork();

    boolean hasFreeTime();

    void findHelp();

}
