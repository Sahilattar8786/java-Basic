package OOPS3.inheritance;

public class Box {
    double l;
    double w;
    double h;
//
  Box(){
      this.l=-1;
      this.w=-1;
      this.h=-1;
  }
  //cube
  Box(double side){
      this.w=side;
      this.l=side;
  }
   Box(double l, double w, double h) {
    this.l = l;
    this.w = w;
    this.h = h;
  }
  Box (Box Old){
      this.l = Old.l;
      this.w = Old.w;
      this.h = Old.h;
  }

  public void display(){
      System.out.println("Running this box");
      System.out.println("l="+l);
  }
}

class BoxWeight extends Box{
  double weight;
  BoxWeight (){
      this.weight=-1;
  }
  BoxWeight (double l, double w , double  h , double weight ){
      super(l,w,h);   //  super keyword is used to call parent class constructor in child class
      this.weight = weight;
  }
  BoxWeight (double side,double weight){
      super(side);
      this.weight=weight;
  }

}

class BoxPrice extends  BoxWeight {
    double cost;
    BoxPrice (){
      super();
      this.cost=-1;
    }
    BoxPrice (double l, double w , double h, double cost,double weight){
        super(l,w,h,weight);
        this.cost=cost;
    }
    BoxPrice (double side , double weight, double cost){
        super(side,weight);
        this.cost=cost;
    }

}
