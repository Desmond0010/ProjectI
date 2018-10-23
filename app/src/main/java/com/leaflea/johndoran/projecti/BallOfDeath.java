package com.leaflea.johndoran.projecti;


import javax.microedition.khronos.opengles.GL10;


public class BallOfDeath {

    public static float size=3f;
    private static float radius=12f;


    float xpos=0;
    float ypos=0;
    float zpos=0;

    public static void setRadius(float radius) {
        BallOfDeath.radius = radius;
    }

    public float getX(){
        return xpos;

    }
    public float getY(){
        return ypos;

    }
    public float getZ(){
        return zpos;

    }
    public static float getRadius() {
        return radius;
    }

    public BallOfDeath(){
        this.MR=rC.getMR();

    }
    public static GL10 gl;
    public static renderController rC=new renderController();
    public static MyRenderer MR;
    public BallOfDeath(GL10 gl,float xpos,float ypos, float zpos) {
        this.MR=rC.getMR();
        this.gl=gl;
        this.xpos=xpos;
        this.ypos=ypos;
        this.zpos=zpos;

        //zpos=Main.vz-10;

       // Render();
    }

    private static int stacks=8;
    private static int slices=8;
    /* public float[] generateSphereVerts(){
         float[] verts;
         float tempx;
         float tempy;
         float tempz;
         int curNumSlices;

         for (int c=0;c<stacks;c++){



         }
         return verts;
     }

     public int findCorrespondingIndex(int chosenInd, int numOfIndBeforeLastCircle,int prevNoInd,int curNumInd){
         int corInd=(Math.round(((float)prevNoInd/(float)curNumInd)*((float)(chosenInd-numOfIndBeforeLastCircle-prevNoInd))))%curNumInd+numOfIndBeforeLastCircle;

         return corInd;
     }
 */
    public static float[] vertices;
    public static float[] colors;
    public static short[] indices;
    public void makeEverything(){
        /*
        vertices=new float[stacks*slices*3+3+3];
        float tempx=0;
        float tempy=0;
        float tempz=0;

        for(int c=0;c<(stacks);c++){


            tempy=((float)((float)c-((float)stacks/2f))/((float)stacks))*2f*radius;




            for (int d=0;d<(slices)/2;d++){

                tempx=((float)(2*d-slices/2)/(float)slices*2f)*((float)Math.sqrt((double)(radius*radius-tempy*tempy)));
                tempz=(float)Math.sqrt((double)(radius*radius-((float)Math.sqrt((double)(tempx*tempx+tempy*tempy)))*((float)Math.sqrt((double)(tempx*tempx+tempy*tempy)))));

                vertices[c*slices*3+d*3+0           ]=  tempx;
                vertices[c*slices*3+d*3+1           ]=  tempy;
                vertices[c*slices*3+d*3+2           ]=  tempz;
                vertices[c*slices*3+(d+slices/2)*3+0]=  -1f*tempx;
                vertices[c*slices*3+(d+slices/2)*3+1]=  tempy;
                vertices[c*slices*3+(d+slices/2)*3+2]=  -1f*tempz;


            }
        }



        ///////////FOR 32x32 will fix
        //vertices[21*slices*3+(0)*3+0]=-3f;
        //vertices[21*slices*3+(0)*3+1]=0 ;
        //vertices[21*slices*3+(0)*3+2]=0 ;
        //vertices[11*slices*3+(0)*3+0]=-3f;
        //vertices[11*slices*3+(0)*3+1]=0 ;
        //vertices[11*slices*3+(0)*3+2]=0 ;

        //vertices[21*slices*3+(slices/2)*3+0]=3f;
        //vertices[21*slices*3+(slices/2)*3+1]=0 ;
        //vertices[21*slices*3+(slices/2)*3+2]=0 ;
        //vertices[11*slices*3+(slices/2)*3+0]=3f;
        //vertices[11*slices*3+(slices/2)*3+1]=0 ;
        //vertices[11*slices*3+(slices/2)*3+2]=0 ;




















        vertices[stacks*slices*3+0]=0;
        vertices[stacks*slices*3+1]=radius;
        vertices[stacks*slices*3+2]=0;







            indices=new short[(stacks-1)*slices*6+slices*3+6
                    ];

        for (int c=0;c<(stacks-1);c++){
            for (int d=0;d<slices;d++){
                indices[(c)*slices*6+d*6+0]=(short)((c  )*slices+(d  )%slices);
                indices[(c)*slices*6+d*6+1]=(short)((c+1)*slices+(d  )%slices);
                indices[(c)*slices*6+d*6+2]=(short)((c+1)*slices+(d+1)%slices);
                indices[(c)*slices*6+d*6+3]=(short)((c  )*slices+(d  )%slices);
                indices[(c)*slices*6+d*6+4]=(short)((c  )*slices+(d+1)%slices);
                indices[(c)*slices*6+d*6+5]=(short)((c+1)*slices+(d+1)%slices);

            }
        }
        for (int c=0;c<slices;c++){

            indices[(stacks-1)*slices*6+c*3+0]=(short)((stacks-1)*slices+(c+0)%slices);
            indices[(stacks-1)*slices*6+c*3+1]=(short)((stacks-1)*slices+(c+1)%slices);
            indices[(stacks-1)*slices*6+c*3+2]=(short)((stacks)*slices);

        }

        indices[(stacks-1)*slices*6+slices*3+0]=100;
        indices[(stacks-1)*slices*6+slices*3+1]=20;
        indices[(stacks-1)*slices*6+slices*3+2]=(short)(stacks*slices+1);
        indices[(stacks-1)*slices*6+slices*3+3]=(short)(stacks*slices+1);
        indices[(stacks-1)*slices*6+slices*3+4]=56;
        indices[(stacks-1)*slices*6+slices*3+5]=43;
*/
        colors=new float[stacks*slices*4];
        for(int c=0;c<colors.length/4;c++) {

            colors[c*4+0]=0.1f;
            colors[c*4+1]=0.3f;
            colors[c*4+2]=0.6f;
            colors[c*4+3]=1f;


        }


        vertices=VerticesUtil.generateSphere(0,0,radius,slices,stacks);
        indices=VerticesUtil.generateSphereIndices(slices,stacks);
    }

    float cd=0;
    public void Render(float xpos,float ypos, float zpos){

        cd=cd+3f;
        this.xpos=xpos;
        this.ypos=ypos;
        this.zpos=zpos;

        gl.glPushMatrix();{
            //gl.glColor4f(0.7f*(0.2f+(float)Math.random()), 0.2f, 0.8f*(0.2f+(float)Math.random()),1f);
            gl.glColor4f(0.7f, 0.2f, 0.8f,1f);

            gl.glTranslatef(xpos, ypos, zpos);

            //rC.drawWithBuffers(gl,MR.getmBODVerts()//,MR.getmBODColor(),MR.getmBODInd(),stacks*slices);
            rC.drawWithBuffers(gl,MR.getmBODVerts(),MR.getmBODInd(),stacks*slices);
        }


        gl.glPopMatrix();

    }

    public float[] getVertices() {
        return vertices;
    }

    public void setVertices(float[] vertices) {
        this.vertices = vertices;
    }

    public short[] getIndices() {
        return indices;
    }

    public void setIndices(short[] indices) {
        this.indices = indices;
    }

    public float[] getColors() {
        return colors;
    }

    public void setColors(float[] colors) {
        this.colors = colors;
    }
}
