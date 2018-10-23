package com.leaflea.johndoran.projecti;

/**
 * Created by John on 27/06/16.
 */
public class Steering {


    public static MyRenderer MR;

    private static float cmx=0;
    private static float cmy=0;

    public Steering(MyRenderer MR){
        this.setMR(MR);
    }

    public static float getAccelerationx() {
        return accelerationx;
    }

    public static void setAccelerationx(float accelerationx) {
        Steering.accelerationx = accelerationx;
    }

    public static float getAccelerationy() {
        return accelerationy;
    }

    public static void setAccelerationy(float accelerationy) {
        Steering.accelerationy = accelerationy;
    }

    public static float getVelx() {
        return velx;
    }

    public static void setVelx(float velx) {
        Steering.velx = velx;
    }

    public static float getVely() {
        return vely;
    }

    public static void setVely(float vely) {
        Steering.vely = vely;
    }

    public static float getCmx() {
        return cmx;
    }

    public static void setCmx(float cmx) {
        Steering.cmx = cmx;
    }

    public static float getCmy() {
        return cmy;
    }

    public static void setCmy(float cmy) {
        Steering.cmy = cmy;
    }

    public void simple(){
        MR=renderController.getMR();
        getMR().fmx=(int) getMR().Screen_Width /2;
        getMR().fmy=(int) getMR().Screen_Height/10*7;//  Screen_Height/5*3


        float handling_ability=(0.2f+
                (getMR().vehicles[getMR().selected_vehicle].getHandling()+ getMR().vehicles[getMR().selected_vehicle].getHandlingPlus()))/20f;


        getMR().default_x_vrotspeed=1f;
        if (Math.abs((int)(getMR().mx- getMR().fmx))<80) {
            getMR().magcounterx = ((float) getMR().mx - (float) getMR().fmx) / 80f;
        }else{
            getMR().magcounterx = 80f/80f *
                    (float)((getMR().mx- getMR().fmx)/Math.abs((int)(getMR().mx- getMR().fmx)));   //+ or -
        }
        getMR().setXrot(-1f*((1-handling_ability)* getMR().magcounterx* getMR().rotlimit+handling_ability* getMR().getXrot()));
        if (getMR().getXrot() < -getMR().rotlimit) {
            getMR().setXrot(-getMR().rotlimit);}
        if (getMR().getXrot() >  getMR().rotlimit) {
            getMR().setXrot(getMR().rotlimit);}
        float madeupx = getMR().getXrot() * getMR().xTCSpeed;


        getMR().default_y_vrotspeed=1f;
        if (Math.abs((int)(getMR().my- getMR().fmy))<80) {
            getMR().magcountery = ((float) getMR().my - (float) getMR().fmy) / 80f;
        }else{
            getMR().magcountery = 80f/80f *
                    (float)((getMR().my- getMR().fmy)/Math.abs((int)(getMR().my- getMR().fmy)));   //+ or -
        }
        getMR().setYrot(-1f*((1-handling_ability)* getMR().magcountery* getMR().rotlimit+handling_ability* getMR().getYrot()));
        if (getMR().getYrot() < -getMR().rotlimit) {
            getMR().setYrot(-getMR().rotlimit);}
        if (getMR().getYrot() >  getMR().rotlimit) {
            getMR().setYrot(getMR().rotlimit);}

        float madeupy = getMR().getYrot() * getMR().yTCSpeed;

        getMR().vx = getMR().vx + madeupx;
        getMR().vy = getMR().vy + madeupy;
    }



    public static float accelerationx=0;
    public static float accelerationy=-1f;
    public static float velx=0;
    public static float vely=0;


