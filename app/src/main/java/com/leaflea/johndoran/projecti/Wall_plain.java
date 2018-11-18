package com.leaflea.johndoran.projecti;



import javax.microedition.khronos.opengles.GL10;


public class Wall_plain extends Walls
{
    public static float[] wallVerts;
    public static float[] wallStripVerts;


    CentralisedVariables CV =new CentralisedVariables();
    float xposition=CV.WidthOfLevels/2*-1;
    float yposition=CV.HeightOfLevels/2*-1;
    //Main ma =new Main();


    //Texture wall;

    Boolean initialised=false;

    GL10 gl;
    renderController rC=new renderController();
    MyRenderer MR;
    Boolean right;

    public Wall_plain(){}
    public Wall_plain(GL10 gl,float ozposition,Boolean right) {

        this.right=right;

        this.gl=gl;
        this.MR=rC.getMR();

       // Render(ozposition, right);

        if (!initialised){
            //wall= LoadTexture("Walls_plain-lowdef");
        }

    }

    public static float[] getWallVerts() {
        return wallVerts;
    }

    public static void setWallVerts(float[] wallVerts) {
        Wall_plain.wallVerts = wallVerts;
    }

    public static float[] getWallStripVerts() {
        return wallStripVerts;
    }

    public static void setWallStripVerts(float[] wallStripVerts) {
        Wall_plain.wallStripVerts = wallStripVerts;
    }


    public void makeEverything(){
        float length=CV.LengthOfLevels;
        float height=CV.HeightOfLevels;
        float width=CV.WidthOfLevels;
        float[] wallVertices={
                0,0     ,0,
                0,height     ,0,
                0,height ,length,
                0,0 ,length
        };
        setWallVerts(wallVertices);
        float[] wallStripVertices={
                0,0     ,0,
                0,height/8f     ,0,
                0,height/8f ,length/(float)repeatsfor,
                0,0 ,length/(float)repeatsfor
        };
        setWallStripVerts(wallStripVertices);
    }
    private int repeatsfor=1;


    public void Render(GL10 gl,float zposition, Boolean right){
        this.MR=rC.getMR();

        int number=0;
        int counter=0;
        float height=CV.HeightOfLevels;
        float totalwalllength=CV.LengthOfLevels;
        float length=totalwalllength/repeatsfor;
        float xposition=this.xposition;
        float yposition=this.yposition;


        float zshift=0;
        float locrevesse=1;
        float x1=0;
        float x2=0;
        float z=0;

        float xchange=0.1f;
        Boolean notleft=right;
        if (notleft){
            xchange=xchange*-1;
            xposition=xposition+CV.WidthOfLevels;
        }

        while(number==0){

            gl.glPushMatrix();
            {

                //wall.bind();
                // glEnable(GL_TEXTURE);
                gl.glTranslatef(xposition, yposition, zposition);
                gl.glColor4f(0f, 0f, 0.5f, 1);


                for(counter=0;counter<repeatsfor;counter++){
                    gl.glPushMatrix();
                    gl.glColor4f(0.5f, 0f, 0.9f, 1f);
                    gl.glTranslatef(0f, 0f, (float) ((float) counter * (float) length));
                    rC.drawWithBuffers(gl, MR.getmWallRectVerts(), MR.getmStandardRectInd(), 6);
                    gl.glPopMatrix();
                    zshift=zshift+length;
                }
                // glDisable(GL_TEXTURE);
                //metal




                // for(z=0;z<locrevesse;z=z+0.1f){
                //	 glColor3f(0.5f,0.5f,0);
                //	 x1=1*(z-0.1f)*(z-0.1f)-1*(z-0.1f);
                //	 x2=1*z*z-1*z;
                //	 glVertex3f(0+x2,0            ,0+zshift+length-locrevesse);
                //	 glVertex3f(0+x2,0+height     ,0+zshift+length-locrevesse);
                //	 glVertex3f(0+x1,0+height     ,0+zshift+length-locrevesse+z);
                //	 glVertex3f(0+x1,0            ,0+zshift+length-locrevesse+z);
                //
                // }







            }
            gl.glPopMatrix();
            gl.glPushMatrix();
            {
                gl.glColor4f(0.6f, 0.6f, 0.6f, 1f);
                //gl.glTranslatef(xposition,yposition,zposition);
                for(counter=0;counter<repeatsfor;counter++){
                  //  gl.glTranslatef(xposition, yposition, zposition + counter * length);
                    gl.glPushMatrix();

                   // gl.glColor4f(0.8f, 0.2f, 0.6f, 1f);

                    if (right){
                        gl.glTranslatef(xposition + -0.9f,yposition +  CV.HeightOfLevels/12f*4f,zposition + counter * length);}
                    else{
                        gl.glTranslatef(xposition +  0.9f, yposition + CV.HeightOfLevels/12f*4f,zposition + counter * length);
                    }
                    //gl.glTranslatef(0,CV.HeightOfLevels / 6 * 2f, 0);
                    rC.drawWithBuffers(gl, MR.getmWallStripRectVerts(), MR.getmStandardRectInd(), 6);

                    gl.glPopMatrix();


                    gl.glPushMatrix();
                    //gl.glColor4f(0.8f, 0.2f, 0.6f,1f);

                    if (right){
                        gl.glTranslatef(xposition + -0.9f,yposition +  CV.HeightOfLevels/12f*8f,zposition + counter * length);}
                    else{
                        gl.glTranslatef(xposition +  0.9f, yposition + CV.HeightOfLevels/12f*8f,zposition + counter * length);
                    }
                    rC.drawWithBuffers(gl, MR.getmWallStripRectVerts(), MR.getmStandardRectInd(), 6);
                    gl.glPopMatrix();


                }}
            gl.glPopMatrix();
            number++;
        }
    }


