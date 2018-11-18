package com.leaflea.johndoran.projecti;

import javax.microedition.khronos.opengles.GL10;


public class Ceiling_plain extends Walls {


    Boolean black;
    GL10 gl;
    renderController rC=new renderController();
    MyRenderer MR;

    public Ceiling_plain(){}
    public Ceiling_plain(GL10 gl,float oyposition,float ozposition,Boolean oblack)
    {
        this.MR=rC.getMR();
        this.gl=gl;
        this.black=oblack;
        //Render(oyposition,ozposition);
    }

    CentralisedVariables CV =new CentralisedVariables();

    public static float[] ceilVerts;

    public static float[] getCeilVerts() {
        return ceilVerts;
    }

    public static void setCeilVerts(float[] ceilVerts) {
        Ceiling_plain.ceilVerts = ceilVerts;
    }

    public void makeEverything(){
        float length=CV.LengthOfLevels;
        float width=CV.WidthOfLevels;
        float[] ceilVertices={
                0,0     ,0,
                0,0     ,length,
                width,0 ,length,
                width,0 ,0
        };
        setCeilVerts(ceilVertices);
    }
    public void Render(GL10 gl,float yposition,float zposition,Boolean oblack){
        this.black=oblack;
        int number=0;


        float length=CV.LengthOfLevels;
        float width=CV.WidthOfLevels;
        float xposition=CV.WidthOfLevels/(2f)*(-1f);


        gl.glPushMatrix();
        {
            gl.glTranslatef(xposition, yposition, zposition //-CV.LengthOfLevels
            );

            if (black) {
                gl.glColor4f(0f,0f,0f,1);
            } else {
                gl.glColor4f(0.2f,0.2f,0.2f,1); }

            //glColor4f(0,1,0,1);
            //for (int c=0; c<) {
                rC.drawWithBuffers(gl, MR.getmCeilingVerts(), MR.getmStandardRectInd(), 4);
            //}

        }
        gl.glPopMatrix();

    }

    public void Render(GL10 gl,float yposition,float zposition,Boolean oblack, float R, float G, float B){
        this.black=oblack;
        int number=0;


        float length=CV.LengthOfLevels;
        float width=CV.WidthOfLevels;
        float xposition=CV.WidthOfLevels/(2f)*(-1f);


        gl.glPushMatrix();
        {
            gl.glTranslatef(xposition, yposition, zposition //-CV.LengthOfLevels
            );

                gl.glColor4f(R,G,B,1);

            //glColor4f(0,1,0,1);
            //for (int c=0; c<) {
            rC.drawWithBuffers(gl, MR.getmCeilingVerts(), MR.getmStandardRectInd(), 4);
            //}

        }
        gl.glPopMatrix();

    }
}