    public void gravity(){
        MR=renderController.getMR();
        float velx= getMR().getVelx();
        float vely= getMR().getVely();

        Boolean active=false;
        float speedlimit=(float) getMR().speedlimit;

        float fmx=(float) getMR().fmx;
        float fmy=(float) getMR().fmy;
        float Screen_Width=(float) getMR().Screen_Width;
        float Screen_Height=(float) getMR().Screen_Height;
        float default_x_vrotspeed=(float) getMR().default_x_vrotspeed;
        float magcounterx=(float) getMR().magcounterx;
        cmx=(float) getMR().mx;
        float xrot=(float) getMR().getXrot();
        float xTCSpeed=(float) getMR().xTCSpeed;
        float magcountery=(float) getMR().magcountery;
        cmy=(float) getMR().my;
        float yrot=(float) getMR().getYrot();
        float rotlimit=(float) getMR().rotlimit;

        float yTCSpeed=(float) getMR().yTCSpeed;
        float handlingGrade=getMR().vehicles[getMR().selected_vehicle].getHandling()
                + getMR().vehicles[getMR().selected_vehicle].getHandlingPlus();
        float handling_ability=(0.5f+
                (handlingGrade)/5f);

        float controlGrade=getMR().vehicles[getMR().selected_vehicle].getSize()
                         + getMR().vehicles[getMR().selected_vehicle].getSizePlus();;
        float pm=1f;

        {
            float mag=(float)Math.sqrt((double)(((fmx-cmx)*(fmx-cmx))+((fmy-cmy)*(fmy-cmy))));
            float sin=(-fmy+cmy)/mag;
            float cos=(-fmx+cmx)/mag;
            float base=100f;
            if(mag>base){
                cmx=fmx+base*cos;
                cmy=fmy+base*sin;
            }

        }

        //handling_ability=(MR.getM1())*5f;

        if(getMR().mouseDown&&
                cmy>Screen_Height*0.1f){
            active=true;
        }else{
            active=false;
        }
        float timeMod=MR.calculateTimeMod();

        setAccelerationy(timeMod*-0.1f);
        //setAccelerationy(0);
        setAccelerationx(0);


        fmx=Screen_Width  * 0.5f;
        fmy=Screen_Height * 0.7f;
        getMR().fmx=(int)fmx;
        getMR().fmy=(int)fmy;
        float dist=timeMod*handling_ability*0.00005f*(float)Math.sqrt((double)(cmx-fmx)*(cmx-fmx)+(cmy-fmy)*(cmy-fmy));
        if (active) {

            setAccelerationx(getAccelerationx() +dist*(cmx-fmx)*pm);

            setAccelerationy(getAccelerationy() +dist*(cmy-fmy));

            getMR().setZrot(-45f*  (cmx-fmx)/(Screen_Width)*pm);
            getMR().setYrot(-45f* (cmy-fmy-30f)/
                    (Screen_Height*0.35f));//divide by bigger number so that more of the screen does less of the work

        }

        float vlim=2f;

        //MR.setVelx(velx * (1f - handlingGrade / 50f) + timeMod*getAccelerationx());
        //MR.setVely(vely * (1f - handlingGrade / 50f) + timeMod*getAccelerationy());

        //original//MR.setVelx(velx * (float)Math.pow((double)(0.999f-handlingGrade/100f*0.5f),timeMod) + timeMod*getAccelerationx());
        //original//MR.setVely(vely * (float)Math.pow((double)(0.999f-handlingGrade/100f*0.5f),timeMod) + timeMod*getAccelerationy());


        if(Math.abs(velx)>vlim){
            if(velx>0){
                velx=vlim;
            }else{
                velx=-vlim;
            }
        }

        if(Math.abs(vely)>vlim){
            if(vely>0){
                vely=vlim;
            }else{
                vely=-vlim;
            }
        }

        MR.setVelx(velx * (float)Math.pow((double)(1f-(controlGrade-4)/100f*0.5f),timeMod) + timeMod*getAccelerationx());
        MR.setVely(vely * (float)Math.pow((double)(1f-(controlGrade-4)/100f*0.5f),timeMod) + timeMod*getAccelerationy());



        velx=MR.getVelx();
        vely=MR.getVely();
        getMR().vx = getMR().vx + timeMod*velx;
        getMR().vy = getMR().vy + timeMod*vely;
    }


