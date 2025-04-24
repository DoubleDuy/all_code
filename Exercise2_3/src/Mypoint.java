public class Mypoint {
        private int x=0;
        private int y=0;
        //intitlalize constructor
        //overloading constructor
        public Mypoint(){}//default constructor
        public Mypoint(int x,int y){
            this.x=x;//this หมายถึงอ้างอิงที่ทรัพยากร คลาสที่กำลังทำงานอยู่
            this.y=y;
        }
        //intitialize constructor
        public int getX(){
            return this.x;

        }
        public void setX(int x){
            this.x=x;
        }
        public int getY(){
            return this.y;
        }
        public void setY(int y){
            this.y=y;
        }
        public int[] getXY(){
           int[] result=new int[]{this.x,this.y};
           return result;
        }
        public void setXY(int x,int y){
            this.x=x;
            this.y=y;

        }
        public String toString(){
            return "("+this.x+","+this.y+")";

        }
        //intitialize constructor
        public double distance(int x,int y){
            //distance from this point and given point
            return Math.sqrt(Math.pow(this.x-x,2)+Math.pow(this.y-y,2));
        }
        public double distance(Mypoint another){
            int givenX=another.x;
            int givenY=another.y;
            return Math.sqrt(Math.pow(this.x-givenX,2)+Math.pow(this.y-givenY,2));
        }
        public double distance(){
            return Math.sqrt(Math.pow(this.x-0,2)+Math.pow(this.y-0,2));

        }

    }


