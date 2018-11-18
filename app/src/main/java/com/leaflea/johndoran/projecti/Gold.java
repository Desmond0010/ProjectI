package com.leaflea.johndoran.projecti;



import javax.microedition.khronos.opengles.GL10;


public class Gold {


    public float getX(){
        return xpos;

    }
    public float getY(){
        return ypos;

    }
    public float getZ(){
        return zpos;

    }
    public static float getLength(){
        return length;

    }
    public static float getWidth(){
        return width;

    }
    public static float getHeight(){
        return height;

    }



    public float getDIAMONDwidth() {
        return DIAMONDwidth;
    }

    public float getDIAMONDlength() {
        return DIAMONDlength;
    }

    public float getDIAMONDheight() {
        return DIAMONDheight;
    }

    public int getValue() {
        return value;
    }

    public static float transparency=0.9f;
    public static float DIAMONDlength =3f*1/6f;
    public static float DIAMONDwidth  =3f*1/3f;
    public static float DIAMONDheight =2f;
    public float xpos    =0;
    public float ypos    =0;
    public float zpos    =1000000;
    public static float length  =3f*2f*6f;
    public static float width   =3f*2f*3f;
    public static float height  =3f*2f*2f;
    int value=1;

    static GL10 gl;
    public static MyRenderer MR;
    public static renderController rC=new renderController();
    public Gold(){
        this.MR=rC.getMR();

    }
    //public static float multiplier=1f;
    static Boolean init=false;
    public Gold(GL10 gl,float X,float Y,float Z,int value) {


        if(!init) {

            for (int c = 0; c < GOLD1Verts.length/3; c++) {
                GOLD1Verts[c*3+0] = GOLD1Verts[c*3+0] * width;
                GOLD1Verts[c*3+1] = GOLD1Verts[c*3+1] * height;
                GOLD1Verts[c*3+2] = GOLD1Verts[c*3+2] * length;

            }
            for (int c = 0; c < GOLD2Verts.length/3; c++) {

                GOLD2Verts[c*3+0] = GOLD2Verts[c*3+0] * width;
                GOLD2Verts[c*3+1] = GOLD2Verts[c*3+1] * height;
                GOLD2Verts[c*3+2] = GOLD2Verts[c*3+2] * length;
            }
            for (int c = 0; c < GOLD3Verts.length/3; c++) {

                GOLD3Verts[c*3+0] = GOLD3Verts[c*3+0] * width;
                GOLD3Verts[c*3+1] = GOLD3Verts[c*3+1] * height;
                GOLD3Verts[c*3+2] = GOLD3Verts[c*3+2] * length;
            }
            calculateDimensions();

            init=true;
        }
        this.MR=rC.getMR();
        this.gl=gl;

        this.xpos=X;
        this.ypos=Y;
        this.zpos=Z;
        this.value=value;
        switch(value){


            case 1:
                RenderGOLD(xpos,ypos,zpos);
                break;

            case 2:
                RenderPLATINUM(xpos,ypos,zpos);
                break;

            case 3:
                RenderDIAMOND(xpos,ypos,zpos);
                break;

            default:
                RenderGOLD(xpos,ypos,zpos);
        }
    }
    static float[] GW=new float[3];//x
    static float[] GH=new float[3];//y
    static float[] GL=new float[3];//z
    static float[] GX=new float[3];
    static float[] GY=new float[3];
    static float[] GZ=new float[3];