    public void gravity(float m1,float m2){
        MR=renderController.getMR();
        float velx= getMR().getVelx();
        float vely= getMR().getVely();
        float fmx=(float) getMR().fmx;
        float fmy=(float) getMR().fmy;
        float Screen_Width=(float) getMR().Screen_Width;
        float Screen_Height=(float) getMR().Screen_Height;
        Boolean active=false;
        float speedlimit=(float) getMR().speedlimit;
        float default_x_vrotspeed=(float) getMR().default_x_vrotspeed;float magcounterx=(float) getMR().magcounterx;float xrot=(float) getMR().getXrot();float xTCSpeed=(float) getMR().xTCSpeed;float magcountery=(float) getMR().magcountery;float yrot=(float) getMR().getYrot();float rotlimit=(float) getMR().rotlimit;float yTCSpeed=(float) getMR().yTCSpeed;

        cmx=(float) getMR().mx;

        cmy=(float) getMR().my;
        float handlingGrade=getMR().vehicles[getMR().selected_vehicle].getHandling()
                + getMR().vehicles[getMR().selected_vehicle].getHandlingPlus();
        float handling_ability=(0.5f+
                (handlingGrade)/5f);

        float controlGrade=getMR().vehicles[getMR().selected_vehicle].getSize()
                + getMR().vehicles[getMR().selected_vehicle].getSizePlus();;
        float pm=1f;

        {
            float mag=(float)Math.sqrt((double)(((fmx-cmx)*(fmx-cmx))+((fmy-cmy)*(fmy-cmy))));
            float sin=(-fmy+cmy)/mag;
            float cos=(-fmx+cmx)/mag;
            float base=100f;
            if(mag>base){
                cmx=fmx+base*cos;
                cmy=fmy+base*sin;
            }

        }

        //handling_ability=(MR.getM1())*5f;

        if(getMR().mouseDown&&
                cmy>Screen_Height*0.1f){
            active=true;
        }else{
            active=false;
        }
        float timeMod=MR.calculateTimeMod();

        setAccelerationy(timeMod * -0.1f);
        //setAccelerationy(0);
        setAccelerationx(0);


        fmx=Screen_Width  * 0.5f;
        fmy=Screen_Height * 0.7f;
        getMR().fmx=(int)fmx;
        getMR().fmy=(int)fmy;

        float adjustMod=m1;


        //log of x to the base 0.9 as 0.9 of the xrotPercent is what I aim should be achievable in the same timeframe
        //n is therefor the number of 25th`s of a second which should pass before

        //  1/(adjustMod*timeMod) number of frames of seconds before xrotDesiredPercentage is reached
        double n=0;


        //m1 depends on size
        //m1=(float)Math.pow(10d,(double)(controlGrade)/10f-1d);
        m1=(float)Math.pow(35d,(double)((m1+0.1f)/1.1f/10f)-1d);

        //m2 depends on handling
        //m2=(float)Math.pow(10d,(double)(handlingGrade)/10f-1d);
        m2=(float)Math.pow(2.3d,((double)((m2+0.1f)/1.1f/10f)-1d));

        float xrotDesiredPercent=(cmx-fmx)/(Screen_Width/2f)*pm;
        float yrotDesiredPercent=(cmy-fmy-30f)/(Screen_Height*0.35f);

        float xrotPercent= getMR().getZrot() /-45f;
        float yrotPercent= getMR().getYrot() /-45f;


        float reductiondegree=(float)Math.log10((double)(1/((m1+0.1f)/1.1f)))
                ;
        float reductionDegreeTimeAdj=(float)Math.pow((double)reductiondegree,(double)timeMod);

        adjustMod=1-reductionDegreeTimeAdj;

        getMR().setZrot(getMR().getZrot() *reductiondegree);
        getMR().setYrot(getMR().getYrot() *reductiondegree);


        xrotPercent=xrotPercent+adjustMod* (xrotDesiredPercent-xrotPercent);
        yrotPercent=yrotPercent+adjustMod* (yrotDesiredPercent-yrotPercent);
        getMR().setZrot(-45f* xrotPercent);
        getMR().setYrot(-45f* yrotPercent);






        float dist=timeMod*m2*0.025f*(float)Math.sqrt((double)(cmx-fmx)*(cmx-fmx)+(cmy-fmy)*(cmy-fmy));
        setAccelerationx(//getAccelerationx() +
                timeMod*dist *(xrotPercent) * pm);
        setAccelerationy(//getAccelerationy() +
                (timeMod*dist *(yrotPercent)) //+timeMod*-0.03f
        )    ;



        float vlim=2f;

        if(Math.abs(velx)>vlim){
            if(velx>0){
                velx=vlim;
            }else{
                velx=-vlim;
            }
        }
        if(Math.abs(vely)>vlim){
            if(vely>0){
                vely=vlim;
            }else{
                vely=-vlim;
            }
        }
        //hm//MR.setVelx(velx * (float)Math.pow((double)(1f-(controlGrade-4)/100f*0.5f),timeMod) + timeMod*getAccelerationx());
        //hm//MR.setVely(vely * (float)Math.pow((double)(1f-(controlGrade-4)/100f*0.5f),timeMod) + timeMod*getAccelerationy());

        MR.setVelx(velx + timeMod*getAccelerationx());
        MR.setVely(vely + timeMod*getAccelerationy());

        velx=MR.getVelx();
        vely=MR.getVely();
        getMR().vx = getMR().vx + timeMod*velx;
        getMR().vy = getMR().vy + timeMod*vely;
    }