    public void Render(GL10 gl,float zposition, Boolean right,float R, float G, float B){
        this.MR=rC.getMR();

        int number=0;
        int counter=0;
        float height=CV.HeightOfLevels;
        float totalwalllength=CV.LengthOfLevels;
        float length=totalwalllength/repeatsfor;
        float xposition=this.xposition;
        float yposition=this.yposition;


        float zshift=0;
        float locrevesse=1;
        float x1=0;
        float x2=0;
        float z=0;

        float xchange=0.1f;
        Boolean notleft=right;
        if (notleft){
            xchange=xchange*-1;
            xposition=xposition+CV.WidthOfLevels;
        }

        while(number==0){

            gl.glPushMatrix();
            {

                //wall.bind();
                // glEnable(GL_TEXTURE);
                gl.glTranslatef(xposition, yposition, zposition);
                gl.glColor4f(0f, 0f, 0.5f, 1);


                for(counter=0;counter<repeatsfor;counter++){
                    gl.glPushMatrix();
                    gl.glColor4f(R,G,B, 1f);
                    gl.glTranslatef(0f, 0f, (float) ((float) counter * (float) length));
                    rC.drawWithBuffers(gl, MR.getmWallRectVerts(), MR.getmStandardRectInd(), 6);
                    gl.glPopMatrix();
                    zshift=zshift+length;
                }


            }
            gl.glPopMatrix();
            gl.glPushMatrix();
            {
                //gl.glColor4f(R+0.2f,G+0.2f,B+0.2f, 1f);
                gl.glColor4f(0.5f,0.5f,1f,1f);
                //gl.glTranslatef(xposition,yposition,zposition);
                for(counter=0;counter<repeatsfor;counter++){
                    //  gl.glTranslatef(xposition, yposition, zposition + counter * length);
                    gl.glPushMatrix();

                    // gl.glColor4f(0.8f, 0.2f, 0.6f, 1f);

                    if (right){
                        gl.glTranslatef(xposition - 2f,yposition +  CV.HeightOfLevels/12f*4f,zposition + counter * length);}
                    else{
                        gl.glTranslatef(xposition + 2f, yposition + CV.HeightOfLevels/12f*4f,zposition + counter * length);
                    }
                    //gl.glTranslatef(0,CV.HeightOfLevels / 6 * 2f, 0);
                    rC.drawWithBuffers(gl, MR.getmWallStripRectVerts(), MR.getmStandardRectInd(), 6);

                    gl.glPopMatrix();


                    gl.glPushMatrix();
                    //gl.glColor4f(0.8f, 0.2f, 0.6f,1f);

                    if (right){
                        gl.glTranslatef(xposition - 2f,yposition +  CV.HeightOfLevels/12f*8f,zposition + counter * length);}
                    else{
                        gl.glTranslatef(xposition + 2f, yposition + CV.HeightOfLevels/12f*8f,zposition + counter * length);
                    }
                    rC.drawWithBuffers(gl, MR.getmWallStripRectVerts(), MR.getmStandardRectInd(), 6);
                    gl.glPopMatrix();


                }}
            gl.glPopMatrix();
            number++;
        }
    }