    public static void calculateDimensions(){
        int d=0;
        for(int c=0;c<GOLD1Verts.length/3;c++){
            if(c==0){
                GW[d]=GOLD2Verts[c*3+0];
                GX[d]=GOLD2Verts[c*3+0];
                GH[d]=GOLD2Verts[c*3+1];
                GY[d]=GOLD2Verts[c*3+1];
                GL[d]=GOLD2Verts[c*3+2];
                GZ[d]=GOLD2Verts[c*3+2];
            }

            if(GOLD1Verts[c*3+0]>GW[d]){
                GW[d]=GOLD1Verts[c*3+0] ;
            }
            if(GOLD1Verts[c*3+0]<GX[d]){
                GX[d]=GOLD1Verts[c*3+0] ;
            }
            if(GOLD1Verts[c*3+1]>GH[d]){
                GH[d]=GOLD1Verts[c*3+1];
            }
            if(GOLD1Verts[c*3+1]<GY[d]){
                GY[d]=GOLD1Verts[c*3+1];
            }
            if(GOLD1Verts[c*3+2]>GL[d]){
                GL[d]=GOLD1Verts[c*3+2];
            }
            if(GOLD1Verts[c*3+2]<GZ[d]){
                GZ[d]=GOLD1Verts[c*3+2];
            }
        }
        d++;
        for(int c=0;c<GOLD2Verts.length/3;c++){
            if(c==0){
                    GW[d]=GOLD2Verts[c*3+0];
                    GX[d]=GOLD2Verts[c*3+0];
                    GH[d]=GOLD2Verts[c*3+1];
                    GY[d]=GOLD2Verts[c*3+1];
                    GL[d]=GOLD2Verts[c*3+2];
                    GZ[d]=GOLD2Verts[c*3+2];
            }
            if(GOLD2Verts[c*3+0]>GW[d]){
                GW[d]=GOLD2Verts[c*3+0];
            }
            if(GOLD2Verts[c*3+0]<GX[d]){
                GX[d]=GOLD2Verts[c*3+0];
            }
            if(GOLD2Verts[c*3+1]>GH[d]){
                GH[d]=GOLD2Verts[c*3+1];
            }
            if(GOLD2Verts[c*3+1]<GY[d]){
                GY[d]=GOLD2Verts[c*3+1];
            }
            if(GOLD2Verts[c*3+2]>GL[d]){
                GL[d]=GOLD2Verts[c*3+2];
            }
            if(GOLD2Verts[c*3+2]<GZ[d]){
                GZ[d]=GOLD2Verts[c*3+2];
            }
        }
        d++;
        for(int c=0;c<GOLD3Verts.length/3;c++){
            if(c==0){
                GW[d]=GOLD3Verts[c*3+0];
                GX[d]=GOLD3Verts[c*3+0];
                GH[d]=GOLD3Verts[c*3+1];
                GY[d]=GOLD3Verts[c*3+1];
                GL[d]=GOLD3Verts[c*3+2];
                GZ[d]=GOLD3Verts[c*3+2];
            }
            if(GOLD3Verts[c*3+0]>GW[d]){
                GW[d]=GOLD3Verts[c*3+0];
            }
            if(GOLD3Verts[c*3+0]<GX[d]){
                GX[d]=GOLD3Verts[c*3+0];
            }
            if(GOLD3Verts[c*3+1]>GH[d]){
                GH[d]=GOLD3Verts[c*3+1];
            }
            if(GOLD3Verts[c*3+1]<GY[d]){
                GY[d]=GOLD3Verts[c*3+1];
            }
            if(GOLD3Verts[c*3+2]>GL[d]){
                GL[d]=GOLD3Verts[c*3+2];
            }
            if(GOLD3Verts[c*3+2]<GZ[d]){
                GZ[d]=GOLD3Verts[c*3+2];
            }
        }
        d++;

        for(int c=0;c<3;c++){
            GW[c]=GW[c]-GX[c];
            GH[c]=GH[c]-GY[c];
            GL[c]=GL[c]-GZ[c];


        }
    }