    public void nogravity(float m1,
                          float m2){

        float handlingGrade=getMR().vehicles[getMR().selected_vehicle].getHandling()
                + getMR().vehicles[getMR().selected_vehicle].getHandlingPlus();
        float controlGrade=getMR().vehicles[getMR().selected_vehicle].getSize()
                + getMR().vehicles[getMR().selected_vehicle].getSizePlus();;


        m1=2f+handlingGrade/6f*4f;
        m2=2f+controlGrade /6f*4f;


        MR=renderController.getMR();
        float velx= getMR().getVelx();
        float vely= getMR().getVely();
        float fmx=(float) getMR().fmx;
        float fmy=(float) getMR().fmy;
        float Screen_Width=(float) getMR().Screen_Width;
        float Screen_Height=(float) getMR().Screen_Height;
        Boolean active=false;
        float speedlimit=(float) getMR().speedlimit;
        float default_x_vrotspeed=(float) getMR().default_x_vrotspeed;float magcounterx=(float) getMR().magcounterx;float xrot=(float) getMR().getXrot();float xTCSpeed=(float) getMR().xTCSpeed;float magcountery=(float) getMR().magcountery;float yrot=(float) getMR().getYrot();float rotlimit=(float) getMR().rotlimit;float yTCSpeed=(float) getMR().yTCSpeed;
        cmx=(float) getMR().mx;
        cmy=(float) getMR().my;
        float pm=1f;
        {
            float mag=(float)Math.sqrt((double)(((fmx-cmx)*(fmx-cmx))+((fmy-cmy)*(fmy-cmy))));
            float sin=(-fmy+cmy)/mag;
            float cos=(-fmx+cmx)/mag;
            float base=100f;
            if(mag>base){
                cmx=fmx+base*cos;
                cmy=fmy+base*sin;
            }
        }
        if(getMR().mouseDown&&
                cmy>Screen_Height*0.1f){
            active=true;
        }else{
            active=false;
        }
        float timeMod=MR.calculateTimeMod();

        setAccelerationy(timeMod * -0.1f);
        //setAccelerationy(0);
        setAccelerationx(0);

        fmx=Screen_Width  * 0.5f;
        fmy=Screen_Height * 0.7f;
        getMR().fmx=(int)fmx;
        getMR().fmy=(int)fmy;

        float adjustMod=m1;

        //log of x to the base 0.9 as 0.9 of the xrotPercent is what I aim should be achievable in the same timeframe
        //n is therefor the number of 25th`s of a second which should pass before

        //  1/(adjustMod*timeMod) number of frames of seconds before xrotDesiredPercentage is reached
        double n=0;


        float maxXrot=55f;
        float maxYrot=55f;


        //m1 depends on size
        //m1=(float)Math.pow(10d,(double)(controlGrade)/10f-1d);




        m1=(float)Math.pow(50d,(double)((m1+0.699f)/1.7f/10f)-1d)
        //1f
        ;
        if(m1>=1){
            m1=0.999f;
        }

        //m2 depends on handling
        //m2=(float)Math.pow(10d,(double)(handlingGrade)/10f-1d);


        m2=14f*(float)Math.pow(21d,((double)((m2+0.6f)/1.7f/10f)-1d));

        float xrotDesiredPercent=(cmx-fmx)/(Screen_Width/2f)*pm;
        float yrotDesiredPercent=(cmy-fmy)/(Screen_Height*0.35f);

        float xrotPercent= getMR().getZrot() /-maxXrot;
        float yrotPercent= getMR().getYrot() /-maxYrot;


        float reductiondegree=(float)Math.log10((double)(1/((m1+0.1f)/1.1f)))
                ;
        float reductionDegreeTimeAdj=(float)Math.pow((double) reductiondegree, (double) timeMod);

        //float reductionDegreeTimeAdj=(float)Math.pow((double)0.99d,(double)timeMod);


        adjustMod=1-reductionDegreeTimeAdj;

        //xrotPercent = xrotPercent*reductionDegreeTimeAdj;
        //yrotPercent = yrotPercent*reductionDegreeTimeAdj;
        if(active) {

            xrotPercent = xrotPercent + adjustMod * (xrotDesiredPercent - xrotPercent);
            yrotPercent = yrotPercent + adjustMod * (yrotDesiredPercent - yrotPercent);
        }


        getMR().setZrot(-maxXrot * xrotPercent);
        getMR().setXrot(Math.abs(0.7f * maxXrot * xrotPercent));

        getMR().setYrot(-maxYrot* yrotPercent);

        reductiondegree=1-(1-reductiondegree)/6f;
        getMR().setZrot(getMR().getZrot() *reductiondegree);
        getMR().setYrot(getMR().getYrot() * reductiondegree);
        getMR().setXrot(getMR().getXrot() * reductiondegree);


        float dist=timeMod*m2*0.025f*(float)Math.sqrt((double)(cmx-fmx)*(cmx-fmx)+(cmy-fmy)*(cmy-fmy));
        setAccelerationx(//getAccelerationx() +
                timeMod*dist *(xrotPercent) * pm);
        setAccelerationy(//getAccelerationy() +
                (timeMod*dist *(yrotPercent)) //+timeMod*-0.03f
        )    ;

        float vlim=2f;


        double timeStop=1.5d-(double)m1/12d*1.5d;
        double frameStopAdj=timeStop*25d/timeMod;

        double red=Math.pow(0.1,1d/frameStopAdj);

        velx=velx*(float)red;
        vely=vely*(float)red;

        if(Math.abs(velx)>vlim){
            if(velx>0){
                velx=vlim;
            }else{
                velx=-vlim;
            }
        }
        if(Math.abs(vely)>vlim){
            if(vely>0){
                vely=vlim;
            }else{
                vely=-vlim;
            }
        }
        //hm//MR.setVelx(velx * (float)Math.pow((double)(1f-(controlGrade-4)/100f*0.5f),timeMod) + timeMod*getAccelerationx());
        //hm//MR.setVely(vely * (float)Math.pow((double)(1f-(controlGrade-4)/100f*0.5f),timeMod) + timeMod*getAccelerationy());

            MR.setVelx(velx + timeMod * getAccelerationx());
            MR.setVely(vely + timeMod * getAccelerationy());

            velx = MR.getVelx();
            vely = MR.getVely();


        getMR().vx = getMR().vx + timeMod*velx;
        getMR().vy = getMR().vy + timeMod*vely;
    }


















