package com.leaflea.johndoran.projecti;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by John on 01/08/16.
 */
public class Theme {
    Boolean firstTime=true;
    private static Boolean PPbought=true;
    Wall_plain w1;
    Wall_plain w2;
    Wall_plain w3;
    Wall_plain w4;
    Wall_plain w5;
    Wall_plain w6;
    Ceiling_plain c1;
    Ceiling_plain c2;
    Ceiling_plain c3;
    float z1=0;
    float z2=0;
    float z3=0;
    float LengthOfLevels=0;
    float HeigthOfLevels=0;
    float WidthOfLevels =0;
    CentralisedVariables CV;
    GL10 gl;
    MyRenderer MR;
    renderController rC;
    float vz;
    float[] papx;
    float[] papy;
    float[] papz;
    float[] paptx;
    float[] papty;
    float[] paptz;
    float[] papxr;
    float[] papyr;
    float[] papzr;
    float[] papspeed;
    float[] papspeedr;


    int nop=12;
    public void init(GL10 gl){
        this.gl=gl;
        rC=new renderController();
        this.MR=rC.getMR();
        CV=new CentralisedVariables();
        LengthOfLevels=CV.LengthOfLevels;
        HeigthOfLevels=CV.HeightOfLevels;
        WidthOfLevels =CV.WidthOfLevels ;
        z1=0f              ;
        z2=LengthOfLevels  ;
        z3=LengthOfLevels*2;
        w1 = new Wall_plain();
        w2 = new Wall_plain();
        w3 = new Wall_plain();
        w4 = new Wall_plain();
        w5 = new Wall_plain();
        w6 = new Wall_plain();

        c1 = new Ceiling_plain();
        c2 = new Ceiling_plain();
        c3 = new Ceiling_plain();


        papx =new float[nop];
        papy =new float[nop];
        papz =new float[nop];
        paptx =new float[nop];
        papty =new float[nop];
        paptz =new float[nop];
        papxr=new float[nop];
        papyr=new float[nop];
        papzr=new float[nop];

        papspeed =new float[nop];
        papspeedr=new float[nop];
        for(int c=0;c<nop;c++){

            randomisePP(c);
        }
    }

    public void randomisePP(int c){
        papx[c] =-WidthOfLevels/2f*1.5f+1.5f*WidthOfLevels*(float)Math.random();
        papy[c] =HeigthOfLevels/2f+1f*HeigthOfLevels*(float)Math.random();
        papz[c] =vz+0.2f*LengthOfLevels+0.3f*LengthOfLevels*(float)Math.random();

        papxr[c]=-15f+30f*(float)Math.random();
        papyr[c]=-15f+30f*(float)Math.random();
        papzr[c]=-15f+30f*(float)Math.random();

        paptx[c]=papx[c]+WidthOfLevels/3f*(float)Math.random();
        papty[c]=papy[c]+HeigthOfLevels/3f*(float)Math.random();
        paptz[c]=papz[c]+LengthOfLevels/8f*(float)Math.random();
        papspeed[c] =5f*(0.003f+0.007f*(float)Math.random())*40f/ MR.getFps();
        papspeedr[c]=(0.3f*(float)Math.random()       )*40f/ MR.getFps();

    }

    public void renderPlainTheme(GL10 gl,float vz) {
        this.vz=vz;
        this.gl=gl;
        if (firstTime) {
            init(gl);
            firstTime=false;
        }
        gl.glClearColor(1, 1, 1, 0.8f);
        gl.glClearColor(0, 0, 0, 0.8f);

        w1.Render(gl, z1, false,0.5f, 0f, 0.9f,0.6f, 0.6f, 0.6f);
        w2.Render(gl, z1, true ,0.5f, 0f, 0.9f,0.6f, 0.6f, 0.6f);
        w3.Render(gl, z2, false,0.5f, 0f, 0.9f,0.6f, 0.6f, 0.6f);
        w4.Render(gl, z2, true ,0.5f, 0f, 0.9f,0.6f, 0.6f, 0.6f);
        w5.Render(gl, z3, false,0.5f, 0f, 0.9f,0.6f, 0.6f, 0.6f);
        w6.Render(gl, z3, true ,0.5f, 0f, 0.9f,0.6f, 0.6f, 0.6f);

        c1.Render(gl, -CV.HeightOfLevels / 2, z1, false);
        c2.Render(gl, -CV.HeightOfLevels / 2, z2, false);
        c3.Render(gl, -CV.HeightOfLevels / 2, z3, false);
        if ((vz > (z1 + CV.LengthOfLevels))) {
            z1 = z1 + CV.LengthOfLevels;
            z2 = z2 + CV.LengthOfLevels;
            z3 = z3 + CV.LengthOfLevels;
        }
    }

