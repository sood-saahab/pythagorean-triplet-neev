import java.util.*;

class PythagoreanTriplet {
    int a,b,c;

    PythagoreanTriplet(int a, int b, int c) {
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public String toString(){
        return String.format("(%d,%d,%d)",a,b,c);
    }
    public boolean equals(Object o){
        if(this==o)
            return true;
        else if(o instanceof PythagoreanTriplet){
            PythagoreanTriplet pt=(PythagoreanTriplet) o;
            return a==pt.a && b==pt.b && c==pt.c;
        }
        else
            return false;
    }
    static TripletListBuilder makeTripletsList() {
        return new TripletListBuilder();
    }

    static class TripletListBuilder {
        int sum;
        Integer maxFactor=null;
        static final double perimeter_ratio=1+1+Math.sqrt(2);
        TripletListBuilder thatSumTo(int sum) {
            this.sum=sum;
            if(maxFactor==null)
                maxFactor=sum;
            return this;
        }

        TripletListBuilder withFactorsLessThanOrEqualTo(int maxFactor) {
            this.maxFactor=maxFactor;
            return this;
        }

        List<PythagoreanTriplet> build() {
            List<PythagoreanTriplet> triplets=new ArrayList<>();
            for(int a=1;a<=Math.floor(sum/perimeter_ratio);a++){
                int numenator=a*a+(int)Math.pow(sum-a,2);
                int denomenator=2*(sum-a);
                if(numenator%denomenator==0){
                    int c=numenator/denomenator;
                    if(c<=maxFactor){
                        int b=sum-a-c;
                        triplets.add(new PythagoreanTriplet(a,b,c));
                    }
                }
            }
            return triplets;
        }

    }

}