    public void nogravityold(){

        float handlingGrade=getMR().vehicles[getMR().selected_vehicle].getHandling()
                + getMR().vehicles[getMR().selected_vehicle].getHandlingPlus();
        float controlGrade=getMR().vehicles[getMR().selected_vehicle].getSize()
                + getMR().vehicles[getMR().selected_vehicle].getSizePlus();;
        float m1=handlingGrade;
        float m2=controlGrade;


        MR=renderController.getMR();
        float velx= getMR().getVelx();
        float vely= getMR().getVely();
        float fmx=(float) getMR().fmx;
        float fmy=(float) getMR().fmy;
        float Screen_Width=(float) getMR().Screen_Width;
        float Screen_Height=(float) getMR().Screen_Height;
        Boolean active=false;
        float speedlimit=(float) getMR().speedlimit;
        float default_x_vrotspeed=(float) getMR().default_x_vrotspeed;float magcounterx=(float) getMR().magcounterx;float xrot=(float) getMR().getXrot();float xTCSpeed=(float) getMR().xTCSpeed;float magcountery=(float) getMR().magcountery;float yrot=(float) getMR().getYrot();float rotlimit=(float) getMR().rotlimit;float yTCSpeed=(float) getMR().yTCSpeed;
        cmx=(float) getMR().mx;
        cmy=(float) getMR().my;
        float pm=1f;
        {
            float mag=(float)Math.sqrt((double)(((fmx-cmx)*(fmx-cmx))+((fmy-cmy)*(fmy-cmy))));
            float sin=(-fmy+cmy)/mag;
            float cos=(-fmx+cmx)/mag;
            float base=100f;
            if(mag>base){
                cmx=fmx+base*cos;
                cmy=fmy+base*sin;
            }
        }
        if(getMR().mouseDown&&
                cmy>Screen_Height*0.1f){
            active=true;
        }else{
            active=false;
        }
        float timeMod=MR.calculateTimeMod();

        setAccelerationy(timeMod * -0.1f);
        //setAccelerationy(0);
        setAccelerationx(0);

        fmx=Screen_Width  * 0.5f;
        fmy=Screen_Height * 0.7f;
        getMR().fmx=(int)fmx;
        getMR().fmy=(int)fmy;

        float adjustMod=m1;

        //log of x to the base 0.9 as 0.9 of the xrotPercent is what I aim should be achievable in the same timeframe
        //n is therefor the number of 25th`s of a second which should pass before

        //  1/(adjustMod*timeMod) number of frames of seconds before xrotDesiredPercentage is reached
        double n=0;


        float maxXrot=45f;
        float maxYrot=45f;


        //m1 depends on size
        //m1=(float)Math.pow(10d,(double)(controlGrade)/10f-1d);




        m1=//(float)Math.pow(10d,(double)((m1+0.699f)/1.7f/10f)-1d)
                1f
        ;
        if(m1>=1){
            m1=0.999f;
        }

        //m2 depends on handling
        //m2=(float)Math.pow(10d,(double)(handlingGrade)/10f-1d);


        m2=2.3f*(float)Math.pow(3d,((double)((m2+0.6f)/1.7f/10f)-1d));

        float xrotDesiredPercent=(cmx-fmx)/(Screen_Width/2f)*pm;
        float yrotDesiredPercent=(cmy-fmy-30f)/(Screen_Height*0.35f);

        float xrotPercent= getMR().getZrot() /-maxXrot;
        float yrotPercent= getMR().getYrot() /-maxYrot;


        float reductiondegree=(float)Math.log10((double)(1/((m1+0.1f)/1.1f)))
                ;
        float reductionDegreeTimeAdj=(float)Math.pow((double)reductiondegree,(double)timeMod);

        adjustMod=1-reductionDegreeTimeAdj;

        getMR().setZrot(getMR().getZrot() * reductiondegree);
        getMR().setYrot(getMR().getYrot() *reductiondegree);
        getMR().setXrot(getMR().getXrot() * reductiondegree);




        if(active) {

            xrotPercent = xrotPercent + adjustMod * (xrotDesiredPercent - xrotPercent);
            yrotPercent = yrotPercent + adjustMod * (yrotDesiredPercent - yrotPercent);
        }

        //xrotPercent=xrotPercent*reductiondegree;
        //yrotPercent=yrotPercent*reductiondegree;
        getMR().setZrot(-maxXrot* xrotPercent);
        getMR().setXrot(maxXrot * xrotPercent);

        getMR().setYrot(-maxYrot * yrotPercent);






        float dist=timeMod*m2*0.025f*(float)Math.sqrt((double)(cmx-fmx)*(cmx-fmx)+(cmy-fmy)*(cmy-fmy));
        setAccelerationx(//getAccelerationx() +
                timeMod*dist *(xrotPercent) * pm);
        setAccelerationy(//getAccelerationy() +
                (timeMod*dist *(yrotPercent)) //+timeMod*-0.03f
        )    ;

        float vlim=2f;

        if(Math.abs(velx)>vlim){
            if(velx>0){
                velx=vlim;
            }else{
                velx=-vlim;
            }
        }
        if(Math.abs(vely)>vlim){
            if(vely>0){
                vely=vlim;
            }else{
                vely=-vlim;
            }
        }





        //velx=velx*1f/((m1+0.1f)/1.1f);
        //vely=vely*1f/((m1+0.1f)/1.1f);

        //hm//MR.setVelx(velx * (float)Math.pow((double)(1f-(controlGrade-4)/100f*0.5f),timeMod) + timeMod*getAccelerationx());
        //hm//MR.setVely(vely * (float)Math.pow((double)(1f-(controlGrade-4)/100f*0.5f),timeMod) + timeMod*getAccelerationy());

        MR.setVelx(velx + timeMod * getAccelerationx());
        MR.setVely(vely + timeMod * getAccelerationy());

        velx = MR.getVelx();
        vely = MR.getVely();


        getMR().vx = getMR().vx + timeMod*velx;
        getMR().vy = getMR().vy + timeMod*vely;
    }