    public float[] getGOLDVerts(int value){
        float[] verts;
        switch(value){
            case 1:
                verts=GOLD1Verts;
                break;
            case 2:
                verts=GOLD2Verts;
                break;
            case 3:
                verts=GOLD3Verts;
                break;
            default:
                verts=GOLD1Verts;
                break;
        }
        return verts;
    }
    public float[] getGOLDColors(int value){
        float[] Colors;
        switch(value){
            case 1:
                Colors=GOLD1Colors;
                break;
            case 2:
                Colors=GOLD2Colors;
                break;
            case 3:
                Colors=GOLD3Colors;
                break;
            default:
                Colors=GOLD1Colors;
                break;
        }
        return Colors;
    }
    public short[] getGOLDInd(int value){
        short[] Ind;
        switch(value){
            case 1:
                Ind=GOLD1Ind;
                break;
            case 2:
                Ind=GOLD2Ind;
                break;
            case 3:
                Ind=GOLD3Ind;
                break;
            default:
                Ind=GOLD1Ind;
                break;
        }
        return Ind;
    }
    public static float[] GOLD1Verts={
            0,0,0   ,      1,0,0,        0,1,0.125f,         1,1,0.125f,
            0,0,0.5f,      1,0,0.5f,     0,1,0.375f,         1,1,0.375f,
            0,0,0.5f,      1,0,0.5f,     0,1,0.625f,         1,1,0.625f,
            0,0,1   ,      1,0,1,        0,1,0.875f,         1,1,0.875f
    };
    public static float[] GOLD1Colors={
            0.85f,0.85f,0.15f,transparency,   0.85f,0.85f,0.15f,transparency,     0.85f,0.85f,0.15f,transparency,    0.85f,0.85f,0.15f,transparency,
            0.85f,0.85f,0.15f,transparency,   0.85f,0.85f,0.15f,transparency,     0.85f,0.85f,0.15f,transparency,    0.85f,0.85f,0.15f,transparency,
            0.85f,0.85f,0.15f,transparency,   0.85f,0.85f,0.15f,transparency,     0.85f,0.85f,0.15f,transparency,    0.85f,0.85f,0.15f,transparency,
            0.85f,0.85f,0.15f,transparency,   0.85f,0.85f,0.15f,transparency,     0.85f,0.85f,0.15f,transparency,    0.85f,0.85f,0.15f,transparency
    };
    public static short[] GOLD1Ind={
            0,1,3,    0,2,3,
            0,2,5,    0,5,6,
            2,3,7,    2,6,7,

            4,5,7,    4,6,7,
            15,14,12,    15,13,12,
            15,13,10,    15,10,9,
            13,12,8,     13,9,8,
            11,10,8,     11,9,8


    };


    public static float T=0.7f;
    public void RenderGOLD(float X,float Y,float Z){
        this.xpos=X;
        this.ypos=Y;
        this.zpos=Z;
        gl.glPushMatrix();

            gl.glTranslatef(xpos, ypos, zpos);
            gl.glColor4f(0.85f, 0.85f, 0.15f, T);
            rC.drawWithBuffers(gl, true, MR.getmGold1Verts(), MR.getmGold1Color(), MR.getmGold1Ind(), GOLD1Ind.length);

        gl.glPopMatrix();
    }


    public static float[] GOLD2Verts={
            0,0,0,         1,0,0,        0,1,0.125f,         1,1,0.125f,
            0,0,0.5f,      1,0,0.5f,     0,1,0.375f,         1,1,0.375f,
            0,0,0.5f,      1,0,0.5f,     0,1,0.625f,         1,1,0.625f,
            0,0,1,         1,0,1,        0,1,0.875f,         1,1,0.875f
    };
    public static float[] GOLD2Colors={
            229f/360f, 228f/360f, 226f/360f,transparency  ,229f/360f, 228f/360f, 226f/360f,transparency,
            229f/360f, 228f/360f, 226f/360f,transparency  ,229f/360f, 228f/360f, 226f/360f,transparency,
            229f/360f, 228f/360f, 226f/360f,transparency  ,229f/360f, 228f/360f, 226f/360f,transparency,
            229f/360f, 228f/360f, 226f/360f,transparency  ,229f/360f, 228f/360f, 226f/360f,transparency,
            229f/360f, 228f/360f, 226f/360f,transparency  ,229f/360f, 228f/360f, 226f/360f,transparency,
            229f/360f, 228f/360f, 226f/360f,transparency  ,229f/360f, 228f/360f, 226f/360f,transparency,
            229f/360f, 228f/360f, 226f/360f,transparency  ,229f/360f, 228f/360f, 226f/360f,transparency,
            229f/360f, 228f/360f, 226f/360f,transparency  ,229f/360f, 228f/360f, 226f/360f,transparency

    };
    /*
    public float[] GOLD2Colors={
            1f,0,0,1f,  1f,0,0,1f,
            1f,0,0,1f,  1f,0,0,1f,
            1f,0,0,1f,  1f,0,0,1f,
            1f,0,0,1f,  1f,0,0,1f,
            1f,0,0,1f,  1f,0,0,1f,
            1f,0,0,1f,  1f,0,0,1f,
            1f,0,0,1f,  1f,0,0,1f,
            1f,0,0,1f,  1f,0,0,1f
    };
    */


