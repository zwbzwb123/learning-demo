package patterns.builder;

/*
*  持有 builder，指导一个产品的构建
*  本质：分离整体构建算法与部件构造
* */
public class Director {

    Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    public void constructor(){

        // 在实际场景中，可能还需要一些运算并为builder提供参数
        builder.buildPartOne();
        builder.buildPartTwo();
        builder.buildPartThree();
    }
}