    public float sin(float a){
        return (float)Math.sin((double)a);
    }

    public float asin(float a){
        return (float)Math.asin((double)a);
    }

    public void gravity1(){
        MR=renderController.getMR();
        float velx= getMR().getVelx();
        float vely= getMR().getVely();

        Boolean active=false;
        float fmx=(float) getMR().fmx;
        float fmy=(float) getMR().fmy;
        float Screen_Width=(float) getMR().Screen_Width;
        float Screen_Height=(float) getMR().Screen_Height;
        float default_x_vrotspeed=(float) getMR().default_x_vrotspeed;
        float magcounterx=(float) getMR().magcounterx;
        float mx=(float) getMR().mx;
        float xrot=(float) getMR().getXrot();
        float xTCSpeed=(float) getMR().xTCSpeed;
        float magcountery=(float) getMR().magcountery;
        float my=(float) getMR().my;
        float yrot=(float) getMR().getYrot();
        float rotlimit=(float) getMR().rotlimit;
        float speedlimit=(float) getMR().speedlimit;

        float yTCSpeed=(float) getMR().yTCSpeed;
        float handling_ability=(0.2f+
                (getMR().vehicles[getMR().selected_vehicle].getHandling()+ getMR().vehicles[getMR().selected_vehicle].getHandlingPlus())/2f)/10f;


        float pm=1f;

        if(!active&&(mx>Screen_Width*0.8f)&&(my>Screen_Height*0.3f)){
            //fmx=Screen_Width*0.9f;
            //fmy=Screen_Height*0.35f;
            active=true;
            pm=1f;
        }else if(!active&&(mx<Screen_Width*0.2f)&&(my>Screen_Height*0.3f)){
            //fmx=mx;
            //fmy=my;
            active=true;
            pm=1f;

        }else{
            active=false;
        }

        if(getMR().mouseDown&&my>Screen_Height*0.3f){
            active=true;
        }else{
            active=false;
        }

        setAccelerationx(0);
        setAccelerationy(-1.5f);



        fmx=Screen_Width*0.5f;
        fmy=Screen_Height*0.35f;
        float dist=0.005f*(float)Math.sqrt((double)(mx-fmx)*(mx-fmx)+(my-fmy)*(my-fmy));
        if (active) {

            setAccelerationx(getAccelerationx() +dist*0.018f*(mx-Screen_Width*0.5f)*pm);

            setAccelerationy(getAccelerationy() +dist*0.018f*(my-Screen_Height*0.65f));

            getMR().setXrot(-0.3f* 10f*dist*(mx-Screen_Width*0.5f)/(Screen_Width)*pm);
            getMR().setYrot(-1f  * 10f*dist*(my-Screen_Height*0.65f)/(Screen_Height*0.35f));

        }
        MR.setVelx(velx * 1f + getAccelerationx());
        MR.setVely(vely*1f+ getAccelerationy());


        getMR().vx = getMR().vx + velx;
        getMR().vy = getMR().vy + vely;
    }

    public MyRenderer getMR() {
        return MR;
    }

    public void setMR(MyRenderer MR) {
        this.MR = MR;
    }
}
