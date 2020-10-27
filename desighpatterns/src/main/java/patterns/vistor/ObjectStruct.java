package patterns.vistor;

import java.util.ArrayList;
import java.util.Collection;

public class ObjectStruct {

    private Collection<Element> elements = new ArrayList<>(10);

    public void vistorElement(Visitor visitor){
        elements.stream().forEach(element -> {
            element.accept(visitor);
        });
    }
}