    public void Render(GL10 gl,float zposition, Boolean right,float R, float G, float B,float R2, float G2, float B2){
        this.MR=rC.getMR();

        int number=0;
        int counter=0;
        float height=CV.HeightOfLevels;
        float totalwalllength=CV.LengthOfLevels;
        float length=totalwalllength/repeatsfor;
        float xposition=this.xposition;
        float yposition=this.yposition;


        float zshift=0;
        float locrevesse=1;
        float x1=0;
        float x2=0;
        float z=0;

        float xchange=0.1f;
        Boolean notleft=right;
        if (notleft){
            xchange=xchange*-1;
            xposition=xposition+CV.WidthOfLevels;
        }

        while(number==0){

            gl.glPushMatrix();
            {

                //wall.bind();
                // glEnable(GL_TEXTURE);
                gl.glTranslatef(xposition, yposition, zposition);
                gl.glColor4f(0f, 0f, 0.5f, 1);


                for(counter=0;counter<repeatsfor;counter++){
                    gl.glPushMatrix();
                    gl.glColor4f(R,G,B, 1f);
                    gl.glTranslatef(0f, 0f, (float) ((float) counter * (float) length));
                    rC.drawWithBuffers(gl, MR.getmWallRectVerts(), MR.getmStandardRectInd(), 6);
                    gl.glPopMatrix();
                    zshift=zshift+length;
                }


            }
            gl.glPopMatrix();
            gl.glPushMatrix();
            {
                //gl.glColor4f(R+0.2f,G+0.2f,B+0.2f, 1f);
                gl.glColor4f(R2,G2,B2,1f);
                //gl.glTranslatef(xposition,yposition,zposition);
                for(counter=0;counter<repeatsfor;counter++){
                    //  gl.glTranslatef(xposition, yposition, zposition + counter * length);
                    gl.glPushMatrix();

                    // gl.glColor4f(0.8f, 0.2f, 0.6f, 1f);

                    if (right){
                        gl.glTranslatef(xposition + -1.2f,yposition +  CV.HeightOfLevels/12f*4f,zposition + counter * length);}
                    else{
                        gl.glTranslatef(xposition +  1.2f, yposition + CV.HeightOfLevels/12f*4f,zposition + counter * length);
                    }
                    //gl.glTranslatef(0,CV.HeightOfLevels / 6 * 2f, 0);
                    rC.drawWithBuffers(gl, MR.getmWallStripRectVerts(), MR.getmStandardRectInd(), 6);

                    gl.glPopMatrix();


                    gl.glPushMatrix();
                    //gl.glColor4f(0.8f, 0.2f, 0.6f,1f);

                    if (right){
                        gl.glTranslatef(xposition + -1.2f,yposition +  CV.HeightOfLevels/12f*8f,zposition + counter * length);}
                    else{
                        gl.glTranslatef(xposition +  1.2f, yposition + CV.HeightOfLevels/12f*8f,zposition + counter * length);
                    }
                    rC.drawWithBuffers(gl, MR.getmWallStripRectVerts(), MR.getmStandardRectInd(), 6);
                    gl.glPopMatrix();


                }}
            gl.glPopMatrix();
            number++;
        }
    }
    /*
    public static Texture LoadTexture(String Key){
        try {
            return TextureLoader.getTexture("PNG", new FileInputStream(new File("res/"+Key+".png")));
        } catch (FileNotFoundException e) {

            System.out.println("Developer error1");
            e.printStackTrace();
            return null;
        } catch (IOException e) {

            System.out.println("Developer error2");
            e.printStackTrace();
            return null;
        }

    }*/
}
