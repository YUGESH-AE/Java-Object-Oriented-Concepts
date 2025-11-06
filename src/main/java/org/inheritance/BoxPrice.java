package org.inheritance;

public class BoxPrice  extends BoxWeight{
    
    double cost;

    public BoxPrice(){
        super();
        this.cost=-1;
    }

    public BoxPrice(BoxPrice boxPrice){
        super(boxPrice);
        this.cost=boxPrice.cost;
    }
}