    public void renderPaperPlaneTheme(GL10 gl,float vz){
        this.vz=vz;
        this.gl=gl;
        if (firstTime) {
            init(gl);
            firstTime=false;
        }
        gl.glClearColor(1, 1, 1, 0.8f);
        gl.glClearColor(0, 0, 0, 0.8f);

        w1.Render(gl, z1, false,0.8f,0.8f,0.8f);
        w2.Render(gl, z1, true ,0.8f,0.8f,0.8f);
        w3.Render(gl, z2, false,0.8f,0.8f,0.8f);
        w4.Render(gl, z2, true ,0.8f,0.8f,0.8f);
        w5.Render(gl, z3, false,0.8f,0.8f,0.8f);
        w6.Render(gl, z3, true ,0.8f,0.8f,0.8f);

        c1.Render(gl, -CV.HeightOfLevels / 2, z1, false,0.5f,0.5f,1f);
        c2.Render(gl, -CV.HeightOfLevels / 2, z2, false,0.5f,0.5f,1f);
        c3.Render(gl, -CV.HeightOfLevels / 2, z3, false,0.5f,0.5f,1f);
        if ((vz > (z1 + CV.LengthOfLevels))) {
            z1 = z1 + CV.LengthOfLevels;
            z2 = z2 + CV.LengthOfLevels;
            z3 = z3 + CV.LengthOfLevels;
        }



        renderPaps();
    }
    float last=0;
    float change=0;
    public void renderPaps(){

        for(int c=0;c<nop;c++){

            float difflimit=10f;
            float diffx=paptx[c]-papx[c];
            if(diffx>difflimit){
                diffx=difflimit;
            }else if(diffx<-difflimit){
                diffx=-difflimit;
            }

            papxr[c]=papxr[c]+diffx*papspeedr[c];
            papx[c]=papx[c]+papspeed[c]*papxr[c];

            float diffy=papty[c]-papy[c];
            if(diffy>difflimit){
                diffy=difflimit;
            }else if(diffy<-difflimit){
                diffy=-difflimit;
            }

            papyr[c]=papyr[c]+diffy*papspeedr[c];
            papy[c]=papy[c]+papspeed[c]*papyr[c];

            float diffz=paptz[c]-papz[c];
            if(diffz>difflimit){
                diffz=difflimit;
            }else if(diffz<-difflimit){
                diffz=-difflimit;
            }
            papzr[c]=papzr[c]+diffz*papspeedr[c];
            change=vz-last;
            papz[c]=papz[c]+papspeed[c]*papzr[c]+change*0.8f
            ;
            paptz[c]=paptz[c]+change*0.8f
            ;
            float rotlimit=30f;
            if(papxr[c]>rotlimit){
                papxr[c]=rotlimit;
            }else if(papxr[c]<-rotlimit){
                papxr[c]=-rotlimit;
            }

            if(papyr[c]>rotlimit){
                papyr[c]=rotlimit;
            }else if(papyr[c]<-rotlimit){
                papyr[c]=-rotlimit;
            }

            if(papzr[c]>rotlimit){
                papzr[c]=rotlimit;
            }else if(papzr[c]<-rotlimit){
                papzr[c]=-rotlimit;
            }

            last=vz;
            if(papz[c]<vz-10f){
                randomisePP(c);

            }
            renderPaperPlane(papx[c],papy[c],papz[c],papxr[c],-papyr[c],papzr[c]);
        }
    }
    public void renderPaperPlane(float MotorX,float MotorY,float MotorZ,float xrot,float yrot,float zrot){



        gl.glPushMatrix();
        {

            gl.glTranslatef(MotorX, MotorY, MotorZ);

            gl.glRotatef(xrot, 0,1,0);
            gl.glRotatef(yrot, 0, 0, 1);
            gl.glRotatef(zrot, 1, 0, 0);

            rC.drawWithBuffers(gl,true,MR.getmPaperPlaneVerts(),MR.getmPaperPlaneColor(),MR.getmPaperPlaneInd(),36);
        }
        gl.glPopMatrix();
    }


    public static Boolean getPPbought() {
        return PPbought;
    }

    public static void setPPbought(Boolean PPbought) {
        Theme.PPbought = PPbought;
    }
}
