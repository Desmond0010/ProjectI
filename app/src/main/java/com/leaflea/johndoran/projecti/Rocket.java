package com.leaflea.johndoran.projecti;

import javax.microedition.khronos.opengles.GL10;

public class Rocket// extends MultiCuboids
{
    public static float size=3f;
    public static float ConeLength=3f*size;
    public static float radius=1.7f*size;
    public float getConeLength() {
        return ConeLength;
    }
    public float getSize() {
        return size;
    }
    public float getRadius() {
        return radius;
    }
    public void setRadius(float radius) {
        this.radius=radius;
    }
    public float getCylLength() {
        return CylLength;
    }
    public float CylLength=8*size;
    float x;
    float y;
    float xvel=0;
    float yvel=0;
    float zvel=0.1f;
    int quarterlayers=40;
    int counter;

    float xpos=0;
    float ypos=0;
    float zpos=0;

    public float getX(){
        return xpos;

    }
    public float getY(){
        return ypos;

    }
    public float getZ(){
        return zpos;

    }
    private Boolean notdone =true;

    public Rocket(){}
    GL10 gl;

    public static renderController rC=new renderController();
    public static MyRenderer MR;
    public Rocket(GL10 gl,float xpos,float ypos,float zpos) {
        this.gl=gl;
        this.MR=rC.getMR();

        this.xpos=xpos;
        this.ypos=ypos;
        this.zpos=zpos;

        //zpos=Main.vz-10;

       // Render();
    }


    public int sides=40;
    public static float[] vertices;
    public static float[] colors;
    public static short[] indices;



    public void makeEverything(){
        vertices=new float[(2*sides)*3+3];
        float tempx;
        float tempy;
        vertices[0]=0;
        vertices[1]=0;
        vertices[2]=0;

        for (int c=1;c<(sides/2+1);c++){

            tempx=(c-1)*radius*2f/(float)sides-radius;
            tempy=(float)Math.sqrt((float)(radius*radius-tempx*tempx));

            vertices[(c)*3+0]=tempx;
            vertices[(c)*3+1]=tempy;
            vertices[(c)*3+2]=getConeLength();

            vertices[(c+sides/2)*3+0]=-tempx;
            vertices[(c+sides/2)*3+1]=-tempy;
            vertices[(c+sides/2)*3+2]=getConeLength();


            vertices[(c+sides)*3+0]=tempx;
            vertices[(c+sides)*3+1]=tempy;
            vertices[(c+sides)*3+2]=getCylLength()+getConeLength();

            vertices[(c+sides/2+sides)*3+0]=-tempx;
            vertices[(c+sides/2+sides)*3+1]=-tempy;
            vertices[(c+sides/2+sides)*3+2]=getCylLength()+getConeLength();

        }

        colors=new float[(sides*2+1)*4];

        colors[0]=0;
        colors[1]=0;
        colors[2]=0;
        colors[3]=1;



        for(int c=1;c<(sides+1);c++){
            colors[c*4+0]=0.5f;
            colors[c*4+1]=0.5f;
            colors[c*4+2]=0.5f;
            colors[c*4+3]=1;

            colors[sides*4+c*4+0]=0.8f;
            colors[sides*4+c*4+1]=0.8f;
            colors[sides*4+c*4+2]=0.8f;
            colors[sides*4+c*4+3]=1;

        }

        indices=new short[sides*9];

        for (int c=0;c<sides;c++){
            indices[c*9+0]=0;
            indices[c*9+1]=(short)((c)%sides+1);
            indices[c*9+2]=(short)((c+1)%sides+1);
            indices[c*9+3]=(short)((c)%sides+1);
            indices[c*9+4]=(short)((c)%sides+sides+1);
            indices[c*9+5]=(short)((c+1)%sides+sides+1);
            indices[c*9+6]=(short)((c)%sides+1);
            indices[c*9+7]=(short)((c+1)%sides+1);
            indices[c*9+8]=(short)((c+1)%sides+sides+1);
        }


    }





    public void Render(float xpos,float ypos, float zpos){

        this.xpos=xpos;
        this.ypos=ypos;
        this.zpos=zpos;

        gl.glPushMatrix();
        gl.glColor4f(0.5f, 0.8f, 0.8f, 1f);
        gl.glTranslatef(xpos, ypos, zpos);

        rC.drawWithBuffers(gl,true, MR.getmRocketVerts(),MR.getmRocketsColor(), MR.getmRocketInd(), 225 * 3);


        //rC.drawWithBuffers(gl,MR.getmVehicleVerts(), MR.getmVehicleInd(), 36);


        gl.glPopMatrix();

    }

    public float[] getVertices() {
        return vertices;
    }

    public void setVertices(float[] vertices) {
        this.vertices = vertices;
    }

    public float[] getColors() {
        return colors;
    }

    public void setColors(float[] colors) {
        this.colors = colors;
    }

    public short[] getIndices() {
        return indices;
    }

    public void setIndices(short[] indices) {
        this.indices = indices;
    }
}