    public static short[] GOLD2Ind={
            0,1,3,    0,2,3,
            0,2,5,    0,5,6,
            2,3,7,    2,6,7,
            4,5,7,    4,6,7,
            15,14,12,    15,13,12,
            15,13,10,    15,10,9,
            13,12,8,     13,9,8,
            11,10,8,     11,9,8
    };

    public void RenderPLATINUM(float X,float Y,float Z) {
        this.xpos=X;
        this.ypos=Y;
        this.zpos=Z;
        gl.glPushMatrix();{
            gl.glTranslatef(xpos, ypos, zpos);
            gl.glColor4f(0,0,0, T);

            rC.drawWithBuffers(gl, true, MR.getmGold2Verts(), MR.getmGold2Color(), MR.getmGold2Ind(), GOLD2Ind.length);

        }
        gl.glPopMatrix();
    }


    public static float[] GOLD3Verts={
            0.5f+0                 , 0.5f+DIAMONDheight/2f    , 0.5f+0,
            0.5f+DIAMONDwidth/2f   , 0.5f+0                   , 0.5f+0               ,
            0.5f+0                 , 0.5f+0                   , 0.5f+DIAMONDlength/2f,
            0.5f-DIAMONDwidth/2f   , 0.5f+0                   , 0.5f+0               ,
            0.5f+0                 , 0.5f+0                   , 0.5f-DIAMONDlength/2f,
            0.5f+0                 , 0.5f-DIAMONDheight/2f    , 0.5f+0
    };
    public static float[] GOLD3Colors ={
            105f/360f,  129f/360f,  119f/360f, transparency,
            124f/360f,  143f/360f,  148f/360f, transparency,
            124f/360f,  143f/360f,  148f/360f, transparency,
            124f/360f,  143f/360f,  148f/360f, transparency,
            124f/360f,  143f/360f,  148f/360f, transparency,
            105f/360f,  129f/360f,  119f/360f, transparency
    } ;

    public static float[] getGOLD3Colors(){

        return GOLD3Colors;
    }

    public static short[] GOLD3Ind = {

            (short)0,(short)1,(short)2,
            (short)0,(short)2,(short)3,
            (short)0,(short)3,(short)4,
            (short)0,(short)4,(short)1,

            (short)5,(short)1,(short)2,
            (short)5,(short)2,(short)3,
            (short)5,(short)3,(short)4,
            (short)5,(short)4,(short)1

    };



    public void RenderDIAMOND(float X,float Y,float Z) {
        this.xpos=X;
        this.ypos=Y;
        this.zpos=Z;
        gl.glColor4f(0,1f,0,T);
        gl.glPushMatrix();
        {

            gl.glTranslatef(xpos + DIAMONDwidth / 2f, ypos - DIAMONDheight / 2f, zpos);



            //rC.drawWithBuffers(gl, true, MR.getmGold3Verts(), MR.getmGold3Color(), MR.getmGold3Ind(), GOLD3Ind.length);
            rC.drawWithBuffers(gl, true, rC.vertexBufferGenerator(GOLD3Verts),rC.colorsBufferGenerator(GOLD3Colors) , rC.indexBufferGenerator(GOLD3Ind), GOLD3Ind.length);

        }
        gl.glPopMatrix();
    }

    //public static float getMultiplier() {
    //    return multiplier;
    //}
//
    //public static void setMultiplier(float multipliere) {
    //    multiplier = multipliere;
    //}

    public float[] getGW() {
        return GW;
    }

    public void setGW(float[] GW) {
        this.GW = GW;
    }

    public float[] getGH() {
        return GH;
    }

    public void setGH(float[] GH) {
        this.GH = GH;
    }

    public float[] getGL() {
        return GL;
    }

    public void setGL(float[] GL) {
        this.GL = GL;
    }

    public float[] getGX() {
        return GX;
    }

    public void setGX(float[] GX) {
        this.GX = GX;
    }

    public float[] getGY() {
        return GY;
    }

    public void setGY(float[] GY) {
        this.GY = GY;
    }

    public float[] getGZ() {
        return GZ;
    }

    public void setGZ(float[] GZ) {
        this.GZ = GZ;
    }
}
