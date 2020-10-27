package patterns.builder;

/*
*  定义如何构建一个产品的各个部件
* */
public interface Builder {

    void buildPartOne();

    void buildPartTwo();

    void buildPartThree();

    String getResult();
}
